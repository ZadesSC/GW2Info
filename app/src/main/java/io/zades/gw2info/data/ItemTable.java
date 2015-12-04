package io.zades.gw2info.data;

import io.zades.gw2info.data.pojo.ItemDatum;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zades on 12/4/2015.
 */
public class ItemTable
{
	private static ItemTable sInstance = null;
	private ConcurrentHashMap<Long, ItemDatum> mItemTable;

	public ItemTable()
	{
		mItemTable = new ConcurrentHashMap<>();
	}

	public static ItemTable getInstance()
	{
		if(sInstance == null)
		{
			sInstance = new ItemTable();
		}
		return sInstance;
	}

	public void storeItems(List<ItemDatum> data)
	{
		//using old loop in case of null values
		for(int x = 0; x < data.size(); x++)
		{
			mItemTable.put(data.get(x).getId(), data.get(x));
		}
	}

	public ItemDatum getItemData(long id)
	{
		return mItemTable.get(id);
	}
}
