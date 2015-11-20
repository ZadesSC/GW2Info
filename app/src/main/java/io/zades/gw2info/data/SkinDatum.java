package io.zades.gw2info.data;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class SkinDatum {

	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("type")
	@Expose
	private String type;
	@SerializedName("flags")
	@Expose
	private List<String> flags = new ArrayList<String>();
	@SerializedName("restrictions")
	@Expose
	private List<Object> restrictions = new ArrayList<Object>();
	@SerializedName("id")
	@Expose
	private Long id;
	@SerializedName("icon")
	@Expose
	private String icon;
	@SerializedName("details")
	@Expose
	private Details details;

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

	/**
	 *
	 * @return
	 * The restrictions
	 */
	public List<Object> getRestrictions() {
		return restrictions;
	}

	/**
	 *
	 * @param restrictions
	 * The restrictions
	 */
	public void setRestrictions(List<Object> restrictions) {
		this.restrictions = restrictions;
	}

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
	 * The details
	 */
	public Details getDetails() {
		return details;
	}

	/**
	 *
	 * @param details
	 * The details
	 */
	public void setDetails(Details details) {
		this.details = details;
	}

	@Generated("org.jsonschema2pojo")
	public class Details {

		@SerializedName("type")
		@Expose
		private String type;
		@SerializedName("weight_class")
		@Expose
		private String weightClass;

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
		 * The weightClass
		 */
		public String getWeightClass() {
			return weightClass;
		}

		/**
		 *
		 * @param weightClass
		 * The weight_class
		 */
		public void setWeightClass(String weightClass) {
			this.weightClass = weightClass;
		}

	}

}