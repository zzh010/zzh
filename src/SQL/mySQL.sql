CREATE TABLE userInfo (id varchar(10) primary key,
                       name VARCHAR(10),password varchar(20));
insert into userInfo values('00001','��','123');
insert into userInfo values('00002','ë','456');
insert into userInfo values('00003','��','789');
insert into userInfo values('00004','��','321');
insert into userInfo values('00005','��','654');


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
insert into emp_Info values(1,'������','������','��','��','������','1990-1-1','��','���۲�',
                            '15112345678','��Ա','2009-1-1','��Ա','����','10000','��Ա','����');
insert into emp_Info values(2,'ëά��','����','Ů','��','����','1990-1-1','��','�г�Ӫ��',
                            '15112345678','��Ա','2009-1-1','��Ա','����','20000','����','����');
insert into emp_Info values(3,'�³�','�ӱ�','��','��','�ӱ�','1990-1-1','��','�ɹ���',
                            '15112345678','��Ա','2009-1-1','��Ա','����','10000','��Ա','����');
insert into emp_Info values(4,'�ּ�ҫ','����','��','��','����','1990-1-1','��','�г�Ӫ��',
                            '15112345678','��Ա','2009-1-1','��Ա','����','10000','��Ա','����');
insert into emp_Info values(5,'����԰','�ӱ�','Ů','��','�ӱ�','1990-1-1','��','����',
                            '15112345678','��Ա','2009-1-1','��Ա','˶ʿ','15000','С�鳤','����');
insert into emp_Info values(6,'԰����','�ӱ�','Ů','��','�ӱ�','1990-1-1','��','����',
                            '15112345678','��Ա','2009-1-1','��Ա','˶ʿ','15000','С�鳤','����');
insert into emp_Info values(7,'����԰','�ӱ�','Ů','��','�ӱ�','1990-1-1','��','����',
                            '15112345678','��Ա','2009-1-1','��Ա','����','15000','С�鳤','����');
insert into emp_Info values(8,'����԰','�ӱ�','Ů','��','�ӱ�','1990-1-1','��','����',
                            '15112345678','��Ա','2009-1-1','��Ա','˶ʿ','15000','С�鳤','����');



create table dept_Info (dept_id int primary key,dept_name varchar(50),description varchar(200),empnums int);
insert into dept_Info values(101,'�ͻ�����','Ϊ�ͻ��������',50);
insert into dept_Info values(102,'ս�Բ���','�߻���˾��չ����Ͳ���',10);
insert into dept_Info values(103,'������Դ��','Ϊ��˾��չ�����ʺ��˲�',100);
insert into dept_Info values(104,'����','����˾����',5);
insert into dept_Info values(105,'���۲�','�����Ʒ������',150);
insert into dept_Info values(106,'������','�����Ʒ����',250);
insert into dept_Info values(107,'�ɹ���','ԭ�ϵĲɹ�',350);


create table job_Info (job_id int primary key auto_increment,id int,olddept varchar(50),
                       newdept varchar(50), transTime date,jobnotes varchar(100));

insert into job_Info values(null,1,'�ͻ�����','���۲�','2010-1-5','����');
insert into job_Info values(null,3,'������', '�ɹ���','2010-1-5','����');
insert into job_Info values(null,5,'������Դ��','����','2010-1-5','����');
insert into job_Info values(null,2,'�ͻ�����','���۲�','2010-1-5','����');
insert into job_Info values(null,4,'������', '�ɹ���','2010-1-5','����');
insert into job_Info values(null,6,'������Դ��','����','2010-1-5','����');
insert into job_Info values(null,7,'�ͻ�����','���۲�','2010-1-5','����');
insert into job_Info values(null,8,'������', '�ɹ���','2010-1-5','����');



create table rewards (rid int primary key auto_increment,id int,time date,status varchar(10),reason varchar(100));

insert into rewards values(null,2,'2010-5-4','�ͷ�', 'й¶��˾����');
insert into rewards values(null,4,'2010-6-14','����','����м�ֵ�ο����');
insert into rewards values(null,5,'2010-7-1','����', '������ǰ�������');


create table leavenote (lid int primary key,id int,
                        year int,month int,day int,
                        reason varchar(50),days int,
                        approveperson varchar(10),approvetime date,
                        status varchar(10),notes varchar(50));
insert into leavenote values(10001,3,2010,5,5,'����',3,'�ϴ�','2010-5-5','������','��һ�¹���');


create table salary (sid int primary key auto_increment,id int,salarybase varchar(20),bonus varchar(20),extrawage int, year int , month int);

insert into salary values(null,1,'10000','500',200,2010,7);
insert into salary values(null,2,'20000','2500',200,2010,7);
insert into salary values(null,3,'10000','500',200,2010,7);
insert into salary values(null,4,'10000','500',200,2010,7);
insert into salary values(null,5,'15000','1500',200,2010,7);



create table attendance (aid int primary key auto_increment,id int ,year int,month int,actual int,notes varchar(100));
insert into attendance values(null,2,2010,6,32,'������');
insert into attendance values(null,4,2010,7,25,'����');
insert into attendance values(null,5,2010,8,24,'����');
insert into attendance values(null,6,2010,7,25,'����');
insert into attendance values(null,7,2010,7,25,'����');
insert into attendance values(null,8,2010,7,25,'����');
insert into attendance values(null,1,2010,7,20,'����');
insert into attendance values(null,3,2010,7,21,'����');

create table extrawork(eid int primary key auto_increment,id int,extrawage int,day date);
insert into extrawork values(null,2,200,'2010-1-1');
insert into extrawork values(null,1,200,'2009-2-5');
insert into extrawork values(null,2,200,'2008-3-8');
insert into extrawork values(null,2,200,'2010-1-1');
insert into extrawork values(null,1,200,'2009-2-5');
insert into extrawork values(null,2,200,'2008-3-8');



