package io.zades.gw2info.models;

/**
 * Created by zades on 12/4/2015.
 */
public class BankParentModel
{
	//something something tab information
	private static final String BANK_TAB_STRING = "Bank Tab ";
	private String mBankTabString;

	public BankParentModel(int parentPosition)
	{
		setBankTabString(BANK_TAB_STRING + parentPosition);
	}

	public String getBankTabString()
	{
		return mBankTabString;
	}

	public void setBankTabString(String mBankTabString)
	{
		this.mBankTabString = mBankTabString;
	}
}
