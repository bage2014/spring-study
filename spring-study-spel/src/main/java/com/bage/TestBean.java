package com.bage;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestBean{
	String []inventions = {"0","1","2","3"};
	List<InnerBean> Members = Arrays.asList(new InnerBean());
	Map<String,InnerBean> Officers = new HashMap<String,InnerBean>();
	String Name = "123";
	Map<String,Integer> map = new HashMap<String, Integer>();
	
	public Map<String,Integer> getMap() {
		return map;
	}

	public void setMap(Map<String,Integer> map) {
		this.map = map;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public TestBean(){
		Officers.put("president",new InnerBean());
		map.put("a", 1);
		map.put("ab", 11);
		map.put("abc", 111);
	}
	
	public Map<String, InnerBean> getOfficers() {
		return Officers;
	}
	public void setOfficers(Map<String, InnerBean> officers) {
		Officers = officers;
	}
	public String[] getInventions() {
		return inventions;
	}
	public void setInventions(String[] inventions) {
		this.inventions = inventions;
	}
	public List<InnerBean> getMembers() {
		return Members;
	}
	public void setMembers(List<InnerBean> members) {
		Members = members;
	}
	public String callMethods(String input){
		return "callMethodsReturn:" + input;
	}
	
	public boolean isMember(String input){
		return true;
	}
	
}

class InnerBean {
	String Name = "123";
	String []Inventions = {"0","1","2","3","2","3","3"};
	
	public InnerBean(){
		
	}
	
	public String[] getInventions() {
		return Inventions;
	}

	public void setInventions(String[] inventions) {
		Inventions = inventions;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	
}
