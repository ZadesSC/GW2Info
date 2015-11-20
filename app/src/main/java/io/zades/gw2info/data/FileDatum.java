package io.zades.gw2info.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FileDatum {

	@SerializedName("id")
	@Expose
	private String id;
	@SerializedName("icon")
	@Expose
	private String icon;

	/**
	 *
	 * @return
	 * The id
	 */
	public String getId() {
		return id;
	}

	/**
	 *
	 * @param id
	 * The id
	 */
	public void setId(String id) {
		this.id = id;
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

}