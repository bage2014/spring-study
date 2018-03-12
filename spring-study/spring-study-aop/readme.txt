
https://docs.spring.io/spring/docs/5.0.0.RC3/spring-framework-reference/core.html#aop

参考链接：https://docs.spring.io/spring/docs/5.0.0.RC3/spring-framework-reference/core.html#aop-ataspectj
Required libraries (JARS)
At a minimum you will need the following libraries to use the Spring Framework’s support for AspectJ LTW:
	spring-aop.jar (version 2.5 or later, plus all mandatory dependencies)
	aspectjweaver.jar (version 1.6.8 or later)
If you are using the Spring-provided agent to enable instrumentation, you will also need:
	spring-instrument.jar
	

5. Aspect Oriented Programming with Spring

5.1.1. AOP concepts

Aspect: a modularization of a concern that cuts across multiple classes. Transaction management is a good example of a crosscutting concern in enterprise Java applications. In Spring AOP, aspects are implemented using regular classes (the schema-based approach) or regular classes annotated with the @Aspect annotation (the @AspectJ style).

Join point: a point during the execution of a program, such as the execution of a method or the handling of an exception. In Spring AOP, a join point always represents a method execution.

Advice: action taken by an aspect at a particular join point. Different types of advice include "around," "before" and "after" advice. (Advice types are discussed below.) Many AOP frameworks, including Spring, model an advice as an interceptor, maintaining a chain of interceptors around the join point.

Pointcut: a predicate that matches join points. Advice is associated with a pointcut expression and runs at any join point matched by the pointcut (for example, the execution of a method with a certain name). The concept of join points as matched by pointcut expressions is central to AOP, and Spring uses the AspectJ pointcut expression language by default.

Introduction: declaring additional methods or fields on behalf of a type. Spring AOP allows you to introduce new interfaces (and a corresponding implementation) to any advised object. For example, you could use an introduction to make a bean implement an IsModified interface, to simplify caching. (An introduction is known as an inter-type declaration in the AspectJ community.)

Target object: object being advised by one or more aspects. Also referred to as the advised object. Since Spring AOP is implemented using runtime proxies, this object will always be a proxied object.

AOP proxy: an object created by the AOP framework in order to implement the aspect contracts (advise method executions and so on). In the Spring Framework, an AOP proxy will be a JDK dynamic proxy or a CGLIB proxy.

Weaving: linking aspects with other application types or objects to create an advised object. This can be done at compile time (using the AspectJ compiler, for example), load time, or at runtime. Spring AOP, like other pure Java AOP frameworks, performs weaving at runtime.

Types of advice:

Before advice: Advice that executes before a join point, but which does not have the ability to prevent execution flow proceeding to the join point (unless it throws an exception).

After returning advice: Advice to be executed after a join point completes normally: for example, if a method returns without throwing an exception.

After throwing advice: Advice to be executed if a method exits by throwing an exception.

After (finally) advice: Advice to be executed regardless of the means by which a join point exits (normal or exceptional return).

Around advice: Advice that surrounds a join point such as a method invocation. This is the most powerful kind of advice. Around advice can perform custom behavior before and after the method invocation. It is also responsible for choosing whether to proceed to the join point or to shortcut the advised method execution by returning its own return value or throwing an exception.


5.1.2. Spring AOP capabilities and goals

Spring AOP currently supports only method execution join points (advising the execution of methods on Spring beans). Field interception is not implemented, although support for field interception could be added without breaking the core Spring AOP APIs. If you need to advise field access and update join points, consider a language such as AspectJ.

5.1.3. AOP Proxies


5.2. @AspectJ support

5.2.1. Enabling @AspectJ Support

5.2.2. Declaring an aspect

5.2.3. Declaring a pointcut
//  your classpath must include the AspectJ run-time Java archive
// 参考链接：https://www.eclipse.org/aspectj/doc/released/progguide/examples-howto.html

The full AspectJ pointcut language supports additional pointcut designators that are not supported in Spring. These are: call, get, set, preinitialization, staticinitialization, initialization, handler, adviceexecution, withincode, cflow, cflowbelow, if, @this, and @withincode. 
Use of these pointcut designators in pointcut expressions interpreted by Spring AOP will result in an IllegalArgumentException being thrown：

execution - for matching method execution join points, this is the primary pointcut designator you will use when working with Spring AOP

within - limits matching to join points within certain types (simply the execution of a method declared within a matching type when using Spring AOP)

this - limits matching to join points (the execution of methods when using Spring AOP) where the bean reference (Spring AOP proxy) is an instance of the given type

target - limits matching to join points (the execution of methods when using Spring AOP) where the target object (application object being proxied) is an instance of the given type

args - limits matching to join points (the execution of methods when using Spring AOP) where the arguments are instances of the given types

@target - limits matching to join points (the execution of methods when using Spring AOP) where the class of the executing object has an annotation of the given type

@args - limits matching to join points (the execution of methods when using Spring AOP) where the runtime type of the actual arguments passed have annotations of the given type(s)

@within - limits matching to join points within types that have the given annotation (the execution of methods declared in types with the given annotation when using Spring AOP)

@annotation - limits matching to join points where the subject of the join point (method being executed in Spring AOP) has the given annotation

常用类似正则规则
Some examples of common pointcut expressions are given below.

the execution of any public method:

execution(public * *(..))
the execution of any method with a name beginning with "set":

execution(* set*(..))
the execution of any method defined by the AccountService interface:

execution(* com.xyz.service.AccountService.*(..))
the execution of any method defined in the service package:

execution(* com.xyz.service.*.*(..))
the execution of any method defined in the service package or a sub-package:

execution(* com.xyz.service..*.*(..))
any join point (method execution only in Spring AOP) within the service package:

within(com.xyz.service.*)
any join point (method execution only in Spring AOP) within the service package or a sub-package:

within(com.xyz.service..*)
any join point (method execution only in Spring AOP) where the proxy implements the AccountService interface:

this(com.xyz.service.AccountService)

any join point (method execution only in Spring AOP) where the target object implements the AccountService interface:

target(com.xyz.service.AccountService)

any join point (method execution only in Spring AOP) which takes a single parameter, and where the argument passed at runtime is Serializable:

args(java.io.Serializable)

any join point (method execution only in Spring AOP) where the target object has an @Transactional annotation:

@target(org.springframework.transaction.annotation.Transactional)

any join point (method execution only in Spring AOP) where the declared type of the target object has an @Transactional annotation:

@within(org.springframework.transaction.annotation.Transactional)

any join point (method execution only in Spring AOP) where the executing method has an @Transactional annotation:

@annotation(org.springframework.transaction.annotation.Transactional)

any join point (method execution only in Spring AOP) which takes a single parameter, and where the runtime type of the argument passed has the @Classified annotation:

@args(com.xyz.security.Classified)

any join point (method execution only in Spring AOP) on a Spring bean named tradeService:

bean(tradeService)

any join point (method execution only in Spring AOP) on Spring beans having names that match the wildcard expression *Service:

bean(*Service)
## Combining pointcut expressions 2018-03-05 22:22
// TODO 常用的类似正则表达式

5.2.4. Declaring advice

// TODO Passing parameters to advice 以及下面的都待验证
## 2018-03-12 21:13
// TODO how you could match the execution of methods annotated with an @Auditable annotation





