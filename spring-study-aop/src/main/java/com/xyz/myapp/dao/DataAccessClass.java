package com.xyz.myapp.dao;

import org.springframework.stereotype.Repository;

@Repository("myappDataAccessClass")
public class DataAccessClass {

	public void method(){
		System.out.println("com.xyz.someapp.dao.DataAccessClass.method() is work" );
	}
	
}
