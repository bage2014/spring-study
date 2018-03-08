package com.xyz.someapp.dao.imp;

import org.springframework.stereotype.Repository;

import com.xyz.someapp.dao.IDataAccess;

@Repository
public class DataAccessBeanImp implements IDataAccess {

	/* (non-Javadoc)
	 * @see com.xyz.someapp.dao.imp.IDataAccess#method()
	 */
	public void method(){
		System.out.println("com.xyz.someapp.dao.imp.DataAccessBeanImp() is work" );
	}
	
}
