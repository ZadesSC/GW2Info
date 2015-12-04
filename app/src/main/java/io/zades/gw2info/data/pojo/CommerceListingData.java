package io.zades.gw2info.data.pojo;


import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CommerceListingData {

	@SerializedName("id")
	@Expose
	private Long id;
	@SerializedName("buys")
	@Expose
	private List<Buy> buys = new ArrayList<Buy>();
	@SerializedName("sells")
	@Expose
	private List<Sell> sells = new ArrayList<Sell>();

	/**
	 *
	 * @return
	 * The id
	 */
	public Long getId() {
		return id;
	}

	/**
	 *
	 * @param id
	 * The id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 *
	 * @return
	 * The buys
	 */
	public List<Buy> getBuys() {
		return buys;
	}

	/**
	 *
	 * @param buys
	 * The buys
	 */
	public void setBuys(List<Buy> buys) {
		this.buys = buys;
	}

	/**
	 *
	 * @return
	 * The sells
	 */
	public List<Sell> getSells() {
		return sells;
	}

	/**
	 *
	 * @param sells
	 * The sells
	 */
	public void setSells(List<Sell> sells) {
		this.sells = sells;
	}

	public class Buy {

		@SerializedName("listings")
		@Expose
		private Long listings;
		@SerializedName("unit_price")
		@Expose
		private Long unitPrice;
		@SerializedName("quantity")
		@Expose
		private Long quantity;

		/**
		 *
		 * @return
		 * The listings
		 */
		public Long getListings() {
			return listings;
		}

		/**
		 *
		 * @param listings
		 * The listings
		 */
		public void setListings(Long listings) {
			this.listings = listings;
		}

		/**
		 *
		 * @return
		 * The unitPrice
		 */
		public Long getUnitPrice() {
			return unitPrice;
		}

		/**
		 *
		 * @param unitPrice
		 * The unit_price
		 */
		public void setUnitPrice(Long unitPrice) {
			this.unitPrice = unitPrice;
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

	public class Sell {

		@SerializedName("listings")
		@Expose
		private Long listings;
		@SerializedName("unit_price")
		@Expose
		private Long unitPrice;
		@SerializedName("quantity")
		@Expose
		private Long quantity;

		/**
		 *
		 * @return
		 * The listings
		 */
		public Long getListings() {
			return listings;
		}

		/**
		 *
		 * @param listings
		 * The listings
		 */
		public void setListings(Long listings) {
			this.listings = listings;
		}

		/**
		 *
		 * @return
		 * The unitPrice
		 */
		public Long getUnitPrice() {
			return unitPrice;
		}

		/**
		 *
		 * @param unitPrice
		 * The unit_price
		 */
		public void setUnitPrice(Long unitPrice) {
			this.unitPrice = unitPrice;
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
}