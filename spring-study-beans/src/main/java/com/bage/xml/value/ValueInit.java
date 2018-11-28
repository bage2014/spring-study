package com.bage.xml.value;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class ValueInit {

	private int id;
	private String url;
	private String canNull;
	private List<Object> list;
	private Map<String,Object> map;
	private Set<Object> set;
	private Properties properties;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCanNull() {
		return canNull;
	}
	public void setCanNull(String canNull) {
		this.canNull = canNull;
	}
	public List<Object> getList() {
		return list;
	}
	public void setList(List<Object> list) {
		this.list = list;
	}
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	public Set<Object> getSet() {
		return set;
	}
	public void setSet(Set<Object> set) {
		this.set = set;
	}
	public Properties getProperties() {
		return properties;
	}
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	@Override
	public String toString() {
		return "DBConfig [id=" + id + ", url=" + url + ", canNull=" + canNull + ", list=" + list + ", map=" + map
				+ ", set=" + set + ", properties=" + properties + "]";
	}
	
}
