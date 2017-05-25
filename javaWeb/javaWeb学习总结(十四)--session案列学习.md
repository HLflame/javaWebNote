# JavaWeb学习总结(十四)--Session案列学习
----
**Content**

-	[案列一:将商品添加到购物车](#案列一:将商品添加到购物车)

-	[案例二：进行一次性验证码的校验](#案例二：进行一次性验证码的校验)

----

# 案列一:将商品添加到购物车
-	技术分析:
	-	Cookie本身是有大小和个数的限制.Session没有限制.Cookie的数据保存在客户端,Session数据保存在服务器端.
	-	Session的执行原理：基于Cookie的.

	-	获得Session:
	    -	request.getSession();
-	步骤分析:
	-	【步骤一】：点击加入购物车提交到Servlet
	-	【步骤二】：在Servlet将购物的商品存入到Session中.
	-	【步骤三】：可以创建一个Map集合用于保存购物信息Map的key可以是商品的名称,Map的value是数量.
	-	【步骤四】：在购物车页面中显示Map中的数据就可以.
-	代码实现:
-	![](http://i.imgur.com/dMkOEXM.png)
# 案例二：进行一次性验证码的校验
-	技术分析：
	-	使用session保存生产的验证码.
-	步骤分析:
	-	【步骤一】：生成验证码,将生成验证码的随机的4个字母或数字保存到session中.
	-	【步骤二】：在页面中输入验证码值,点提交.
	-	【步骤三】：在Servlet中从表单中获得验证码从session中获得一个验证码.
	-	【步骤四】：比对两个验证码值是否一致.
	-	【步骤五】：将session中保存的验证码清空.
-	代码实现:
-	![](http://i.imgur.com/u7eJK9h.png)
-	使用JS控制图片切换:
-	![](http://i.imgur.com/qysPzFa.png)