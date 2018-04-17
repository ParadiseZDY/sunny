package com.sunny.domain;
import com.sunny.common.Entry;


/**
 * 
 * 
 * @author zhao.dy
 * @date 2018-04-16 12:20
 **/
public class GmsConfig extends Entry {

	private static final long serialVersionUID = 800049270031181716L;

	/**Key**/
	private String key;

	/**Value**/
	private String value;

	/**描述**/
	private String description;

	/**0:系统配置;1业务配置;2其他**/
	private Integer type;

	public void setKey(String key){
		this.key = key;
	}

	public String getKey(){
		return this.key;
	}

	public void setValue(String value){
		this.value = value;
	}

	public String getValue(){
		return this.value;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return this.description;
	}

	public void setType(Integer type){
		this.type = type;
	}

	public Integer getType(){
		return this.type;
	}

	@Override
	public String toString() {
		return "GmsConfig{" +
				"key='" + key + '\'' +
				", value='" + value + '\'' +
				", description='" + description + '\'' +
				", type=" + type +
				"} " + super.toString();
	}
}
