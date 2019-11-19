Insert into EGW_STATUS (ID,MODULETYPE,DESCRIPTION,LASTMODIFIEDDATE,CODE,ORDER_ID) values (NEXTVAL('SEQ_EGW_STATUS'),'MBHeader','Created',now(),'CREATED',1);
Insert into EGW_STATUS (ID,MODULETYPE,DESCRIPTION,LASTMODIFIEDDATE,CODE,ORDER_ID) values (NEXTVAL('SEQ_EGW_STATUS'),'MBHeader','Approved',now(),'APPROVED',3);
Insert into EGW_STATUS (ID,MODULETYPE,DESCRIPTION,LASTMODIFIEDDATE,CODE,ORDER_ID) values (NEXTVAL('SEQ_EGW_STATUS'),'MBHeader','Cancelled',now(),'CANCELLED',5);

--rollback delete from EGW_STATUS where MODULETYPE='MBHeader' and code='APPROVED';
--rollback delete from EGW_STATUS where MODULETYPE='MBHeader' and code='CANCELLED';
--rollback delete from EGW_STATUS where MODULETYPE='MBHeader' and code='CREATED';