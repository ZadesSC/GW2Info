package io.zades.gw2info.data;


import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class AccountAchievementsDatum
{

	@SerializedName("id")
	@Expose
	private Integer id;
	@SerializedName("current")
	@Expose
	private Integer current;
	@SerializedName("max")
	@Expose
	private Integer max;
	@SerializedName("done")
	@Expose
	private Boolean done;
	@SerializedName("bits")
	@Expose
	private List<Integer> bits = new ArrayList<Integer>();

	/**
	 *
	 * @return
	 * The id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 *
	 * @param id
	 * The id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 *
	 * @return
	 * The current
	 */
	public Integer getCurrent() {
		return current;
	}

	/**
	 *
	 * @param current
	 * The current
	 */
	public void setCurrent(Integer current) {
		this.current = current;
	}

	/**
	 *
	 * @return
	 * The max
	 */
	public Integer getMax() {
		return max;
	}

	/**
	 *
	 * @param max
	 * The max
	 */
	public void setMax(Integer max) {
		this.max = max;
	}

	/**
	 *
	 * @return
	 * The done
	 */
	public Boolean getDone() {
		return done;
	}

	/**
	 *
	 * @param done
	 * The done
	 */
	public void setDone(Boolean done) {
		this.done = done;
	}

	/**
	 *
	 * @return
	 * The bits
	 */
	public List<Integer> getBits() {
		return bits;
	}

	/**
	 *
	 * @param bits
	 * The bits
	 */
	public void setBits(List<Integer> bits) {
		this.bits = bits;
	}

}