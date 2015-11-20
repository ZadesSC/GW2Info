package io.zades.gw2info.data;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class PvpGameDatum {

	@SerializedName("id")
	@Expose
	private String id;
	@SerializedName("map_id")
	@Expose
	private Long mapId;
	@SerializedName("started")
	@Expose
	private String started;
	@SerializedName("ended")
	@Expose
	private String ended;
	@SerializedName("result")
	@Expose
	private String result;
	@SerializedName("team")
	@Expose
	private String team;
	@SerializedName("profession")
	@Expose
	private String profession;
	@SerializedName("scores")
	@Expose
	private Scores scores;

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
	 * The mapId
	 */
	public Long getMapId() {
		return mapId;
	}

	/**
	 *
	 * @param mapId
	 * The map_id
	 */
	public void setMapId(Long mapId) {
		this.mapId = mapId;
	}

	/**
	 *
	 * @return
	 * The started
	 */
	public String getStarted() {
		return started;
	}

	/**
	 *
	 * @param started
	 * The started
	 */
	public void setStarted(String started) {
		this.started = started;
	}

	/**
	 *
	 * @return
	 * The ended
	 */
	public String getEnded() {
		return ended;
	}

	/**
	 *
	 * @param ended
	 * The ended
	 */
	public void setEnded(String ended) {
		this.ended = ended;
	}

	/**
	 *
	 * @return
	 * The result
	 */
	public String getResult() {
		return result;
	}

	/**
	 *
	 * @param result
	 * The result
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/**
	 *
	 * @return
	 * The team
	 */
	public String getTeam() {
		return team;
	}

	/**
	 *
	 * @param team
	 * The team
	 */
	public void setTeam(String team) {
		this.team = team;
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

	@Generated("org.jsonschema2pojo")
	public class Scores {

		@SerializedName("red")
		@Expose
		private Long red;
		@SerializedName("blue")
		@Expose
		private Long blue;

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

	}

}