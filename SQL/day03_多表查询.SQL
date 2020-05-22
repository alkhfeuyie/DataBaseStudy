/*1、选择部门30中员工的所有信息*/
select *
from emp
where deptno=30
/*2、列出职位为Manager的员工编号姓名*/
select empno,ename
from emp
where job='Manager'
/*3、找出奖金高于工资的员工*/
select *
from emp
where comm>sal
/*4、找出每个员工奖金和工资的总和*/
select ename,sal+ifnull(comm,0) as totalWages
from emp
/*5、找出部门10中的经理和部门20中的普通员工*/
select ename,job,deptno
from emp
where job='MANAGER' and deptno=10
or job != 'MANAGER' and deptno=20
/*6、找出部门10中既不是普通员工，而且工资>=2000的员工*/
select ename,job,sal
from emp
where deptno=10 and job='MANAGER' and sal>2000
/*7、找出有奖金的员工的不同工作*/
select job
from emp
where comm>0
/*8、找出没有奖金或奖金低于500的员工*/
select ename
from emp
where comm<500 or comm is null
/*9、显示雇员姓名，根据其服务年限将其最老的员工排在最前*/
select ename,hiredate
from emp
order by hiredate asc