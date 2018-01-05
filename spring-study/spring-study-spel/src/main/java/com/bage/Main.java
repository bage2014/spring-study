package com.bage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
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

	@SuppressWarnings({ "resource", "unchecked" })
	public static void main(String[] args) throws Exception {
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
				
		// Literal expressions
		parser = new SpelExpressionParser();
		// evals to "Hello World"
		String helloWorld = (String) parser.parseExpression("'Hello World'").getValue();
		System.out.println(helloWorld);
		double avogadrosNumber = (Double) parser.parseExpression("6.0221415E+23").getValue();
		System.out.println(avogadrosNumber);
		// evals to 2147483647
		int maxValue = (Integer) parser.parseExpression("0x7FFFFFFF").getValue();
		System.out.println(maxValue);
		boolean trueValue = (Boolean) parser.parseExpression("true").getValue();
		System.out.println(trueValue);
		Object nullValue = parser.parseExpression("null").getValue();
		System.out.println(nullValue);
		
		// 4.5.2. Properties, Arrays, Lists, Maps, Indexers
		// evals to 1856
		// 因为目前不存在此属性 int year = (Integer) parser.parseExpression("year + 1900").getValue(context);
		String nationality = (String) parser.parseExpression("nationality").getValue(context);
		//String city = (String) parser.parseExpression("placeOfBirth.nationality").getValue(context);
		System.out.println(nationality);
		
		TestBean testBean = new TestBean();
		// Inventions Array
		StandardEvaluationContext teslaContext = new StandardEvaluationContext(testBean);
		// evaluates to "Induction motor"
		String invention = parser.parseExpression("inventions[3]").getValue(
		                teslaContext, String.class);
		System.out.println(invention);
		// Members List
		StandardEvaluationContext societyContext = new StandardEvaluationContext(testBean);
		// evaluates to "Nikola Tesla"
		name = parser.parseExpression("Members.get(0).Name").getValue(societyContext, String.class);
		// 也可以这样获取 name = parser.parseExpression("Members[0].Name").getValue(societyContext, String.class);
		System.out.println(name);
		// List and Array navigation
		// evaluates to "Wireless communication"
		invention = parser.parseExpression("Members[0].Inventions[6]").getValue(
		                societyContext, String.class);
		System.out.println(invention);
		// Officers's InnerBean
		InnerBean pupin = parser.parseExpression("Officers['president']").getValue(
		                societyContext, InnerBean.class);
		System.out.println(pupin);
		// evaluates to "Idvor"
		String Name = parser.parseExpression("Officers['president'].Name").getValue(
		                societyContext, String.class);
		System.out.println(Name);
		// setting values
		parser.parseExpression("Officers['president'].Name").setValue(
		                societyContext, "123456");
		Name = parser.parseExpression("Officers['president'].Name").getValue(
                societyContext, String.class);
		System.out.println(Name);

		// 4.5.3. Inline lists
		// evaluates to a Java list containing the four numbers
		List numbers = (List) parser.parseExpression("{1,2,3,4}").getValue(context);
		List<List> listOfLists = (List<List>) parser.parseExpression("{{'a','b'},{'x','y'}}").getValue(context);
		System.out.println(numbers.get(2));
		System.out.println(listOfLists.get(0).get(1));

		// 4.5.4. Inline Maps
		// evaluates to a Java map containing the two entries
		Map inventorInfo = (Map) parser.parseExpression("{name:'Nikola',dob:'10-July-1856'}").getValue(context);
		Map<String,Map> mapOfMaps = (Map<String,Map>) parser.parseExpression("{name:{first:'Nikola',last:'Tesla'},dob:{day:10,month:'July',year:1856}}").getValue(context);
		System.out.println(inventorInfo.get("name"));
		System.out.println(mapOfMaps.get("name").get("last"));

		// Array construction
		int[] numbers1 = (int[]) parser.parseExpression("new int[4]").getValue(context);
		// Array with initializer
		int[] numbers2 = (int[]) parser.parseExpression("new int[]{1,2,3}").getValue(context);
		// Multi dimensional array
		int[][] numbers3 = (int[][]) parser.parseExpression("new int[4][5]").getValue(context);
		System.out.println(numbers1.length + "," + numbers2[1] + "," + numbers3[3][4]);
		
		// 4.5.6. Methods
		// string literal, evaluates to "bc"
		String cc = parser.parseExpression("'abc'.substring(2, 3)").getValue(String.class);
		// evaluates to true
		String callMethods = parser.parseExpression("callMethods('Mihajlo Pupin')").getValue(
		                societyContext, String.class);
		System.out.println(cc + ",," + callMethods);
		
		// 4.5.7. Operators
		// evaluates to true
		trueValue = parser.parseExpression("2 == 2").getValue(Boolean.class);
		System.out.println(trueValue);
		// evaluates to false
		boolean falseValue = parser.parseExpression("2 < -5.0").getValue(Boolean.class);
		// evaluates to true
		trueValue = parser.parseExpression("'black' < 'block'").getValue(Boolean.class);
		System.out.println(falseValue + ",," + trueValue);
		
		// addition 
//		// evaluates to false
		falseValue = parser.parseExpression(
		                " 12 instanceof T(Integer)").getValue(Boolean.class);
		System.out.println(falseValue);
//		// evaluates to true
//		boolean trueValue = parser.parseExpression("'5.00' matches '\^-?\\d+(\\.\\d{2})?$' ").getValue(Boolean.class);
//		//evaluates to false
//		boolean falseValue = parser.parseExpression(
//		                "'5.0067' matches '\^-?\\d+(\\.\\d{2})?$'").getValue(Boolean.class);
//		System.out.println(falseValue + ",," + trueValue);
		// TODO 带有正则表达式的未完成
		
		// Logical operators
		// lt (<), gt (>), le (⇐), ge (>=), eq (==), ne (!=), div (/), mod (%), not (!). 
		// -- AND --
		// evaluates to false
		falseValue = parser.parseExpression("true and false").getValue(Boolean.class);
		System.out.println(falseValue);
		// -- OR --
		// evaluates to true
		trueValue = parser.parseExpression("true or false").getValue(Boolean.class);
		// -- NOT --
		// evaluates to false
		falseValue = parser.parseExpression("!true").getValue(Boolean.class);
		System.out.println(trueValue + ",," + falseValue);
		
		// Mathematical operators
		// Addition
		int two = parser.parseExpression("1 + 1").getValue(Integer.class); // 2
		String testString = parser.parseExpression(
		                "'test' + ' ' + 'string'").getValue(String.class); // 'test string'
		// Subtraction
		int four = parser.parseExpression("1 - -3").getValue(Integer.class); // 4
		double d = parser.parseExpression("1000.00 - 1e4").getValue(Double.class); // -9000
		// Multiplication
		int six = parser.parseExpression("-2 * -3").getValue(Integer.class); // 6
		double twentyFour = parser.parseExpression("2.0 * 3e0 * 4").getValue(Double.class); // 24.0
		// Division
		int minusTwo = parser.parseExpression("6 / -3").getValue(Integer.class); // -2
		double one = parser.parseExpression("8.0 / 4e0 / 2").getValue(Double.class); // 1.0
		// Modulus
		int three = parser.parseExpression("7 % 4").getValue(Integer.class); // 3
		one = parser.parseExpression("8 / 5 % 2").getValue(Integer.class); // 1
		// Operator precedence
		int minusTwentyOne = parser.parseExpression("1+2-3*8").getValue(Integer.class); // -21
		System.out.println(two + ","  + testString + "," + four + "," + d  + "," + six + "," + twentyFour
				+ "," + minusTwo + "," + one + "," + three + "," + minusTwentyOne
				);
		
		// 4.5.8. Assignment
		Inventor inventor = new Inventor();
		StandardEvaluationContext inventorContext = new StandardEvaluationContext(inventor);
		parser.parseExpression("name").setValue(inventorContext, "Alexander Seovic2");
		// alternatively
		String aleks = parser.parseExpression(
		                "name = 'Alexandar Seovic'").getValue(inventorContext, String.class);
		System.out.println("aleks:" + aleks);
		
		// 4.5.9. Types
		Class dateClass = parser.parseExpression("T(java.util.Date)").getValue(Class.class);
		Class stringClass = parser.parseExpression("T(String)").getValue(Class.class);
		trueValue = parser.parseExpression(
		                "T(java.math.RoundingMode).CEILING < T(java.math.RoundingMode).FLOOR")
		                .getValue(Boolean.class);
		System.out.println(dateClass + ","  + stringClass + "," + trueValue);
		
		// 4.5.10. Constructors
		Inventor einstein = parser.parseExpression(
                "new com.bage.Inventor('Albert Einstein', new java.util.Date(), 'German')")
                .getValue(Inventor.class);
		//create new inventor instance within add method of List
//		Object obj = parser.parseExpression(
//                "Members.add(new com.bage.InnerBean())").getValue(societyContext);
//		System.out.println(einstein + "," + obj);
		// TODO create new inventor instance within add method of List
		
		// 4.5.11. Variables 变量
		tesla = new Inventor("Nikola Tesla",new Date(), "Serbian");
		context = new StandardEvaluationContext(tesla);
		context.setVariable("newName", "Mike Tesla");
		parser.parseExpression("Name = #newName").getValue(context);
		System.out.println(tesla.getName()); // "Mike Tesla"
		
		// The #this and #root variables
		// create an array of integers
		List<Integer> primes = new ArrayList<Integer>();
		primes.addAll(Arrays.asList(2,3,5,7,11,13,17));
		// create parser and set variable 'primes' as the array of integers
		context = new StandardEvaluationContext();
		context.setVariable("primes",primes);
		// all prime numbers > 10 from the list (using selection ?{...})
		// evaluates to [11, 13, 17]
		List<Integer> primesGreaterThanTen = (List<Integer>) parser.parseExpression(
		                "#primes.?[#this>10]").getValue(context);
		System.out.println(primesGreaterThanTen);
		// TODO #root
		
		// 4.5.12. Functions
		// StandardEvaluationContext.registerFunction(String name, Method m)
		StandardEvaluationContext  contexts = new StandardEvaluationContext();
		contexts.registerFunction("reverseString",StringUtils.class.getDeclaredMethod("reverseString", new Class[] { String.class }));
		String helloWorldReversed = parser.parseExpression(
		        "#reverseString('hello')").getValue(contexts, String.class);
		System.out.println("helloWorldReversed:" + helloWorldReversed);
		// 4.5.13. Bean references		
		contexts.setBeanResolver(new MyBeanResolver());
		// This will end up calling resolve(context,"foo") on MyBeanResolver during evaluation
		Object bean = parser.parseExpression("@foo").getValue(contexts);
		System.out.println(bean);
		//bean = parser.parseExpression("&foo").getValue(context);// should instead be prefixed with a (&) symbol.

		// 4.5.14. Ternary Operator (If-Then-Else)
		// String falseString = parser.parseExpression("false ? 'trueExp' : 'falseExp'").getValue(String.class);
		parser.parseExpression("Name").setValue(societyContext, "IEEE");
		societyContext.setVariable("queryName", "Nikola Tesla");
		String expressionStr = "isMember(#queryName)? #queryName + ' is a member of the ' " +
		                "+ Name + ' Society' : #queryName + ' is not a member of the ' + Name + ' Society'";
		String queryResultString = parser.parseExpression(expressionStr)
		                .getValue(societyContext, String.class);
		// queryResultString = "Nikola Tesla is a member of the IEEE Society"
		System.out.println(queryResultString);
		
		// 4.5.15. The Elvis Operator
		context = new StandardEvaluationContext(tesla);
		name = parser.parseExpression("name?:'Elvis Presley'").getValue(context, String.class);
		System.out.println(name); // Nikola Tesla
		tesla.setName(null);
		name = parser.parseExpression("name?:'Elvis Presley'").getValue(context, String.class);
		System.out.println(name); // Elvis Presley
		
		// 4.5.16. Safe Navigation operator
		// 同样可以使用在 @Value("#{systemProperties['pop3.port'] ?: 25}") 中
		tesla.setPlaceOfBirth(new PlaceOfBirth("Smiljan"));
		context = new StandardEvaluationContext(tesla);
		String city = parser.parseExpression("PlaceOfBirth?.City").getValue(context, String.class);
		System.out.println(city); // Smiljan
		tesla.setPlaceOfBirth(null);
		PlaceOfBirth placeOfBirth = parser.parseExpression("PlaceOfBirth").getValue(context, PlaceOfBirth.class);
		System.out.println(placeOfBirth);
		city = parser.parseExpression("PlaceOfBirth?.City").getValue(context, String.class);
		System.out.println(city); // null - does not throw NullPointerException!!!
		
		// 4.5.17. Collection Selection
		List<Inventor> list = (List<Inventor>) parser.parseExpression(
                "Members.?[Name == '123']").getValue(societyContext);
		System.out.println(list);
		Map<String,Integer> newMap = (Map<String,Integer>) parser.parseExpression("map.?[value<27]").getValue(societyContext);
		System.out.println(newMap);
		
		// 4.5.18. Collection Projection
		// returns ['Smiljan', 'Idvor' ]
		// List<Inventor> placesOfBirth = (List<Inventor>)parser.parseExpression("Members.![placeOfBirth.city]").getValue(societyContext);;
		// System.out.println(placesOfBirth);
		// TODO
		
		// 4.5.19. Expression templating
		String randomPhrase = parser.parseExpression("random number is #{T(java.lang.Math).random()}",
          new TemplateParserContext()).getValue(String.class);
		System.out.println(randomPhrase);
		// evaluates to "random number is 0.7038186818312008"
		
		
	}
	
}

