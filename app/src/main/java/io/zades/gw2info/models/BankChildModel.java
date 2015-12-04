package io.zades.gw2info.models;

import io.zades.gw2info.data.pojo.ItemDatum;

/**
 * Created by zades on 12/4/2015.
 */
public class BankChildModel
{
	//something something item data
	private int mAmount;
	private ItemDatum mItemData;

	public BankChildModel()
	{

	}

	public int getAmount()
	{
		return mAmount;
	}

	public void setAmount(int amount)
	{
		this.mAmount = amount;
	}

	public ItemDatum getItemData()
	{
		return mItemData;
	}

	public void setItemData(ItemDatum itemData)
	{
		this.mItemData = itemData;
	}
}
