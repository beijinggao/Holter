#FTP用户信息表  
create table HolterUser 
(  
   userid varchar(64) not null primary key,  
   userpassword varchar(64),  
   homedirectory varchar(128) not null,  
   enableflag boolean default true,  
   writepermission boolean default false,  
   idletime int default 0,  
   uploadrate int default 0,  
   downloadrate int default 0,  
   maxloginnumber int default 0,  
   maxloginperip int default 0  
);  