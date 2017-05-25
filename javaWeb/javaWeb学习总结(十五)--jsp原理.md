# javaWeb学习总结--jsp原理
----
**Content**

-	[什么是JSP？](#什么是JSP？)
-	[JSP原理](#JSP原理)

----

# 什么是JSP？
-	JSP全称是Java Server Pages，它和servle技术一样，都是SUN公司定义的一种用于开发动态web资源的技术。
-	JSP这门技术的最大的特点在于，写jsp就像在写html，但它相比html而言，html只能为用户提供静态数据，而Jsp技术允许在页面中嵌套java代码，为用户提供动态数据。
# JSP原理
-	2.1、Web服务器是如何调用并执行一个jsp页面的？
-	浏览器向服务器发请求，不管访问的是什么资源，其实都是在访问Servlet，所以当访问一个jsp页面时，其实也是在访问一个Servlet，服务器在执行jsp的时候，首先把jsp翻译成一个Servlet，所以我们访问jsp时，其实不是在访问jsp，而是在访问jsp翻译过后的那个Servlet
-	当我们通过浏览器访问index.jsp时，服务器首先将index.jsp翻译成一个index_jsp.class，在Tomcat服务器的work\Catalina\localhost\项目名\org\apache\jsp目录下可以看到index_jsp.class的源代码文件index_jsp.java，index_jsp.java
-	index_jsp这个类是继承 org.apache.jasper.runtime.HttpJspBase这个类的
-	HttpJspBase类是继承HttpServlet的，所以HttpJspBase类是一个Servlet，而index_jsp又是继承HttpJspBase类的，所以index_jsp类也是一个Servlet，所以当浏览器访问服务器上的index.jsp页面时，其实就是在访问index_jsp这个Servlet，index_jsp这个Servlet使用_jspService这个方法处理请求。
-	2.2 Web服务器在调用jsp时，会给jsp提供一些什么java对象？
-	1 PageContext pageContext;
-	2 HttpSession session;
-	3 ServletContext application;
-	4 ServletConfig config;
-	5 JspWriter out;
-	6 Object page = this;
-	7 HttpServletRequest request, 
-	8 HttpServletResponse response
-	9 excepton
-	其中page对象，request和response已经完成了实例化，而其它5个没有实例化的对象通过下面的方式实例化
-	1 pageContext = _jspxFactory.getPageContext(this, request, response,null, true, 8192, true);
-	2 application = pageContext.getServletContext();
-	3 config = pageContext.getServletConfig();
-	4 session = pageContext.getSession();
-	5 out = pageContext.getOut();
-	 这8个java对象在Jsp页面中是可以直接使用的，如下所示：
-	 session.setAttribute("name", "session对象");//使用session对象,设置session对象的属性
-	 out.print(session.getAttribute("name")+"<br/>");//获取session对象的属性
-	 pageContext.setAttribute("name", "pageContext对象");//使用pageContext对象,设置pageContext对象的属性
-	  out.print(pageContext.getAttribute("name")+"<br/>");//获取pageContext对象的属性
-	  application.setAttribute("name", "application对象");//使用application对象,设置application对象的属性
-	  out.print(application.getAttribute("name")+"<br/>");//获取application对象的属性
-	  out.print("Hello Jsp"+"<br/>");//使用out对象
-	  out.print("服务器调用index.jsp页面时翻译成的类的名字是："+page.getClass()+"<br/>");//使用page对象
-	  out.print("处理请求的Servlet的名字是："+config.getServletName()+"<br/>");//使用config对象
-	  out.print(response.getContentType()+"<br/>");//使用response对象
-	   out.print(request.getContextPath()+"<br/>");//使用request对象
-	2.3 Tomcat服务器的执行流程
-	第一次执行：
	-	客户端通过电脑连接服务器，因为是请求是动态的，所以所有的请求交给WEB容器来处理
	-	在容器中找到需要执行的*.jsp文件
	-	之后*.jsp文件通过转换变为*.java文件
	-	*.java文件经过编译后，形成*.class文件
	-	最终服务器要执行形成的*.class文件
-	第二次执行
	-	因为已经存在了*.class文件，所以不在需要转换和编译的过程
-	修改后执行
	-	1.源文件已经被修改过了，所以需要重新转换，重新编译。