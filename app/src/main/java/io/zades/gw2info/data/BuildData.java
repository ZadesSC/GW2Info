package io.zades.gw2info.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BuildData {

	@SerializedName("id")
	@Expose
	private Long id;

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

}