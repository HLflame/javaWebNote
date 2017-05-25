只为成功找方法,不为失败找借口!
----

# jsp获取绝对路径
----

-	在javaWeb开发中,常使用绝对路径的方式来引入JavaScript和Css文件,这样可以避免因为目录变动导致引入文件找不到的情况,常用的做法如下:
	-	使用${pageContext.request.contextPath}
		-	代码"${pageContext.request.contextPath}"的作用是取出部署的应用程序名,这样不管如何部署,所用路径都是正确的.
		-	列如:
		![](http://i.imgur.com/ita5vy2.png)
		![](http://i.imgur.com/CwbfGdT.png)
		-	使用<%=request.getContextPath()%>和使用${pageContext.request.contextPath}达到同样的效果
		![](http://i.imgur.com/ZyiDiHS.png)