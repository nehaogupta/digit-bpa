﻿INSERT INTO eg_wf_matrix (id, department, objecttype, currentstate, currentstatus, pendingactions, currentdesignation, additionalrule, nextstate, nextaction, nextdesignation, nextstatus, validactions, fromqty, toqty, fromdate, todate) VALUES (NEXTVAL('eg_wf_matrix_seq'), 'ANY', 'PropertyImpl', 'Demolition:NEW', NULL, NULL, 'Senior Assistant,Junior Assistant', 'DEMOLITION', 'Demolition:Assistant Approved', 'Bill Collector Approval Pending', 'Bill Collector', 'Assistant Approved', 'Create', NULL, NULL, '2015-04-01', '2099-04-01');
INSERT INTO eg_wf_matrix (id, department, objecttype, currentstate, currentstatus, pendingactions, currentdesignation, additionalrule, nextstate, nextaction, nextdesignation, nextstatus, validactions, fromqty, toqty, fromdate, todate) VALUES (NEXTVAL('eg_wf_matrix_seq'), 'ANY', 'PropertyImpl', 'Demolition:Assistant Approved', NULL, NULL, 'Bill Collector', 'DEMOLITION', 'Demolition:Bill Collector Approved', 'UD Revenue Inspector Approval Pending', 'UD Revenue Inspector', 'Bill Collector Approved', 'Forward,Reject', NULL, NULL, '2015-04-01', '2099-04-01');
INSERT INTO eg_wf_matrix (id, department, objecttype, currentstate, currentstatus, pendingactions, currentdesignation, additionalrule, nextstate, nextaction, nextdesignation, nextstatus, validactions, fromqty, toqty, fromdate, todate) VALUES (NEXTVAL('eg_wf_matrix_seq'), 'ANY', 'PropertyImpl', 'Demolition:Bill Collector Approved', NULL, NULL, 'UD Revenue Inspector', 'DEMOLITION', 'Demolition:UD Revenue Inspector Approved', 'Revenue Officer Approval Pending', 'Revenue officer', 'UD Revenue Inspector Approved', 'Forward,Reject', NULL, NULL, '2015-04-01', '2099-04-01');
INSERT INTO eg_wf_matrix (id, department, objecttype, currentstate, currentstatus, pendingactions, currentdesignation, additionalrule, nextstate, nextaction, nextdesignation, nextstatus, validactions, fromqty, toqty, fromdate, todate) VALUES (NEXTVAL('eg_wf_matrix_seq'), 'ANY', 'PropertyImpl', 'Demolition:UD Revenue Inspector Approved', NULL, NULL, 'Revenue officer', 'DEMOLITION', 'Demolition:Revenue Officer Approved', 'Commissioner Approval Pending', 'Commissioner', 'Revenue Officer Approved', 'Forward,Reject', NULL, NULL, '2015-04-01', '2099-04-01');
INSERT INTO eg_wf_matrix (id, department, objecttype, currentstate, currentstatus, pendingactions, currentdesignation, additionalrule, nextstate, nextaction, nextdesignation, nextstatus, validactions, fromqty, toqty, fromdate, todate) VALUES (NEXTVAL('eg_wf_matrix_seq'), 'ANY', 'PropertyImpl', 'Demolition:Revenue Officer Approved', NULL, NULL, 'Commissioner', 'DEMOLITION', 'Demolition:Commissioner Approved', 'Digital Signature Pending', 'Commissioner', 'Digitally Signed', 'Approve,Reject', NULL, NULL, '2015-04-01', '2099-04-01');
INSERT INTO eg_wf_matrix (id, department, objecttype, currentstate, currentstatus, pendingactions, currentdesignation, additionalrule, nextstate, nextaction, nextdesignation, nextstatus, validactions, fromqty, toqty, fromdate, todate) VALUES (NEXTVAL('eg_wf_matrix_seq'), 'ANY', 'PropertyImpl', 'Demolition:Commissioner Approved', NULL, NULL, 'Commissioner', 'DEMOLITION', 'Demolition:Digitally Signed', 'Notice Print Pending', NULL, NULL, 'Preview,Sign', NULL, NULL, '2015-04-01', '2099-04-01');
INSERT INTO eg_wf_matrix (id, department, objecttype, currentstate, currentstatus, pendingactions, currentdesignation, additionalrule, nextstate, nextaction, nextdesignation, nextstatus, validactions, fromqty, toqty, fromdate, todate) VALUES (NEXTVAL('eg_wf_matrix_seq'), 'ANY', 'PropertyImpl', 'Demolition:Digitally Signed', NULL, NULL, 'Senior Assistant,Junior Assistant', 'DEMOLITION', 'Demolition:END', 'END', NULL, NULL, 'Generate Notice', NULL, NULL, '2015-04-01', '2099-04-01');
INSERT INTO eg_wf_matrix (id, department, objecttype, currentstate, currentstatus, pendingactions, currentdesignation, additionalrule, nextstate, nextaction, nextdesignation, nextstatus, validactions, fromqty, toqty, fromdate, todate) VALUES (NEXTVAL('eg_wf_matrix_seq'), 'ANY', 'PropertyImpl', 'Demolition:Rejected', NULL, NULL, 'Senior Assistant,Junior Assistant', 'DEMOLITION', 'Demolition:Assistant Approved', 'Bill Collector Approval Pending', 'Bill Collector', NULL, 'Forward,Reject', NULL, NULL, '2015-04-01', '2099-04-01');
INSERT INTO eg_wf_matrix (id, department, objecttype, currentstate, currentstatus, pendingactions, currentdesignation, additionalrule, nextstate, nextaction, nextdesignation, nextstatus, validactions, fromqty, toqty, fromdate, todate) VALUES (NEXTVAL('eg_wf_matrix_seq'), 'ANY', 'PropertyImpl', 'Created', NULL, NULL, 'NULL', 'DEMOLITION', 'Demolition:NEW', 'Assistant approval pending', 'Senior Assistant,Junior Assistant', 'Assistant Approved', 'Forward', NULL, NULL, '2015-04-01', '2099-04-01');
