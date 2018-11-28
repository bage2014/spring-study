package com.bage.javaconfig.Composing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

        @Autowired
        private AccountRepository accountRepository;

        @Bean
        public TransferService transferService() {
                return new TransferServiceImpl(accountRepository);
        }

}