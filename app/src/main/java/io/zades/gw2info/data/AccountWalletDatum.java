package io.zades.gw2info.data;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AccountWalletDatum
{

	@SerializedName("id")
	@Expose
	private Long id;
	@SerializedName("value")
	@Expose
	private Long value;

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
	 * The value
	 */
	public Long getValue() {
		return value;
	}

	/**
	 *
	 * @param value
	 * The value
	 */
	public void setValue(Long value) {
		this.value = value;
	}

}
