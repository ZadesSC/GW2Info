package io.zades.gw2info.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by zades on 1/15/2016.
 */
public class TimedMetaEventView extends View
{
	private static int DEFAULT_ARRAY_SIZE = 10;
	private static int DEFAULT_RECT_SIZE = 60;
	private static int DEFAULT_SAPCING_SIZE = 5;
	private static int DEFAULT_SUBTEXT_SPACING = 5;
	private List<BoxContainer> mBoxes;
	private float mScaleFactor;
	private Calendar mCurrentTime;


	public TimedMetaEventView(Context context)
	{
		super(context);
		init();
	}
	public TimedMetaEventView(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		init();
	}
	public TimedMetaEventView(Context context, AttributeSet attrs, int defStyles)
	{
		super(context, attrs, defStyles);
		init();
	}

	private void init()
	{
		mCurrentTime = new GregorianCalendar();
		DisplayMetrics metrics = getResources().getDisplayMetrics();
		mScaleFactor = metrics.density;

		//Default paint is black and default text is text
		//used to test
		mBoxes = new ArrayList<>();
		mBoxes.add(loadVbMeta());
		mBoxes.add(loadAbMeta());
		mBoxes.add(loadTdMeta());
		mBoxes.add(loadDsMeta());
		//mBoxes.add(new BoxContainer());
		//mBoxes.add(new BoxContainer());

	}

	@Override
	protected void onDraw(Canvas canvas)
	{
		super.onDraw(canvas);
		int width = getWidth();
		int height = getHeight();
		int padding = (int) (10 * mScaleFactor);
		int rectSize = (int) (DEFAULT_RECT_SIZE * mScaleFactor);
		int spacingSize = (int) (DEFAULT_SAPCING_SIZE * mScaleFactor);
		int subTextSpacing = (int) (DEFAULT_SUBTEXT_SPACING * mScaleFactor);
		int totalHeight = 0;

		//setting calendar
		Calendar time = (Calendar) mCurrentTime.clone();
		//convert to GMT
		TimeZone localTimeZone = time.getTimeZone();
		TimeZone serverTimeZone = new SimpleTimeZone(0, "GMT");
		time.setTimeZone(serverTimeZone);

		//time.set(Calendar.MINUTE, 0); something is weird with set, using roll instead
		time.add(Calendar.MINUTE, time.get(Calendar.MINUTE) * -1);

		if(time.get(Calendar.HOUR_OF_DAY) % 2 != 0 )
		{
			Log.d("TMEV", "Hours: " + time.get(Calendar.HOUR_OF_DAY));
			time.add(Calendar.HOUR_OF_DAY, -1);
			Log.d("TMEV", "Hours: " + time.get(Calendar.HOUR_OF_DAY));
		}

		Calendar lineTime = (Calendar) time.clone();

		for(int x = 0; x < mBoxes.size(); x++)
		{
			BoxContainer box = mBoxes.get(x);
			int textSize = (int) box.getTextPaint().getTextSize();
			int blockSize = textSize + rectSize + spacingSize;

			canvas.drawText(box.getText(),padding , padding + textSize + x * blockSize, box.getTextPaint());
			//canvas.drawRect(padding, padding + x * blockSize + textSize + spacingSize, width - padding, padding + x * blockSize + textSize + rectSize, box.getPaints().get(0));

			int offset = 0;
			int rectLength = width - padding * 2;

			for(int y = 0; y < box.getPaints().size(); y++)
			{
				double ratio = box.getSizes().get(y) / 120.0;
				int boxLength = (int) (rectLength * ratio);
				int start = padding + offset;
				int end = padding + offset + boxLength;

				//Setup time
				SimpleDateFormat hhmm = new SimpleDateFormat("hh:mm");
				hhmm.setTimeZone(localTimeZone);
				String readableTime = hhmm.format(time.getTime());

				canvas.drawRect(start, padding + x * blockSize + textSize + spacingSize, end, padding + x * blockSize + textSize + rectSize, box.getPaints().get(y));
				canvas.drawText(readableTime, start, padding + x * blockSize + textSize + spacingSize + box.getSubTextPaint().getTextSize(), box.getSubTextPaint());
				canvas.drawText(box.getSubText().get(y), start, padding + x * blockSize + textSize + rectSize - subTextSpacing, box.getSubTextPaint());


				//roll time and increment
				time.add(Calendar.MINUTE, (int) (box.getSizes().get(y) / 1.0)); //divide by 1.0 to convert from Float to float
				offset += boxLength;
			}

			//reset calendar
			time = (Calendar) lineTime.clone();

			//calculate total height
			totalHeight = padding + x * blockSize + textSize + rectSize;
			Log.d("dsfs", "total height: " + totalHeight);
		}

		//Draw line representing current time
		//Calcuate amount of time since between of 2h loop
		long timeElapsed = mCurrentTime.getTimeInMillis() - lineTime.getTimeInMillis();
		double timeElapsedInMinutes = timeElapsed/1000.0/60.0;
		double ratio = timeElapsedInMinutes/120.0;
		int rectLength = width - padding * 2;
		int lineWidth = (int) (2 * mScaleFactor);
		int lineStart = (int) (rectLength * ratio) - lineWidth/2;

		Log.d("TMEV", "Time Elapsed: " + timeElapsedInMinutes);

		Paint linePaint = new Paint();
		linePaint.setColor(Color.RED);

		canvas.drawRect(lineStart, padding, lineStart + lineWidth, height - padding *2, linePaint);

		//set height
		if(getLayoutParams().height != totalHeight)
		{
			getLayoutParams().height = totalHeight;
			invalidate();
		}
	}

	@Override
	public void onMeasure(int widthSpec, int heightSpec)
	{
		super.onMeasure(widthSpec, heightSpec);

		//TODO: FIX THIS STUPID ASS IMPLEMENTATION
		int padding = (int) (10 * mScaleFactor);
		int rectSize = (int) (DEFAULT_RECT_SIZE * mScaleFactor);
		int spacingSize = (int) (DEFAULT_SAPCING_SIZE * mScaleFactor);
		int textSize = (int) mBoxes.get(0).getTextPaint().getTextSize();
		int blockSize = textSize + rectSize + spacingSize;
		int x = 4;

		setMeasuredDimension(widthSpec, padding + x * blockSize + textSize + rectSize);


	}
	public void updateTime()
	{
		mCurrentTime = new GregorianCalendar();
		invalidate();
	}

	//TODO: change to load from other sources like the file system in the future for modularibility
	//for now just load here cause I'm lazy

	private BoxContainer loadVbMeta()
	{
		//Verdant Brink Meta:
		//..night continues to 00:10
		//00:10-00:30 night bosses
		//00:30-01:45 day
		//01:45-0:10 night

		List<Paint> paints = new ArrayList<>();
		List<Float> sizes = new ArrayList<>();
		List<String> subSection = new ArrayList<>();

		String text = "Verdant Brink";

		//night
		Paint paintNight = new Paint();
		paintNight.setColor(Color.parseColor("#4CAF50"));
		String textContNight = "";
		String textNight = "Night";
		Float timeContNight = new Float(10);
		Float timeNight = new Float(15);

		//night boss
		Paint paintNightBoss = new Paint();
		paintNightBoss.setColor(Color.parseColor("#1B5E20"));
		String textNightBoss = "Night Bosses";
		Float timeNightBoss = new Float(20);

		//day
		Paint paintDay = new Paint();
		paintDay.setColor(Color.parseColor("#8BC34A"));
		String textDay = "Day";
		Float timeDay = new Float(75);

		paints.add(paintNight);
		paints.add(paintNightBoss);
		paints.add(paintDay);
		paints.add(paintNight);

		sizes.add(timeContNight);
		sizes.add(timeNightBoss);
		sizes.add(timeDay);
		sizes.add(timeNight);

		subSection.add(textContNight);
		subSection.add(textNightBoss);
		subSection.add(textDay);
		subSection.add(textNight);

		BoxContainer container = new BoxContainer(text, paints, sizes, subSection);

		return container;
	}

	public BoxContainer loadAbMeta()
	{
		//Auric Basin Meta
		//Meta events continues to 00:45
		//00:45-1:00 challenges
		//1:00-1:20 octovine
		//1:20-1:30 break
		//1:30-02:00 meta

		List<Paint> paints = new ArrayList<>();
		List<Float> sizes = new ArrayList<>();
		List<String> subSection = new ArrayList<>();

		String text = "Auric Basin";

		//meta
		Paint paintMeta = new Paint();
		paintMeta.setColor(Color.parseColor("#FFEB3B"));
		String textContMeta = "";
		String textMeta = "Meta";
		Float timeContMeta = new Float(45);
		Float timeMeta = new Float(30);

		//challenges
		Paint paintChallenges = new Paint();
		paintChallenges.setColor(Color.parseColor("#FBC02D"));
		String textChallenges = "Challenges";
		Float timeChallenges = new Float(15);

		//octovine
		Paint paintOcto = new Paint();
		paintOcto.setColor(Color.parseColor("#F57F17"));
		String textOcto = "Octovine";
		Float timeOcto = new Float(20);

		//rest
		Paint paintRest = new Paint();
		paintRest.setColor(Color.parseColor("#FFFDE7"));
		String textRest = "Rest";
		Float timeRest = new Float(10);



		paints.add(paintMeta);
		paints.add(paintChallenges);
		paints.add(paintOcto);
		paints.add(paintRest);
		paints.add(paintMeta);

		sizes.add(timeContMeta);
		sizes.add(timeChallenges);
		sizes.add(timeOcto);
		sizes.add(timeRest);
		sizes.add(timeMeta);

		subSection.add(textContMeta);
		subSection.add(textChallenges);
		subSection.add(textOcto);
		subSection.add(textRest);
		subSection.add(textMeta);

		BoxContainer container = new BoxContainer(text, paints, sizes, subSection);

		return container;
	}

	public BoxContainer loadTdMeta()
	{
		//td meta
		//outposts cont 00:25
		//prep 00:25-00:30
		//chak gerent 00:30-00:50
		//outposts 00:50-02:00

		List<Paint> paints = new ArrayList<>();
		List<Float> sizes = new ArrayList<>();
		List<String> subSection = new ArrayList<>();

		String text = "Tangled Depths";

		//outpost
		Paint paintOutpost = new Paint();
		paintOutpost.setColor(Color.parseColor("#B39DDB"));
		String textContOutpost = "";
		String textOutpost = "Outpost";
		Float timeContOutpost = new Float(20);
		Float timeOutpost = new Float(70);

		//prep
		Paint paintPrep = new Paint();
		paintPrep.setColor(Color.parseColor("#7E57C2"));
		String textPrep = "Prep";
		Float timePrep = new Float(10);

		//Gerent
		Paint paintGerent = new Paint();
		paintGerent.setColor(Color.parseColor("#5E35B1"));
		String textGerent = "Gerent";
		Float timeGerent = new Float(20);

		paints.add(paintOutpost);
		paints.add(paintPrep);
		paints.add(paintGerent);
		paints.add(paintOutpost);

		sizes.add(timeContOutpost);
		sizes.add(timePrep);
		sizes.add(timeGerent);
		sizes.add(timeOutpost);

		subSection.add(textContOutpost);
		subSection.add(textPrep);
		subSection.add(textGerent);
		subSection.add(textOutpost);

		BoxContainer container = new BoxContainer(text, paints, sizes, subSection);

		return container;
	}

	public BoxContainer loadDsMeta()
	{
		List<Paint> paints = new ArrayList<>();
		List<Float> sizes = new ArrayList<>();
		List<String> subSection = new ArrayList<>();

		String text = "Dragon Stand";

		//Meta
		Paint paintMeta = new Paint();
		paintMeta.setColor(Color.parseColor("#9E9E9E"));
		String textContMeta = "";
		String textMeta = "Meta";
		Float timeContMeta = new Float(89);
		Float timeMeta = new Float(30);

		//start line
		Paint paintPrep = new Paint();
		paintPrep.setColor(Color.parseColor("#000000"));
		String textPrep = "";
		Float timePrep = new Float(1);

		paints.add(paintMeta);
		paints.add(paintPrep);
		paints.add(paintMeta);

		sizes.add(timeContMeta);
		sizes.add(timePrep);
		sizes.add(timeMeta);

		subSection.add(textContMeta);
		subSection.add(textPrep);
		subSection.add(textMeta);

		BoxContainer container = new BoxContainer(text, paints, sizes, subSection);

		return container;
	}

	public class BoxContainer
	{
		private List<Paint> mPaints;
		private List<Float> mSizes;
		private List<String> mSubText;
		private Paint mTextPaint;
		private Paint mSubTextPaint;
		private String mText;

		public BoxContainer()
		{
			mPaints = new ArrayList<>();
			mSizes = new ArrayList<>();

			Paint defaultPaint = new Paint();
			defaultPaint.setColor(Color.BLACK);
			defaultPaint.setTextSize(20 * mScaleFactor);

			Paint defaultTextPaint = new Paint();
			defaultTextPaint.setColor(Color.BLACK);
			defaultTextPaint.setTextSize(20 * mScaleFactor);

			Paint defaultSubTextPaint = new Paint();
			defaultSubTextPaint.setColor(Color.BLACK);
			defaultSubTextPaint.setTextSize(10 * mScaleFactor);

			mTextPaint = defaultSubTextPaint;
			mSubTextPaint = defaultSubTextPaint;

			mPaints.add(defaultPaint);
			mSizes.add(new Float(1.00));
			mText = "Default";
		}

		public BoxContainer(String text, List<Paint> paints, List<Float> sizes, List<String> subText)
		{
			mPaints = paints;
			mSizes = sizes;
			mText = text;
			mSubText = subText;

			Paint defaultTextPaint = new Paint();
			defaultTextPaint.setColor(Color.BLACK);
			defaultTextPaint.setTextSize(20 * mScaleFactor);
			defaultTextPaint.setFlags(Paint.ANTI_ALIAS_FLAG);

			Paint defaultSubTextPaint = new Paint();
			defaultSubTextPaint.setColor(Color.BLACK);
			defaultSubTextPaint.setTextSize(12 * mScaleFactor);
			defaultSubTextPaint.setFlags(Paint.ANTI_ALIAS_FLAG);

			mTextPaint = defaultTextPaint;
			mSubTextPaint = defaultSubTextPaint;
		}

		public List<Paint> getPaints()
		{
			return mPaints;
		}

		public List<Float> getSizes()
		{
			return mSizes;
		}

		public List<String> getSubText()
		{
			return mSubText;
		}

		public Paint getTextPaint()
		{
			return mTextPaint;
		}

		public Paint getSubTextPaint()
		{
			return mSubTextPaint;
		}
		public String getText()
		{
			return mText;
		}
	}
}
