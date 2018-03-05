package com.bage;

public class Logger {

	private static final boolean isDebug = true;
	
	public static void log(String msg){
		if(isDebug){
			System.out.println(msg);
		}
	}
	
	public static void log(String msg,boolean isDebug){
		if(isDebug){
			System.out.println(msg);
		}
	}
	
}
