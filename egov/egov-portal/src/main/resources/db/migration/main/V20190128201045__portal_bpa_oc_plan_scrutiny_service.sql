Insert into EGP_PORTALSERVICE (id,module,code,sla,version,url,isactive,name,userservice,businessuserservice,helpdoclink,createdby,createddate,lastmodifieddate,lastmodifiedby) values(nextval('seq_egp_portalservice'),(select id from eg_module where name='Digit DCR'),'New Occupancy Certificate Plan Scrutiny',null,0,'/edcr/occupancy-certificate/plan/submit','false','New Occupancy Certificate Plan Scrutiny','true','true','/edcr/occupancy-certificate/plan/submit',1,now(),now(),1);

Insert into EGP_PORTALSERVICE (id,module,code,sla,version,url,isactive,name,userservice,businessuserservice,helpdoclink,createdby,createddate,lastmodifieddate,lastmodifiedby) values(nextval('seq_egp_portalservice'),(select id from eg_module where name='Digit DCR'),'Resubmit Occupancy Certificate Plan Scrutiny',null,0,'/edcr/occupancy-certificate/plan/resubmit','false','Resubmit Occupancy Certificate Plan Scrutiny','true','true','/edcr/occupancy-certificate/plan/resubmit',1,now(),now(),1);