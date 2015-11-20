package io.zades.gw2info.data;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SpecializationDatum {

	@SerializedName("id")
	@Expose
	private Long id;
	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("profession")
	@Expose
	private String profession;
	@SerializedName("elite")
	@Expose
	private Boolean elite;
	@SerializedName("minor_traits")
	@Expose
	private List<Long> minorTraits = new ArrayList<Long>();
	@SerializedName("major_traits")
	@Expose
	private List<Long> majorTraits = new ArrayList<Long>();
	@SerializedName("icon")
	@Expose
	private String icon;
	@SerializedName("background")
	@Expose
	private String background;

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
	 * The profession
	 */
	public String getProfession() {
		return profession;
	}

	/**
	 *
	 * @param profession
	 * The profession
	 */
	public void setProfession(String profession) {
		this.profession = profession;
	}

	/**
	 *
	 * @return
	 * The elite
	 */
	public Boolean getElite() {
		return elite;
	}

	/**
	 *
	 * @param elite
	 * The elite
	 */
	public void setElite(Boolean elite) {
		this.elite = elite;
	}

	/**
	 *
	 * @return
	 * The minorTraits
	 */
	public List<Long> getMinorTraits() {
		return minorTraits;
	}

	/**
	 *
	 * @param minorTraits
	 * The minor_traits
	 */
	public void setMinorTraits(List<Long> minorTraits) {
		this.minorTraits = minorTraits;
	}

	/**
	 *
	 * @return
	 * The majorTraits
	 */
	public List<Long> getMajorTraits() {
		return majorTraits;
	}

	/**
	 *
	 * @param majorTraits
	 * The major_traits
	 */
	public void setMajorTraits(List<Long> majorTraits) {
		this.majorTraits = majorTraits;
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
	 * The background
	 */
	public String getBackground() {
		return background;
	}

	/**
	 *
	 * @param background
	 * The background
	 */
	public void setBackground(String background) {
		this.background = background;
	}

}