只为成功找方法,不为失败找借口!
# JavaWeb学习总结(二)--Tomcat服务器学习和使用(一)

----

**Content**

-	[Tomcat服务器端口的配置](#Tomcat服务器端口的配置)
-	[Tomcat服务器虚拟目录的映射方式](#Tomcat服务器虚拟目录的映射方式)
-	[Tomcat服务器配置虚拟主机](#Tomcat服务器配置虚拟主机)
-	[浏览器与服务器交互的过程](#浏览器与服务器交互的过程)
-	[JavaWeb应用的组成结构](#JavaWeb应用的组成结构)

----
# Tomcat服务器端口的配置
-	Tomcat的所有配置都放在conf文件夹之中，里面的server.xml文件是配置的核心文件。
-	如果想修改Tomcat服务器的启动端口，则可以在server.xml配置文件中的Connector节点进行的端口修改
	例如：将Tomcat服务器的启动端口由默认的8080改成8081端口
-	Tomcat服务器启动端口默认配置
-	![](http://i.imgur.com/K4pmPy3.png)
-	将Tomcat服务器启动端口修改成8081端口
-	![](http://i.imgur.com/PmaBDHO.png)
-	这样就把原来默认Tomcat默认的的8080端口改成了8081端口了，需要注意的是，一旦服务器中的*.xml文件改变了，则Tomcat服务器就必须重新启动，重新启动之后将重新读取新的配置信息。因为已经在server.xml文件中将Tomcat的启动端口修改成了8081，所以Tomcat服务器启动时就以8081端口启动了，如下图所示：
-	![](http://i.imgur.com/osFpEjp.png)
-	　访问Tomcat服务器也必须以新的访问端口去访问：http://localhost:8081/，如下图所示：
-	　![](http://i.imgur.com/S3deVl0.png)
# Tomcat服务器虚拟目录的映射方式
-	Web应用开发好后，若想供外界访问，需要把web应用所在目录交给web服务器管理，这个过程称之为虚似目录的映射。那么在Tomcat服务器中，如何进行虚拟目录的映射呢？总共有如下的几种方式：
-	2.1 虚拟目录的映射方式一：在server.xml文件的host元素中配置
	-	找到server.xml文件的host元素，如下图所示：
	-	![](http://i.imgur.com/5RIe3Hv.png)
	-	在<Host></Host>这对标签加上<Context path="/JavaWebApp" docBase="F:\JavaWebDemoProject" />即可将在F盘下的JavaWebDemoProject这个JavaWeb应用映射到JavaWebApp这个虚拟目录上，JavaWebApp这个虚拟目录是由Tomcat服务器管理的，JavaWebApp是一个硬盘上不存在的目录，是我们自己随便写的一个目录，也就是虚拟的一个目录，所以称之为"虚拟目录"，代码如下：
	-	![](http://i.imgur.com/Ig6cSbf.png)
	-	其中，Context表示上下文，代表的就是一个JavaWeb应用，Context元素有两个属性，
	-	Ⅰ.path：用来配置虚似目录，必须以"/"开头。
	-	Ⅱ.docBase：配置此虚似目录对应着硬盘上的Web应用所在目录。
	-	使用浏览器访问"/JavaWebApp"这个虚拟目录下的1.jsp这个web资源，访问结果如下：
	-	![](http://i.imgur.com/xNAiTbH.png)
	-	　1.jsp可以正常访问，这说明我们已经成功地将将在F盘下的JavaWebDemoProject这个JavaWeb应用映射到JavaWebApp这个虚拟目录上了，访问"/JavaWebApp/1.jsp"就相当于访问"F:\JavaWebDemoProject\1.jsp"
	-	　注意：在Tomcat6之后中，不再建议在server.xml文件中使用配置context元素的方式来添加虚拟目录的映射，因为每次修改server.xml文件后，Tomcat服务器就必须要重新启动后才能重新加载server.xml文件。在Tomcat服务器的文档http://localhost:8080/docs/config/context.html中有这样的说明：
-	　2.2、虚拟目录的映射方式二：让tomcat服务器自动映射
	-	　tomcat服务器会自动管理webapps目录下的所有web应用，并把它映射成虚似目录。换句话说，tomcat服务器webapps目录中的web应用，外界可以直接访问。
	-	　例如：把F盘下的JavaWebDemoProject这个JavaWeb应用直接copy到tomcat服务器webapps目录中，如下图所示：
	-	　![](http://i.imgur.com/eTNqDLl.png)
	-	　此时Tomcat服务器就会自动为JavaWebDemoProject这个JavaWeb应用映射一个同名的虚拟目录"/JavaWebDemoProject"，然后就可以使用浏览器访问这个JavaWeb应用的资源了，如下图所示：
	-	　![](http://i.imgur.com/bF8rmbl.png)
-	2.3 虚拟目录的映射方式三
	-	在tomcat服务器的\conf\Catalina\localhost目录下添加一个以xml作为扩展名的文件，xml文件的名字可以任意取，比如下面的aa.xml，注意这一句话"The context path and version will be derived from the base name of the file"，这一句话的意思翻译过来就是"context元素的path属性源自于是这个xml文件的名字"，上面提到过，Context元素的path属性是用来配置虚似目录的名称的，所以虚似目录的名称就是这个xml文件的名称。
	-	$CATALINA_BASE指的就是tomcat服务器根目录，[enginename]指的是Tomcat服务器使用的引擎名称，Tomcat使用的引擎是Catalina
	-	![](http://i.imgur.com/XRDu2Tf.png)
	-	在aa.xml文件中添加Context元素映射JavaWeb应用，代码如下：
	-	![](http://i.imgur.com/5OUKKQm.png)
	-	注意：在Context元素中并没有指明path属性来设置虚拟目录的名称，那么"F:\JavaWebDemoProject"映射的虚拟目录名称是神马呢，就是当前正在编辑的这个xml文件的名称aa。
	-	![](http://i.imgur.com/ZS5b5LU.png)
	-	使用这种方式映射虚拟目录的最大好处是修改了配置文件后不用重启Tomcat服务器，比如将aa.xml修改成bb.xml，Tomcat服务器会自动Undeploying context [/aa]，然后自动信息: Deploying configuration descriptor D:\apache-tomcat-7.0.53\conf\Catalina\localhost\bb.xml
	-	![](http://i.imgur.com/eSaRDf0.png)
# Tomcat服务器配置虚拟主机
-	3.1 配置虚拟主机
	-	配置虚似主机就是配置一个网站。
	-	在Tomcat服务器配置一个虚拟主机(网站)，需要修改conf文件夹下的server.xml这个配置文件，使用Host元素进行配置，打开server.xml，可以看到Tomcat服务器自带的一个名称为localhost的虚拟主机(网站)，如下图所示：
	-	![](http://i.imgur.com/cv1XYBu.png)
	-	平时我们将开发好的JavaWeb应用放到webapps文件夹下，然后就可以使用"http://localhost:端口号/JavaWebAppName"的方式去访问了，其实访问的就是name是"localhost"的那台虚拟主机(Host)，这台虚拟主机管理webapps文件夹下的所有web应用。
	-	例如：http://localhost:8080/JavaWebDemoProject/1.jsp，这个URL地址访问的就是名称是localhost的那台虚拟主机下的JavaWebDemoProject这个应用里面的1.jsp这个web资源。
	-	我们可以使用如下的方式配置一个虚拟主机，例如
	-	![](http://i.imgur.com/nuUNVix.png)
	-	这里我们新配置一个虚拟主机，虚拟主机的name是"www.gacl.cn"，虚拟主机"www.gacl.cn"现在管理着JavaWebApps文件夹下的所有web应用，平时我们在互联网上使用域名"www.baidu.com"访问百度的网站时，其实就是在访问一个名称是"www.baidu.com"的虚拟主机，所以当我们要访问name是"www.gacl.cn"的这个虚拟主机时，就可以使用"域名(www.gacl.cn)"去访问，注意一下appBase="F:\JavaWebApps"，这里的JavaWebApps文件夹代表的不是一个项目的根目录，而是一个存放了一个或者多个JavaWeb应用的文件夹，如下图所示：
	-	![](http://i.imgur.com/ZEDhYC4.png)
	-	就好像是Tomcat服务器的webapps文件夹一样，里面存放了很多的JavaWeb应用
	-	![](http://i.imgur.com/otrAz4W.png)
-	3.2 windows系统中注册域名
	-	配置的主机(网站)要想通过域名被外部访问，必须在DNS服务器或windows系统中注册访问网站时使用的域名，找到"C:\Windows\System32\drivers\etc"目录下的hosts文件，如下图所示：
	-	![](http://i.imgur.com/WYtZGiq.png)
	-	编辑这个文件，将新添加的网站的域名和IP地址绑定在一起，这样我们就可以在浏览器中使用www.gacl.cn这个域名去访问name是www.gacl.cn那个虚拟主机里面管理的那些web应用了
	-	![](http://i.imgur.com/OvB2tQ9.png)
	-	使用浏览器通过域名"www.gacl.cn"访问"www.gacl.cn"这个虚拟主机下的JavaWebDemo1这个web应用下的1.jsp这个web资源，"www.gacl.cn"这个虚拟主机开放了一个8080端口，用户只能通过这个8080端口去访问JavaWebDemo1这个web应用下的1.jsp这个web资源
	-	![](http://i.imgur.com/SnsCimS.png)
#  浏览器与服务器交互的过程
-	4.1 浏览器与服务器交互图
	-	![](http://i.imgur.com/I3IfzJp.png)
	-	当我们打开浏览器，在浏览器的地址栏中输入URL地址"http://www.gacl.cn:8080/JavaWebDemo1/1.jsp"去访问服务器上的1.jsp这个web资源的过程中，浏览器和服务器都做了神马操作呢，我们是怎么在浏览器里面看到1.jsp这个web资源里面的内容的呢？
	-	浏览器和服务器做了以下几个操作：
		-	1、浏览器根据主机名"www.gacl.cn"去操作系统的Hosts文件中查找主机名对应的IP地址。
		-	2、浏览器如果在操作系统的Hosts文件中没有找到对应的IP地址，就去互联网上的DNS服务器上查找"www.gacl.cn"这台主机对应的IP地址。
		-	3、浏览器查找到"www.gacl.cn"这台主机对应的IP地址后，就使用IP地址连接到Web服务器。
		-	4、浏览器连接到web服务器后，就使用http协议向服务器发送请求，发送请求的过程中，浏览器会向Web服务器以Stream(流)的形式传输数据，告诉Web服务器要访问服务器里面的哪个Web应用下的Web资源，如下图所示：
		-	![](http://i.imgur.com/GhwXocr.png)
		-	　这就是浏览器向Web服务器发请求时向服务器传输的数据，解释一下"GET /JavaWebDemo1/1.jsp HTTP/1.1"这里面的内容，
		-	　　GET：告诉Web服务器，浏览器是以GET的方式向服务器发请求。
		-	　　/JavaWebDemo1/1.jsp：告诉Web服务器，浏览器要访问JavaWebDemo1应用里面的1.jsp这个Web资源。
		-	　　HTTP/1.1：告诉Web服务器，浏览器是以HTTP协议请求的，使用的是1.1的版本。
		-	　　5、浏览器做完上面4步工作后，就开始等待，等待Web服务器把自己想要访问的1.jsp这个Web资源传输给它。
		-	　　6、服务器接收到浏览器传输的数据后，开始解析接收到的数据，服务器解析"GET /JavaWebDemo1/1.jsp HTTP/1.1"里面的内容时知道客户端浏览器要访问的是JavaWebDemo1应用里面的1.jsp这个Web资源，然后服务器就去读取1.jsp这个Web资源里面的内容，将读到的内容再以Stream(流)的形式传输给浏览器，如下图所示：
		-	　　![](http://i.imgur.com/R4bkGQn.png)
		-	　　这个就是Web服务器传输给浏览器的数据。
		-	　　7、浏览器拿到服务器传输给它的数据之后，就可以把数据展现给用户看了，如下图所示：
		-	　　![](http://i.imgur.com/qmuwiJH.png)
		-	　　看到的这个"JavaWebDemo1"就是浏览器解析服务器发送回来的数据后的效果
		-	　　服务器发送回来的数据：
		-	　　![](http://i.imgur.com/RmG2Hwn.png)
		-	　　这就是浏览器和服务器的交互过程。
# JavaWeb应用的组成结构
-	开发JavaWeb应用时，不同类型的文件有严格的存放规则，否则不仅可能会使web应用无法访问，还会导致web服务器启动报错
	-	![](http://i.imgur.com/jZAbM1H.png)
	-	WebRoot →Web应用所在目录，一般情况下虚拟目录要配置到此文件夹当中
		-	┝WEB-INF：此文件夹必须位于WebRoot文件夹里面，而且必须以这样的形式去命名，字母都要大写
			-	┝web.xml：配置文件，有格式要求，此文件必须以这样的形式去命名，并且必须放置到WEB-INF文件夹中。		
	-	　web.xml的格式可以直接从Tomcat中参考得到：找到Tomcat目录下的webapps\ROOT\WEB-INF这个目录下的web.xml文件，把这个文件拷贝到我们新建的WEB-INF文件夹中，并修改这个web.xml文件，把里面的注释删除掉，只留下如下所示的代码即可：
	-	　web.xml :
	-	　![](http://i.imgur.com/n9CewWN.png)
	-	　这就是web.xml这个文件的格式

