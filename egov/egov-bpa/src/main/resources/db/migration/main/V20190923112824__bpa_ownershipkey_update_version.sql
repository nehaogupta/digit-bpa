update eg_appconfig_values  set version=0 where config = (select id from eg_appconfig  where keyname ='AUTOGENERATE_OWNERSHIP_NUMBER');