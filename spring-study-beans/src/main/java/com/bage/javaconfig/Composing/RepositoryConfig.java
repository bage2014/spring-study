package com.bage.javaconfig.Composing;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {

        private final DataSource dataSource;

        @Autowired
        public RepositoryConfig(DataSource dataSource) {
                this.dataSource = dataSource;
        }

        @Bean
        public AccountRepository accountRepository() {
                return new JdbcAccountRepository(dataSource);
        }

}
