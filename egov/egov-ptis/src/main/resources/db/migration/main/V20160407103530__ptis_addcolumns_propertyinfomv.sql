ALTER TABLE egpt_mv_propertyinfo RENAME aggregate_current_demand TO AGGREGATE_CURRENT_FIRSTHALF_DEMAND;
ALTER TABLE egpt_mv_propertyinfo RENAME current_collection TO CURRENT_FIRSTHALF_COLLECTION;
ALTER TABLE egpt_mv_propertyinfo RENAME pen_aggr_current_demand TO pen_aggr_current_firsthalf_demand;
ALTER TABLE egpt_mv_propertyinfo RENAME pen_aggr_current_coll TO pen_aggr_current_firsthalf_coll;

ALTER TABLE egpt_mv_propertyinfo ADD COLUMN AGGREGATE_CURRENT_SECONDHALF_DEMAND double precision;
ALTER TABLE egpt_mv_propertyinfo ADD COLUMN CURRENT_SECONDHALF_COLLECTION double precision;
ALTER TABLE egpt_mv_propertyinfo ADD COLUMN pen_aggr_current_secondhalf_demand double precision;  
ALTER TABLE egpt_mv_propertyinfo ADD COLUMN pen_aggr_current_secondhalf_coll double precision; 