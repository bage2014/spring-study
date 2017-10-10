package com.bage.annotation.autowired.wellknownresolvable;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Component;

@Component(value="movieRecommenderWellknownresolvable")
public class MovieRecommender {

	BeanFactory beanFactory;
	ApplicationContext applicationContext;
	Environment environment;
	ResourceLoader ResourceLoader;
	ApplicationEventPublisher applicationEventPublisher;
	MessageSource messageSource;
	ConfigurableApplicationContext configurableApplicationContext;
	ResourcePatternResolver resourcePatternResolver;
	
	public MovieRecommender(BeanFactory beanFactory, ApplicationContext applicationContext, Environment environment,
			org.springframework.core.io.ResourceLoader resourceLoader,
			ApplicationEventPublisher applicationEventPublisher, MessageSource messageSource,
			ConfigurableApplicationContext configurableApplicationContext,
			ResourcePatternResolver resourcePatternResolver) {
		super();
		this.beanFactory = beanFactory;
		this.applicationContext = applicationContext;
		this.environment = environment;
		ResourceLoader = resourceLoader;
		this.applicationEventPublisher = applicationEventPublisher;
		this.messageSource = messageSource;
		this.configurableApplicationContext = configurableApplicationContext;
		this.resourcePatternResolver = resourcePatternResolver;
	}

	public BeanFactory getBeanFactory() {
		return beanFactory;
	}

	public void setBeanFactory(BeanFactory beanFactory) {
		this.beanFactory = beanFactory;
	}

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	public Environment getEnvironment() {
		return environment;
	}

	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

	public ResourceLoader getResourceLoader() {
		return ResourceLoader;
	}

	public void setResourceLoader(ResourceLoader resourceLoader) {
		ResourceLoader = resourceLoader;
	}

	public ApplicationEventPublisher getApplicationEventPublisher() {
		return applicationEventPublisher;
	}

	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
	}

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public ConfigurableApplicationContext getConfigurableApplicationContext() {
		return configurableApplicationContext;
	}

	public void setConfigurableApplicationContext(ConfigurableApplicationContext configurableApplicationContext) {
		this.configurableApplicationContext = configurableApplicationContext;
	}

	public ResourcePatternResolver getResourcePatternResolver() {
		return resourcePatternResolver;
	}

	public void setResourcePatternResolver(ResourcePatternResolver resourcePatternResolver) {
		this.resourcePatternResolver = resourcePatternResolver;
	}

	@Override
	public String toString() {
		return "MovieRecommender [\nbeanFactory=" + beanFactory + ", applicationContext=" + applicationContext
				+ ", \nenvironment=" + environment + ", \nResourceLoader=" + ResourceLoader + ", \napplicationEventPublisher="
				+ applicationEventPublisher + ", \nmessageSource=" + messageSource + ", \nconfigurableApplicationContext="
				+ configurableApplicationContext + ", \nresourcePatternResolver=" + resourcePatternResolver + "\n]";
	} 
	
}
