package io.zades.gw2info.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CommerceTransactionDatum {

	@SerializedName("id")
	@Expose
	private Long id;
	@SerializedName("item_id")
	@Expose
	private Long itemId;
	@SerializedName("price")
	@Expose
	private Long price;
	@SerializedName("quantity")
	@Expose
	private Long quantity;
	@SerializedName("created")
	@Expose
	private String created;
	@SerializedName("purchased")
	@Expose
	private String purchased;

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
	 * The itemId
	 */
	public Long getItemId() {
		return itemId;
	}

	/**
	 *
	 * @param itemId
	 * The item_id
	 */
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	/**
	 *
	 * @return
	 * The price
	 */
	public Long getPrice() {
		return price;
	}

	/**
	 *
	 * @param price
	 * The price
	 */
	public void setPrice(Long price) {
		this.price = price;
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

	/**
	 *
	 * @return
	 * The created
	 */
	public String getCreated() {
		return created;
	}

	/**
	 *
	 * @param created
	 * The created
	 */
	public void setCreated(String created) {
		this.created = created;
	}

	/**
	 *
	 * @return
	 * The purchased
	 */
	public String getPurchased() {
		return purchased;
	}

	/**
	 *
	 * @param purchased
	 * The purchased
	 */
	public void setPurchased(String purchased) {
		this.purchased = purchased;
	}

}