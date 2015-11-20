package io.zades.gw2info.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MiniDatum {

	@SerializedName("id")
	@Expose
	private Long id;
	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("icon")
	@Expose
	private String icon;
	@SerializedName("order")
	@Expose
	private Long order;
	@SerializedName("item_id")
	@Expose
	private Long itemId;

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
	 * The name
	 */
	public String getName() {
		return name;
	}

	/**
	 *
	 * @param name
	 * The name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 *
	 * @return
	 * The icon
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 *
	 * @param icon
	 * The icon
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

	/**
	 *
	 * @return
	 * The order
	 */
	public Long getOrder() {
		return order;
	}

	/**
	 *
	 * @param order
	 * The order
	 */
	public void setOrder(Long order) {
		this.order = order;
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

}