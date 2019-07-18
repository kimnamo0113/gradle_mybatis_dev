select user(), database();

select * from addresses;
select * from course_enrollment;
select * from courses;
select * from students;
select * from tutors;

select stud_id,name,email,dob,substring(phone,1,3) f,substring(phone,5,3) m,substring(phone,9,4) l
from students where stud_id=1;

select stud_id, name, email, phone, dob from students;

desc students;

alter table students auto_increment=100;


select last_insert_id() from students;

SHOW INDEX FROM students;