package io.zades.gw2info.utils;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import io.zades.gw2info.R;

/**
 * Created by zades on 11/19/2015.
 */
public class Utils
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

	/**
	 * Takes an array of ints and returns them as a comma separated string
	 * @param array Array of ints
	 * @return A string of ints that are comma separated
	 */
	public static String convertIntArrayToString(int[] array)
	{
		String str = "";
		for(int x = 0; x < array.length; x++)
		{
			str += array[x];
			if (x != array.length - 1)
			{
				str += ",";
			}
		}

		Log.d("CONVERT", str);
		return str;
	}

	public static int getColorFromRarity(String rarity, Context context)
	{
		int color;

		switch (rarity.trim())
		{
			case TEXT_LEGENDARY:
				color = COLOR_LEGENDARY;
				break;
			case TEXT_ASCENDED:
				color = COLOR_ASCENDED;
				break;
			case TEXT_EXOTIC:
				color = COLOR_EXOTIC;
				break;
			case TEXT_RARE:
				color = COLOR_RARE;
				break;
			case TEXT_MASTERWORK:
				color = COLOR_MASTERWORK;
				break;
			case TEXT_FINE:
				color = COLOR_FINE;
				break;
			case TEXT_BASIC:
				color = COLOR_BASIC;
				break;
			case TEXT_JUNK:
				color = COLOR_JUNK;
				break;
			default:
				color = COLOR_JUNK;
				break;
		}

		return ContextCompat.getColor(context, color);
	}

	public static String getHtmlColorText(String text, int color)
	{
		return "<font color=\"" + color + "\">" + text + "</font>";
	}
}
