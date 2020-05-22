select * from emp;
/*2.查找部门30中员工的详细信息*/
select * from emp where DEPTNO=30;
/*3.查找奖金多于基本工资的员工信息*/
select * from emp where COMM>SAL;
/*4.查找奖金多于基本工资60%的员工信息*/
select * from emp where COMM>(SAL*0.6);
/*5.查找部门10、部门20的员工信息*/
select * from emp where DEPTNO=10 or DEPTNO=20;
/*6.获得奖金的员工的工作*/
select ename,job,comm from emp where comm>0;
/*7.奖金少于100或者没有获得奖金的员工的信息*/
select * from emp where comm<100 or comm is null;
/*8.以A、B、S开始的员工信息*/
select * from emp where ename like 'A%' or ename like 'B%' or ename like 'S%';
/*9.名字长度为6个字符的员工信息*/
select * from emp where length(ename)=6; 		
/*10.计算员工的日薪*/
select ename,sal/30 as '日薪' from emp;
/*使用截取函数，截取小数点后2位*/
select ename,truncate(sal/30,2) as '日薪' from emp;
/*四舍五入保留2位小数*/
select ename,round(sal/30,2) as '日薪' from emp;
/*11.名字中不包含字母R的员工信息*/
select * from emp where ename not like '%R%';
/*
 * 排序:  默认升序排列
 *   
 * */	
select * from emp order by ename asc;
/*
 * 排序:  倒序
 *   
 * */	
select * from emp order by ename desc;