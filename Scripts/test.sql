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

select * from addresses where addr_id=3;

select stud_id, name,email,phone,a.addr_id,street,city,state,zip,country
from students s left join addresses a on s.addr_id=a.addr_id
where stud_id=1
;


alter table students auto_increment=100;


select last_insert_id() from students;

SHOW INDEX FROM students;

select * from tutors;
select * from courses;

select t.tutor_id,t.name as tutor_name, email, course_id, c.name, description, start_date, end_date
from tutors t left join courses c on t.tutor_id=c.tutor_id
where t.tutor_id=1;


alter table students add gender tinyint unsigned;
select * from students;
desc students;
