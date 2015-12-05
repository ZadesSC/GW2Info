package io.zades.gw2info.graphics;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import com.squareup.picasso.Transformation;
import io.zades.gw2info.R;

/**
 * Created by zades on 12/5/2015.
 */
public class IconBorderTransformation implements Transformation
{
	public static final int COLOR_LEGENDARY = R.color.legendaryColor;
	public static final int COLOR_ASCENDED = R.color.ascendedColor;
	public static final int COLOR_EXOTIC = R.color.exoticColor;
	public static final int COLOR_RARE = R.color.rareColor;
	public static final int COLOR_MASTERWORK = R.color.masterworkColor;
	public static final int COLOR_FINE = R.color.fineColor;
	public static final int COLOR_BASIC = R.color.basicColor;
	public static final int COLOR_JUNK = R.color.junkColor;

	public static final String TEXT_LEGENDARY = "Legendary";
	public static final String TEXT_ASCENDED = "Ascended";
	public static final String TEXT_EXOTIC = "Exotic";
	public static final String TEXT_RARE = "Rare";
	public static final String TEXT_MASTERWORK = "Masterwork";
	public static final String TEXT_FINE = "Fine";
	public static final String TEXT_BASIC = "Basic";
	public static final String TEXT_JUNK = "Junk";

	private static final int borderWidth = 4;

	private int mColor;
	private int mNumber;
	private Context mContext;

	public IconBorderTransformation(int color, int number, Context context)
	{
		mColor = color;
		mNumber = number;
		mContext = context;
	}

	public IconBorderTransformation(String color, int number, Context context)
	{
		switch (color.trim())
		{
			case TEXT_LEGENDARY:
				mColor = COLOR_LEGENDARY;
				break;
			case TEXT_ASCENDED:
				mColor = COLOR_ASCENDED;
				break;
			case TEXT_EXOTIC:
				mColor = COLOR_EXOTIC;
				break;
			case TEXT_RARE:
				mColor = COLOR_RARE;
				break;
			case TEXT_MASTERWORK:
				mColor = COLOR_MASTERWORK;
				break;
			case TEXT_FINE:
				mColor = COLOR_FINE;
				break;
			case TEXT_BASIC:
				mColor = COLOR_BASIC;
				break;
			case TEXT_JUNK:
				mColor = COLOR_JUNK;
				break;
			default:
				mColor = COLOR_JUNK;
				break;
		}
		Log.d("Transform", "Color: " + color + " " + mColor);

		mNumber = number;
		mContext = context;
	}

	@Override
	public Bitmap transform(Bitmap source)
	{
		//Bitmap output = Bitmap.createBitmap(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
		//source.recycle();
		Bitmap dest = Bitmap.createBitmap(source.getWidth()+borderWidth*2, source.getHeight()+borderWidth*2, source.getConfig());
		Canvas canvas = new Canvas(dest);
		canvas.drawColor(ContextCompat.getColor(mContext, mColor));
		canvas.drawBitmap(source, borderWidth, borderWidth, null);
		source.recycle();

		return dest;
	}

	@Override
	public String key()
	{
		return "icon border";
	}
}
