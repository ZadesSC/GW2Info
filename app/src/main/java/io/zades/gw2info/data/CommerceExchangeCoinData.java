package io.zades.gw2info.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CommerceExchangeCoinData
{

	@SerializedName("coins_per_gem")
	@Expose
	private Long coinsPerGem;
	@SerializedName("quantity")
	@Expose
	private Long quantity;

	/**
	 *
	 * @return
	 * The coinsPerGem
	 */
	public Long getCoinsPerGem() {
		return coinsPerGem;
	}

	/**
	 *
	 * @param coinsPerGem
	 * The coins_per_gem
	 */
	public void setCoinsPerGem(Long coinsPerGem) {
		this.coinsPerGem = coinsPerGem;
	}

	/**
	 *
	 * @return
	 * The quantity
	 */
	public Long getQuantity() {
		return quantity;
	}

	/**
	 *
	 * @param quantity
	 * The quantity
	 */
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

}