select e.ename,d.dname from emp e,dept d where e.deptno = d.deptno;
select * from emp where sal > (select sal from emp where ename='SMITH');

select e.ename,d.dname from emp e,dept d where e.deptno=d.deptno and d.dname='sales';
select * from emp where JOB = (select JOB from emp where ename='SCOTT');
select ename from emp where sal >(select max(sal) from emp where deptno='30');
select e.ename,d.dname,e.sal from emp e,dept d where e.deptno=d.deptno;
select ename,job,min(sal) from emp group by job;