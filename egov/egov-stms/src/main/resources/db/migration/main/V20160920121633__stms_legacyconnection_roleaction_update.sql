INSERT INTO EG_ACTION (ID,NAME,URL,QUERYPARAMS,PARENTMODULE,ORDERNUMBER,DISPLAYNAME,ENABLED,CONTEXTROOT,VERSION,CREATEDBY,CREATEDDATE,LASTMODIFIEDBY,LASTMODIFIEDDATE,APPLICATION) values (NEXTVAL('SEQ_EG_ACTION'),'GetSewerageLegacyDonationAmount','/ajaxconnection/getlegacy-donation-amount',null,(select id from EG_MODULE where name = 'Sewerage Tax Management'),1,'Get Legacy Sewerage Connection Donation Amount',false,'stms',0,1,now(),1,now(),(select id from eg_module  where name = 'Sewerage Tax Management'));
INSERT INTO eg_roleaction(roleid, actionid) VALUES ((select id from eg_role where name = 'Sewerage Tax Administrator'), (select id from eg_action where name = 'GetSewerageLegacyDonationAmount'and contextroot = 'stms'));
INSERT INTO eg_roleaction(roleid, actionid) VALUES ((select id from eg_role where name = 'Super User'), (select id from eg_action where name = 'GetSewerageLegacyDonationAmount'and contextroot = 'stms'));

--rollback delete from eg_roleaction where actionid in (select id from eg_action where name in ('GetSewerageLegacyDonationAmount') and contextroot = 'stms') and roleid in((select id from eg_role where name = 'Sewerage Tax Administrator'),(select id from eg_role where name = 'Super User'));
--rollback delete from eg_action where name in ('GetSewerageLegacyDonationAmount') and contextroot = 'stms';