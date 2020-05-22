/*1.查询所有员工的姓名、部门名*/
select e.ename,d.dname from emp e,dept d where e.deptno = d.deptno;
/*2.工资水平高于SMITH的员工信息*/
select * from emp where sal > (select sal from emp where ename='SMITH');
/*3.查询部门号及其部门的最低工资*/
select dname,min(e.sal) from emp e,dept d where e.deptno = d.deptno group by d.deptno
/*4.查询销售部所有员工的姓名*/
select e.ename,d.dname from emp e,dept d where e.deptno=d.deptno and d.dname='sales';
/*5.查询与SCOTT从事相同工作的员工*/
select * from emp where JOB = (select JOB from emp where ename='SCOTT');
/*6.返回工资高于部门30所有员工工资水平的员工*/
select ename from emp where sal >(select max(sal) from emp where deptno='30');
/*7.返回员工的姓名、所在部门名及其工资*/
select e.ename,d.dname,e.sal from emp e,dept d where e.deptno=d.deptno;
/*8.返回员工工作及其从事此工作的最低工资*/
select ename,job,min(sal) from emp group by job;