package io.zades.gw2info.data;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class ContinentDatum {

	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("continent_dims")
	@Expose
	private List<Long> continentDims = new ArrayList<Long>();
	@SerializedName("min_zoom")
	@Expose
	private Long minZoom;
	@SerializedName("max_zoom")
	@Expose
	private Long maxZoom;
	@SerializedName("floors")
	@Expose
	private List<Long> floors = new ArrayList<Long>();
	@SerializedName("id")
	@Expose
	private Long id;

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
	 * The continentDims
	 */
	public List<Long> getContinentDims() {
		return continentDims;
	}

	/**
	 *
	 * @param continentDims
	 * The continent_dims
	 */
	public void setContinentDims(List<Long> continentDims) {
		this.continentDims = continentDims;
	}

	/**
	 *
	 * @return
	 * The minZoom
	 */
	public Long getMinZoom() {
		return minZoom;
	}

	/**
	 *
	 * @param minZoom
	 * The min_zoom
	 */
	public void setMinZoom(Long minZoom) {
		this.minZoom = minZoom;
	}

	/**
	 *
	 * @return
	 * The maxZoom
	 */
	public Long getMaxZoom() {
		return maxZoom;
	}

	/**
	 *
	 * @param maxZoom
	 * The max_zoom
	 */
	public void setMaxZoom(Long maxZoom) {
		this.maxZoom = maxZoom;
	}

	/**
	 *
	 * @return
	 * The floors
	 */
	public List<Long> getFloors() {
		return floors;
	}

	/**
	 *
	 * @param floors
	 * The floors
	 */
	public void setFloors(List<Long> floors) {
		this.floors = floors;
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

}