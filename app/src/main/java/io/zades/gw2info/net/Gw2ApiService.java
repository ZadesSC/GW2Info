package io.zades.gw2info.net;

import io.zades.gw2info.data.pojo.*;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Path;
import retrofit.http.Query;

import java.util.List;

/**
 * Created by zades on 11/17/2015.
 */
public interface Gw2ApiService
{
	@GET("account")
	Call<AccountData> getAccount(
		@Header(Gw2Api.AUTH_HEADER) String auth
	);

	@GET("account/achievements")
	Call<List<AccountAchievementsDatum>> getAccountAchievements(
			@Header(Gw2Api.AUTH_HEADER) String auth
	);

	@GET("account/bank")
	Call<List<AccountBankDatum>> getAccountBank(
			@Header(Gw2Api.AUTH_HEADER) String auth
	);

	@GET("account/dyes")
	Call<List<Integer>> getAccountDyes(
			@Header(Gw2Api.AUTH_HEADER) String auth
	);

	@GET("account/materials")
	Call<List<AccountMaterialDatum>> getAccountMaterials(
			@Header(Gw2Api.AUTH_HEADER) String auth
	);

	@GET("account/minis")
	Call<List<Integer>> getAccountMinis(
			@Header(Gw2Api.AUTH_HEADER) String auth
	);

	@GET("account/skins")
	Call<List<Integer>> getAccountSkins(
			@Header(Gw2Api.AUTH_HEADER) String auth
	);

	@GET("account/wallet")
	Call<List<AccountWalletDatum>> getAccountWallet(
			@Header(Gw2Api.AUTH_HEADER) String auth
	);

	@GET("achievements")
	Call<List<AchievementDatum>> getAchievements(
			@Query("ids") String ids
	);

	@GET("achievements/daily")
	Call<AchievementDailyData> getAchievementsDaily();

	@GET("build")
	Call<BuildData> getBuild();

	@GET("characters")	//get list of characters
	Call<List<String>> getCharacters(
			@Header(Gw2Api.AUTH_HEADER) String auth,
			@Query("page") int page
	);

	@GET("characters")	//get inforation of a character
	Call<List<CharacterDatum>> getCharacters(
			@Header(Gw2Api.AUTH_HEADER) String auth,
			@Query("ids") String ids
	);

	@GET("colors")
	Call<ColorData> getColors(
			@Query("ids") String ids
	);

	@GET("commerce/exchange")	//most likely not used
	Call<List<String>> getCommerceExchange();

	@GET("commerce/exchange/coins")
	Call<CommerceExchangeCoinData> getCommerceExchangeCoins(
			@Query("quantity") int quantity
	);

	@GET("commerce/exchange/gems")
	Call<CommerceExchangeGemData> getCommerceExchangeGems(
			@Query("quantity") int quantity
	);

	@GET("commerce/listings")
	Call<CommerceListingData> getCommerceListings(
			@Query("ids") String ids
	);

	@GET("commerce/prices")
	Call<CommercePriceData> getCommercePrices(
			@Query("ids") String ids
	);

	@GET("commerce/transactions{currentOrHistory}/{buyOrSell}")
	Call<List<CommerceTransactionDatum>> getCommerceTransactions(
			@Header(Gw2Api.AUTH_HEADER) String auth,
			@Path("currentOrHistory") String currentOrHistory,
			@Path("buyOrSell") String buyOrSell
	);

	@GET("continents")
	Call<List<ContinentDatum>> getContinents(
			@Query("ids") String ids
	);

	@GET("currencies")
	Call<List<CurrencyDatum>> getCurrencies(
			@Query("ids") String ids
	);

	@GET("files")
	Call<List<FileDatum>> getFiles(
			@Query("ids") String ids
	);

//	@GET("floors")
//	Call<> getFloors(
//			@Query("ids") String ids
//	);

	@GET("items")
	Call<List<ItemDatum>> getItems(
			@Query("ids") String ids
	);

//	@GET("maps")
//	Call<> getMaps(
//			@Query("ids") String ids
//	);

	@GET("materials")
	Call<List<MaterialDatum>> getMaterials(
			@Query("ids") String ids
	);

	@GET("minis")
	Call<List<MiniDatum>> getMinis(
			@Query("ids") String ids
	);

	@GET("pvp/games")
	Call<List<PvpGameDatum>> getPvpGames(
			@Header(Gw2Api.AUTH_HEADER) String auth
	);

	@GET("pvp/stats")
	Call<PvpStatData> getPvpStats(
			@Header(Gw2Api.AUTH_HEADER) String auth
	);

	@GET("recipes")
	Call<List<RecipeDatum>> getRecipes(
			@Query("ids") String ids
	);

	@GET("recipes/search")
	Call<List<Integer>> getRecipesSearch(
			@Query("input") int input,
			@Query("output") int output
	);

	@GET("skins")
	Call<List<SkinDatum>> getSkins(
			@Query("ids") String ids
	);

	@GET("specializations")
	Call<List<SpecializationDatum>> getSpecializations(
			@Query("ids") String ids
	);

	@GET("tokeninfo")
	Call<TokenData> getTokenInfo();

	@GET("traits")
	Call<List<TraitDatum>> getTraits(
			@Query("ids") String ids
	);

	@GET("worlds")
	Call<List<WorldDatum>> getWorlds(
			@Query("ids") String ids
	);

	@GET("wvw/matches")
	Call<List<WorldDatum>> getWvwMatches(
			@Query("ids") String ids,
			@Query("world") String world
	);

	@GET("wvw/objectives")
	Call<List<WvwObjectiveDatum>> getWvwObjectives(
			@Query("ids") String ids
	);
}
