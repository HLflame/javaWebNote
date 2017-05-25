# 事务的概述
-	什么是事务:(ACID)
	-	事务指的是逻辑上的一组操作,组成这组操作的各个逻辑单元要么一起成功,要么一起失败
-	MYSQL的事务管理:
	-	创建一个账号表:
	-	![](http://i.imgur.com/fTlooir.png)
	-	MYSQL的事务管理有两种方式:(MYSQL数据库事务默认是自动提交的.Oracle数据库事务默认是不自动提交的)
	-	1.手动开启事务
		-	start transaction
		-	多条sql语句;
		-	commit/rollback;
	-	2.设置一个自动提交参数
		-	show variables like '%commit%';--查看与commit相关的参数.
		-	set autocommit = 0;--将autocommit参数设置为off.

-	jdbc的事务管理:
	-	JDBC的事务的管理的API:
		-	void setAutoCommit(boolean autoCommit);将此链接的自动提交模式设置为给定状态
		-	void commit();使用上一次提交/回滚后进行的更改成为持久更改,并释放Connection对象当前持有的所有数据锁.
		-	void rollback();取消当前事务中进行的所有更改,释放此Connection对象当前持有的所有数据库锁
	-	DBUtils实现事务管理
		-	没有事务管理
		-	![](http://i.imgur.com/5KnBHlf.png)
		-	有事务管理
		-	![](http://i.imgur.com/akPa8H4.png)
# 总结:
-	事务特性:
	-	原子性:强调事务的不可分割.
	-	一致性:强调的是事务执行的前后,数据的完整性要保持一致.
	-	隔离性:一个事务的执行不应该受到其他事务的干扰.
	-	持久性:事务一旦结束(提交/回滚)数据就持久保持到了数据库.

-	如果不考虑事务的隔离性,引发一些安全性问题:
	-	一类读问题:
		-	脏读		:一个事务读到另一个事务还没有提交的数据
		-	不可重复读:一个事务读到了另一个事务已经提交的update的数据,导致在当前的事务中多次查询结果不一致.
		-	幻读/虚读:一个事务读到另一个事务已经提交的insert的数据,导致在当前的事务中多次查询结果不一致.
	-	一类写问题:
		-	引发两类丢失更新

-	解决引发的读问题:
	-	设置事务的隔离级别:
		-	read uncommitted	:未提交读,脏读,不可重复读,虚读都可能发生
		-	read committed		:已提交读,避免脏读,但是不可重复读和虚读有可能发生.
		-	repeatable read		:可重复读,避免脏读,不可重复读,但是虚读有可能发生.
		-	serializable		:串行化的.避免脏读,不可重复读,虚读的发生.

-	MYSQL隔离级别:repeatable read Oracle隔离级别:read committed
-	演示脏读的发生:
-	![](http://i.imgur.com/G27Hry4.png)
-	演示避免脏读,不可重复读发生
-	![](http://i.imgur.com/8OgaGRL.png)
-	演示避免不可重复读:
-	![](http://i.imgur.com/69FO6Vr.png)
-	演示避免虚读的发生:
-	![](http://i.imgur.com/oXqDTy4.png)

# 案列-,银行转账事务处理
-	线程ThreadLocal处理事务
-	![](http://i.imgur.com/Bzb5bpx.png)
-	事务处理的service
-	![](http://i.imgur.com/WzKIGYd.png)
-	dao层修改数据
-	![](http://i.imgur.com/M0o1Sfo.png)


		