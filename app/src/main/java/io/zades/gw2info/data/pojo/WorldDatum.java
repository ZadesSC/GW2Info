package io.zades.gw2info.data.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WorldDatum {

	@SerializedName("id")
	@Expose
	private Long id;
	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("population")
	@Expose
	private String population;

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
	 * The population
	 */
	public String getPopulation() {
		return population;
	}

	/**
	 *
	 * @param population
	 * The population
	 */
	public void setPopulation(String population) {
		this.population = population;
	}

}