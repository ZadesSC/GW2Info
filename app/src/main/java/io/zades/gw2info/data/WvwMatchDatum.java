package io.zades.gw2info.data;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WvwMatchDatum {

	@SerializedName("id")
	@Expose
	private String id;
	@SerializedName("start_time")
	@Expose
	private String startTime;
	@SerializedName("end_time")
	@Expose
	private String endTime;
	@SerializedName("scores")
	@Expose
	private Scores scores;
	@SerializedName("worlds")
	@Expose
	private Worlds worlds;
	@SerializedName("deaths")
	@Expose
	private Deaths deaths;
	@SerializedName("kills")
	@Expose
	private Kills kills;
	@SerializedName("maps")
	@Expose
	private List<Map> maps = new ArrayList<Map>();

	/**
	 *
	 * @return
	 * The id
	 */
	public String getId() {
		return id;
	}

	/**
	 *
	 * @param id
	 * The id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 *
	 * @return
	 * The startTime
	 */
	public String getStartTime() {
		return startTime;
	}

	/**
	 *
	 * @param startTime
	 * The start_time
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	/**
	 *
	 * @return
	 * The endTime
	 */
	public String getEndTime() {
		return endTime;
	}

	/**
	 *
	 * @param endTime
	 * The end_time
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	/**
	 *
	 * @return
	 * The scores
	 */
	public Scores getScores() {
		return scores;
	}

	/**
	 *
	 * @param scores
	 * The scores
	 */
	public void setScores(Scores scores) {
		this.scores = scores;
	}

	/**
	 *
	 * @return
	 * The worlds
	 */
	public Worlds getWorlds() {
		return worlds;
	}

	/**
	 *
	 * @param worlds
	 * The worlds
	 */
	public void setWorlds(Worlds worlds) {
		this.worlds = worlds;
	}

	/**
	 *
	 * @return
	 * The deaths
	 */
	public Deaths getDeaths() {
		return deaths;
	}

	/**
	 *
	 * @param deaths
	 * The deaths
	 */
	public void setDeaths(Deaths deaths) {
		this.deaths = deaths;
	}

	/**
	 *
	 * @return
	 * The kills
	 */
	public Kills getKills() {
		return kills;
	}

	/**
	 *
	 * @param kills
	 * The kills
	 */
	public void setKills(Kills kills) {
		this.kills = kills;
	}

	/**
	 *
	 * @return
	 * The maps
	 */
	public List<Map> getMaps() {
		return maps;
	}

	/**
	 *
	 * @param maps
	 * The maps
	 */
	public void setMaps(List<Map> maps) {
		this.maps = maps;
	}

	public class Deaths {

		@SerializedName("red")
		@Expose
		private Long red;
		@SerializedName("blue")
		@Expose
		private Long blue;
		@SerializedName("green")
		@Expose
		private Long green;

		/**
		 *
		 * @return
		 * The red
		 */
		public Long getRed() {
			return red;
		}

		/**
		 *
		 * @param red
		 * The red
		 */
		public void setRed(Long red) {
			this.red = red;
		}

		/**
		 *
		 * @return
		 * The blue
		 */
		public Long getBlue() {
			return blue;
		}

		/**
		 *
		 * @param blue
		 * The blue
		 */
		public void setBlue(Long blue) {
			this.blue = blue;
		}

		/**
		 *
		 * @return
		 * The green
		 */
		public Long getGreen() {
			return green;
		}

		/**
		 *
		 * @param green
		 * The green
		 */
		public void setGreen(Long green) {
			this.green = green;
		}

	}

	public class Kills {

		@SerializedName("red")
		@Expose
		private Long red;
		@SerializedName("blue")
		@Expose
		private Long blue;
		@SerializedName("green")
		@Expose
		private Long green;

		/**
		 *
		 * @return
		 * The red
		 */
		public Long getRed() {
			return red;
		}

		/**
		 *
		 * @param red
		 * The red
		 */
		public void setRed(Long red) {
			this.red = red;
		}

		/**
		 *
		 * @return
		 * The blue
		 */
		public Long getBlue() {
			return blue;
		}

		/**
		 *
		 * @param blue
		 * The blue
		 */
		public void setBlue(Long blue) {
			this.blue = blue;
		}

		/**
		 *
		 * @return
		 * The green
		 */
		public Long getGreen() {
			return green;
		}

		/**
		 *
		 * @param green
		 * The green
		 */
		public void setGreen(Long green) {
			this.green = green;
		}

	}

	public class Map {

		@SerializedName("id")
		@Expose
		private Long id;
		@SerializedName("type")
		@Expose
		private String type;
		@SerializedName("scores")
		@Expose
		private Scores scores;
		@SerializedName("bonuses")
		@Expose
		private List<Object> bonuses = new ArrayList<Object>();
		@SerializedName("objectives")
		@Expose
		private List<Objective> objectives = new ArrayList<Objective>();
		@SerializedName("deaths")
		@Expose
		private Deaths deaths;
		@SerializedName("kills")
		@Expose
		private Kills kills;

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
		 * The scores
		 */
		public Scores getScores() {
			return scores;
		}

		/**
		 *
		 * @param scores
		 * The scores
		 */
		public void setScores(Scores scores) {
			this.scores = scores;
		}

		/**
		 *
		 * @return
		 * The bonuses
		 */
		public List<Object> getBonuses() {
			return bonuses;
		}

		/**
		 *
		 * @param bonuses
		 * The bonuses
		 */
		public void setBonuses(List<Object> bonuses) {
			this.bonuses = bonuses;
		}

		/**
		 *
		 * @return
		 * The objectives
		 */
		public List<Objective> getObjectives() {
			return objectives;
		}

		/**
		 *
		 * @param objectives
		 * The objectives
		 */
		public void setObjectives(List<Objective> objectives) {
			this.objectives = objectives;
		}

		/**
		 *
		 * @return
		 * The deaths
		 */
		public Deaths getDeaths() {
			return deaths;
		}

		/**
		 *
		 * @param deaths
		 * The deaths
		 */
		public void setDeaths(Deaths deaths) {
			this.deaths = deaths;
		}

		/**
		 *
		 * @return
		 * The kills
		 */
		public Kills getKills() {
			return kills;
		}

		/**
		 *
		 * @param kills
		 * The kills
		 */
		public void setKills(Kills kills) {
			this.kills = kills;
		}

	}

	public class Objective {

		@SerializedName("id")
		@Expose
		private String id;
		@SerializedName("type")
		@Expose
		private String type;
		@SerializedName("owner")
		@Expose
		private String owner;
		@SerializedName("last_flipped")
		@Expose
		private String lastFlipped;
		@SerializedName("claimed_by")
		@Expose
		private Object claimedBy;
		@SerializedName("claimed_at")
		@Expose
		private Object claimedAt;

		/**
		 *
		 * @return
		 * The id
		 */
		public String getId() {
			return id;
		}

		/**
		 *
		 * @param id
		 * The id
		 */
		public void setId(String id) {
			this.id = id;
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
		 * The owner
		 */
		public String getOwner() {
			return owner;
		}

		/**
		 *
		 * @param owner
		 * The owner
		 */
		public void setOwner(String owner) {
			this.owner = owner;
		}

		/**
		 *
		 * @return
		 * The lastFlipped
		 */
		public String getLastFlipped() {
			return lastFlipped;
		}

		/**
		 *
		 * @param lastFlipped
		 * The last_flipped
		 */
		public void setLastFlipped(String lastFlipped) {
			this.lastFlipped = lastFlipped;
		}

		/**
		 *
		 * @return
		 * The claimedBy
		 */
		public Object getClaimedBy() {
			return claimedBy;
		}

		/**
		 *
		 * @param claimedBy
		 * The claimed_by
		 */
		public void setClaimedBy(Object claimedBy) {
			this.claimedBy = claimedBy;
		}

		/**
		 *
		 * @return
		 * The claimedAt
		 */
		public Object getClaimedAt() {
			return claimedAt;
		}

		/**
		 *
		 * @param claimedAt
		 * The claimed_at
		 */
		public void setClaimedAt(Object claimedAt) {
			this.claimedAt = claimedAt;
		}

	}

	public class Scores {

		@SerializedName("red")
		@Expose
		private Long red;
		@SerializedName("blue")
		@Expose
		private Long blue;
		@SerializedName("green")
		@Expose
		private Long green;

		/**
		 *
		 * @return
		 * The red
		 */
		public Long getRed() {
			return red;
		}

		/**
		 *
		 * @param red
		 * The red
		 */
		public void setRed(Long red) {
			this.red = red;
		}

		/**
		 *
		 * @return
		 * The blue
		 */
		public Long getBlue() {
			return blue;
		}

		/**
		 *
		 * @param blue
		 * The blue
		 */
		public void setBlue(Long blue) {
			this.blue = blue;
		}

		/**
		 *
		 * @return
		 * The green
		 */
		public Long getGreen() {
			return green;
		}

		/**
		 *
		 * @param green
		 * The green
		 */
		public void setGreen(Long green) {
			this.green = green;
		}

	}

	public class Worlds {

		@SerializedName("red")
		@Expose
		private Long red;
		@SerializedName("blue")
		@Expose
		private Long blue;
		@SerializedName("green")
		@Expose
		private Long green;

		/**
		 *
		 * @return
		 * The red
		 */
		public Long getRed() {
			return red;
		}

		/**
		 *
		 * @param red
		 * The red
		 */
		public void setRed(Long red) {
			this.red = red;
		}

		/**
		 *
		 * @return
		 * The blue
		 */
		public Long getBlue() {
			return blue;
		}

		/**
		 *
		 * @param blue
		 * The blue
		 */
		public void setBlue(Long blue) {
			this.blue = blue;
		}

		/**
		 *
		 * @return
		 * The green
		 */
		public Long getGreen() {
			return green;
		}

		/**
		 *
		 * @param green
		 * The green
		 */
		public void setGreen(Long green) {
			this.green = green;
		}

	}
}