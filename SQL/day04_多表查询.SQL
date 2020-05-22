/*1、列出员工表中每个部门的员工数和部门号*/
select deptno,count(*)
from emp
group by deptno
/*2、列出员工表中每个部门的员工数(大于3)和部门的名称*/
select e.deptno,d.dname,count(*)
from emp e,dept d
where d.deptno=e.deptno
group by e.deptno
having count(*)>3
/*3、找出工资比JONES多的员工*/
select *
from emp
where sal>(
	select sal
	from emp
	where ename='JONES')
/*4、列出所有员工的姓名和其上级的姓名*/
select a.ename as '员工',b.ename as '上司'
from emp a,emp b
where a.empno=b.mgr
/*5、找出不在部门20，且比部门20中任何一个人工资都高的员工姓名，部门名称*/
select e.ename,d.dname
from emp e,dept d
where e.deptno=d.deptno and e.deptno!=20 and sal>(
	select max(sal)
	from emp
	where deptno=20)
/*6、平均工资大于2000的工作职位*/
select job,avg(sal)
from emp
group by job
having avg(sal)>2000
/*7、分部门找出工资大于2000的所有员工的平均工资，且平均工资大于2500*/
select deptno,avg(sal)
from emp
where sal>2000
group by deptno
having avg(sal)>2500
/*8、找出每个月工资总数最少的那个部门的部门编号部门名称部门位置*/
select e.deptno,d.dname,d.loc,sum(e.sal) as 'totalWages'
from emp e,dept d
where e.deptno=d.deptno
group by e.deptno