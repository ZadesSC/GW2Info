package io.zades.gw2info.data;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AccountData
{

	@SerializedName("id")
	@Expose
	private String id;
	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("world")
	@Expose
	private Integer world;
	@SerializedName("guilds")
	@Expose
	private List<String> guilds = new ArrayList<String>();
	@SerializedName("created")
	@Expose
	private String created;
	@SerializedName("access")
	@Expose
	private String access;

	/**
	 * @return The id
	 */
	public String getId()
	{
		return id;
	}

	/**
	 * @param id The id
	 */
	public void setId(String id)
	{
		this.id = id;
	}

	/**
	 * @return The name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name The name
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * @return The world
	 */
	public Integer getWorld()
	{
		return world;
	}

	/**
	 * @param world The world
	 */
	public void setWorld(Integer world)
	{
		this.world = world;
	}

	/**
	 * @return The guilds
	 */
	public List<String> getGuilds()
	{
		return guilds;
	}

	/**
	 * @param guilds The guilds
	 */
	public void setGuilds(List<String> guilds)
	{
		this.guilds = guilds;
	}

	/**
	 * @return The created
	 */
	public String getCreated()
	{
		return created;
	}

	/**
	 * @param created The created
	 */
	public void setCreated(String created)
	{
		this.created = created;
	}

	/**
	 * @return The access
	 */
	public String getAccess()
	{
		return access;
	}

	/**
	 * @param access The access
	 */
	public void setAccess(String access)
	{
		this.access = access;
	}

}