UPDATE eg_wf_matrix set nextaction ='HOD approval pending' where objecttype ='CouncilPreamble' and currentstate='Rejected';
UPDATE eg_wf_matrix set nextdesignation ='' where objecttype ='CouncilPreamble' and currentstate='Rejected';