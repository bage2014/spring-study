package com.bage.xml.autowiringcollaborators.bytype;

import com.bage.xml.autowiringcollaborators.CPU;

public class CumputerBean {
	// 电脑名称
	private CPU cpu;

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
