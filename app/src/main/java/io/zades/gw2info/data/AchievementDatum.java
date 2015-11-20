package io.zades.gw2info.data;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AchievementDatum
{

	@SerializedName("id")
	@Expose
	private Long id;
	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("description")
	@Expose
	private String description;
	@SerializedName("requirement")
	@Expose
	private String requirement;
	@SerializedName("type")
	@Expose
	private String type;
	@SerializedName("flags")
	@Expose
	private List<String> flags = new ArrayList<String>();

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
	 * The description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 *
	 * @param description
	 * The description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 *
	 * @return
	 * The requirement
	 */
	public String getRequirement() {
		return requirement;
	}

	/**
	 *
	 * @param requirement
	 * The requirement
	 */
	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}

	/**
	 *
	 * @return
	 * The type
	 */
	public String getType() {
		return type;
	}

	/**
	 *
	 * @param type
	 * The type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 *
	 * @return
	 * The flags
	 */
	public List<String> getFlags() {
		return flags;
	}

	/**
	 *
	 * @param flags
	 * The flags
	 */
	public void setFlags(List<String> flags) {
		this.flags = flags;
	}

}