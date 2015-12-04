package io.zades.gw2info.data.pojo;


import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TraitDatum {

	@SerializedName("id")
	@Expose
	private Long id;
	@SerializedName("tier")
	@Expose
	private Long tier;
	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("description")
	@Expose
	private String description;
	@SerializedName("slot")
	@Expose
	private String slot;
	@SerializedName("specialization")
	@Expose
	private Long specialization;
	@SerializedName("icon")
	@Expose
	private String icon;
	@SerializedName("facts")
	@Expose
	private List<Fact> facts = new ArrayList<Fact>();
	@SerializedName("traited_facts")
	@Expose
	private List<TraitedFact> traitedFacts = new ArrayList<TraitedFact>();

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
	 * The tier
	 */
	public Long getTier() {
		return tier;
	}

	/**
	 *
	 * @param tier
	 * The tier
	 */
	public void setTier(Long tier) {
		this.tier = tier;
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
	 * The specialization
	 */
	public Long getSpecialization() {
		return specialization;
	}

	/**
	 *
	 * @param specialization
	 * The specialization
	 */
	public void setSpecialization(Long specialization) {
		this.specialization = specialization;
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
	 * The facts
	 */
	public List<Fact> getFacts() {
		return facts;
	}

	/**
	 *
	 * @param facts
	 * The facts
	 */
	public void setFacts(List<Fact> facts) {
		this.facts = facts;
	}

	/**
	 *
	 * @return
	 * The traitedFacts
	 */
	public List<TraitedFact> getTraitedFacts() {
		return traitedFacts;
	}

	/**
	 *
	 * @param traitedFacts
	 * The traited_facts
	 */
	public void setTraitedFacts(List<TraitedFact> traitedFacts) {
		this.traitedFacts = traitedFacts;
	}

	public class Fact {

		@SerializedName("text")
		@Expose
		private String text;
		@SerializedName("type")
		@Expose
		private String type;
		@SerializedName("icon")
		@Expose
		private String icon;
		@SerializedName("percent")
		@Expose
		private Long percent;
		@SerializedName("value")
		@Expose
		private Long value;
		@SerializedName("target")
		@Expose
		private String target;

		/**
		 *
		 * @return
		 * The text
		 */
		public String getText() {
			return text;
		}

		/**
		 *
		 * @param text
		 * The text
		 */
		public void setText(String text) {
			this.text = text;
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
		 * The percent
		 */
		public Long getPercent() {
			return percent;
		}

		/**
		 *
		 * @param percent
		 * The percent
		 */
		public void setPercent(Long percent) {
			this.percent = percent;
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

		/**
		 *
		 * @return
		 * The target
		 */
		public String getTarget() {
			return target;
		}

		/**
		 *
		 * @param target
		 * The target
		 */
		public void setTarget(String target) {
			this.target = target;
		}

	}

	public class TraitedFact {

		@SerializedName("text")
		@Expose
		private String text;
		@SerializedName("type")
		@Expose
		private String type;
		@SerializedName("icon")
		@Expose
		private String icon;
		@SerializedName("value")
		@Expose
		private Long value;
		@SerializedName("requires_trait")
		@Expose
		private Long requiresTrait;
		@SerializedName("target")
		@Expose
		private String target;

		/**
		 *
		 * @return
		 * The text
		 */
		public String getText() {
			return text;
		}

		/**
		 *
		 * @param text
		 * The text
		 */
		public void setText(String text) {
			this.text = text;
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

		/**
		 *
		 * @return
		 * The requiresTrait
		 */
		public Long getRequiresTrait() {
			return requiresTrait;
		}

		/**
		 *
		 * @param requiresTrait
		 * The requires_trait
		 */
		public void setRequiresTrait(Long requiresTrait) {
			this.requiresTrait = requiresTrait;
		}

		/**
		 *
		 * @return
		 * The target
		 */
		public String getTarget() {
			return target;
		}

		/**
		 *
		 * @param target
		 * The target
		 */
		public void setTarget(String target) {
			this.target = target;
		}

	}
}