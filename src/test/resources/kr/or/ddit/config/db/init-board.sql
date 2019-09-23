select * from not_exists_in_prd;

truncate table my_board;

Insert into MY_BOARD (BOARDID,BOARDNM,USERID,REG_DATE,ABLE) values (1,'자유게시판','bshn123',to_date('2019/08/28','YYYY/MM/DD'),'T');
Insert into MY_BOARD (BOARDID,BOARDNM,USERID,REG_DATE,ABLE) values (2,'QnA게시판','bshn123',to_date('2019/08/28','YYYY/MM/DD'),'T');
Insert into MY_BOARD (BOARDID,BOARDNM,USERID,REG_DATE,ABLE) values (3,'test3','bshn123',to_date('2019/08/28','YYYY/MM/DD'),'F');
Insert into MY_BOARD (BOARDID,BOARDNM,USERID,REG_DATE,ABLE) values (4,'test34','bshn123',to_date('2019/08/28','YYYY/MM/DD'),'F');
Insert into MY_BOARD (BOARDID,BOARDNM,USERID,REG_DATE,ABLE) values (5,'asdfasdf','bshn123',to_date('2019/08/29','YYYY/MM/DD'),'F');
Insert into MY_BOARD (BOARDID,BOARDNM,USERID,REG_DATE,ABLE) values (6,'aaaaa','bshn123',to_date('2019/08/29','YYYY/MM/DD'),'F');
Insert into MY_BOARD (BOARDID,BOARDNM,USERID,REG_DATE,ABLE) values (7,'12312312312','bshn123',to_date('2019/08/29','YYYY/MM/DD'),'F');
Insert into MY_BOARD (BOARDID,BOARDNM,USERID,REG_DATE,ABLE) values (11,'다오테스트','bshn123',to_date('2019/09/02','YYYY/MM/DD'),'F');
Insert into MY_BOARD (BOARDID,BOARDNM,USERID,REG_DATE,ABLE) values (9,'새로만듬','bshn123',to_date('2019/08/30','YYYY/MM/DD'),'F');
Insert into MY_BOARD (BOARDID,BOARDNM,USERID,REG_DATE,ABLE) values (10,'sadfasdf','bshn123',to_date('2019/08/30','YYYY/MM/DD'),'F');
Insert into MY_BOARD (BOARDID,BOARDNM,USERID,REG_DATE,ABLE) values (12,'테스테스트','bshn123',to_date('2019/09/02','YYYY/MM/DD'),'F');
Insert into MY_BOARD (BOARDID,BOARDNM,USERID,REG_DATE,ABLE) values (13,'서비스테스트','bshn123',to_date('2019/09/02','YYYY/MM/DD'),'F');
Insert into MY_BOARD (BOARDID,BOARDNM,USERID,REG_DATE,ABLE) values (14,'asdfasdfasdf','bshn123',to_date('2019/09/02','YYYY/MM/DD'),'F');
Insert into MY_BOARD (BOARDID,BOARDNM,USERID,REG_DATE,ABLE) values (15,'다오테스트','bshn123',to_date('2019/09/02','YYYY/MM/DD'),'F');
Insert into MY_BOARD (BOARDID,BOARDNM,USERID,REG_DATE,ABLE) values (16,'스프링테스트','james',to_date('2019/09/20','YYYY/MM/DD'),'F');
Insert into MY_BOARD (BOARDID,BOARDNM,USERID,REG_DATE,ABLE) values (17,'스프링 끝','bshn123',to_date('2019/09/20','YYYY/MM/DD'),'T');

commit;