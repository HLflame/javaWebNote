只为成功找方法,不为失败找借口!
# javaWeb学习总结(十一)--使用cookie进行会话管理
----
**Content**

-	[会话的概念](#会话的概念)
-	[会话过程中要解决的一些问题？](#会话过程中要解决的一些问题？)
-	[保存会话数据的两种技术](#保存会话数据的两种技术)
-	[Java提供的操作Cookie的API](#Java提供的操作Cookie的API)
-	[Cookie使用范例](#Cookie使用范例)
-	[Cookie注意细节](#Cookie注意细节)

----

# 会话的概念
-	会话可简单理解为：用户开一个浏览器，点击多个超链接，访问服务器多个web资源，然后关闭浏览器，整个过程称之为一个会话。
　　有状态会话：一个同学来过教室，下次再来教室，我们会知道这个同学曾经来过，这称之为有状态会话。
# 会话过程中要解决的一些问题？
-	每个用户在使用浏览器与服务器进行会话的过程中，不可避免各自会产生一些数据，程序要想办法为每个用户保存这些数据。
# 保存会话数据的两种技术
-	3.1 Cookie
	-	Cookie是客户端技术，程序把每个用户的数据以cookie的形式写给用户各自的浏览器。当用户使用浏览器再去访问服务器中的web资源时，就会带着各自的数据去。这样，web资源处理的就是用户各自的数据了。
-	3.2 Session
	-	Session是服务器端技术，利用这个技术，服务器在运行时可以为每一个用户的浏览器创建一个其独享的session对象，由于session为用户浏览器独享，所以用户在访问服务器的web资源时，可以把各自的数据放在各自的session中，当用户再去访问服务器中的其它web资源时，其它web资源再从用户各自的session中取出数据为用户服务。
# Java提供的操作Cookie的API
-	Java中的javax.servlet.http.Cookie类用于创建一个Cookie
-	Cookie类的主要方法

-	1 Cookie(String name, String value)
	-	构造方法
	-	实例化Cookie对象，传入cooke名称和cookie的值
-	2
	-	public String getName()
	-	普通方法
	-	取得Cookie的名字
-	3
	-	public String getValue()
	-	普通方法
	-	取得Cookie的值
-	4
	-	public void setValue(String newValue)
	-	普通方法
	-	设置Cookie的值
-	5
-	public void setMaxAge(int expiry)
-	普通方法
-	设置Cookie的最大保存时间，即cookie的有效期，当服务器给浏览器	回送一个cookie时，如果在服务器端没有调用setMaxAge方法设置	cookie的有效期，那么cookie的有效期只在一次会话过程中有效，用	户开一个浏览器，点击多个超链接，访问服务器多个web资源，然后关	闭浏览器，整个过程称之为一次会话，当用户关闭浏览器，会话就结束	了，此时cookie就会失效，如果在服务器端使用setMaxAge方法设置	了cookie的有效期，比如设置了30分钟，那么当服务器把cookie发送	给浏览器时，此时cookie就会在客户端的硬盘上存储30分钟，在30分	钟内，即使浏览器关了，cookie依然存在，在30分钟内，打开浏览器	访问服务器时，浏览器都会把cookie一起带上，这样就可以在服务器	端获取到客户端浏览器传递过来的cookie里面的信息了，这就是	cookie设置maxAge和不设置maxAge的区别，不设置maxAge，那么	cookie就只在一次会话中有效，一旦用户关闭了浏览器，那么cookie	就没有了，那么浏览器是怎么做到这一点的呢，我们启动一个浏览器，	就相当于启动一个应用程序，而服务器回送的cookie首先是存在浏览	器的缓存中的，当浏览器关闭时，浏览器的缓存自然就没有了，所以存	储在缓存中的cookie自然就被清掉了，而如果设置了cookie的有效	期，那么浏览器在关闭时，就会把缓存中的cookie写到硬盘上存储起	来，这样cookie就能够一直存在了。
-	6
-	public int getMaxAge()
-	普通方法
-	获取Cookies的有效期
-	7
-	public void setPath(String uri)
-	普通方法
-	设置cookie的有效路径，比如把cookie的有效路径设置为"/xdp"，	那么浏览器访问"xdp"目录下的web资源时，都会带上cookie，再比如	把cookie的有效路径设置为"/xdp/gacl"，那么浏览器只有在访	问"xdp"目录下的"gacl"这个目录里面的web资源时才会带上cookie	一起访问，而当访问"xdp"目录下的web资源时，浏览器是不带cookie	的
-	8
-	public String getPath()
-	普通方法
-	获取cookie的有效路径
-	9
-	public void setDomain(String pattern)
-	普通方法
 -	设置cookie的有效域
-	10
-	public String getDomain()
-	普通方法
-	 获取cookie的有效域
-	**response**接口也中定义了一个addCookie方法，它用于在其响应头中增加一个相应的Set-Cookie头字段。 同样，request接口中也定义了一个getCookies方法，它用于获取客户端提交的Cookie。

# Cookie使用范例
-	5.1、使用cookie记录用户上一次访问的时间
-	![](http://i.imgur.com/WJMgtgJ.png)
-	第一次访问时这个Servlet时，效果如下所示：
-	![](http://i.imgur.com/lSIKbOO.png)
-	点击浏览器的刷新按钮，进行第二次访问，此时就服务器就可以通过cookie获取浏览器上一次访问的时间了，效果如下：
-	![](http://i.imgur.com/iX4Hllp.png)
-	在上面的例子中，在程序代码中并没有使用setMaxAge方法设置cookie的有效期，所以当关闭浏览器之后，cookie就失效了，要想在关闭了浏览器之后，cookie依然有效，那么在创建cookie时，就要为cookie设置一个有效期。如下所示：
-	![](http://i.imgur.com/rbBDEbG.png)
-	![](http://i.imgur.com/x09AGK4.png)
-	用户第一次访问时，服务器发送给浏览器的cookie就存储到了硬盘上，如下所示：
-	![](http://i.imgur.com/vdzd2fm.png)
-	这样即使关闭了浏览器，下次再访问时，也依然可以通过cookie获取用户上一次访问的时间。
# Cookie注意细节
-	一个Cookie只能标识一种信息，它至少含有一个标识该信息的名称（NAME）和设置值（VALUE）。
-	一个WEB站点可以给一个WEB浏览器发送多个Cookie，一个WEB浏览器也可以存储多个WEB站点提供的Cookie。
-	浏览器一般只允许存放300个Cookie，每个站点最多存放20个Cookie，每个Cookie的大小限制为4KB。
-	如果创建了一个cookie，并将他发送到浏览器，默认情况下它是一个会话级别的cookie（即存储在浏览器的内存中），用户退出浏览器之后即被删除。若希望浏览器将该cookie存储在磁盘上，则需要使用maxAge，并给出一个以秒为单位的时间。将最大时效设为0则是命令浏览器删除该cookie。
-	6.1 删除Cookie
-	注意:删除cookie时，path必须一致，否则不会删除
-	![](http://i.imgur.com/FIBWurx.png)
-	6.2 cookie中存取中文
-	要想在cookie中存储中文，那么必须使用URLEncoder类里面的encode(String s, String enc)方法进行中文转码，例如：
-	![](http://i.imgur.com/rf4d7TG.png)
-	在获取cookie中的中文数据时，再使用URLDecoder类里面的decode(String s, String enc)进行解码，例如：
-	 URLDecoder.decode(cookies[i].getValue(), "UTF-8")

# 案列:记录用户的商品浏览记录
-	步骤分析:
-	【步骤一】：在登录完成后，显示商品列表页面.
-	【步骤二】：为商品列表页面做一些准备工作.
-	【步骤三】：点击某个商品,将商品ID传递一个Servlet.
-	【步骤四】：在Servlet中:判断是否是第一次浏览商品
-	【步骤五】：如果是第一次：将商品的ID存入到Cookie中即可.
-	【步骤六】：如果不是第一次：判断该商品是否已经浏览了.
-	【步骤七】：如果浏览器过.删除之前元素,将该元素添加到最前面.
-	【步骤八】：如果没有浏览过该商品.判断最大长度，没有超过限制,直接加到最前,如果已经超过限制,删除最后一个，将其插入到最前.
-	代码实现:

public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * * 接收商品id.
		 * * 接收从客户端带过来的所有Cookie.
		 * * 从Cookie的数组中查找指定名称的Cookie.
		 * * 判断是否是第一次浏览商品:
		 *     * 第一次浏览商品
		 *        * 直接将商品的ID存入到Cookie.
		 *        * 将Cookie回写到浏览器.
		 *     * 不是第一次浏览商品 1-2
		 *        * 判断当前的商品是否已经在浏览记录.
		 *            * 已经存在: 2-1 移除当前元素，将当前元素添加到最开始.
		 *            * 没在浏览记录中: 
		 *                * 判断是否已经超过了最大长度:如果超过 2-1-3:删除最后一个 将当前元素添加到最前面.
		 *                * 没有超过:直接将该元素添加到最前位置.
		 *        * 将转换的id的值存入到Cookie,回写浏览器.
		 */
		// 接收id:
		String id = request.getParameter("id");
		// 获得所有的Cookie的信息:
		Cookie[] cookies = request.getCookies();
		// 判断是否是第一次:
		Cookie cookie = CookieUtils.findCookie(cookies, "history");
		if(cookie == null){
			// 第一次浏览商品
			Cookie c = new Cookie("history",id);
			c.setPath("/day11");
			c.setMaxAge(60*60*24*7);
			response.addCookie(c);
		}else{
			// 不是第一次浏览
			// 判断选择的商品是否已经在浏览记录中 2-1
			String value = cookie.getValue();
			String[] ids = value.split("-");
			// 将数组变为集合：
			LinkedList<String> list = new LinkedList<String>(Arrays.asList(ids));
			if(list.contains(id)){
				// 之前浏览过该商品
				list.remove(id); // 1-2-3
				list.addFirst(id);
			}else{
				// 没有浏览过该商品.
				if(list.size() >=3 ){
					// 超过3个
					list.removeLast();
					list.addFirst(id);
				}else{
					// 没到3个.
					list.addFirst(id);
				}
			}
			// 将list中的元素取出,使用-连接上保存到Cookie,写回浏览器.
			StringBuffer sb = new StringBuffer();
			for(String s:list){
				sb.append(s).append("-");
			}
			String sValue = sb.toString().substring(0,sb.length()-1);
			System.out.println(sValue);
			// 存入到Cookie中
			Cookie c = new Cookie("history",sValue);
			c.setPath("/day11");
			c.setMaxAge(60*60*24*7);
			response.addCookie(c);
		}
		
		request.getRequestDispatcher("/demo2/product_info.htm").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
-	清空浏览记录:

删除持久性的Cookie:
public class ClearServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie cookie = new Cookie("history",null);
		cookie.setPath("/day11");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		
		response.sendRedirect("/day11/demo2/product_list.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}