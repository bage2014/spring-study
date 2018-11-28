package com.bage.javaconfig.combining;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bage.javaconfig.Composing.AccountRepository;
import com.bage.javaconfig.Composing.JdbcAccountRepository;

@Configuration("combiningAppConfig")
public class AppConfig {

        @Autowired
        private DataSource dataSource;

        @Bean(name="combiningAccountRepository")
        public AccountRepository accountRepository() {
                return new JdbcAccountRepository(dataSource);
        }

}
