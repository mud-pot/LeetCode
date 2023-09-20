# Write your MySQL query statement below
with table1 as(
  select *
  from Students
  cross join Subjects
),
table2 as(
  select student_id, subject_name, count(subject_name) as count
  from Examinations
  group by student_id, subject_name
)

select table1.student_id, table1.student_name, table1.subject_name, 
case when count is not null then count
else 0
end as attended_exams
from table1
left join table2
on table1.student_id = table2.student_id
and table1.subject_name = table2.subject_name
order by table1.student_id, table1.subject_name