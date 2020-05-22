# 数据库

## 数据库常用基本操作

- 选择：select * from table1 where 范围
- 插入：insert into table1(field1,field2) values(value1,value2)
- 删除：delete from table1 where 范围
- 更新：update table1 set field1=value1 where 范围
- 查找：select * from table1 where field1 like ’%value1%’ 
- 排序：select * from table1 order by field1,field2 [desc]
- 总数：select count as totalcount from table1
- 求和：select sum(field1) as sumvalue from table1
- 平均：select avg(field1) as avgvalue from table1
- 最大：select max(field1) as maxvalue from table1
- 最小：select min(field1) as minvalue from table1

## 数据库中like操作符基本用法

1. % 包含零个或多个字符的任意字符串：
   - like'Mc%' 将搜索以字母Mc开头的所有字符串（McBadden）。
   - like'%inger' 将搜索以字母 inger 结尾的所有字符串（如 Ringer、Stringer）。
   - like'%en%' 将搜索在任何位置包含字母 en 的所有字符串（如 Bennet、Green、McBadden）。

2. _（下划线）任何单个字符：
   - like'_heryl' 将搜索以字母 heryl 结尾的所有六个字母的名称（如 Cheryl、Sheryl）。

3. MySQL允许将NOT运算符与LIKE运算符组合，以找到不匹配特定模式的字符串。假设要搜索姓氏(lastname)不以字符B开头的员工，则可以使用NOT LIKE作为查询

## SQL注入

- 将恶意的SQL命令注入到后台数据库引擎执行的能力，可以通过输入sql语句得到一个存在安全漏洞的网站上的数据库，不按照设计者意图去执行SQL语句。
- 例如:很多影视网站泄露的VIP会员密码大多是通过web表单提交查询字符暴漏出的。

## 如何防范数据库注入攻击

1. 不要手写拼接数据库语句，使用prepareStatement对输入数据进行预编译。

   - 例如：select * from 表名 where username = '" + username +      "' and password = '" + password + "'"
   - 这样的语句出现在代码中十分危险，用户的输入没有经过任何的过滤，假如输入的username是2'or'1=1，password是2'or'1=1，那么无须知道正确的用户名和密码也能成功登录进网站，这就是所谓的万能用户，配合盲注、报错注入等技巧，甚至可以获取数据库中所有的信息
   - 用prepareStatement对输入数据进行预编译，用prepareStatement不但可以避免sql语句拼接的问题，还能因为其预处理的能力大幅提升执行效率
        - 原理：当运行时动态地把参数传给PreprareStatement时，不管参数里有什么，都会作为一个字段的值来处理，保证data永远是data，而不会变成可执行的code，这样子就杜绝了SQL注入的问题

3. 使用框架附带的数据库操作方法

   - 通常框架附带的代码，会把传入的参数作为语义而不是直接拼接到查询语句上，这样能避免很多数据库注入的问题。
