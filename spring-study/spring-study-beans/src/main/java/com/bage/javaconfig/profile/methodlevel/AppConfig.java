package com.bage.javaconfig.profile.methodlevel;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AppConfig {
	
	@Bean("methodlevelDao")
    @Profile("development")
    public Dao mysql() {
            return new MySQLDao();
    }

    @Bean("methodlevelDao")
    @Profile("production")
    public Dao oracle() {
            return new OracleDao();
    }
    
    @Bean("methodlevelDao")
    @Profile("default")
    public Dao Hsqldb() {
            return new HsqldbDao();
    }
}
