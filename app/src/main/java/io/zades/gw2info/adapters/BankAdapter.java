package io.zades.gw2info.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import io.zades.gw2info.data.AccountBankDatum;
import io.zades.gw2info.models.BankChildModel;
import io.zades.gw2info.models.BankParentModel;
import io.zades.gw2info.net.Gw2Api;
import retrofit.Call;

import java.util.List;

/**
 * Created by zades on 12/4/2015.
 */
public class BankAdapter extends AbstractAdvancedRecyclerViewAdapter<BankParentModel, BankChildModel>
{
	private static final String TAG = "BankAdapter";

	public static final int TYPE_CHILD = 1;

	private final Gw2Api sApi = Gw2Api.getInstance();

	private Context mContext;
	private LayoutInflater mInflator;

	public BankAdapter(Context context)
	{
		super();
		mContext = context;
		mInflator = LayoutInflater.from(mContext);
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
	{
		return null;
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
	{

	}

	private void getBankData()
	{
		Call<List<AccountBankDatum>> call = sApi.getAccountBank();
	}
}
