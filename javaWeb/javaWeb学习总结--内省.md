# javaWeb学习总结--内省

-	可以查jdk
	-	introspector对象
	-	BeanInfo对象

----
**Context**

----

# 内省技术
-	用来获得javaBeans的属性及属性的get或set方法
	-	javaBean:就是满足了特定格式的java类:
		* 需要提供无参数的构造方法:
		* 属性私有
		* 对私有的属性提供public的get/set方法.

-	一个javaBean的属性是由get或set方法确定的
# 内省的用法
-	获得某个类中的属性
-	![](http://i.imgur.com/OYwJHi0.png)
-	自定义MyBeanUtils
-	![](http://i.imgur.com/aNyEHtM.png)