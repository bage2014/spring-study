package com.bage.javaconfig.profile;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@Profile("production")
public class JndiDataConfig {

        @Bean(destroyMethod="",name="profileDataSource")
        public DataSource dataSource() throws Exception {
//        	  Context ctx = new InitialContext();
//            return (DataSource) ctx.lookup("java:comp/env/jdbc/datasource");
        	 DriverManagerDataSource dataSource = new DriverManagerDataSource();
             return dataSource;
        }
}
