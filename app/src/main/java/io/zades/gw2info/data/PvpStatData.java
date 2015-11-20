package io.zades.gw2info.data;


import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class PvpStatData
{

	@SerializedName("pvp_rank")
	@Expose
	private Long pvpRank;
	@SerializedName("aggregate")
	@Expose
	private Aggregate aggregate;
	@SerializedName("professions")
	@Expose
	private Professions professions;
	@SerializedName("ladders")
	@Expose
	private Ladders ladders;

	/**
	 * @return The pvpRank
	 */
	public Long getPvpRank()
	{
		return pvpRank;
	}

	/**
	 * @param pvpRank The pvp_rank
	 */
	public void setPvpRank(Long pvpRank)
	{
		this.pvpRank = pvpRank;
	}

	/**
	 * @return The aggregate
	 */
	public Aggregate getAggregate()
	{
		return aggregate;
	}

	/**
	 * @param aggregate The aggregate
	 */
	public void setAggregate(Aggregate aggregate)
	{
		this.aggregate = aggregate;
	}

	/**
	 * @return The professions
	 */
	public Professions getProfessions()
	{
		return professions;
	}

	/**
	 * @param professions The professions
	 */
	public void setProfessions(Professions professions)
	{
		this.professions = professions;
	}

	/**
	 * @return The ladders
	 */
	public Ladders getLadders()
	{
		return ladders;
	}

	/**
	 * @param ladders The ladders
	 */
	public void setLadders(Ladders ladders)
	{
		this.ladders = ladders;
	}

	@Generated("org.jsonschema2pojo")
	public class Aggregate
	{

		@SerializedName("wins")
		@Expose
		private Long wins;
		@SerializedName("losses")
		@Expose
		private Long losses;
		@SerializedName("desertions")
		@Expose
		private Long desertions;
		@SerializedName("byes")
		@Expose
		private Long byes;
		@SerializedName("forfeits")
		@Expose
		private Long forfeits;

		/**
		 * @return The wins
		 */
		public Long getWins()
		{
			return wins;
		}

		/**
		 * @param wins The wins
		 */
		public void setWins(Long wins)
		{
			this.wins = wins;
		}

		/**
		 * @return The losses
		 */
		public Long getLosses()
		{
			return losses;
		}

		/**
		 * @param losses The losses
		 */
		public void setLosses(Long losses)
		{
			this.losses = losses;
		}

		/**
		 * @return The desertions
		 */
		public Long getDesertions()
		{
			return desertions;
		}

		/**
		 * @param desertions The desertions
		 */
		public void setDesertions(Long desertions)
		{
			this.desertions = desertions;
		}

		/**
		 * @return The byes
		 */
		public Long getByes()
		{
			return byes;
		}

		/**
		 * @param byes The byes
		 */
		public void setByes(Long byes)
		{
			this.byes = byes;
		}

		/**
		 * @return The forfeits
		 */
		public Long getForfeits()
		{
			return forfeits;
		}

		/**
		 * @param forfeits The forfeits
		 */
		public void setForfeits(Long forfeits)
		{
			this.forfeits = forfeits;
		}

	}


	@Generated("org.jsonschema2pojo")
	public class Ladders
	{

		@SerializedName("ranked")
		@Expose
		private Ranked ranked;
		@SerializedName("unranked")
		@Expose
		private Unranked unranked;

		/**
		 * @return The ranked
		 */
		public Ranked getRanked()
		{
			return ranked;
		}

		/**
		 * @param ranked The ranked
		 */
		public void setRanked(Ranked ranked)
		{
			this.ranked = ranked;
		}

		/**
		 * @return The unranked
		 */
		public Unranked getUnranked()
		{
			return unranked;
		}

		/**
		 * @param unranked The unranked
		 */
		public void setUnranked(Unranked unranked)
		{
			this.unranked = unranked;
		}

	}

	@Generated("org.jsonschema2pojo")
	public class Ranked
	{

		@SerializedName("wins")
		@Expose
		private Long wins;
		@SerializedName("losses")
		@Expose
		private Long losses;
		@SerializedName("desertions")
		@Expose
		private Long desertions;
		@SerializedName("byes")
		@Expose
		private Long byes;
		@SerializedName("forfeits")
		@Expose
		private Long forfeits;

		/**
		 * @return The wins
		 */
		public Long getWins()
		{
			return wins;
		}

		/**
		 * @param wins The wins
		 */
		public void setWins(Long wins)
		{
			this.wins = wins;
		}

		/**
		 * @return The losses
		 */
		public Long getLosses()
		{
			return losses;
		}

		/**
		 * @param losses The losses
		 */
		public void setLosses(Long losses)
		{
			this.losses = losses;
		}

		/**
		 * @return The desertions
		 */
		public Long getDesertions()
		{
			return desertions;
		}

		/**
		 * @param desertions The desertions
		 */
		public void setDesertions(Long desertions)
		{
			this.desertions = desertions;
		}

		/**
		 * @return The byes
		 */
		public Long getByes()
		{
			return byes;
		}

		/**
		 * @param byes The byes
		 */
		public void setByes(Long byes)
		{
			this.byes = byes;
		}

		/**
		 * @return The forfeits
		 */
		public Long getForfeits()
		{
			return forfeits;
		}

		/**
		 * @param forfeits The forfeits
		 */
		public void setForfeits(Long forfeits)
		{
			this.forfeits = forfeits;
		}

	}

	@Generated("org.jsonschema2pojo")
	public class Unranked
	{

		@SerializedName("wins")
		@Expose
		private Long wins;
		@SerializedName("losses")
		@Expose
		private Long losses;
		@SerializedName("desertions")
		@Expose
		private Long desertions;
		@SerializedName("byes")
		@Expose
		private Long byes;
		@SerializedName("forfeits")
		@Expose
		private Long forfeits;

		/**
		 * @return The wins
		 */
		public Long getWins()
		{
			return wins;
		}

		/**
		 * @param wins The wins
		 */
		public void setWins(Long wins)
		{
			this.wins = wins;
		}

		/**
		 * @return The losses
		 */
		public Long getLosses()
		{
			return losses;
		}

		/**
		 * @param losses The losses
		 */
		public void setLosses(Long losses)
		{
			this.losses = losses;
		}

		/**
		 * @return The desertions
		 */
		public Long getDesertions()
		{
			return desertions;
		}

		/**
		 * @param desertions The desertions
		 */
		public void setDesertions(Long desertions)
		{
			this.desertions = desertions;
		}

		/**
		 * @return The byes
		 */
		public Long getByes()
		{
			return byes;
		}

		/**
		 * @param byes The byes
		 */
		public void setByes(Long byes)
		{
			this.byes = byes;
		}

		/**
		 * @return The forfeits
		 */
		public Long getForfeits()
		{
			return forfeits;
		}

		/**
		 * @param forfeits The forfeits
		 */
		public void setForfeits(Long forfeits)
		{
			this.forfeits = forfeits;
		}

	}

	@Generated("org.jsonschema2pojo")
	public class Professions
	{

		@SerializedName("elementalist")
		@Expose
		private Elementalist elementalist;
		@SerializedName("engineer")
		@Expose
		private Engineer engineer;
		@SerializedName("guardian")
		@Expose
		private Guardian guardian;
		@SerializedName("mesmer")
		@Expose
		private Mesmer mesmer;
		@SerializedName("necromancer")
		@Expose
		private Necromancer necromancer;
		@SerializedName("ranger")
		@Expose
		private Ranger ranger;
		@SerializedName("revanant")
		@Expose
		private Revenant revenant;
		@SerializedName("thief")
		@Expose
		private Thief thief;
		@SerializedName("warrior")
		@Expose
		private Warrior warrior;

		/**
		 * @return The elementalist
		 */
		public Elementalist getElementalist()
		{
			return elementalist;
		}

		/**
		 * @param elementalist The elementalist
		 */
		public void setElementalist(Elementalist elementalist)
		{
			this.elementalist = elementalist;
		}

		/**
		 * @return The guardian
		 */
		public Guardian getGuardian()
		{
			return guardian;
		}

		/**
		 * @param guardian The guardian
		 */
		public void setGuardian(Guardian guardian)
		{
			this.guardian = guardian;
		}

		public Engineer getEngineer()
		{
			return engineer;
		}

		public void setEngineer(Engineer engineer)
		{
			this.engineer = engineer;
		}

		public Mesmer getMesmer()
		{
			return mesmer;
		}

		public void setMesmer(Mesmer mesmer)
		{
			this.mesmer = mesmer;
		}

		public Necromancer getNecromancer()
		{
			return necromancer;
		}

		public void setNecromancer(Necromancer necromancer)
		{
			this.necromancer = necromancer;
		}

		public Ranger getRanger()
		{
			return ranger;
		}

		public void setRanger(Ranger ranger)
		{
			this.ranger = ranger;
		}

		public Revenant getRevenant()
		{
			return revenant;
		}

		public void setRevenant(Revenant revenant)
		{
			this.revenant = revenant;
		}

		public Thief getThief()
		{
			return thief;
		}

		public void setThief(Thief thief)
		{
			this.thief = thief;
		}

		public Warrior getWarrior()
		{
			return warrior;
		}

		public void setWarrior(Warrior warrior)
		{
			this.warrior = warrior;
		}

		@Generated("org.jsonschema2pojo")
		public class ProfessionBase
		{

			@SerializedName("wins")
			@Expose
			protected Long wins;
			@SerializedName("losses")
			@Expose
			protected Long losses;
			@SerializedName("desertions")
			@Expose
			protected Long desertions;
			@SerializedName("byes")
			@Expose
			protected Long byes;
			@SerializedName("forfeits")
			@Expose
			protected Long forfeits;

			/**
			 * @return The wins
			 */
			public Long getWins()
			{
				return wins;
			}

			/**
			 * @param wins The wins
			 */
			public void setWins(Long wins)
			{
				this.wins = wins;
			}

			/**
			 * @return The losses
			 */
			public Long getLosses()
			{
				return losses;
			}

			/**
			 * @param losses The losses
			 */
			public void setLosses(Long losses)
			{
				this.losses = losses;
			}

			/**
			 * @return The desertions
			 */
			public Long getDesertions()
			{
				return desertions;
			}

			/**
			 * @param desertions The desertions
			 */
			public void setDesertions(Long desertions)
			{
				this.desertions = desertions;
			}

			/**
			 * @return The byes
			 */
			public Long getByes()
			{
				return byes;
			}

			/**
			 * @param byes The byes
			 */
			public void setByes(Long byes)
			{
				this.byes = byes;
			}

			/**
			 * @return The forfeits
			 */
			public Long getForfeits()
			{
				return forfeits;
			}

			/**
			 * @param forfeits The forfeits
			 */
			public void setForfeits(Long forfeits)
			{
				this.forfeits = forfeits;
			}

		}

		public class Elementalist extends ProfessionBase {};
		public class Engineer extends ProfessionBase {};
		public class Guardian extends ProfessionBase {};
		public class Mesmer extends ProfessionBase {};
		public class Necromancer extends ProfessionBase {};
		public class Ranger extends ProfessionBase {};
		public class Revenant extends ProfessionBase {};
		public class Thief extends ProfessionBase {};
		public class Warrior extends ProfessionBase {};

	}
}