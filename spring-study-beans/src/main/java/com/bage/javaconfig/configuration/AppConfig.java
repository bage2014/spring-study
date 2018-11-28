package com.bage.javaconfig.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration("configurationAppConfig")
@ComponentScan(basePackages = "com.bage.javaconfig.configuration")
public class AppConfig {

	@Bean
	@Scope("prototype")
	public AsyncCommand asyncCommand() {
	        AsyncCommand command = new AsyncCommand();
	        // inject dependencies here as required
	        return command;
	}

	@Bean
	public CommandManager commandManager() {
	        // return new anonymous implementation of CommandManager with command() overridden
	        // to return a new prototype Command object
	        return new CommandManager() {
	                protected Command createCommand() {
	                        return asyncCommand();
	                }
	        };
	}
	
	@Bean(name="clientService1")
    public ClientService clientService1() {
            ClientService clientService = new ClientServiceImpl();
            clientService.setClientDao(clientDao());
            return clientService;
    }

    @Bean(name="clientService2")
    public ClientService clientService2() {
            ClientService clientService = new ClientServiceImpl();
            clientService.setClientDao(clientDao());
            return clientService;
    }

    @Bean
    public ClientDao clientDao() {
            return new ClientDaoImpl();
    }
    
}

