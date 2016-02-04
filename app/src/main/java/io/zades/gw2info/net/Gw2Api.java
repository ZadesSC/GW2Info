package io.zades.gw2info.net;

import android.util.Log;
import io.zades.gw2info.BuildConfig;
import io.zades.gw2info.data.pojo.AccountBankDatum;
import io.zades.gw2info.data.pojo.AccountMaterialDatum;
import io.zades.gw2info.data.pojo.ItemDatum;
import io.zades.gw2info.data.pojo.MaterialDatum;
import io.zades.gw2info.utils.Utils;
import retrofit.Call;
import retrofit.Retrofit;
import retrofit.GsonConverterFactory;

import java.util.List;

/**
 * Created by zades on 11/16/2015.
 */
public class Gw2Api
{
	public static final String AUTH_HEADER = "Authorization";
	public static final String AUTH_BEARER = "Bearer ";

	private static Gw2Api sInstance = null;
	private static final String ENDPOINT = "https://api.guildwars2.com/v2/";
	private static final String API_KEY = BuildConfig.API_KEY;

	private final Retrofit retrofit;
	private final Gw2ApiService service;


	public Gw2Api()
	{
		this.retrofit = new Retrofit.Builder()
				.baseUrl(ENDPOINT)
				.addConverterFactory(GsonConverterFactory.create())
				.build();

		service = retrofit.create(Gw2ApiService.class);
	}

	public static Gw2Api getInstance()
	{
		if(sInstance == null)
		{
			sInstance = new Gw2Api();
		}

		return sInstance;
	}

	public Call<List<AccountBankDatum>> getAccountBank()
	{
		Log.d("GW2API", "api key: " + API_KEY);
		return service.getAccountBank(AUTH_BEARER + API_KEY);
	}
	public Call<List<AccountMaterialDatum>> getAccountMaterial()
	{
		return service.getAccountMaterials(AUTH_BEARER + API_KEY);
	}

	public Call<List<Integer>> getMaterial()
	{
		return service.getMaterials();
	}

	public Call<List<MaterialDatum>> getMaterial(int[] ids)
	{
		return service.getMaterials(Utils.convertIntArrayToString(ids));
	}

	public Call<List<ItemDatum>> getItems(int[] ids)
	{
		return service.getItems(Utils.convertIntArrayToString(ids));
	}
}
