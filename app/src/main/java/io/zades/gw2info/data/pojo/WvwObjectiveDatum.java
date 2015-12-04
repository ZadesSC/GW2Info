package io.zades.gw2info.data.pojo;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WvwObjectiveDatum {

	@SerializedName("id")
	@Expose
	private String id;
	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("sector_id")
	@Expose
	private Long sectorId;
	@SerializedName("type")
	@Expose
	private String type;
	@SerializedName("map_type")
	@Expose
	private String mapType;
	@SerializedName("map_id")
	@Expose
	private Long mapId;
	@SerializedName("coord")
	@Expose
	private List<Double> coord = new ArrayList<Double>();
	@SerializedName("label_coord")
	@Expose
	private List<Double> labelCoord = new ArrayList<Double>();

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
	 * The sectorId
	 */
	public Long getSectorId() {
		return sectorId;
	}

	/**
	 *
	 * @param sectorId
	 * The sector_id
	 */
	public void setSectorId(Long sectorId) {
		this.sectorId = sectorId;
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
	 * The mapType
	 */
	public String getMapType() {
		return mapType;
	}

	/**
	 *
	 * @param mapType
	 * The map_type
	 */
	public void setMapType(String mapType) {
		this.mapType = mapType;
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
	 * The coord
	 */
	public List<Double> getCoord() {
		return coord;
	}

	/**
	 *
	 * @param coord
	 * The coord
	 */
	public void setCoord(List<Double> coord) {
		this.coord = coord;
	}

	/**
	 *
	 * @return
	 * The labelCoord
	 */
	public List<Double> getLabelCoord() {
		return labelCoord;
	}

	/**
	 *
	 * @param labelCoord
	 * The label_coord
	 */
	public void setLabelCoord(List<Double> labelCoord) {
		this.labelCoord = labelCoord;
	}

}