package com.bage.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bage.Template;
import com.bage.annotation.autowired.constructors.MovieRecommender;
import com.bage.annotation.required.SimpleMovieLister;

public class Main {

	public static void main(String[] args) {
		String beansFilePathStr[] = { "classpath:com/bage/annotation/template.xml" };

		// 加载 spring 容器
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(beansFilePathStr);
		// 获取一个基本bean
		Template template = context.getBean("template", Template.class);
		System.out.println(template);
		
		// 自动注入
		SayHelloImp sayHelloImp = context.getBean("sayHelloImp", SayHelloImp.class);
		System.out.println(sayHelloImp);
		
		// Required 必须指定，否则启动时候就会报错
		SimpleMovieLister simpleMovieLister = context.getBean("simpleMovieLister", SimpleMovieLister.class);
		System.out.println(simpleMovieLister);
		
		// Autowired 自动注入 (xml)
		// 1.构造器注入 customerPreferenceDao 可以使用bean的xml配置进行配置|@Service|//@Component
		MovieRecommender movieRecommender = context.getBean("movieRecommenderCon", MovieRecommender.class);
		System.out.println(movieRecommender.getCustomerPreferenceDao());
		// 2.setter 方法注入 (xml)
		com.bage.annotation.autowired.setter.SimpleMovieLister simpleMovieListerSetter = context.getBean("simpleMovieListerSetter", com.bage.annotation.autowired.setter.SimpleMovieLister.class);
		System.out.println(simpleMovieListerSetter.getMovieFinder());
		// 3.multiplearguments 多参数 (xml)
		com.bage.annotation.autowired.multiplearguments.MovieRecommender movieRecommenderMulArgs = context.getBean("movieRecommenderMulArgs", com.bage.annotation.autowired.multiplearguments.MovieRecommender.class);
		System.out.println(movieRecommenderMulArgs.toString());
		// 4.构造和属性 mix (@Component)
		com.bage.annotation.autowired.mix.MovieRecommender movieRecommenderMix = context.getBean("movieRecommenderMix", com.bage.annotation.autowired.mix.MovieRecommender.class);
		System.out.println(movieRecommenderMix.toString());
		// 5.数组 (@Component)
		com.bage.annotation.autowired.array.MovieRecommender movieRecommenderArray = context.getBean("movieRecommenderArray", com.bage.annotation.autowired.array.MovieRecommender.class);
		System.out.println(movieRecommenderArray);
		// 6.collections (@Component)
		com.bage.annotation.autowired.collections.MovieRecommender movieRecommenderCollections = context.getBean("movieRecommenderCollections", com.bage.annotation.autowired.collections.MovieRecommender.class);
		System.out.println(movieRecommenderCollections);
		// 7.String Maps (@Component)
		com.bage.annotation.autowired.stringmaps.MovieRecommender movieRecommenderMaps = context.getBean("movieRecommenderMaps", com.bage.annotation.autowired.stringmaps.MovieRecommender.class);
		System.out.println(movieRecommenderMaps);
		// 8. @Autowired(required=false) (@Component) 默认是 true
		com.bage.annotation.autowired.required.SimpleMovieLister simpleMovieListerRequired = context.getBean("simpleMovieListerRequired", com.bage.annotation.autowired.required.SimpleMovieLister.class);
		System.out.println(simpleMovieListerRequired);	
		// 9. movieRecommenderWellknownresolvable (@Component)
		com.bage.annotation.autowired.wellknownresolvable.MovieRecommender movieRecommenderWellknownresolvable = context.getBean("movieRecommenderWellknownresolvable", com.bage.annotation.autowired.wellknownresolvable.MovieRecommender.class);
		System.out.println(movieRecommenderWellknownresolvable);
		
	}

}
