package com.bage.annotation.scopecomponents;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

@Scope(value=ConfigurableBeanFactory.SCOPE_SINGLETON,proxyMode=ScopedProxyMode.DEFAULT) // == @Scope("singleton")
// ConfigurableBeanFactory.SCOPE_SINGLETON
// ConfigurableBeanFactory.SCOPE_PROTOTYPE
// WebApplicationContext.SCOPE_REQUEST
// WebApplicationContext.SCOPE_SESSION
// WebApplicationContext.SCOPE_GLOBAL_SESSION
// WebApplicationContext.SCOPE_APPLICATION
// proxyMode=ScopedProxyMode.DEFAULT
// proxyMode=ScopedProxyMode.INTERFACES
// proxyMode=ScopedProxyMode.NO
// proxyMode=ScopedProxyMode.TARGET_CLASS
@Repository
public class MovieFinderImpl {

}
