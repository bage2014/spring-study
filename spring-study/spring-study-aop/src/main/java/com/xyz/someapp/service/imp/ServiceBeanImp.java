package com.xyz.someapp.service.imp;

import org.springframework.stereotype.Service;

import com.xyz.someapp.service.IServiceBean;

@Service
public class ServiceBeanImp implements IServiceBean {
	
	/* (non-Javadoc)
	 * @see com.xyz.someapp.service.imp.IServiceBean#method()
	 */
	public void method(){
		System.out.println("com.xyz.someapp.service.imp.ServiceBeanImp.method() is work" );
	}
}
