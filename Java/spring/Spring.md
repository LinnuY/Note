# Spring 笔记
---
## 框架简介

* SSM = spring + springMVC + mybatis
* MVC框架：struts1,struts2,springMVC
* 持久层框架：hibernate,mybatis
* 整合型框架，设计型框架：spring

## Spring概述

1. 概述  
	1. Spring是一个开源框架。  
	2. Spring为简化企业级开发而生，使用Spring，JavaBean就可以实现很多以前要靠EJB才能实现的功能。同样的功能，在EJB中要通过繁琐的配置和复杂的代码才能实现，而在Spring中却非常的优雅和简洁。  
	3. Spring是一个 **IOC** 和 **AOP** 容器框架。  
	4. Spring的优良特性  
		1. 非入侵式：基于Spring开发的应用中的对象可以不依赖于Spring的API。  
		2. 依赖注入：DI--Dependency Injection，反转控制最经典的实现。  
		3. 面向切面编程：Aspect Oriented Programming -- AOP。  
		4. 容器：Spring是一个容器，因为它包含并且管理应用对象的生命周期。  
		5. 组件化：Spring实现了使用简单的组件配置组合成一个复杂的应用。在Spring中可以使用XML和Java注解组合这些对象。  
		6. 一站式：在IOC和AOP的基础上可以整合各种企业应用的开源框架和优秀的第三方类库（实际上Spring自身也提供了表述层的SpringMVC和持久层的Spring JDBC）。  
	5. Spring模块  
		* Core Container：Beans、Core、Context、SpEL  
		* AOP、Aspects、Instrumentation、Messaging  
		* Data Access/Integration：JDBC、ORM、OXM、JMS、Transctions  
		* Web：WebSocket、Servlet、Web、Portiet  

