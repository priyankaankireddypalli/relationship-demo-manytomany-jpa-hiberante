insert into course(id,name) values(10001,'JPA in 50 Steps');
insert into course(id,name) values(10002,'Spring in 50 Steps');
insert into course(id,name) values(10003,'Spring Boot in 100 Steps');
insert into passport(id,number) values(40001,'P123456');
insert into passport(id,number) values(40002,'R678324');
insert into passport(id,number) values(40003,'P342354');
insert into review(id,description,rating,course_id) values(50001,'5','Great Course',10001);
insert into review(id,description,rating,course_id) values(50002,'4','Wonderful Course',10001);
insert into review(id,description,rating,course_id) values(50003,'5','Awesome Course',10003);
insert into student(id,name,passport_id) values(20001,'priya',40001);
insert into student(id,name,passport_id) values(20002,'raghu',40002);
insert into student(id,name,passport_id) values(20003,'preethi',40003);
insert into student_course(student_id,course_id) values(20001,10001);
insert into student_course(student_id,course_id) values(20002,10001);
insert into student_course(student_id,course_id) values(20003,10001);
insert into student_course(student_id,course_id) values(20001,10003);