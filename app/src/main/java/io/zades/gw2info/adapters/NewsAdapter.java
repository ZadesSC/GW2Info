package io.zades.gw2info.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.pkmmte.pkrss.Article;
import com.pkmmte.pkrss.Callback;
import com.pkmmte.pkrss.PkRSS;
import com.squareup.picasso.Picasso;
import io.zades.gw2info.R;
import io.zades.gw2info.graphics.IconBorderTransformation;
import io.zades.gw2info.viewholders.NewsViewHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zades on 1/18/2016.
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder>
{
	private static String GW2_PLACEHOLDER_LOGO = "https://pbs.twimg.com/profile_images/554760231817723904/1qPEogEk.jpeg";
	private List<Article> mRssList;
	private Context mContext;

	public NewsAdapter(Context context)
	{
		super();

		mContext = context;
		refreshData(new ArrayList<Article>());
	}

	@Override
	public NewsViewHolder onCreateViewHolder(ViewGroup viewGroup, int type)
	{
		View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_card_news, viewGroup, false);

		return new NewsViewHolder(v);
	}

	@Override
	public void onBindViewHolder(NewsViewHolder holder, int position)
	{
		//load data from rss into viewholder
		holder.mTextNewsTitle.setText(mRssList.get(position).getTitle());
		holder.mUrl = mRssList.get(position).getSource();
		//holder.mTextNewsDetails.setText(mRssList.get(position).getDescription());
		//Log.d("tasd", "IMAGE URL: " + mRssList.get(position).getImage().toString());

		//pull out image links
		String strPattern = "<a href=\"\\/\\/(.*\\.(?:jpg|png))\">";
		Pattern pattern = Pattern.compile(strPattern);
		Matcher matcher = pattern.matcher(mRssList.get(position).getContent());

		if(matcher.find())
		{
			//Log.d("sdf", matcher.group(1));

			String imageUrl = matcher.group(1);
			if(imageUrl.length() < 7 || !imageUrl.substring(0, 7).equals("https://"))
			{
				imageUrl = "https://" + imageUrl; 	//TODO: fix case where the image is http and not https or empty
													//TODO: check other cases
			}
			//use image
			Picasso.with(mContext).load(imageUrl).placeholder(R.drawable.image_gw2_logo).fit().centerCrop().into(holder.mImageView);

		}
		else
		{
			//use default
			Picasso.with(mContext).load(R.drawable.image_gw2_logo).fit().centerCrop().into(holder.mImageView);
		}

	}

	@Override
	public int getItemCount()
	{
		return mRssList.size();
	}


	public void refreshData(List<Article> list)
	{
		//PkRSS.with(this).load(GW2_NEWS_URL).callback(this).async();
		mRssList = list;
		notifyDataSetChanged();
	}
}
