package com.bage.xml.autowiringcollaborators.constructor;

import com.bage.xml.autowiringcollaborators.CPU;

public class CumputerBean {
	// 电脑名称
	private CPU cpu;
	
	public CumputerBean(CPU cpu) {
		super();
		this.cpu = cpu;
	}

	public CPU getCpu() {
		return cpu;
	}


	public void setCpu(CPU cpu) {
		this.cpu = cpu;
	}


	@Override
	public String toString() {
		return "CumputerBean [cpu=" + cpu + "]";
	}
	
}
