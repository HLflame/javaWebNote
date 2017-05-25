只为成功找方法,不为失败找借口!

# JavaWeb学习总结(十二)--Session

----
**Content**
-	[会话介绍](#会话介绍)
-	[Session简单介绍](#Session简单介绍)
-	[Session和Cookie的主要区别](#Session和Cookie的主要区别)
-	[session实现原理](#session实现原理)
-	[浏览器禁用Cookie后的session处理](#浏览器禁用Cookie后的session处理)
-	[session对象的创建和销毁](#session对象的创建和销毁时机)

----
# 会话介绍
-	什么是会话:
	-	用户打开一个浏览器访问页面,访问完成后将浏览器关闭的过程称为是一次会话.
# Session简单介绍
-	在WEB开发中，服务器可以为每个用户浏览器创建一个会话对象（session对象），注意：一个浏览器独占一个session对象(默认情况下)。因此，在需要保存用户数据时，服务器程序可以把用户数据写到用户浏览器独占的session中，当用户使用浏览器访问其它程序时，其它程序可以从用户的session中取出该用户的数据，为用户服务。
# Session和Cookie的主要区别
-	Cookie是把用户的数据写给用户的浏览器。
-	Cookie本身是有大小和个数限制的
-	Session没有大小限制
-	Session的执行原理:基于Cookie的
-	Session技术把用户的数据写到用户独占的session中。
-	Session对象由服务器创建，开发人员可以调用request对象的getSession方法得到session对象。
# session实现原理
-	3.1 服务器是如何实现一个session为一个用户浏览器服务的？
	-	　服务器创建session出来后，会把session的id号，以cookie的形式回写给客户机，这样，只要客户机的浏览器不关，再去访问服务器时，都会带着session的id号去，服务器发现客户机浏览器带session id过来了，就会使用内存中与之对应的session为之服务。可以用如下的代码证明：![](http://i.imgur.com/oWawA4m.png)
	-	　第一次访问时，服务器会创建一个新的sesion，并且把session的Id以cookie的形式发送给客户端浏览器，如下图所示：![](http://i.imgur.com/xKylSwH.png)
	-	　点击刷新按钮，再次请求服务器，此时就可以看到浏览器再请求服务器时，会把存储到cookie中的session的Id一起传递到服务器端了，如下图所示：![](http://i.imgur.com/GhoXC14.png)
	-	　我猜想request.getSession()方法内部新创建了Session之后一定是做了如下的处理![](http://i.imgur.com/zfAk1Ef.png)　
# 浏览器禁用Cookie后的session处理
-	4.1 IE8禁用cookie
	-	工具->internet选项->隐私->设置->将滑轴拉到最顶上（阻止所有cookies）![](http://i.imgur.com/PbL6y5i.png)
-	4.2 解决方案：URL重写
	-	　response.encodeRedirectURL(java.lang.String url) 用于对sendRedirect方法后的url地址进行重写。
	-	　response.encodeURL(java.lang.String url)用于对表单action和超链接的url地址进行重写
-	4.3 范例：禁用Cookie后servlet共享Session中的数据
	-	IndexServlet![](http://i.imgur.com/9SIeK15.png)![](http://i.imgur.com/Tn2u3sE.png)
	-	BuyServlet![](http://i.imgur.com/4XPZfcT.png)
	-	ListCartServlet![](http://i.imgur.com/0WF2UOQ.png)
	-	通过查看IndexServlet生成的html代码可以看到，每一个超链接后面都带上了session的Id，如下所示![](http://i.imgur.com/PVTeUf1.png)
	-	所以，当浏览器禁用了cookie后，就可以用URL重写这种解决方案解决Session数据共享问题。而且response. encodeRedirectURL(java.lang.String url) 和response. encodeURL(java.lang.String url)是两个非常智能的方法，当检测到浏览器没有禁用cookie时，那么就不进行URL重写了。我们在没有禁用cookie的火狐浏览器下访问，效果如下：![](http://i.imgur.com/gpa1ig2.png)
	-	可以看到，浏览器第一次访问时，服务器创建Session，然后将Session的Id以Cookie的形式发送回给浏览器，response. encodeURL(java.lang.String url)方法也将URL进行了重写，当点击刷新按钮第二次访问，由于火狐浏览器没有禁用cookie，所以第二次访问时带上了cookie，此时服务器就可以知道当前的客户端浏览器并没有禁用cookie，那么就通知response. encodeURL(java.lang.String url)方法不用将URL进行重写了。
# session对象的创建和销毁时机
-	5.1 session对象的创建时机(session是域对象)
	-	在程序中第一次调用request.getSession()方法时就会创建一个新的Session，可以用isNew()方法来判断Session是不是新创建的
	-	范例：创建session![](http://i.imgur.com/2qkVuF4.png)
-	5.2 session对象的销毁时机
	-	关闭浏览器时,session不会销毁,但保存session的id的cookie没有了
	-	非正常关闭服务器,session会销毁,如果正常关闭服务器session序列化到硬盘.
	-	session对象默认30分钟没有使用，则服务器会自动销毁session，在web.xml文件中可以手工配置session的失效时间，例如：![](http://i.imgur.com/3iCJWIU.png)
	-	当需要在程序中手动设置Session失效时，可以手工调用session.invalidate方法，摧毁session。![](http://i.imgur.com/hrqToje.png)
	