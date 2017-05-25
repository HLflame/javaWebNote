只为成功找方法,不为失败找借口!
# javaweb学习总结(四)--http协议

----
**Content**

-	[什么是HTTP协议](#什么是HTTP协议)
-	[HTTP协议的版本](#HTTP协议的版本)
-	[HTTP1.0和HTTP1.1的区别](#HTTP1.0和HTTP1.1的区别)
-	[HTTP请求](#HTTP请求)
-	[HTTP响应](#HTTP响应)
-	[在服务端设置响应头来控制客户端浏览器的行为](#在服务端设置响应头来控制客户端浏览器的行为)

----
# 什么是HTTP协议
-	HTTP是hypertext transfer protocol（超文本传输协议）的简写，它是TCP/IP协议的一个应用层协议，用于定义WEB浏览器与WEB服务器之间交换数据的过程。客户端连上web服务器后，若想获得web服务器中的某个web资源，需遵守一定的通讯格式，HTTP协议用于定义客户端与web服务器通迅的格式。
# HTTP协议的版本
-	HTTP协议的版本：HTTP/1.0、HTTP/1.1
# HTTP1.0和HTTP1.1的区别
-	在HTTP1.0协议中，客户端与web服务器建立连接后，只能获得一个web资源。
-	在HTTP1.1协议，允许客户端与web服务器建立连接后，在一个连接上获取多个web资源。
# HTTP请求
-	4.1 HTTP请求包括的内容
	-	客户端连上服务器后，向服务器请求某个web资源，称之为客户端向服务器发送了一个HTTP请求。
	-	一个完整的HTTP请求包括如下内容：一个请求行、若干消息头、以及实体内容
	-	范例：![](http://i.imgur.com/RqZAkB1.png)
-	4.2 Http请求的细节——请求行
	-	请求行中的GET称之为请求方式，请求方式有：POST、GET、HEAD、OPTIONS、DELETE、TRACE、PUT，常用的有： GET、 POST
	-	用户如果没有设置，默认情况下浏览器向服务器发送的都是get请求，例如在浏览器直接输地址访问，点超链接访问等都是get，用户如想把请求方式改为post，可通过更改表单的提交方式实现。
	-	不管POST或GET，都用于向服务器请求某个WEB资源，这两种方式的区别主要表现在数据传递上：如果请求方式为GET方式，则可以在请求的URL地址后以?的形式带上交给服务器的数据，多个数据之间以&进行分隔，例如：GET /mail/1.html?name=abc&password=xyz HTTP/1.1
	-	GET方式的特点：在URL地址后附带的参数是有限制的，其数据容量通常不能超过1K。
	-	如果请求方式为POST方式，则可以在请求的实体内容中向服务器发送数据，Post方式的特点：传送的数据量无限制。
-	4.3 HTTP请求的细节——消息头
	-	HTTP请求中的常用消息头
		-	accept:浏览器通过这个头告诉服务器，它所支持的数据类型
		-	Accept-Charset: 浏览器通过这个头告诉服务器，它支持哪种字符集
		-	Accept-Encoding：浏览器通过这个头告诉服务器，支持的压缩格式
		-	Accept-Language：浏览器通过这个头告诉服务器，它的语言环境
		-	Host：浏览器通过这个头告诉服务器，想访问哪台主机
		-	If-Modified-Since: 浏览器通过这个头告诉服务器，缓存数据的时间
		-	Referer：浏览器通过这个头告诉服务器，客户机是哪个页面来的  防盗链
		-	Connection：浏览器通过这个头告诉服务器，请求完后是断开链接还是何持链接
		-	例如：![](http://i.imgur.com/0ZrJllI.png)
# HTTP响应
-	5.1 HTTP响应包括的内容
	-	一个HTTP响应代表服务器向客户端回送的数据，它包括： 一个状态行、若干消息头、以及实体内容 ![](http://i.imgur.com/su2Lhlu.png)
	-	范例：![](http://i.imgur.com/i2dgMZD.png)
-	5.2 HTTP响应的细节——状态行
	-	 状态行格式： HTTP版本号　状态码　原因叙述<CRLF>
	-	 举例：HTTP/1.1 200 OK
	-	 状态码用于表示服务器对请求的处理结果，它是一个三位的十进制数。响应状态码分为5类，如下所示：![](http://i.imgur.com/iO42Msu.png)
-	5.3 HTTP响应细节——常用响应头
	-	HTTP响应中的常用响应头(消息头)
		-	Location: 服务器通过这个头，来告诉浏览器跳到哪里
		-	Server：服务器通过这个头，告诉浏览器服务器的型号
		-	Content-Encoding：服务器通过这个头，告诉浏览器，数据的压缩格式
		-	Content-Length: 服务器通过这个头，告诉浏览器回送数据的长度
		-	Content-Language: 服务器通过这个头，告诉浏览器语言环境
		-	Content-Type：服务器通过这个头，告诉浏览器回送数据的类型
		-	Refresh：服务器通过这个头，告诉浏览器定时刷新
		-	Content-Disposition: 服务器通过这个头，告诉浏览器以下载方式打数据
		-	Transfer-Encoding：服务器通过这个头，告诉浏览器数据是以分块方式回送的
		-	Expires: -1  控制浏览器不要缓存
		-	Cache-Control: no-cache
		-	Pragma: no-cache
# 在服务端设置响应头来控制客户端浏览器的行为
-	6.1 设置Location响应头，实现请求重定向![](http://i.imgur.com/YrbXNAW.png)
	-	当在浏览器中使用URL地址"http://localhost:8080/JavaWeb_HttpProtocol_Study_20140528/servlet/ServletDemo01"访问ServletDemo01时，就可以看到服务器作出响应后发送到浏览器的状态码和响应头信息，如下图所示：![](http://i.imgur.com/Ei4Vmxv.png)
	-	服务器返回一个302状态码告诉浏览器，你要的资源我没有，但是我通过Location响应头告诉你哪里有，而浏览器解析响应头Location后知道要跳转到/JavaWeb_HttpProtocol_Study_20140528/1.jsp页面，所以就会自动跳转到1.jsp，如下图所示：![](http://i.imgur.com/y0L8a8o.png)
-	6.2 设置Content-Encoding响应头，告诉浏览器数据的压缩格式![](http://i.imgur.com/jWd4EEP.png)
	-	服务器发给浏览器的响应信息如下：![](http://i.imgur.com/PupJKjs.png)
	-	浏览器支持的压缩格式有:![](http://i.imgur.com/2eYjmHm.png)
-	6.3 设置content-type响应头，指定回送数据类型
		![](http://i.imgur.com/pW0wYlt.png)
	-	服务器发给浏览器的响应信息如下：![](http://i.imgur.com/P5T4Kyy.png)
	-	在浏览器中显示出了图片
-	6.4 设置refresh响应头，让浏览器定时刷新
	-	![](http://i.imgur.com/HcBe3GH.png)
-	6.5 设置content-disposition响应头，让浏览器下载文件![](http://i.imgur.com/m8g5Tnf.png)
	-	在浏览器中访问ServletDemo05就会弹出文件下载框，如下图所示：![](http://i.imgur.com/ONvGgdd.png)