package io.zades.gw2info.data.pojo;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemDatum {

	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("description")
	@Expose
	private String description;
	@SerializedName("type")
	@Expose
	private String type;
	@SerializedName("level")
	@Expose
	private Long level;
	@SerializedName("rarity")
	@Expose
	private String rarity;
	@SerializedName("vendor_value")
	@Expose
	private Long vendorValue;
	@SerializedName("default_skin")
	@Expose
	private String defaultSkin;
	@SerializedName("game_types")
	@Expose
	private List<String> gameTypes = new ArrayList<String>();
	@SerializedName("flags")
	@Expose
	private List<String> flags = new ArrayList<String>();
	@SerializedName("restrictions")
	@Expose
	private List<Object> restrictions = new ArrayList<Object>();
	@SerializedName("id")
	@Expose
	private Long id;
	@SerializedName("chat_link")
	@Expose
	private String chatLink;
	@SerializedName("icon")
	@Expose
	private String icon;
	@SerializedName("details")
	@Expose
	private Details details;

	public ItemDatum()
	{

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
	 * The level
	 */
	public Long getLevel() {
		return level;
	}

	/**
	 *
	 * @param level
	 * The level
	 */
	public void setLevel(Long level) {
		this.level = level;
	}

	/**
	 *
	 * @return
	 * The rarity
	 */
	public String getRarity() {
		return rarity;
	}

	/**
	 *
	 * @param rarity
	 * The rarity
	 */
	public void setRarity(String rarity) {
		this.rarity = rarity;
	}

	/**
	 *
	 * @return
	 * The vendorValue
	 */
	public Long getVendorValue() {
		return vendorValue;
	}

	/**
	 *
	 * @param vendorValue
	 * The vendor_value
	 */
	public void setVendorValue(Long vendorValue) {
		this.vendorValue = vendorValue;
	}

	/**
	 *
	 * @return
	 * The defaultSkin
	 */
	public String getDefaultSkin() {
		return defaultSkin;
	}

	/**
	 *
	 * @param defaultSkin
	 * The default_skin
	 */
	public void setDefaultSkin(String defaultSkin) {
		this.defaultSkin = defaultSkin;
	}

	/**
	 *
	 * @return
	 * The gameTypes
	 */
	public List<String> getGameTypes() {
		return gameTypes;
	}

	/**
	 *
	 * @param gameTypes
	 * The game_types
	 */
	public void setGameTypes(List<String> gameTypes) {
		this.gameTypes = gameTypes;
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
	 * The chatLink
	 */
	public String getChatLink() {
		return chatLink;
	}

	/**
	 *
	 * @param chatLink
	 * The chat_link
	 */
	public void setChatLink(String chatLink) {
		this.chatLink = chatLink;
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

	public class Attribute {

		@SerializedName("attribute")
		@Expose
		private String attribute;
		@SerializedName("modifier")
		@Expose
		private Long modifier;

		/**
		 *
		 * @return
		 * The attribute
		 */
		public String getAttribute() {
			return attribute;
		}

		/**
		 *
		 * @param attribute
		 * The attribute
		 */
		public void setAttribute(String attribute) {
			this.attribute = attribute;
		}

		/**
		 *
		 * @return
		 * The modifier
		 */
		public Long getModifier() {
			return modifier;
		}

		/**
		 *
		 * @param modifier
		 * The modifier
		 */
		public void setModifier(Long modifier) {
			this.modifier = modifier;
		}

	}

	public class Details
	{

		@SerializedName("type")
		@Expose
		private String type;
		@SerializedName("damage_type")
		@Expose
		private String damageType;
		@SerializedName("min_power")
		@Expose
		private Long minPower;
		@SerializedName("max_power")
		@Expose
		private Long maxPower;
		@SerializedName("defense")
		@Expose
		private Long defense;
		@SerializedName("infusion_slots")
		@Expose
		private List<Object> infusionSlots = new ArrayList<Object>();
		@SerializedName("infix_upgrade")
		@Expose
		private InfixUpgrade infixUpgrade;
		@SerializedName("suffix_item_id")
		@Expose
		private Long suffixItemId;
		@SerializedName("secondary_suffix_item_id")
		@Expose
		private String secondarySuffixItemId;

		/**
		 * @return The type
		 */
		public String getType()
		{
			return type;
		}

		/**
		 * @param type The type
		 */
		public void setType(String type)
		{
			this.type = type;
		}

		/**
		 * @return The damageType
		 */
		public String getDamageType()
		{
			return damageType;
		}

		/**
		 * @param damageType The damage_type
		 */
		public void setDamageType(String damageType)
		{
			this.damageType = damageType;
		}

		/**
		 * @return The minPower
		 */
		public Long getMinPower()
		{
			return minPower;
		}

		/**
		 * @param minPower The min_power
		 */
		public void setMinPower(Long minPower)
		{
			this.minPower = minPower;
		}

		/**
		 * @return The maxPower
		 */
		public Long getMaxPower()
		{
			return maxPower;
		}

		/**
		 * @param maxPower The max_power
		 */
		public void setMaxPower(Long maxPower)
		{
			this.maxPower = maxPower;
		}

		/**
		 * @return The defense
		 */
		public Long getDefense()
		{
			return defense;
		}

		/**
		 * @param defense The defense
		 */
		public void setDefense(Long defense)
		{
			this.defense = defense;
		}

		/**
		 * @return The infusionSlots
		 */
		public List<Object> getInfusionSlots()
		{
			return infusionSlots;
		}

		/**
		 * @param infusionSlots The infusion_slots
		 */
		public void setInfusionSlots(List<Object> infusionSlots)
		{
			this.infusionSlots = infusionSlots;
		}

		/**
		 * @return The infixUpgrade
		 */
		public InfixUpgrade getInfixUpgrade()
		{
			return infixUpgrade;
		}

		/**
		 * @param infixUpgrade The infix_upgrade
		 */
		public void setInfixUpgrade(InfixUpgrade infixUpgrade)
		{
			this.infixUpgrade = infixUpgrade;
		}

		/**
		 * @return The suffixItemId
		 */
		public Long getSuffixItemId()
		{
			return suffixItemId;
		}

		/**
		 * @param suffixItemId The suffix_item_id
		 */
		public void setSuffixItemId(Long suffixItemId)
		{
			this.suffixItemId = suffixItemId;
		}

		/**
		 * @return The secondarySuffixItemId
		 */
		public String getSecondarySuffixItemId()
		{
			return secondarySuffixItemId;
		}

		/**
		 * @param secondarySuffixItemId The secondary_suffix_item_id
		 */
		public void setSecondarySuffixItemId(String secondarySuffixItemId)
		{
			this.secondarySuffixItemId = secondarySuffixItemId;
		}
	}

	public class InfixUpgrade {

		@SerializedName("attributes")
		@Expose
		private List<Attribute> attributes = new ArrayList<Attribute>();

		/**
		 *
		 * @return
		 * The attributes
		 */
		public List<Attribute> getAttributes() {
			return attributes;
		}

		/**
		 *
		 * @param attributes
		 * The attributes
		 */
		public void setAttributes(List<Attribute> attributes) {
			this.attributes = attributes;
		}

	}
}