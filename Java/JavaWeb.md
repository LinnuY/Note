# JavaWeb 
---

## 概念
	
1. 什么是JavaWeb  
	JavaWeb是指，所有通过java语言编写可以通过浏览器访问的程序的总称，叫JavaWeb。  
	JavaWeb是基于请求和响应来开发的。   

2. 什么是请求  
	请求是指客户端给服务器发送数据，叫请求Request。  

3. 什么是响应  
	响应是指服务器给客户端回传数据，叫响应Response。  

4. 请求和响应的关系  
	请求和响应是成对出现的，有请求就有响应。  

## Web资源的分类

web资源按实现的技术和呈现的效果的不同，又分为静态资源和动态资源两种。  

静态资源： html、css、js、txt、mp4视频、jpg图片  
动态资源： jsp页面、Servlet程序  

## 常用的Web服务器

* Tomcat: 由Apache组织提供的一种Web服务器。
* Jboss
* GlassFish: Oracle，收费
* Resin: CAUCHO，收费
* WebLogic: Oracle，收费

## Servlet

1. 什么是Servlet？
	1. Servlet是JavaEE规范之一。规范就是接口。  
	2. Servlet就JavaWeb三大组件之一。三大组件分别是：Servlet程序、Filter过滤器、Listener监听器。  
	3. Servlet是运行在服务器上的一个java小程序，它可以接收客户端发送过来的请求，并响应数据给客户端。  

2. 手动实现Servlet程序  
	1. 编写一个类去实现Servlet接口  
	2. 实现Servlet方法，处理请求，并响应数据
	3. 到web.xml中去配置Servlet程序的访问地址

3. 生命周期
	1. 执行servlet构造器方法  
	2. 执行init初始化方法  
	3. 执行service方法  
	4. 执行destroy方法  

	第一、二步，是在第一次访问的时候创建Servlet程序调用。  
	第三步，每次访问都会调用。  
	第四步，在web工程停止的时候调用。

4. 通过继承HttpServlet实现Servlet程序  
	一般在实际项目开发中，都是使用继承HttpServlet类的方式去实现Servlet程序。  
	1. 编写一个类去继承HttpServlet类  
	2. 根据业务需要重写doGet()或doPost()方法  
	3. 到web.xml中的配置Servlet程序的访问地址  

5. ServletConfig类  
	ServletConfig类从类名上来看，就知道是Servlet程序的配置信息类。  
	Servlet程序和ServletConfig对象都是由Tomcat负责创建，我们负责使用。  
	Servlet程序默认是第一次访问的时候创建，ServletConfig是每个Servlet程序创建时，就创建一个对应的ServletConfig对象。  

	1. ServletConfig类的三大作用
		1. 可以获取Servlet程序的别名servlet-name的值。  
		2. 获取初始化参数init-param  
		3. 获取ServletContext对象  

|  | 存数据 | 取数据 | 删除数据 |
| ---- | ---- | ---- | ---- |
| Map | put() | get() | remove() |
| 域对象 | setAttribute() | getAttribute() | removeAttribute() |  

6. ServletContext类  
	1. 什么是ServletContext？  
		1. ServletContext是一个接口，它表示Servlet上下文对象。  
		2. 一个web工程，只有一个ServletContext对象实例。  
		3. ServletContext对象是一个域对象。  
		4. ServletContext是在web工程部署启动的时候创建。在web工程停止的时候销毁。  
	2. 什么是域对象？  
		域对象，是可以像Map一样存储数据的对象，叫域对象。  
		这里的域指的是存储数据的操作范围，整个 web 工程。  
	3. ServletContext类的四个作用  
		1. 获取web.xml中配置的上下文参数context-param  
		2. 获取当前的工程路径，格式:/工程路径  
		3. 获取工程部署后在服务器硬盘上的绝对路径
		4. 像Map一样存储数据  

## HTTP协议  
1. 什么是HTTP协议  
	协议是指双方，或多方，相互约定好，大家都需要遵守的规则，叫协议。  
	所谓HTTP协议，就是指，客户端和服务器之间通信时，发送的数据，需要遵守的规则，叫HTTP协议。  
	HTTP协议中的数据又叫报文。  

2. 请求的HTTP协议格式  
	客户端给服务器发送数据叫请求。  
	服务器给客户端回传数据叫响应。  
	请求又分为GET请求，和POST请求两种。  
	1. GET请求
		1. 请求行  
			1. 请求的方式  	GET  
			2. 请求的资源路径[+?+请求参数]  
			3. 请求的协议的版本号		HTTP/1.1
		2. 请求头  
			key：value 组成 不同的键值对，表示不同的含义。  
	2. POST请求  
		1. 请求行
			1. 请求的方式	POST
			2. 请求的资源路径[+?+请求参数]
			3. 请求的协议的版本号		HTTP/1.1
		2. 请求头  
			1. key:value	不同的请求头，有不同的含义  
			空行  
		3. 请求体  ===>>>  就是发送给服务器的数据  

3. 常用请求头的说明  
	* Accept： 表示客户端可以接收的数据类型  
	* Accept-Language： 表示客户端可以接收的语言类型  
	* User-Agent： 表示客户端浏览器的信息  
	* Host： 表示请求时的服务器ip和端口号  

4. 哪些是GET请求，哪些是POST请求  
	* GET请求：
		* form 标签 method=get
		* a 标签  
		* link 标签引入css  
		* Script 标签引入js文件  
		* img 标签引入图片  
		* iframe 引入html页面  
		* 在浏览器地址栏中输入地址后敲回车  
	* POST请求：
		* form 标签 method=post  

5. 响应的HTTP协议格式  
	1. 响应行  
		1. 响应的协议和版本号		HTTP/1.1  
		2. 响应状态码  			200  
		3. 响应状态描述符  		ok  
	2. 响应头  
		1. key:value			不同的响应头，有不同的含义
		空行
	3. 响应体   ===>>>	就是回传给客户端的数据  

6. 常见的响应码说明  
	* 200 		表示请求成功  
	* 302 		表示请求重定向
	* 404 		表示请求服务器已经收到，但是数据不存在(请求地址错误)
	* 500 		表示服务器已经收到请求，服务器内部错误(代码错误)

## Servlet2  

1. HttpServletRequest类
	1. 作用  
		每次只要有请求进入Tomcat服务器，Tomcat服务器就会把请求过来的HTTP协议信息解析好封装到Request对象中。然后传递到service方法中给我们使用。我们可以通过HttpServletRequest对象，获取到所有请求的信息。  
	2. 常用方法  
		1. geiRequestURI() 			获取请求的资源路径  
		2. getRequestURL() 			获取请求的统一资源定位符(绝对路径)  
		3. getRemoteHost() 			获取客户端的ip地址  
		4. getHeader() 				获取请求头  
		5. getParameter()			获取请求的参数  
		6. getParameterValues()		获取请求的参数(多个值的时候使用)  
		7. getMethod()				获取请求的方式GET或POST  
		8. setAttribute(key, value)	设置域数据  
		9. getAttribute(key)		获取域数据  
		10. getRequestDispatcher()	获取请求转发对象  
```Java
package edu.xju.lt.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestAPIServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {

//        1. geiRequestURI() 			获取请求的资源路径
        System.out.println("URI => " + req.getRequestURI());
//        2. getRequestURI() 			获取请求的统一资源定位符(绝对路径)
        System.out.println("URL => " + req.getRequestURL());
//        3. getRemoteHost() 			获取客户端的ip地址
        System.out.println("客户端 ip地址 =>" + req.getRemoteHost());
//        4. getHeader() 				获取请求头
        System.out.println("请求头User-Agent => " + req.getHeader("User-Agent"));
//        7. getMethod()				获取请求的方式GET或POST
        System.out.println("请求的方式 => " + req.getMethod());
    }
}

```  

2. 请求的转发
	1. what？  
		请求转发是指服务器收到请求后，从一个资源跳转到另一个资源的操作叫请求转发。  
	2. 特点：  
		1. 浏览器地址栏没有变化  
		2. 他们是一次请求
		3. 他们共享Request数据域
		4. 可以转发到WEB-INF目录下
		5. 是否可以访问工程意外的资源

3. base标签  
	1. 作用  
		可以设置当前页面中所有相对路径工作时，参照哪个路径来进行跳转。  
		```<base href="http://localhost:8080/07_servlet/a/b/c.html">```  

4. Web中的相对目录和绝对目录  
	在JavaWeb中，路径分为相对路径和绝对路径：  
	* 相对路径：  
		* .	        表示当前目录  
		* ..        表示上一级目录  
		* 资源名		表示当前目录/资源名  
	* 绝对路径：  
		* http://ip:port/工程路径/资源路径  

5.  Web中/斜杠的不同意义  
	在web中/是一种绝对路径。  
	* / 斜杠 如果被浏览器解析，得到的地址是：```http://ip:port/```    
	```<a href="/">斜杠</a>```  
	* / 斜杠 如果被服务器解析，得到的地址是：http://ip:port/工程路径  
		1. ```<url-pattern>/servlet1</url-pattern>```  
		2. ```servletContext.getRealPath("/");```  
		3. ```request.getRequestDispatcher("/");```  
	* 特殊情况：```response.sendRediect("/")```;  将斜杠发送给浏览器解析。得到```http://ip:port/```

## HttpServletResponse类  

1. HttpServletResponse类的作用  
	HttpServletResponse类和HttpServletRequest类一样。每次请求进来，Tomcat服务器都会创建一个Response对象传递给Servlet程序去使用。HttpServletRequest表示请求过来的信息，HttpServletResponse表示所有响应的信息。  
	我们如果需要设置返回给客户端的信息，都可以通过HttpServletResponse对象来进行设置。  

2. 两个输出流的说明  
	* 字节流  getOutputStream(); 常用于下载(传递二进制数据)  
	* 字符流  getWriter();		 常用于回传字符串(常用)  
	两个流同时只能用一个。  

3. 往客户端回传数据  
```Java
package edu.xju.lt.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseIOServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println(response.getCharacterEncoding());    // 默认ISO-8859-1
//        方法一
//        response.setCharacterEncoding("UTF-8");
//
//        // 通过响应头，设置浏览器也使用UTF-8字符集
//        response.setHeader("content-type","text/html; charset=UTF-8");
//        方法二
//        同时设置服务器和客户端都是用UTF-8字符集，还设置了响应头
//        要求一定要在获取流对象之前才能调用才有效
	response.setContentType("text/html; charset=UTF-8");
// 往客户端回传 字符串 数据
	PrintWriter printWriter = response.getWriter();
	printWriter.write("龙凌云");
	}
}
```  

4. 请求重定向  
	请求重定向，是指客户端给服务器发请求，然后服务器告诉客户端说，我给你一些地址，你去新地址访问。叫请求重定向(因为之前的地址可能已经被废弃)。 特点：  
	1. 浏览器地址栏会发生改变  
	2. 两次请求  
	3. 不共享Request域中数据  
	4. 不能访问WEB-INF下的资源  
	5. 可以访问工程意外的资源  
	* 第一种方法
```Java
package edu.xju.lt.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Response1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("曾到此一游 Response1");

        // 设置响应状态码302，表示重定向
        response.setStatus(302);

//        response.setHeader("Location","http://localhost:8080/07_servlet/response2");
        response.setHeader("Location","http://www.baidu.com");


    }
}
```  
	* 第二种方法 ：```response.sendRedirect("http://localhost:8080/07_servlet/response2");```

