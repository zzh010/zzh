CREATE TABLE userInfo (id varchar(10) primary key,
                       name VARCHAR(10),password varchar(20));
insert into userInfo values('00001','刘','123');
insert into userInfo values('00002','毛','456');
insert into userInfo values('00003','陈','789');
insert into userInfo values('00004','林','321');
insert into userInfo values('00005','王','654');


create table emp_Info (id int primary key, name varchar(10), 
                       hometown varchar(50),  sex        varchar(4),
                       nation   varchar(10),  address    varchar(50),
                       borntime date,
                       mStatus  varchar(8),   department varchar(20),
                       tele     varchar(12),  political  varchar(8),
                       startwtime date,   post       varchar(10),
                       education varchar(10), salary     int,
                       nowpost varchar(10),   notes varchar(50)
                      );
insert into emp_Info values(1,'刘新龙','黑龙江','男','汉','黑龙江','1990-1-1','否','销售部',
                            '15112345678','团员','2009-1-1','组员','本科','10000','组员','正常');
insert into emp_Info values(2,'毛维静','陕西','女','汉','陕西','1990-1-1','否','市场营销',
                            '15112345678','团员','2009-1-1','组员','本科','20000','经理','正常');
insert into emp_Info values(3,'陈超','河北','男','汉','河北','1990-1-1','否','采购部',
                            '15112345678','团员','2009-1-1','组员','高中','10000','组员','正常');
insert into emp_Info values(4,'林佳耀','广西','男','汉','广西','1990-1-1','否','市场营销',
                            '15112345678','团员','2009-1-1','组员','本科','10000','组员','正常');
insert into emp_Info values(5,'刘新园','河北','女','汉','河北','1990-1-1','否','财务部',
                            '15112345678','团员','2009-1-1','组员','硕士','15000','小组长','正常');
insert into emp_Info values(6,'园刘新','河北','女','汉','河北','1990-1-1','否','财务部',
                            '15112345678','团员','2009-1-1','组员','硕士','15000','小组长','正常');
insert into emp_Info values(7,'刘斤园','河北','女','汉','河北','1990-1-1','否','财务部',
                            '15112345678','团员','2009-1-1','组员','本科','15000','小组长','正常');
insert into emp_Info values(8,'文新园','河北','女','汉','河北','1990-1-1','否','财务部',
                            '15112345678','团员','2009-1-1','组员','硕士','15000','小组长','正常');



create table dept_Info (dept_id int primary key,dept_name varchar(50),description varchar(200),empnums int);
insert into dept_Info values(101,'客户服务','为客户解答疑问',50);
insert into dept_Info values(102,'战略部署','策划公司发展方向和策略',10);
insert into dept_Info values(103,'人力资源部','为公司发展招收适合人才',100);
insert into dept_Info values(104,'财务部','管理公司财务',5);
insert into dept_Info values(105,'销售部','负责产品的销售',150);
insert into dept_Info values(106,'生产部','管理产品生产',250);
insert into dept_Info values(107,'采购部','原料的采购',350);


create table job_Info (job_id int primary key auto_increment,id int,olddept varchar(50),
                       newdept varchar(50), transTime date,jobnotes varchar(100));

insert into job_Info values(null,1,'客户服务','销售部','2010-1-5','正常');
insert into job_Info values(null,3,'生产部', '采购部','2010-1-5','正常');
insert into job_Info values(null,5,'人力资源部','财务部','2010-1-5','正常');
insert into job_Info values(null,2,'客户服务','销售部','2010-1-5','正常');
insert into job_Info values(null,4,'生产部', '采购部','2010-1-5','正常');
insert into job_Info values(null,6,'人力资源部','财务部','2010-1-5','正常');
insert into job_Info values(null,7,'客户服务','销售部','2010-1-5','正常');
insert into job_Info values(null,8,'生产部', '采购部','2010-1-5','正常');



create table rewards (rid int primary key auto_increment,id int,time date,status varchar(10),reason varchar(100));

insert into rewards values(null,2,'2010-5-4','惩罚', '泄露公司机密');
insert into rewards values(null,4,'2010-6-14','奖励','提出有价值参考意见');
insert into rewards values(null,5,'2010-7-1','奖励', '任务提前超额完成');


create table leavenote (lid int primary key,id int,
                        year int,month int,day int,
                        reason varchar(50),days int,
                        approveperson varchar(10),approvetime date,
                        status varchar(10),notes varchar(50));
insert into leavenote values(10001,3,2010,5,5,'病假',3,'老大','2010-5-5','假期中','扣一月工资');


create table salary (sid int primary key auto_increment,id int,salarybase varchar(20),bonus varchar(20),extrawage int, year int , month int);

insert into salary values(null,1,'10000','500',200,2010,7);
insert into salary values(null,2,'20000','2500',200,2010,7);
insert into salary values(null,3,'10000','500',200,2010,7);
insert into salary values(null,4,'10000','500',200,2010,7);
insert into salary values(null,5,'15000','1500',200,2010,7);



create table attendance (aid int primary key auto_increment,id int ,year int,month int,actual int,notes varchar(100));
insert into attendance values(null,2,2010,6,32,'不正常');
insert into attendance values(null,4,2010,7,25,'正常');
insert into attendance values(null,5,2010,8,24,'正常');
insert into attendance values(null,6,2010,7,25,'正常');
insert into attendance values(null,7,2010,7,25,'正常');
insert into attendance values(null,8,2010,7,25,'正常');
insert into attendance values(null,1,2010,7,20,'正常');
insert into attendance values(null,3,2010,7,21,'正常');

create table extrawork(eid int primary key auto_increment,id int,extrawage int,day date);
insert into extrawork values(null,2,200,'2010-1-1');
insert into extrawork values(null,1,200,'2009-2-5');
insert into extrawork values(null,2,200,'2008-3-8');
insert into extrawork values(null,2,200,'2010-1-1');
insert into extrawork values(null,1,200,'2009-2-5');
insert into extrawork values(null,2,200,'2008-3-8');



