
package io.zades.gw2info.data;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class AccountMaterialDatum
{

	@SerializedName("id")
	@Expose
	private Long id;
	@SerializedName("category")
	@Expose
	private Long category;
	@SerializedName("count")
	@Expose
	private Long count;

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
	 * The category
	 */
	public Long getCategory() {
		return category;
	}

	/**
	 *
	 * @param category
	 * The category
	 */
	public void setCategory(Long category) {
		this.category = category;
	}

	/**
	 *
	 * @return
	 * The count
	 */
	public Long getCount() {
		return count;
	}

	/**
	 *
	 * @param count
	 * The count
	 */
	public void setCount(Long count) {
		this.count = count;
	}

}