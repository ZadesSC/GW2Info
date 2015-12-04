package io.zades.gw2info.data.pojo;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CharacterDatum
{

	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("race")
	@Expose
	private String race;
	@SerializedName("gender")
	@Expose
	private String gender;
	@SerializedName("profession")
	@Expose
	private String profession;
	@SerializedName("level")
	@Expose
	private Long level;
	@SerializedName("guild")
	@Expose
	private String guild;
	@SerializedName("age")
	@Expose
	private Long age;
	@SerializedName("created")
	@Expose
	private String created;
	@SerializedName("deaths")
	@Expose
	private Long deaths;
	@SerializedName("crafting")
	@Expose
	private List<Crafting> crafting = new ArrayList<Crafting>();
	@SerializedName("specializations")
	@Expose
	private Specializations specializations;
	@SerializedName("equipment")
	@Expose
	private List<Equipment> equipment = new ArrayList<Equipment>();
	@SerializedName("bags")
	@Expose
	private List<Bag> bags = new ArrayList<Bag>();

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
	 * The race
	 */
	public String getRace() {
		return race;
	}

	/**
	 *
	 * @param race
	 * The race
	 */
	public void setRace(String race) {
		this.race = race;
	}

	/**
	 *
	 * @return
	 * The gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 *
	 * @param gender
	 * The gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
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
	 * The guild
	 */
	public String getGuild() {
		return guild;
	}

	/**
	 *
	 * @param guild
	 * The guild
	 */
	public void setGuild(String guild) {
		this.guild = guild;
	}

	/**
	 *
	 * @return
	 * The age
	 */
	public Long getAge() {
		return age;
	}

	/**
	 *
	 * @param age
	 * The age
	 */
	public void setAge(Long age) {
		this.age = age;
	}

	/**
	 *
	 * @return
	 * The created
	 */
	public String getCreated() {
		return created;
	}

	/**
	 *
	 * @param created
	 * The created
	 */
	public void setCreated(String created) {
		this.created = created;
	}

	/**
	 *
	 * @return
	 * The deaths
	 */
	public Long getDeaths() {
		return deaths;
	}

	/**
	 *
	 * @param deaths
	 * The deaths
	 */
	public void setDeaths(Long deaths) {
		this.deaths = deaths;
	}

	/**
	 *
	 * @return
	 * The crafting
	 */
	public List<Crafting> getCrafting() {
		return crafting;
	}

	/**
	 *
	 * @param crafting
	 * The crafting
	 */
	public void setCrafting(List<Crafting> crafting) {
		this.crafting = crafting;
	}

	/**
	 *
	 * @return
	 * The specializations
	 */
	public Specializations getSpecializations() {
		return specializations;
	}

	/**
	 *
	 * @param specializations
	 * The specializations
	 */
	public void setSpecializations(Specializations specializations) {
		this.specializations = specializations;
	}

	/**
	 *
	 * @return
	 * The equipment
	 */
	public List<Equipment> getEquipment() {
		return equipment;
	}

	/**
	 *
	 * @param equipment
	 * The equipment
	 */
	public void setEquipment(List<Equipment> equipment) {
		this.equipment = equipment;
	}

	/**
	 *
	 * @return
	 * The bags
	 */
	public List<Bag> getBags() {
		return bags;
	}

	/**
	 *
	 * @param bags
	 * The bags
	 */
	public void setBags(List<Bag> bags) {
		this.bags = bags;
	}


	public class Bag {

		@SerializedName("id")
		@Expose
		private Long id;
		@SerializedName("size")
		@Expose
		private Long size;
		@SerializedName("inventory")
		@Expose
		private List<Inventory> inventory = new ArrayList<Inventory>();

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
		 * The size
		 */
		public Long getSize() {
			return size;
		}

		/**
		 *
		 * @param size
		 * The size
		 */
		public void setSize(Long size) {
			this.size = size;
		}

		/**
		 *
		 * @return
		 * The inventory
		 */
		public List<Inventory> getInventory() {
			return inventory;
		}

		/**
		 *
		 * @param inventory
		 * The inventory
		 */
		public void setInventory(List<Inventory> inventory) {
			this.inventory = inventory;
		}

	}

	public class Crafting {

		@SerializedName("discipline")
		@Expose
		private String discipline;
		@SerializedName("rating")
		@Expose
		private Long rating;
		@SerializedName("active")
		@Expose
		private Boolean active;

		/**
		 *
		 * @return
		 * The discipline
		 */
		public String getDiscipline() {
			return discipline;
		}

		/**
		 *
		 * @param discipline
		 * The discipline
		 */
		public void setDiscipline(String discipline) {
			this.discipline = discipline;
		}

		/**
		 *
		 * @return
		 * The rating
		 */
		public Long getRating() {
			return rating;
		}

		/**
		 *
		 * @param rating
		 * The rating
		 */
		public void setRating(Long rating) {
			this.rating = rating;
		}

		/**
		 *
		 * @return
		 * The active
		 */
		public Boolean getActive() {
			return active;
		}

		/**
		 *
		 * @param active
		 * The active
		 */
		public void setActive(Boolean active) {
			this.active = active;
		}

	}

	public class Equipment {

		@SerializedName("id")
		@Expose
		private Long id;
		@SerializedName("slot")
		@Expose
		private String slot;
		@SerializedName("upgrades")
		@Expose
		private List<Long> upgrades = new ArrayList<Long>();
		@SerializedName("skin")
		@Expose
		private Long skin;
		@SerializedName("infusions")
		@Expose
		private List<Long> infusions = new ArrayList<Long>();

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
		 * The slot
		 */
		public String getSlot() {
			return slot;
		}

		/**
		 *
		 * @param slot
		 * The slot
		 */
		public void setSlot(String slot) {
			this.slot = slot;
		}

		/**
		 *
		 * @return
		 * The upgrades
		 */
		public List<Long> getUpgrades() {
			return upgrades;
		}

		/**
		 *
		 * @param upgrades
		 * The upgrades
		 */
		public void setUpgrades(List<Long> upgrades) {
			this.upgrades = upgrades;
		}

		/**
		 *
		 * @return
		 * The skin
		 */
		public Long getSkin() {
			return skin;
		}

		/**
		 *
		 * @param skin
		 * The skin
		 */
		public void setSkin(Long skin) {
			this.skin = skin;
		}

		/**
		 *
		 * @return
		 * The infusions
		 */
		public List<Long> getInfusions() {
			return infusions;
		}

		/**
		 *
		 * @param infusions
		 * The infusions
		 */
		public void setInfusions(List<Long> infusions) {
			this.infusions = infusions;
		}

	}

	public class Inventory {

		@SerializedName("id")
		@Expose
		private Long id;
		@SerializedName("count")
		@Expose
		private Long count;
		@SerializedName("binding")
		@Expose
		private String binding;
		@SerializedName("bound_to")
		@Expose
		private String boundTo;
		@SerializedName("infix_upgrade_id")
		@Expose
		private Long infixUpgradeId;
		@SerializedName("upgrades")
		@Expose
		private List<Long> upgrades = new ArrayList<Long>();

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

		/**
		 *
		 * @return
		 * The binding
		 */
		public String getBinding() {
			return binding;
		}

		/**
		 *
		 * @param binding
		 * The binding
		 */
		public void setBinding(String binding) {
			this.binding = binding;
		}

		/**
		 *
		 * @return
		 * The boundTo
		 */
		public String getBoundTo() {
			return boundTo;
		}

		/**
		 *
		 * @param boundTo
		 * The bound_to
		 */
		public void setBoundTo(String boundTo) {
			this.boundTo = boundTo;
		}

		/**
		 *
		 * @return
		 * The infixUpgradeId
		 */
		public Long getInfixUpgradeId() {
			return infixUpgradeId;
		}

		/**
		 *
		 * @param infixUpgradeId
		 * The infix_upgrade_id
		 */
		public void setInfixUpgradeId(Long infixUpgradeId) {
			this.infixUpgradeId = infixUpgradeId;
		}

		/**
		 *
		 * @return
		 * The upgrades
		 */
		public List<Long> getUpgrades() {
			return upgrades;
		}

		/**
		 *
		 * @param upgrades
		 * The upgrades
		 */
		public void setUpgrades(List<Long> upgrades) {
			this.upgrades = upgrades;
		}

	}

	public class Pve {

		@SerializedName("id")
		@Expose
		private Long id;
		@SerializedName("traits")
		@Expose
		private List<Long> traits = new ArrayList<Long>();

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
		 * The traits
		 */
		public List<Long> getTraits() {
			return traits;
		}

		/**
		 *
		 * @param traits
		 * The traits
		 */
		public void setTraits(List<Long> traits) {
			this.traits = traits;
		}

	}

	public class Pvp {

		@SerializedName("id")
		@Expose
		private Long id;
		@SerializedName("traits")
		@Expose
		private List<Long> traits = new ArrayList<Long>();

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
		 * The traits
		 */
		public List<Long> getTraits() {
			return traits;
		}

		/**
		 *
		 * @param traits
		 * The traits
		 */
		public void setTraits(List<Long> traits) {
			this.traits = traits;
		}

	}

	public class Specializations {

		@SerializedName("pve")
		@Expose
		private List<Pve> pve = new ArrayList<Pve>();
		@SerializedName("pvp")
		@Expose
		private List<Pvp> pvp = new ArrayList<Pvp>();
		@SerializedName("wvw")
		@Expose
		private List<Wvw> wvw = new ArrayList<Wvw>();

		/**
		 *
		 * @return
		 * The pve
		 */
		public List<Pve> getPve() {
			return pve;
		}

		/**
		 *
		 * @param pve
		 * The pve
		 */
		public void setPve(List<Pve> pve) {
			this.pve = pve;
		}

		/**
		 *
		 * @return
		 * The pvp
		 */
		public List<Pvp> getPvp() {
			return pvp;
		}

		/**
		 *
		 * @param pvp
		 * The pvp
		 */
		public void setPvp(List<Pvp> pvp) {
			this.pvp = pvp;
		}

		/**
		 *
		 * @return
		 * The wvw
		 */
		public List<Wvw> getWvw() {
			return wvw;
		}

		/**
		 *
		 * @param wvw
		 * The wvw
		 */
		public void setWvw(List<Wvw> wvw) {
			this.wvw = wvw;
		}

	}

	public class Wvw {

		@SerializedName("id")
		@Expose
		private Long id;
		@SerializedName("traits")
		@Expose
		private List<Long> traits = new ArrayList<Long>();

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
		 * The traits
		 */
		public List<Long> getTraits() {
			return traits;
		}

		/**
		 *
		 * @param traits
		 * The traits
		 */
		public void setTraits(List<Long> traits) {
			this.traits = traits;
		}

	}
}