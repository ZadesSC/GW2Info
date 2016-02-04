package io.zades.gw2info.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.pkmmte.pkrss.Article;
import io.zades.gw2info.R;
import io.zades.gw2info.data.BossTimerList;
import io.zades.gw2info.viewholders.BossTimeViewHolder;
import org.joda.time.*;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;
import org.joda.time.tz.FixedDateTimeZone;

import java.util.*;

/**
 * Created by zades on 2/4/2016.
 */
public class BossTimeAdapter extends RecyclerView.Adapter<BossTimeViewHolder>
{
	private BossTimerList sBossTimerList = BossTimerList.getInstance();
	private List<BossNameTimePair> mTimes;
	private Context mContext;
	private DateTime mCurrentTimeInUtc;


	public BossTimeAdapter(Context context)
	{
		super();
		mTimes = new ArrayList<>();
		mContext = context;

		refreshData();
	}


	@Override
	public BossTimeViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
	{
		View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_boss_times, parent, false);

		return new BossTimeViewHolder(v);
	}

	@Override
	public void onBindViewHolder(BossTimeViewHolder holder, int position)
	{
		Duration duration = new Duration(mCurrentTimeInUtc, mTimes.get(position).mTime);
		PeriodFormatter formatter = new PeriodFormatterBuilder()
				.printZeroAlways()
				.minimumPrintedDigits(2)
				.appendHours()
				.appendSuffix(":")
				.appendMinutes()
				.appendSuffix(":")
				.appendSeconds()
				.toFormatter();
		String formatted = formatter.print(duration.toPeriod());

		if(mCurrentTimeInUtc.compareTo(mTimes.get(position).mTime) > 0)
		{
			formatted = "Active";
			holder.mTextBossTitle.setBackgroundColor(Color.YELLOW);
			holder.mTextBossTime.setBackgroundColor(Color.YELLOW);
		}
		holder.mTextBossTime.setText(formatted);
		holder.mTextBossTitle.setText(mTimes.get(position).mName);
	}

	@Override
	public int getItemCount()
	{
		return mTimes.size();
	}

	public void refreshData()
	{
		mCurrentTimeInUtc = new DateTime(DateTimeZone.UTC);
		DateTime activeTime = mCurrentTimeInUtc.minusMinutes(10);
		LocalTime currentTimeInUtc = mCurrentTimeInUtc.toLocalTime();
		Log.d("asdasd", "checking utc time: " + currentTimeInUtc.toString());
		//Log.d("asdasd", "checking active time: " + activeTime.toString());

		List<BossNameTimePair> newTimes = new ArrayList<>();

		for(BossTimerList.BossTimes bossTimes: sBossTimerList.getBossTimes())
		{
			boolean noTimesRemaining = true; //Used to check if the next availbe time is for tomorrow

			for(LocalTime time: bossTimes.getBossTimes())
			{
				if(activeTime.isBefore(time.toDateTimeToday(DateTimeZone.UTC)))
				{
					DateTime nextTime = time.toDateTimeToday(DateTimeZone.UTC);
					newTimes.add(new BossNameTimePair(bossTimes.getBossName(), nextTime));

					noTimesRemaining = false;
					break;
				}
			}

			if(noTimesRemaining)
			{
				DateTime nextTime = bossTimes.getBossTimes().get(0).toDateTimeToday(DateTimeZone.UTC);
				nextTime = nextTime.plusDays(1);
				Log.d("sdafds", bossTimes.getBossName() + " " + nextTime.toString());
				newTimes.add(new BossNameTimePair(bossTimes.getBossName(), nextTime));
			}
		}

		Collections.sort(newTimes, new BossPairComparator());
		mTimes = newTimes;

		notifyDataSetChanged();
	}

	public class BossNameTimePair
	{
		public DateTime mTime;
		public String mName;

		public BossNameTimePair(String name, DateTime time)
		{
			mTime = time;
			mName = name;
		}
	}

	public class BossPairComparator implements Comparator<BossNameTimePair>
	{

		@Override
		public int compare(BossNameTimePair lhs, BossNameTimePair rhs)
		{
			return lhs.mTime.compareTo(rhs.mTime);
		}
	}
}
