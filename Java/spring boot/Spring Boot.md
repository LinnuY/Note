# 一. Spring Boot 入门

## 1. Spring Boot简介

> 简化Spring应用开发的一个框架   
>
> 整个Spring技术栈的一个大整合   
>
> J2EE开发的一站式解决方案   

## 2. 微服务

2014.Martion Fowler
微服务：架构风格(服务微化)
一个应用应该是一组小型服务;可以通过HTTP的方式进行互通;

每一个功能元素最终都是一个可独立替换和独立升级的软件单元.



## 3. 环境准备

### 1. maven设置:

​	设置jdk为1.8,具体略.

### 2. IDEA设置maven-setting.xml位置以及maven仓库位置:

​	具体略.



## 4. Spring Boot HelloWorld

一个功能

浏览器发送hello请求,服务器接受请求并处理,响应Hello World字符串;

### 1. 创建maven工程;(jar)

### 2. 导入Spring boot相关的依赖

### 3. 编写一个主程序;启动Spring boot应用

```java
/**
 * @SpringBootApplication 来标注一个主程序类,说明这是一个Spring Boot应用
 */
@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {

        // Spring应用启动起来
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
```

### 4. 编写相关的Controller、Service

```java
@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
}
```

### 5. 运行主程序测试

### 6. 简化部署

```xml
<!-- 这个插件,可以将应用打包成一个可执行的jar包 -->
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
```

将这个应用打成jar包,直接使用java -jar的命令进行执行;

## 5. Hello World探究

### 1. POM文件

#### 1. 父项目

```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.4.1</version>
    <relativePath/> <!-- lookup parent from repository -->
</parent>

他的父项目是
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-dependencies</artifactId>
    <version>2.4.1</version>
  </parent>
他来真正管理Spring Boot应用里面所有的依赖版本;
```

Spring Boot的版本仲裁中心;

以后我们导入依赖默认是不需要写版本;(没有在dependencies里面管理的依赖自然需要声明版本号)

#### 2. 导入的依赖

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

spring-boot-starter-==web==:

​		spring-boot-starter:spring-boot场景启动器;帮我们导入了web模块正常运行所依赖的组件;

Spring Boot将所有的功能场景都抽取出来,做成一个个的starters(启动器),只需要在项目里面引入这些starter相关场景的所有依赖都会导入进来.要用什么功能就导入什么场景的启动器

### 2. 主程序类,主入口类

```java
@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {

        // Spring应用启动起来
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
```

@**SpringBootApplication**:Spring Boot应用标注在某个类上说明这个类是SpringBoot的主配置类,SpringBoot就应该运行这个类的main方法来启动SpringBoot应用;

```java
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(
    excludeFilters = {@Filter(
    type = FilterType.CUSTOM,
    classes = {TypeExcludeFilter.class}
), @Filter(
    type = FilterType.CUSTOM,
    classes = {AutoConfigurationExcludeFilter.class}
)}
)
public @interface SpringBootApplication {
```

@**SpringBootConfiguration**:Spring Boot的配置类;

​		标注在某个类上,表示这是一个Spring Boot的配置类;

​		@**Configuration**:配置类上来标注这个注解;

​				配置类 ------ 配置文件;配置类也是容器中的一个组件;@Component

@**EnableAutoConfiguration**:开启自动注入功能;

​		以前我们需要配置的东西,Spring Boot帮我们自动配置;这个注解告诉SpringBoot开启自动配置功能;这样自动配置才能生效;

```java
@AutoConfigurationPackage
@Import({AutoConfigurationImportSelector.class})
public @interface EnableAutoConfiguration {
```

​	@**AutoConfigurationPackage**:自动配置包

​			@**Import**({Registrar.class})

​			Spring的底层注解@Import,给容器中导入一个组件;导入的组件由Registrar.class;

​			**将主配置类(@SpringBootApplication标注的类)的所在包及下面所有子包里面的所有组件扫描到Spring容器中;**

​	

## 6. 使用Spring Initializer快速创建Spring Boot项目

IDE都支持使用Spring的项目创建向导快速创建一个Spring Boot项目;

选择我们需要的模块;向导会联网创建Spring Boot项目;

默认生成的Spring Boot项目;

* 主程序已经生成好了,我们只需要自己的逻辑
* resources文件夹中目录结构
  * static: 保存所有的静态资源;js css images
  * templates: 保存所有的模板页面;(Spring Boot默认jar包使用嵌入式Tomcat,默认不支持JSP页面);可以使用模板引擎(freemarker, thymeleaf)
  * application.properties: Spring Boot应用的配置文件;可以修改一些默认设置;

# 二. 配置文件

## 1. 配置文件

Spring Boot使用了一个全局的配置文件,配置文件名是固定的;

* application.properties
* application.yml



配置文件的作用: 修改SpringBoot自动配置的默认值;SpringBoot在底层都给配置好了

YAML (YAML Ain't Markup Language)

​		YAML A Markup Language: 是一个标记语言

​		YAML isn't Markup Language: 不是一个标记语言

标记语言:

​		以前的配置文件,大多数都是xml文件

​		YAML: 以数据为中心; 比json,xml等更适合做配置文件;

​		YAML: 配置例子

```yaml
server:
  port: 8081
```

​		XML:

```xml
<server>
	<port>8081</port>
</server>
```

## 2. YAML语法:

### 1. 基本语法

k:(空格) v: 表示一对键值对(空格必须有)

以空格的缩进来控制层级关系;只要是左对齐的一列数据,都是同一个层级的

```java
server:
  port: 8081
  path: /hello
```

属性和值也是大小写敏感;

### 2. 值的写法

#### 字面量: 普通的值(数字,字符串,布尔)

​		k:v : 字面直接来写;

​				字符串默认不用加上单引号或者双引号;

​				"": 双引号--不会转移字符串里面的特殊字符,特殊字符会作为本身想表示的意思

​							name: "zhangsan \n lisi";输出: zhuangsan 换行 lisi

​				'': 单引号--会转移特殊字符,特殊字符最终只是一个普通的字符串数据

​							name: 'zhangsan \n lisi' ; 输出: zhuangsan \n lisi

#### 对象,Map(属性和值)(键值对):

​			k:v : 在下一行来写对象的属性和值的关系; 注意缩进

​					对象还是k: v的方式

```yaml
friends:
	lastName: zhangsan
	age: 20
```

​		行内写法:

```yaml
friends: {lastName: zhangsan, age: 18}
```



#### 数组(List,Set):

用- 值表示数组中的一个元素

```yaml
pets:
 - cat
 - dog
 - pig
```

行内写法

```yaml
pets: [cat, dog, pig] 
```



## 3. 配置文件值注入

配置文件

```yaml
person:
  lastName: zhangsan
  age: 18
  boss: false
  birth: 2002/01/11
  maps: {k1: v1, k2: v2}
  lists:
    - lisi
    - zhaoliu
  dog:
    name: dog
    age: 2
```

JavaBean:

```java
/**
 * 将配置文件中配置的每一个属性的值,映射到这个组件中
 * @ConfigurationProperties 告诉SpringBoot将本类中的所有属性和配置文件中相关的配置进行绑定;
 *      prefix = "person": 配置文件中哪个下面的所有属性进行一一映射
 *
 * 只有这个组件时容器中的组件,才能使用容器提供的@ConfigurationProperties功能;
 * @author LongTeng
 * @date 2021/01/11
 **/
@Component
@ConfigurationProperties(prefix = "person")
public class Person {

    private String lastName;
    private Integer age;
    private Boolean boss;
    private Date birth;

    private Map<String, Object> maps;
    private List<Object> lists;
    private Dog dog;
```



我们可以导入配置文件处理器,以后编写配置就有提示.

```xml
<!-- 导入配置文件处理器,配置文件进行绑定就会有提示 -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-configuration-processor</artifactId>
</dependency>
```