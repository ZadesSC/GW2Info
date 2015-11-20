package io.zades.gw2info.data;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class CommercePriceData {

	@SerializedName("id")
	@Expose
	private Long id;
	@SerializedName("buys")
	@Expose
	private Buys buys;
	@SerializedName("sells")
	@Expose
	private Sells sells;

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
	public Buys getBuys() {
		return buys;
	}

	/**
	 *
	 * @param buys
	 * The buys
	 */
	public void setBuys(Buys buys) {
		this.buys = buys;
	}

	/**
	 *
	 * @return
	 * The sells
	 */
	public Sells getSells() {
		return sells;
	}

	/**
	 *
	 * @param sells
	 * The sells
	 */
	public void setSells(Sells sells) {
		this.sells = sells;
	}

	@Generated("org.jsonschema2pojo")
	public class Buys {

		@SerializedName("quantity")
		@Expose
		private Long quantity;
		@SerializedName("unit_price")
		@Expose
		private Long unitPrice;

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

	}

	@Generated("org.jsonschema2pojo")
	public class Sells {

		@SerializedName("quantity")
		@Expose
		private Long quantity;
		@SerializedName("unit_price")
		@Expose
		private Long unitPrice;

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

	}
}