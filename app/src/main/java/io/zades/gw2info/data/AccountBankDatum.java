package io.zades.gw2info.data;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class AccountBankDatum
{

	@SerializedName("id")
	@Expose
	private Integer id;
	@SerializedName("count")
	@Expose
	private Integer count;
	@SerializedName("upgrades")
	@Expose
	private List<Integer> upgrades = new ArrayList<Integer>();
	@SerializedName("infusions")
	@Expose
	private List<Integer> infusions = new ArrayList<Integer>();
	@SerializedName("skin")
	@Expose
	private Integer skin;

	/**
	 *
	 * @return
	 * The id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 *
	 * @param id
	 * The id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 *
	 * @return
	 * The count
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 *
	 * @param count
	 * The count
	 */
	public void setCount(Integer count) {
		this.count = count;
	}

	/**
	 *
	 * @return
	 * The upgrades
	 */
	public List<Integer> getUpgrades() {
		return upgrades;
	}

	/**
	 *
	 * @param upgrades
	 * The upgrades
	 */
	public void setUpgrades(List<Integer> upgrades) {
		this.upgrades = upgrades;
	}

	/**
	 *
	 * @return
	 * The infusions
	 */
	public List<Integer> getInfusions() {
		return infusions;
	}

	/**
	 *
	 * @param infusions
	 * The infusions
	 */
	public void setInfusions(List<Integer> infusions) {
		this.infusions = infusions;
	}

	/**
	 *
	 * @return
	 * The skin
	 */
	public Integer getSkin() {
		return skin;
	}

	/**
	 *
	 * @param skin
	 * The skin
	 */
	public void setSkin(Integer skin) {
		this.skin = skin;
	}

}