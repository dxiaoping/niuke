use sql_study_data;
select e.emp_no from employees e
left join salaries s on e.emp_no=s.emp_no
and s.to_date='9999-01-01';


select a.emp_no,a.salary,
(select sum(s.salary) from  salaries as s
 where s.emp_no <=a.emp_no
and s.to_date='9999-01-01')as running_total
from salaries as a where a.to_date='9999-01-01'
order by a.emp_no;

alter table test1 rename to test;