package com.bage;

import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import com.bage.annotation.AppConfig;
import com.bage.annotation.FieldValueTestBean;
import com.bage.annotation.FieldValueTestBeanConstructor;
import com.bage.compilation.MyMessage;
import com.bage.evaluationcontext.Simple;
import com.bage.parserconfiguration.Demo;
import com.bage.xml.ShapeGuess;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// hello world
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression("'Hello World'");
		Expression exp2 = parser.parseExpression("\"Hello World\"");
		String message = (String) exp.getValue();
		String message2 = (String) exp2.getValue();
		System.out.println(message);
		System.out.println(message2);
		
		// 使用函数
		exp = parser.parseExpression("'Hello World'.concat('!')");
		message = (String) exp.getValue();
		System.out.println(message);
		
		// invokes 'getBytes()'
		exp = parser.parseExpression("'Hello World'.bytes");
		byte[] bytes = (byte[]) exp.getValue();
		System.out.println(bytes);
	
		// invokes 'getBytes().length'
		exp = parser.parseExpression("'Hello World'.bytes.length");
		int length = (Integer) exp.getValue();
		System.out.println(length);
		
		exp = parser.parseExpression("new String('hello world').toUpperCase()");
		message = exp.getValue(String.class);
		System.out.println(message);
		
		// Create and set a calendar
		GregorianCalendar c = new GregorianCalendar();
		c.set(1856, 7, 9);

		// The constructor arguments are name, birthday, and nationality.
		Inventor tesla = new Inventor("Nikola Tesla", c.getTime(), "Serbian");
		EvaluationContext context = new StandardEvaluationContext(tesla);
		String name = (String) parser.parseExpression("name").getValue(context);
		Date date = (Date) parser.parseExpression("birthday").getValue(context);
		boolean result = parser.parseExpression("name == 'Nikola Tesla'").getValue(context, Boolean.class); // evaluates to true
		System.out.println(name + ";" + date.getTime() + ";" + result);

		// setValue
		Simple simple = new Simple();
		simple.booleanList.add(true);
		StandardEvaluationContext simpleContext = new StandardEvaluationContext(simple);
		// false is passed in here as a string. SpEL and the conversion service will
		// correctly recognize that it needs to be a Boolean and convert it
		parser.parseExpression("booleanList[0]").setValue(simpleContext, "false");
		// b will be false
		Boolean b = simple.booleanList.get(0);
		System.out.println(b);
		
		// Turn on:
		// - auto null reference initialization
		// - auto collection growing
		SpelParserConfiguration config = new SpelParserConfiguration(true,true);
		parser = new SpelExpressionParser(config);
		Expression expression = parser.parseExpression("list[3]");
		Demo demo = new Demo();
		Object o = expression.getValue(demo);
		// demo.list will now be a real collection of 4 entries
		// Each entry is a new empty String
		System.out.println("list[3]:" + o);
		System.out.println("demo.list:" + demo.list.size());
		
		// SpEL compilation
		System.out.println("" + new MyMessage().work());
		
		// 4.4.1. XML based configuration
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:com/bage/xml/based.xml");
		System.out.println(ctx.getBean(com.bage.xml.NumberGuess.class));
		
		// 存在问题 #{ systemProperties['user.region'] }
		System.out.println(ctx.getBean("taxCalculator"));

		// refer to other bean properties by name
		System.out.println(ctx.getBean(ShapeGuess.class));
		
		// @Value annotation can be placed on fields, methods and method/constructor parameters to specify a default value
		ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println(ctx.getBean(FieldValueTestBean.class));
		System.out.println(ctx.getBean(FieldValueTestBeanConstructor.class)); // 构造器需要 @Autowired
				
		
		
		
	}
	
}
