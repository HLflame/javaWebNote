# javaWeb学习总结--jquery-Ajax传递JSON数据

# 案列:使用jQ完成省市联动的案列:使用xml作为向应数据

-	需求:
	-	在注册页面上的籍贯的地方有选择省,省发生变化市也会跟着变化.市的数据从服务器端获取.响应XML格式的数据.
-	技术分析:
	-	【AJAX的响应的数据】:
		-	文本,一段HTML的数据,XML,JSON

	-	【使用工具生成XML的文件】
		-	通常使用xStream工具. 将集合,数组,对象转成XML.

-	步骤分析:
	-	【步骤一】：使用注册页面中省市的下拉列表.
	-	【步骤二】：当省份发生变化,触发一个事件.
	-	【步骤三】：将选择的省份的信息传入到Servlet中
	-	【步骤四】：根据省份信息查询市的信息.
	-	【步骤五】：将查询到市的信息转成XML.
	-	【步骤六】：获得XML的指定信息,显示到第二个列表中.

-	代码实现:
	-	![](http://i.imgur.com/Xhnkuqf.png)

# 案列:使用JQ完成省市联动的案列:使用JSON作为响应数据

-	需求:
	-	在注册页面上的籍贯的地方有选择省,省发生变化市也会跟着变化.市的数据从服务器端获取.响应JSON格式的数据.
	
-	技术分析:
	-	【JSON的概述】
		-	JSON的概念:
		-	![](http://i.imgur.com/ywn5bGN.png)
		-	JSON的数据格式的介绍:
		-	{“id”:1,”name”:aaa}
		-	[{“id”:1,”name”:aaa},{“id”:2,”name”:bbb}]
		-	{
  			  “city”:{“cid”:1,”cname”:”xxx”}
			}

	-	【JSON的生成工具】
	-	JSONLIB 转换JSON数据:
		-	JSONArray		:将数组或List集合转成JSON.
		-	 JSONObject	:将对象或Map集合转成JSON.

-	代码实现:
	-	![](http://i.imgur.com/kHwe4LL.png)