只为成功找方法,不为失败找借口!
# JavaWeb学习总结(三)--Tomcat服务器学习和使用(二)

----
**Content**

-	[打包JavaWeb应用](#打包JavaWeb应用)
-	[Tomcat的体系结构](#Tomcat的体系结构)
-	[互联网上的加密原理](#互联网上的加密原理)
-	[https链接器](#https链接器)

----
# 打包JavaWeb应用
-	在Java中，使用"jar"命令来对将JavaWeb应用打包成一个War包，jar命令的用法如下：
	-	![](http://i.imgur.com/zasqI91.png)
	-	范例：将JavaWebDemoProject这个JavaWeb应用打包成war包
	-	![](http://i.imgur.com/XlC1k7A.png)
	-	执行完之后，就可以得到一个![](http://i.imgur.com/hfHHJx7.png)文件,
	-	平时开发完JavaWeb应用后，一般都会将JavaWeb应用打包成一个war包，然后将这个war包放到Tomcat服务器的webapps目录下，当Tomcat服务器启动时，就会自动将webapps目录下的war包解压。比如现在将![](http://i.imgur.com/vgHwSuc.png)放到放到Tomcat服务器的webapps目录下![](http://i.imgur.com/FxqNt4i.png)
	-	Tomcat服务器启动后会自动"Deploying web application"，将![](http://i.imgur.com/K6HQFC8.png)这个war文件解压缩，如下图所示：![](http://i.imgur.com/f8NVm9D.png)![](http://i.imgur.com/a51MDWd.png)
	
# Tomcat的体系结构
-	![](http://i.imgur.com/ViRZLRR.png)
-	Tomcat服务器的启动是基于一个server.xml文件的，Tomcat启动的时候首先会启动一个Server，Server里面就会启动Service，Service里面就会启动多个"Connector(连接器)"，每一个连接器都在等待客户机的连接，当有用户使用浏览器去访问服务器上面的web资源时，首先是连接到Connector(连接器)，Connector(连接器)是不处理用户的请求的，而是将用户的请求交给一个Engine(引擎)去处理，Engine(引擎)接收到请求后就会解析用户想要访问的Host，然后将请求交给相应的Host，Host收到请求后就会解析出用户想要访问这个Host下面的哪一个Web应用,一个web应用对应一个Context。![](http://i.imgur.com/qWUF8x8.png)
# 互联网上的加密原理
-	Tomcat服务器启动时候会启动多个Connector(连接器)，而Tomcat服务器的连接器又分为加密连接器和非加密连机器，比如：![](http://i.imgur.com/vvNvhNh.png)
-	　这里访问的就是使用8080端口的那个连接器![](http://i.imgur.com/mLQEOEn.png)
-	这个Connector是一个没有加密的连接器，使用"http://localhost:8080/JavaWebDemoProject/Web/1.jsp"去请求服务器上的web资源的这个过程中，我们的请求是不加密的，要是想以一种加密的方式来访问Tomcat服务器，那么就要在Tomcat里面配置一个加密的Connector。要配置一个加密连接器，首先应该把互联网上的加密原理弄清楚。
-	3.1 对称加密
	-	采用单钥密码系统的加密方法，同一个密钥可以同时用作信息的加密和解密，这种加密方法称为对称加密，也称为单密钥加密。
	-	需要对加密和解密使用相同密钥的加密算法。由于其速度快，对称性加密通常在消息发送方需要加密大量数据时使用。对称性加密也称为密钥加密。
	-	所谓对称，就是采用这种加密方法的双方使用方式用同样的密钥进行加密和解密。密钥是控制加密及解密过程的指令。算法是一组规则，规定如何进行加密和解密。
	-	加密的安全性不仅取决于加密算法本身，密钥管理的安全性更是重要。因为加密和解密都使用同一个密钥，如何把密钥安全地传递到解密者手上就成了必须要解决的问题。
	-	常用的对称加密有：DES、IDEA、RC2、RC4、SKIPJACK、RC5、AES算法等
-	3.2 非对称加密
	-	非对称加密算法需要两个密钥：公开密钥（publickey）和私有密钥（privatekey）。公开密钥与私有密钥是一对，如果用公开密钥对数据进行加密，只有用对应的私有密钥才能解密；如果用私有密钥对数据进行加密，那么只有用对应的公开密钥才能解密。因为加密和解密使用的是两个不同的密钥，所以这种算法叫作非对称加密算法。 非对称加密算法实现机密信息交换的基本过程是：甲方生成一对密钥并将其中的一把作为公用密钥向其它方公开；得到该公用密钥的乙方使用该密钥对机密信息进行加密后再发送给甲方；甲方再用自己保存的另一把专用密钥对加密后的信息进行解密。另一方面，甲方可以使用乙方的公钥对机密信息进行签名后再发送给乙方；乙方再用自己的私匙对数据进行验签。
	-	非对称加密工作原理
		-	1.A要向B发送信息，A和B都要产生一对用于加密和解密的公钥和私钥。
		-	2.A的私钥保密，A的公钥告诉B；B的私钥保密，B的公钥告诉A。
		-	3.A要给B发送信息时，A用B的公钥加密信息，因为A知道B的公钥。
		-	4.A将这个消息发给B（已经用B的公钥加密消息）。
		-	5.B收到这个消息后，B用自己的私钥解密A的消息。其他所有收到这个报文的人都无法解密，因为只有B才有B的私钥
		-	发送方使用接收方的公钥对数据加密，而接收方则使用自己的私钥解密，这样，信息就可以安全无误地到达目的地了，即使被第三方截获，由于没有相应的私钥，也无法进行解密。通过数字的手段保证加密过程是一个不可逆过程，即只有用私有密钥才能解密。
		-	非对称性加密依然没有解决数据传输的安全性问题，比如A想向B发数据，B首先生成一对密钥(公钥和私钥)，然后将公钥发给A，A拿到B发给他的公钥有就可以使用公钥加密数据后发给B，然而在B公钥发送给A的这个过程中，很有可能会被第三方C截获，C截获到B的公钥后，也使用B的公钥加密数据，然后发给B，B接收到数据后就晕了，因为搞不清楚接收到的数据到底是A发的还是C发的，这是其中一个问题，另一个问题就是，C截获到B发的公钥后，C可以自己生成一对密钥(公钥和私钥)，然后发给A，A拿到公钥后就以为是B发给他的，然后就使用公钥加密数据发给B，发送给B的过程中被C截获下来，由于A是用C发给他的公钥加密数据的，而C有私钥，因此就可以解密A加密过后的内容了，而B接收到A发给他的数据后反而解不开了，因为数据是用C的公钥加密的，B没有C的私钥，所以就无法解密。所以，非对称性加密存在一个问题：A想向B发数据，A如何确定拿到的公钥一定是B发的呢？那么如何解决这个问题呢？只能靠一个第三方机构(CA机构，即证书授权中心(Certificate Authority )，或称证书授权机构)来担保。A想向B发数据，B首先将公钥发给CA机构，CA机构拿到B的公钥后跑到B的家里问：这是你发的公钥吗？B确认过后说是：没错，是我发的！那么此时CA机构就会为B的公钥做担保，生成一份数字证书给B，数字证书包含了CA的担保认证签名和B的公钥，B拿到CA的这份数字证书后，就发给A，A拿到数字证书后，看到上面有CA的签名，就可以确定当前拿到的公钥是B发的，那么就可以放心大胆地使用公钥加密数据，然后发给B了。
# https链接器
-	明白了互联网上的加密原理之后，下面来看看浏览器与服务器交互时，浏览器想将数据加密后再发送给服务器，那么该怎么做呢？服务器首先要向浏览器出示一份数字证书，浏览器看到数字证书后，就可以使用数字证书里面的公钥加密数据，所以要想做浏览器和服务器的加密数据传输，那么首先得针对服务器生成一份数字证书。然后再配置一下服务器，让服务器收到浏览器的请求之后，会向浏览器出示它的数字证书。
-	4.1 生成Tomcat服务器的数字证书
	-	SUN公司提供了制作证书的工具keytool， 在JDK 1.4以后的版本中都包含了这一工具，它的位置为<JAVA_HOME>\bin\keytool.exe![](http://i.imgur.com/trjAwGx.png)
	-	使用keytool生成一个名字为tomcat的证书，存放在.keystore这个密钥库中![](http://i.imgur.com/7rjC7di.png)
	-	命令执行完之后，操作系统的用户文件夹下面就会生成一个.keystore文件，如下图所示：![](http://i.imgur.com/neZayHq.png)
	-	使用命令：keytool -list -keystore .keystore查看.keystore密钥库里面的所有证书![](http://i.imgur.com/aBZNONp.png)
-	4.2 配置https链接器
	-	将生成的.keystore密钥库文件拷贝到Tomcat服务器的conf目录下，如下图所示：![](http://i.imgur.com/UIielCx.png)
	-	修改server.xml文件，配置https连接器，代码如下：![](http://i.imgur.com/clxW9Qq.png)
	-	在server.xml文件中配置了一个端口是8443的加密连接器，浏览器访问8443端口的连接器时，将会以加密的方式来访问web服务器，这个连接器收到浏览器的请求后，将会向浏览器出示一份数字证书，浏览器再用数字证书里面的公钥来加密数据，keystoreFile="conf/.keystore" 用来指明密钥库文件的所在路径，服务器从密钥库中提取证书时需要密码，keystorePass="123456"指明密钥库的访问密码。
	-	使用"https://localhost:8443/"访问8443的加密连接器![](http://i.imgur.com/HlArESu.png)
	-	由于密钥库里面的证书是我们手工生成的，没有经过CA的认证，所以使用"https://localhost:8443/"访问8443的加密连接器，浏览器会出现"证书错误，导航已阻止"，浏览器认为当前要访问的这个主机是不安全的，不推荐继续访问，点击![](http://i.imgur.com/snJIwXS.png)就可以继续访问了，如下图所示：![](http://i.imgur.com/pxSM6aW.png)
-	4.3 安装数字证书
	-	为了让浏览器信任我们生成的数字证书，需要将数字证书安装到浏览器中，以IE8浏览器为例进行证书安装说明，安装步骤如下：![](http://i.imgur.com/7dWTKtT.png)![](http://i.imgur.com/NPGNv55.png)![](http://i.imgur.com/EaM6OpQ.png)![](http://i.imgur.com/Skasy0X.png)![](http://i.imgur.com/4Dp8rDe.png)![](http://i.imgur.com/ERdj6w5.png)
	-	证书安装成功后，重启IE浏览器，使用"https://localhost:8443/"访问8443的加密连接器，此时浏览器就不再提示证书错误了，如下图所示：![](http://i.imgur.com/cYwf7Rw.png)
-	4.4 删除数字证书
	-	以IE8为例进行说明，操作步骤如下：工具----->Internet选项![](http://i.imgur.com/HrdO8HK.png)![](http://i.imgur.com/1JwNI0f.png)![](http://i.imgur.com/yjkV70r.png)
	-	