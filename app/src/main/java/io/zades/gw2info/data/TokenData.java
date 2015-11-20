package io.zades.gw2info.data;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TokenData
{

	@SerializedName("id")
	@Expose
	private String id;
	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("permissions")
	@Expose
	private List<String> permissions = new ArrayList<String>();

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
	 * @return The permissions
	 */
	public List<String> getPermissions()
	{
		return permissions;
	}

	/**
	 * @param permissions The permissions
	 */
	public void setPermissions(List<String> permissions)
	{
		this.permissions = permissions;
	}
}
