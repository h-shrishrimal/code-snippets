drop table rmg_app.auto_apply_requirement;
CREATE TABLE rmg_app.auto_apply_requirement
(
  auto_apply_requirement_id integer NOT NULL,
  request_id integer,
  requirement_id integer,
  requestor_employee_id integer,
  applicant_employeeid integer,
  isapplied character varying(100) DEFAULT 'N'::character varying,
  reason_for_failure character varying(700),
  cretaeduserid character varying(20),
  createdtimestamp timestamp without time zone,
  updateduserid character varying(20),
  updatedtimestamp timestamp without time zone
);

update rmg_app.auto_apply_requirement set createdtimestamp=now();  


select substring(created_date_timestamp from 9 for 2) || '-' || substring(created_date_timestamp from 5 for 3) || '-' || substring(created_date_timestamp from 25 for 4) from  rmg_app.applied_requirement
where applicant_employeeid ='854063';