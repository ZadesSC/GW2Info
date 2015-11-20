package io.zades.gw2info.data;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RecipeDatum
{

	@SerializedName("type")
	@Expose
	private String type;
	@SerializedName("output_item_id")
	@Expose
	private Long outputItemId;
	@SerializedName("output_item_count")
	@Expose
	private Long outputItemCount;
	@SerializedName("min_rating")
	@Expose
	private Long minRating;
	@SerializedName("time_to_craft_ms")
	@Expose
	private Long timeToCraftMs;
	@SerializedName("disciplines")
	@Expose
	private List<String> disciplines = new ArrayList<String>();
	@SerializedName("flags")
	@Expose
	private List<String> flags = new ArrayList<String>();
	@SerializedName("ingredients")
	@Expose
	private List<Ingredient> ingredients = new ArrayList<Ingredient>();
	@SerializedName("id")
	@Expose
	private Long id;
	@SerializedName("chat_link")
	@Expose
	private String chatLink;

	/**
	 * @return The type
	 */
	public String getType()
	{
		return type;
	}

	/**
	 * @param type The type
	 */
	public void setType(String type)
	{
		this.type = type;
	}

	/**
	 * @return The outputItemId
	 */
	public Long getOutputItemId()
	{
		return outputItemId;
	}

	/**
	 * @param outputItemId The output_item_id
	 */
	public void setOutputItemId(Long outputItemId)
	{
		this.outputItemId = outputItemId;
	}

	/**
	 * @return The outputItemCount
	 */
	public Long getOutputItemCount()
	{
		return outputItemCount;
	}

	/**
	 * @param outputItemCount The output_item_count
	 */
	public void setOutputItemCount(Long outputItemCount)
	{
		this.outputItemCount = outputItemCount;
	}

	/**
	 * @return The minRating
	 */
	public Long getMinRating()
	{
		return minRating;
	}

	/**
	 * @param minRating The min_rating
	 */
	public void setMinRating(Long minRating)
	{
		this.minRating = minRating;
	}

	/**
	 * @return The timeToCraftMs
	 */
	public Long getTimeToCraftMs()
	{
		return timeToCraftMs;
	}

	/**
	 * @param timeToCraftMs The time_to_craft_ms
	 */
	public void setTimeToCraftMs(Long timeToCraftMs)
	{
		this.timeToCraftMs = timeToCraftMs;
	}

	/**
	 * @return The disciplines
	 */
	public List<String> getDisciplines()
	{
		return disciplines;
	}

	/**
	 * @param disciplines The disciplines
	 */
	public void setDisciplines(List<String> disciplines)
	{
		this.disciplines = disciplines;
	}

	/**
	 * @return The flags
	 */
	public List<String> getFlags()
	{
		return flags;
	}

	/**
	 * @param flags The flags
	 */
	public void setFlags(List<String> flags)
	{
		this.flags = flags;
	}

	/**
	 * @return The ingredients
	 */
	public List<Ingredient> getIngredients()
	{
		return ingredients;
	}

	/**
	 * @param ingredients The ingredients
	 */
	public void setIngredients(List<Ingredient> ingredients)
	{
		this.ingredients = ingredients;
	}

	/**
	 * @return The id
	 */
	public Long getId()
	{
		return id;
	}

	/**
	 * @param id The id
	 */
	public void setId(Long id)
	{
		this.id = id;
	}

	/**
	 * @return The chatLink
	 */
	public String getChatLink()
	{
		return chatLink;
	}

	/**
	 * @param chatLink The chat_link
	 */
	public void setChatLink(String chatLink)
	{
		this.chatLink = chatLink;
	}

	public class Ingredient {

		@SerializedName("item_id")
		@Expose
		private Long itemId;
		@SerializedName("count")
		@Expose
		private Long count;

		/**
		 *
		 * @return
		 * The itemId
		 */
		public Long getItemId() {
			return itemId;
		}

		/**
		 *
		 * @param itemId
		 * The item_id
		 */
		public void setItemId(Long itemId) {
			this.itemId = itemId;
		}

		/**
		 *
		 * @return
		 * The count
		 */
		public Long getCount() {
			return count;
		}

		/**
		 *
		 * @param count
		 * The count
		 */
		public void setCount(Long count) {
			this.count = count;
		}

	}
}
