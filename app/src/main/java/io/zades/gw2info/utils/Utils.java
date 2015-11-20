package io.zades.gw2info.utils;

/**
 * Created by zades on 11/19/2015.
 */
public class Utils
{
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

		return str;
	}
}
