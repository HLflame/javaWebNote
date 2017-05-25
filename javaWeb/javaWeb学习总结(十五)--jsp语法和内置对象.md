# javaWeb学习总结--jsp语法和内置对象

----
**Content**

-	[JSP的概述](#JSP的概述)
-	[JSP的脚本](#JSP的脚本)
-	[JSP的注释](#JSP的注释)
-	[JSP的指令](#JSP的指令)
-	[JSP的内置对象(*****)](#JSP的内置对象(*****))
-	[JSP的动作标签](#JSP的动作标签)

----

# JSP的概述
-	什么是JSP：
	-	 Java Server Pages（Java服务器端的页面）
-	为什么要学习JSP:
-		SUN公司推出的Servlet自身有缺陷,没有办法与ASP,PHP进行竞争.推出了动态网页开发技术JSP.
-	使用JSP:
	-	 JSP = HTML + Java代码 + JSP自身的东西.
-	执行JSP的过程:
	-	 JSP翻译成Servlet,编译这个Servlet的类,生成class文件.得到执行.
# JSP的脚本
-	<%!   %>		:翻译成Servlet中的成员内容. 定义变量，方法，类. -- 不建议.
-	<%    %>		:翻译成Servlet中service方法内部的内容. 定义类,变量 
-	<%=   %>		:翻译成Servlet中service方法中out.print();
# JSP的注释
-	HTML的注释		:<!-- 注释 -->
-	Java代码的注释	:// 单行注释 /*多行注释*/ /** 文档注释 */
-	JSP的注释		:<%-- JSP的注释 --%>
# JSP的指令
-	指令的语法:
	-	<%@ 指令名称 属性名称=”属性值” 属性名称=”属性值” ...%>
-	JSP中有三个指令:page指令, include指令, taglib指令.
-	JSP中page指令:<%@ page %> -- 设置JSP的.
	-	* language		:JSP脚本中使用的语言.现在只能写java.
	-	* contentType	:设置浏览器打开这个JSP的时候采用的默认的字符集的编码.
	-	* pageEncoding	:设置文件保存到本地硬盘,以及生成Servlet后,Servlet保存到硬盘上的编码.
	-	* import		:在JSP中引入类对象.但是import可以出现多次.
		-	<%@page import="java.util.ArrayList"%>
	    -	<%@page import="java.util.List"%>
	-	* extends		:设置JSP翻译成Servlet后继承的类,默认值:org.apache.jasper.runtime.HttpJspBase,这个值要想修改,这个类必须是HttpServlet的子类
	-	* autoFlush		:设置JSP的缓存自动刷出.true:自动刷出.
	-	* buffer		:设置JSP的缓冲区的大小,默认8kb.
	-	* session		:设置在JSP中是否可以直接使用session对象.默认值是true.
	-	* isELIgnored	:设置在JSP中是否忽略EL表达式.默认值是false不忽略.
	-	* errorPage		:设置错误友好页面的提示.
	-	* isErrorPage	:通过这个设置显示JSP的错误信息.
		-	* 设置全局的错误友好页面：
        	* 在web.xml中设置:
        	* ![](http://i.imgur.com/goqUDLo.png)
-	JSP中的include指令:指示JSP包含其他的页面.
	-	<%@ include file="logo.jsp" %>
	-	<%@ include file="menu.jsp" %>
	-	<h1>BODY部分</h1>
	-	<%@ include file="footer.jsp" %>
-	JSP中的taglib指令:指示JSP引入标签库.
	-	<%@ taglib uri="标签的URI的路径" prefix="标签的别名" %>
# JSP的内置对象(*****)
-	JSP的内置对象:在JSP中可以直接使用的对象.
-	JSP中有9大内置对象:
-	![](http://i.imgur.com/pCTR3Br.png)
-	![](http://i.imgur.com/hl9Ym39.png)