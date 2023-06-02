/*
drop table login;
drop table Sdetail;
drop table plant;
drop table PDetail;
drop table customer;
drop table suplier;
*/

create database agri;
\c agri;

create table login(uname text,pwd text);
insert into login values('admin','admin');

                                                                                                                                  
create table Sdetail(pid integer,pname text,pdesc text,fer text,tplant integer,prate float,sdate text,tamt float,sname text,scontact text);



create table PDetail(pid integer,pname text,pdesc text,fer text,tplant integer,prate float,pdate text,tamt float,sname text,scontact text);




create table plant(pid integer primary key,pname text,pdesc text,fer text,price float,qtyavail integer); 



create table suplier(sid integer primary key,sname text,scontact text,sadd text);  



create table customer(cid integer primary key,cname text,contact text);
                          
