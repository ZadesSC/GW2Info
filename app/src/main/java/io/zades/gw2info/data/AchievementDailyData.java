package io.zades.gw2info.data;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class AchievementDailyData
{

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

	@Generated("org.jsonschema2pojo")
	public class Level {

		@SerializedName("min")
		@Expose
		private Long min;
		@SerializedName("max")
		@Expose
		private Long max;

		/**
		 *
		 * @return
		 * The min
		 */
		public Long getMin() {
			return min;
		}

		/**
		 *
		 * @param min
		 * The min
		 */
		public void setMin(Long min) {
			this.min = min;
		}

		/**
		 *
		 * @return
		 * The max
		 */
		public Long getMax() {
			return max;
		}

		/**
		 *
		 * @param max
		 * The max
		 */
		public void setMax(Long max) {
			this.max = max;
		}
	}

	@Generated("org.jsonschema2pojo")
	public class Level_ {

		@SerializedName("min")
		@Expose
		private Long min;
		@SerializedName("max")
		@Expose
		private Long max;

		/**
		 *
		 * @return
		 * The min
		 */
		public Long getMin() {
			return min;
		}

		/**
		 *
		 * @param min
		 * The min
		 */
		public void setMin(Long min) {
			this.min = min;
		}

		/**
		 *
		 * @return
		 * The max
		 */
		public Long getMax() {
			return max;
		}

		/**
		 *
		 * @param max
		 * The max
		 */
		public void setMax(Long max) {
			this.max = max;
		}
	}

	@Generated("org.jsonschema2pojo")
	public class Level__ {

		@SerializedName("min")
		@Expose
		private Long min;
		@SerializedName("max")
		@Expose
		private Long max;

		/**
		 *
		 * @return
		 * The min
		 */
		public Long getMin() {
			return min;
		}

		/**
		 *
		 * @param min
		 * The min
		 */
		public void setMin(Long min) {
			this.min = min;
		}

		/**
		 *
		 * @return
		 * The max
		 */
		public Long getMax() {
			return max;
		}

		/**
		 *
		 * @param max
		 * The max
		 */
		public void setMax(Long max) {
			this.max = max;
		}

	}

	@Generated("org.jsonschema2pojo")
	public class Pve {

		@SerializedName("id")
		@Expose
		private Long id;
		@SerializedName("level")
		@Expose
		private Level level;

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
		 * The level
		 */
		public Level getLevel() {
			return level;
		}

		/**
		 *
		 * @param level
		 * The level
		 */
		public void setLevel(Level level) {
			this.level = level;
		}

	}

	@Generated("org.jsonschema2pojo")
	public class Pvp {

		@SerializedName("id")
		@Expose
		private Long id;
		@SerializedName("level")
		@Expose
		private Level_ level;

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
		 * The level
		 */
		public Level_ getLevel() {
			return level;
		}

		/**
		 *
		 * @param level
		 * The level
		 */
		public void setLevel(Level_ level) {
			this.level = level;
		}

	}

	@Generated("org.jsonschema2pojo")
	public class Wvw {

		@SerializedName("id")
		@Expose
		private Long id;
		@SerializedName("level")
		@Expose
		private Level__ level;

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
		 * The level
		 */
		public Level__ getLevel() {
			return level;
		}

		/**
		 *
		 * @param level
		 * The level
		 */
		public void setLevel(Level__ level) {
			this.level = level;
		}

	}
}