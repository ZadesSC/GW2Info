package io.zades.gw2info.data.pojo;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ColorData {

	@SerializedName("id")
	@Expose
	private Long id;
	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("base_rgb")
	@Expose
	private List<Long> baseRgb = new ArrayList<Long>();
	@SerializedName("cloth")
	@Expose
	private Cloth cloth;
	@SerializedName("leather")
	@Expose
	private Leather leather;
	@SerializedName("metal")
	@Expose
	private Metal metal;
	@SerializedName("item")
	@Expose
	private Long item;
	@SerializedName("categories")
	@Expose
	private List<String> categories = new ArrayList<String>();

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
	 * The baseRgb
	 */
	public List<Long> getBaseRgb() {
		return baseRgb;
	}

	/**
	 *
	 * @param baseRgb
	 * The base_rgb
	 */
	public void setBaseRgb(List<Long> baseRgb) {
		this.baseRgb = baseRgb;
	}

	/**
	 *
	 * @return
	 * The cloth
	 */
	public Cloth getCloth() {
		return cloth;
	}

	/**
	 *
	 * @param cloth
	 * The cloth
	 */
	public void setCloth(Cloth cloth) {
		this.cloth = cloth;
	}

	/**
	 *
	 * @return
	 * The leather
	 */
	public Leather getLeather() {
		return leather;
	}

	/**
	 *
	 * @param leather
	 * The leather
	 */
	public void setLeather(Leather leather) {
		this.leather = leather;
	}

	/**
	 *
	 * @return
	 * The metal
	 */
	public Metal getMetal() {
		return metal;
	}

	/**
	 *
	 * @param metal
	 * The metal
	 */
	public void setMetal(Metal metal) {
		this.metal = metal;
	}

	/**
	 *
	 * @return
	 * The item
	 */
	public Long getItem() {
		return item;
	}

	/**
	 *
	 * @param item
	 * The item
	 */
	public void setItem(Long item) {
		this.item = item;
	}

	/**
	 *
	 * @return
	 * The categories
	 */
	public List<String> getCategories() {
		return categories;
	}

	/**
	 *
	 * @param categories
	 * The categories
	 */
	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	public class Cloth {

		@SerializedName("brightness")
		@Expose
		private Long brightness;
		@SerializedName("contrast")
		@Expose
		private Double contrast;
		@SerializedName("hue")
		@Expose
		private Long hue;
		@SerializedName("saturation")
		@Expose
		private Double saturation;
		@SerializedName("lightness")
		@Expose
		private Double lightness;
		@SerializedName("rgb")
		@Expose
		private List<Long> rgb = new ArrayList<Long>();

		/**
		 *
		 * @return
		 * The brightness
		 */
		public Long getBrightness() {
			return brightness;
		}

		/**
		 *
		 * @param brightness
		 * The brightness
		 */
		public void setBrightness(Long brightness) {
			this.brightness = brightness;
		}

		/**
		 *
		 * @return
		 * The contrast
		 */
		public Double getContrast() {
			return contrast;
		}

		/**
		 *
		 * @param contrast
		 * The contrast
		 */
		public void setContrast(Double contrast) {
			this.contrast = contrast;
		}

		/**
		 *
		 * @return
		 * The hue
		 */
		public Long getHue() {
			return hue;
		}

		/**
		 *
		 * @param hue
		 * The hue
		 */
		public void setHue(Long hue) {
			this.hue = hue;
		}

		/**
		 *
		 * @return
		 * The saturation
		 */
		public Double getSaturation() {
			return saturation;
		}

		/**
		 *
		 * @param saturation
		 * The saturation
		 */
		public void setSaturation(Double saturation) {
			this.saturation = saturation;
		}

		/**
		 *
		 * @return
		 * The lightness
		 */
		public Double getLightness() {
			return lightness;
		}

		/**
		 *
		 * @param lightness
		 * The lightness
		 */
		public void setLightness(Double lightness) {
			this.lightness = lightness;
		}

		/**
		 *
		 * @return
		 * The rgb
		 */
		public List<Long> getRgb() {
			return rgb;
		}

		/**
		 *
		 * @param rgb
		 * The rgb
		 */
		public void setRgb(List<Long> rgb) {
			this.rgb = rgb;
		}

	}

	public class Leather {

		@SerializedName("brightness")
		@Expose
		private Long brightness;
		@SerializedName("contrast")
		@Expose
		private Double contrast;
		@SerializedName("hue")
		@Expose
		private Long hue;
		@SerializedName("saturation")
		@Expose
		private Double saturation;
		@SerializedName("lightness")
		@Expose
		private Double lightness;
		@SerializedName("rgb")
		@Expose
		private List<Long> rgb = new ArrayList<Long>();

		/**
		 *
		 * @return
		 * The brightness
		 */
		public Long getBrightness() {
			return brightness;
		}

		/**
		 *
		 * @param brightness
		 * The brightness
		 */
		public void setBrightness(Long brightness) {
			this.brightness = brightness;
		}

		/**
		 *
		 * @return
		 * The contrast
		 */
		public Double getContrast() {
			return contrast;
		}

		/**
		 *
		 * @param contrast
		 * The contrast
		 */
		public void setContrast(Double contrast) {
			this.contrast = contrast;
		}

		/**
		 *
		 * @return
		 * The hue
		 */
		public Long getHue() {
			return hue;
		}

		/**
		 *
		 * @param hue
		 * The hue
		 */
		public void setHue(Long hue) {
			this.hue = hue;
		}

		/**
		 *
		 * @return
		 * The saturation
		 */
		public Double getSaturation() {
			return saturation;
		}

		/**
		 *
		 * @param saturation
		 * The saturation
		 */
		public void setSaturation(Double saturation) {
			this.saturation = saturation;
		}

		/**
		 *
		 * @return
		 * The lightness
		 */
		public Double getLightness() {
			return lightness;
		}

		/**
		 *
		 * @param lightness
		 * The lightness
		 */
		public void setLightness(Double lightness) {
			this.lightness = lightness;
		}

		/**
		 *
		 * @return
		 * The rgb
		 */
		public List<Long> getRgb() {
			return rgb;
		}

		/**
		 *
		 * @param rgb
		 * The rgb
		 */
		public void setRgb(List<Long> rgb) {
			this.rgb = rgb;
		}

	}

	public class Metal {

		@SerializedName("brightness")
		@Expose
		private Long brightness;
		@SerializedName("contrast")
		@Expose
		private Double contrast;
		@SerializedName("hue")
		@Expose
		private Long hue;
		@SerializedName("saturation")
		@Expose
		private Double saturation;
		@SerializedName("lightness")
		@Expose
		private Double lightness;
		@SerializedName("rgb")
		@Expose
		private List<Long> rgb = new ArrayList<Long>();

		/**
		 *
		 * @return
		 * The brightness
		 */
		public Long getBrightness() {
			return brightness;
		}

		/**
		 *
		 * @param brightness
		 * The brightness
		 */
		public void setBrightness(Long brightness) {
			this.brightness = brightness;
		}

		/**
		 *
		 * @return
		 * The contrast
		 */
		public Double getContrast() {
			return contrast;
		}

		/**
		 *
		 * @param contrast
		 * The contrast
		 */
		public void setContrast(Double contrast) {
			this.contrast = contrast;
		}

		/**
		 *
		 * @return
		 * The hue
		 */
		public Long getHue() {
			return hue;
		}

		/**
		 *
		 * @param hue
		 * The hue
		 */
		public void setHue(Long hue) {
			this.hue = hue;
		}

		/**
		 *
		 * @return
		 * The saturation
		 */
		public Double getSaturation() {
			return saturation;
		}

		/**
		 *
		 * @param saturation
		 * The saturation
		 */
		public void setSaturation(Double saturation) {
			this.saturation = saturation;
		}

		/**
		 *
		 * @return
		 * The lightness
		 */
		public Double getLightness() {
			return lightness;
		}

		/**
		 *
		 * @param lightness
		 * The lightness
		 */
		public void setLightness(Double lightness) {
			this.lightness = lightness;
		}

		/**
		 *
		 * @return
		 * The rgb
		 */
		public List<Long> getRgb() {
			return rgb;
		}

		/**
		 *
		 * @param rgb
		 * The rgb
		 */
		public void setRgb(List<Long> rgb) {
			this.rgb = rgb;
		}

	}
}