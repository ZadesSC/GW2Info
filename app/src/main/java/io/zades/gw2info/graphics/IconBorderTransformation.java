package io.zades.gw2info.graphics;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import com.squareup.picasso.Transformation;
import io.zades.gw2info.R;
import io.zades.gw2info.utils.Utils;

/**
 * Created by zades on 12/5/2015.
 */
public class IconBorderTransformation implements Transformation
{
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
		mNumber = number;
		mContext = context;
		mColor = Utils.getColorFromRarity(color, mContext);
	}

	@Override
	public Bitmap transform(Bitmap source)
	{
		//Bitmap output = Bitmap.createBitmap(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
		//source.recycle();
		Bitmap dest = Bitmap.createBitmap(source.getWidth()+borderWidth*2, source.getHeight()+borderWidth*2, source.getConfig());
		Canvas canvas = new Canvas(dest);
		canvas.drawColor(mColor);
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
