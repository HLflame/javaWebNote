# javaWeb学习总结--反射(Reflect)
----
# 问题
-	1.如何绕过源代码操作某个类?
-	2.反射的目的是什么?
-	3.描述组成一个类的基本要素
-	4.获得一个Class对象的方式有几种?
-	5.描述反射操作类的基本流程

----
**Content**

-	[反射原理](#反射原理)
-	[反射目的](#反射目的)
-	[得到反射的方式](#得到反射的方式)

----
# 反射原理
-	类的加载器将class文件加载到虚拟机中,就会有一个Class对象代表该类
-	![](http://i.imgur.com/HgNG1w1.png)
# 反射目的
-	为了操作某个类的属性或方法
# 得到反射的方式
-	1.通过类名.class
-	2.通过类的实例对象.getClass()方法获得
-	3.使用Class的forName的静态方法获得(推荐使用),参数为"完全限定名"
# 用反射操作构造方法
-	采用默认的无惨构造函数
	-	类名.class.newInstance();
-	采用有参数的构造方法来创建对象
	-	类名.class.getConstructor(String.class,Integer.class,...).newInstance("参数",参数);
	-	![](http://i.imgur.com/olGkurC.png)

# 用反射操作类中的属性
-	1.获得反射Class对象
	-	Class clazz=Class.forName("完全限定名");
-	2.获得属性
	-	clazz.getField("name");//获得某个属性
	-	Field[]	fields=clazz.getFields();//获得所有的属性
-	3.获得私有的属性
	-	Field field=clazz.getDeclaredField("name");
	-	field.setAccessible(true);
	-	Person p=(Person)clazz.newInstance();
	-	String name=(String)field.get(p);
	-	详细操作![](http://i.imgur.com/yFcqUxT.png)

# 用反射操作类中的方法,并且让方法执行
-	1.获得class对象
	-	Class clazz=Class.forName("完全限定名");
-	2.获得类的方法(私有的方法,不带参数)
	-	Method method=clazz.getDeclaredMethod("run");
	-	method.setAccessible(true);//设置私有方法可以访问
-	3.执行方法(不带参数)
	-	method.invoke(clazz.newInstance());
-	4.获得类的方法(公有的方法,带参数)
	-	Method method=clazz.getMethod("方法名",参数列表(String.class));
-	5.执行方法
	-	method.invoke(clazz.newInstance(),"参数列表"("凤姐"))
	-	![](http://i.imgur.com/KwLvslo.png)

