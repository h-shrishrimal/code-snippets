
CREATE SCHEMA rmg_app
  AUTHORIZATION postgres;

-- Table: rmg_app.applied_requirement

-- DROP TABLE rmg_app.applied_requirement;

CREATE TABLE rmg_app.applied_requirement
(
  application_id serial NOT NULL,
  request_id integer,
  requirement_id integer,
  requestor_employeeid integer,
  applicant_employeeid integer,
  rmg_employeeid character varying(100) DEFAULT NULL::character varying,
  rmg_status character varying(10) DEFAULT NULL::character varying,
  rmg_comments character varying(200) DEFAULT NULL::character varying,
  gl_employeeid integer,
  gl_comments character varying(200) DEFAULT NULL::character varying,
  applicant_comments character varying(500) DEFAULT NULL::character varying,
  release_date character varying(50) DEFAULT NULL::character varying,
  description character varying(3000) DEFAULT NULL::character varying,
  applicant_experience character varying(25) DEFAULT NULL::character varying,
  applicant_contactnumber character varying(50) DEFAULT NULL::character varying,
  requestor_status character varying(20),
  requestor_comments character varying(200),
  created_by integer,
  created_date_timestamp character varying(50),
  updated_by integer,
  updated_date_timestamp character varying(50),
  updaed_date_1 date,
  CONSTRAINT applied_requirement_pkey PRIMARY KEY (application_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE rmg_app.applied_requirement
  OWNER TO postgres;

-----------------------------------------------
-- Table: rmg_app.emp_t_factor_details

-- DROP TABLE rmg_app.emp_t_factor_details;

CREATE TABLE rmg_app.emp_t_factor_details
(
  employee_number integer,
  employee_name character varying(100) DEFAULT NULL::character varying,
  t_factor numeric(5,2) DEFAULT NULL::numeric
)
WITH (
  OIDS=FALSE
);
ALTER TABLE rmg_app.emp_t_factor_details
  OWNER TO postgres;


------------------------------------------  

-- Table: rmg_app.employee_master_rmg_proc

-- DROP TABLE rmg_app.employee_master_rmg_proc;

CREATE TABLE rmg_app.employee_master_rmg_proc
(
  employee_number integer NOT NULL DEFAULT 0,
  employee_name character varying(100) DEFAULT NULL::character varying,
  portal_group character varying(10) DEFAULT NULL::character varying,
  team_role character varying(100) DEFAULT NULL::character varying,
  business character varying(100) DEFAULT NULL::character varying,
  customer character varying(100) DEFAULT NULL::character varying,
  account_head character varying(100) NOT NULL,
  allocation_end_date date,
  allocation_start_date date,
  won_or_swon character varying(100) DEFAULT NULL::character varying,
  am_employee_number integer,
  am character varying(100) DEFAULT NULL::character varying,
  brm_employee_number integer,
  brm character varying(100) DEFAULT NULL::character varying,
  rm_employee_number integer,
  rm character varying(100) DEFAULT NULL::character varying,
  gl_emp_no integer,
  gl character varying(100) DEFAULT NULL::character varying,
  supervisor_employee_number integer,
  supervisor_name character varying(100) DEFAULT NULL::character varying,
  deputy_owner character varying(100) DEFAULT NULL::character varying,
  project_owner character varying(100) DEFAULT NULL::character varying,
  updated_date date,
  CONSTRAINT employee_master_rmg_proc_pri_key PRIMARY KEY (employee_number)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE rmg_app.employee_master_rmg_proc
  OWNER TO postgres;

---------------------------------------------------------

-- Table: rmg_app.recommendations_requirement

-- DROP TABLE rmg_app.recommendations_requirement;

CREATE TABLE rmg_app.recommendations_requirement
(
  request_id integer,
  requirement_id integer NOT NULL,
  requestor_employee_id integer,
  requestor_employee_name character varying(1000) DEFAULT NULL::character varying,
  required_competency character varying(1000) DEFAULT NULL::character varying,
  applicant_experience character varying(25) DEFAULT NULL::character varying,
  employee_name character varying(1000) DEFAULT NULL::character varying,
  employee_number integer NOT NULL,
  employee_competency character varying(1000) DEFAULT NULL::character varying,
  ievolve_match numeric(5,2) DEFAULT NULL::numeric,
  overall_t_factor numeric(5,2) DEFAULT NULL::numeric,
  employee_experience character varying(25) DEFAULT NULL::character varying,
  CONSTRAINT recommendations_requirement_pkey PRIMARY KEY (requirement_id, employee_number)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE rmg_app.recommendations_requirement
  OWNER TO postgres;

---------------------------------------------

-- Table: rmg_app.requirement_details

-- DROP TABLE rmg_app.requirement_details;

CREATE TABLE rmg_app.requirement_details
(
  rmg_offshore_branch character varying(600) DEFAULT NULL::character varying,
  requirement_pending_with character varying(30) DEFAULT NULL::character varying,
  account_head character varying(600) DEFAULT NULL::character varying,
  requestor_employee_id numeric(10,0) DEFAULT NULL::numeric,
  requestor_employee_name character varying(600) DEFAULT NULL::character varying,
  requirement_start_date character varying(25) DEFAULT NULL::character varying,
  request_id integer DEFAULT NULL::numeric,
  requirement_id numeric(10,0) DEFAULT NULL::numeric,
  cluster character varying(10) DEFAULT NULL::character varying,
  requirement_status character varying(10) DEFAULT NULL::character varying,
  requirement_type character varying(30) DEFAULT NULL::character varying,
  group_customer_name character varying(600) DEFAULT NULL::character varying,
  customer_name character varying(300) DEFAULT NULL::character varying,
  business character varying(80) DEFAULT NULL::character varying,
  skill character varying(80) DEFAULT NULL::character varying,
  category character varying(80) DEFAULT NULL::character varying,
  competency_proficiency_details character varying(1800) DEFAULT NULL::character varying,
  start_date_overdue character varying(25) DEFAULT NULL::character varying,
  overdue_bucket character varying(80) DEFAULT NULL::character varying,
  onsite_offshore character varying(80) DEFAULT NULL::character varying,
  confirmed_date character varying(25) DEFAULT NULL::character varying,
  confirmed_employee_number numeric(100,0) DEFAULT NULL::numeric,
  confirmed_employee_name character varying(80) DEFAULT NULL::character varying,
  requirement_end_date character varying(25) DEFAULT NULL::character varying,
  won_swon character varying(10) DEFAULT NULL::character varying,
  project_number numeric(10,0) DEFAULT NULL::numeric,
  project_type character varying(60) DEFAULT NULL::character varying,
  requirement_bg character varying(60) DEFAULT NULL::character varying,
  requirement_parent_iou character varying(60) DEFAULT NULL::character varying,
  requirement_child_iou character varying(60) DEFAULT NULL::character varying,
  horizontal_parent_iou character varying(60) DEFAULT NULL::character varying,
  horizontal_child_iou character varying(60) DEFAULT NULL::character varying,
  client_geography character varying(60) DEFAULT NULL::character varying,
  requirement_geography character varying(60) DEFAULT NULL::character varying,
  requirement_country character varying(60) DEFAULT NULL::character varying,
  requirement_branch character varying(300) DEFAULT NULL::character varying,
  requirement_city character varying(300) DEFAULT NULL::character varying,
  currency character varying(10) DEFAULT NULL::character varying,
  realization numeric(10,0) DEFAULT NULL::numeric,
  staffing_reason character varying(60) DEFAULT NULL::character varying,
  preffered_source_staffing character varying(60) DEFAULT NULL::character varying,
  replacement_employee_number numeric(10,0) DEFAULT NULL::numeric,
  associate_requirement_country character varying(60) DEFAULT NULL::character varying,
  total_experience character varying(30) DEFAULT NULL::character varying,
  role character varying(30) DEFAULT NULL::character varying,
  competency_type character varying(300) DEFAULT NULL::character varying,
  categorization character varying(300) DEFAULT NULL::character varying,
  sub_categorization character varying(600) DEFAULT NULL::character varying,
  sub_sub_categorization character varying(600) DEFAULT NULL::character varying,
  evaluator_emp_id character varying(600) DEFAULT NULL::character varying,
  evaluator_emp_name character varying(600) DEFAULT NULL::character varying,
  request_created_on character varying(25) DEFAULT NULL::character varying,
  last_action_date character varying(25) DEFAULT NULL::character varying,
  grs_rmg_id numeric(10,0) DEFAULT NULL::numeric,
  grs_rmg_name character varying(600) DEFAULT NULL::character varying,
  grs_status character varying(600) DEFAULT NULL::character varying,
  grs_proposed_candidate_name character varying(315) DEFAULT NULL::character varying,
  grs_confirmed_employee_number numeric(10,0) DEFAULT NULL::numeric,
  grs_confirmed_employee_name character varying(600) DEFAULT NULL::character varying,
  ba_company_name character varying(600) DEFAULT NULL::character varying,
  gbams_rmg_id numeric(10,0) DEFAULT NULL::numeric,
  gbams_rm_name character varying(600) DEFAULT NULL::character varying,
  gbams_status character varying(30) DEFAULT NULL::character varying,
  gbams_proposed_name character varying(600) DEFAULT NULL::character varying,
  gbams_confirmed_employee_number numeric(10,0) DEFAULT NULL::numeric,
  gbams_confirmed_employee_name character varying(600) DEFAULT NULL::character varying,
  associates_proposed numeric(10,0) DEFAULT NULL::numeric
)
WITH (
  OIDS=FALSE
);
ALTER TABLE rmg_app.requirement_details
  OWNER TO postgres;

  
---------------------------------------------------

-- Table: rmg_app.requirement_rmg_details

-- DROP TABLE rmg_app.requirement_rmg_details;

CREATE TABLE rmg_app.requirement_rmg_details
(
  ge_business character varying(80) DEFAULT NULL::character varying,
  rmg_emp_no integer,
  requirement_location character varying(60) DEFAULT NULL::character varying,
  gl_employeeid integer
)
WITH (
  OIDS=FALSE
);
ALTER TABLE rmg_app.requirement_rmg_details
  OWNER TO postgres;

---------------------------------------------------------

-- Table: rmg_app.rmg_approver

-- DROP TABLE rmg_app.rmg_approver;

CREATE TABLE rmg_app.rmg_approver
(
  rmg_id integer NOT NULL,
  CONSTRAINT rmg_approver_pkey PRIMARY KEY (rmg_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE rmg_app.rmg_approver
  OWNER TO postgres;

---------------------------------------

-- Table: rmg_app.userid_requirementid_mapping

-- DROP TABLE rmg_app.userid_requirementid_mapping;

CREATE TABLE rmg_app.userid_requirementid_mapping
(
  id serial NOT NULL,
  user_id integer,
  requirement_id integer,
  CONSTRAINT userid_requirementid_mapping_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE rmg_app.userid_requirementid_mapping
  OWNER TO postgres;

CREATE TABLE rmg_app.user_audit_details
(
  audit_id serial NOT NULL,
  user_id integer NOT NULL,
  user_action character varying(200),
  audit_timestamp  timestamp without time zone not null default now()
)  
-------------------------------------------------- 
--Execute below scripts in dev

ALTER TABLE rmg_app.requirement_details ALTER COLUMN business SET NOT NULL;
ALTER TABLE rmg_app.requirement_details ALTER COLUMN skill SET NOT NULL;
ALTER TABLE rmg_app.requirement_details ALTER COLUMN competency_proficiency_details SET NOT NULL;
ALTER TABLE rmg_app.requirement_details ALTER COLUMN requirement_city SET NOT NULL;
ALTER TABLE rmg_app.requirement_details ALTER COLUMN requirement_branch SET NOT NULL;
ALTER TABLE rmg_app.requirement_details ALTER COLUMN requirement_country SET NOT NULL;

------------------------------

--Local Log path -- file: C:/Users/854063/git/iAspire-Service/Service/logs/rmg_app.log

--Execute below scripts in dev

alter table rmg_app.applied_requirement ADD column valid_visa character varying(10);
alter table rmg_app.applied_requirement ADD column visa_type character varying(100);
alter table rmg_app.applied_requirement ADD column visa_issue_date character varying(100);
alter table rmg_app.applied_requirement ADD column visa_expiry_date character varying(100);

-----------------
--for refernce to get sequence details
select currval('hibernate_sequence'); 
select max(audit_id) from rmg_app.user_audit_details;
SELECT setval('rmg_app.user_audit_details_audit_id_seq', 5596, true);   

select nextval('rmg_app.userid_requirementid_mapping_id_seq'); 
select max(id) from rmg_app.userid_requirementid_mapping;
SELECT setval('rmg_app.applied_requirement_application_id_seq', 973, true);   


SELECT last_value FROM rmg_app.applied_requirement_application_id_seq;

SELECT last_value FROM rmg_app.hibernate_sequence;

select max(application_id) from rmg_app.applied_requirement;

SELECT setval('rmg_app.applied_requirement_application_id_seq', 936, true);   

CREATE SEQUENCE hibernate_sequence
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
  

rmg_app.userid_requirementid_mapping_id_seq;
select max(audit_id) from rmg_app.user_audit_details;
SELECT * from rmg_app.sequences;

-----------------------------------

--Newly added table to get rejection reasons
-- Table: rmg_app.dropdown_data

-- DROP TABLE rmg_app.dropdown_data;

CREATE TABLE rmg_app.dropdown_data
(
  id serial NOT NULL,
  dropdown_column character varying(100),
  dropdown_value character varying(400)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE rmg_app.dropdown_data
  OWNER TO postgres;
  
alter table rmg_app.applied_requirement ADD column rejection_reason_rq character varying(400);
alter table rmg_app.applied_requirement ADD column rejection_reason_rmg character varying(400);

alter table rmg_app.user_audit_details ADD column dashboard_flag character varying(400);  
  
INSERT INTO rmg_app.dropdown_data(id, dropdown_column, dropdown_value) VALUES (NEXTVAL('rmg_app.dropdown_data_id_seq'),'Reason_for_Rejection_RQ', 'Technically not suitable');
INSERT INTO rmg_app.dropdown_data(id, dropdown_column, dropdown_value) VALUES (NEXTVAL('rmg_app.dropdown_data_id_seq'),'Reason_for_Rejection_RQ', 'Associate do not have Valid work authorization');
INSERT INTO rmg_app.dropdown_data(id, dropdown_column, dropdown_value) VALUES (NEXTVAL('rmg_app.dropdown_data_id_seq'),'Reason_for_Rejection_RQ', 'Associate has location constraint');
INSERT INTO rmg_app.dropdown_data(id, dropdown_column, dropdown_value) VALUES (NEXTVAL('rmg_app.dropdown_data_id_seq'),'Reason_for_Rejection_RQ', 'Associate aspiration mismacth');
INSERT INTO rmg_app.dropdown_data(id, dropdown_column, dropdown_value) VALUES (NEXTVAL('rmg_app.dropdown_data_id_seq'),'Reason_for_Rejection_RQ', 'Release cancelled');
INSERT INTO rmg_app.dropdown_data(id, dropdown_column, dropdown_value) VALUES (NEXTVAL('rmg_app.dropdown_data_id_seq'),'Reason_for_Rejection_RQ', 'Requirement fulfilled by another associate');
INSERT INTO rmg_app.dropdown_data(id, dropdown_column, dropdown_value) VALUES (NEXTVAL('rmg_app.dropdown_data_id_seq'),'Reason_for_Rejection_RQ', 'Associate confirmed against another requirement');
INSERT INTO rmg_app.dropdown_data(id, dropdown_column, dropdown_value) VALUES (NEXTVAL('rmg_app.dropdown_data_id_seq'),'Reason_for_Rejection_RQ', 'Already identified another associate');
INSERT INTO rmg_app.dropdown_data(id, dropdown_column, dropdown_value) VALUES (NEXTVAL('rmg_app.dropdown_data_id_seq'),'Reason_for_Rejection_RQ', 'Duplicate RGS ID closed');
INSERT INTO rmg_app.dropdown_data(id, dropdown_column, dropdown_value) VALUES (NEXTVAL('rmg_app.dropdown_data_id_seq'),'Reason_for_Rejection_RQ', 'Position closed by Customer');
INSERT INTO rmg_app.dropdown_data(id, dropdown_column, dropdown_value) VALUES (NEXTVAL('rmg_app.dropdown_data_id_seq'),'Reason_for_Rejection_RQ', 'No response from associate');
INSERT INTO rmg_app.dropdown_data(id, dropdown_column, dropdown_value) VALUES (NEXTVAL('rmg_app.dropdown_data_id_seq'),'Reason_for_Rejection_RQ', 'RGS created for allocation');
INSERT INTO rmg_app.dropdown_data(id, dropdown_column, dropdown_value) VALUES (NEXTVAL('rmg_app.dropdown_data_id_seq'),'Reason_for_Rejection_RQ', 'Associate has work timing issues');  

INSERT INTO rmg_app.dropdown_data(id, dropdown_column, dropdown_value) VALUES (NEXTVAL('rmg_app.dropdown_data_id_seq'),'Reason_for_Rejection_RM', 'Associate is not selected in Customer Interview');
INSERT INTO rmg_app.dropdown_data(id, dropdown_column, dropdown_value) VALUES (NEXTVAL('rmg_app.dropdown_data_id_seq'),'Reason_for_Rejection_RM', 'Associate is not willing to join');
INSERT INTO rmg_app.dropdown_data(id, dropdown_column, dropdown_value) VALUES (NEXTVAL('rmg_app.dropdown_data_id_seq'),'Reason_for_Rejection_RM', 'Associate is confirmed for another Project');
INSERT INTO rmg_app.dropdown_data(id, dropdown_column, dropdown_value) VALUES (NEXTVAL('rmg_app.dropdown_data_id_seq'),'Reason_for_Rejection_RM', 'Medical or HR issue');


CREATE TABLE rmg_app.auto_apply_requirement
(
  auto_apply_requirement_id integer NOT NULL,
  requirement_id integer,
  applicant_employeeid integer,
  isapplied character varying(100) DEFAULT 'N'::character varying
);


Select * from global_login.role_details;
select * from global_login.user_master where emp_no='888888';
select * from rmg_app.rmg_approver;
INSERT INTO global_login.role_details(role_id, role_name, app_id, status, created_date, created_user_id, updated_date, updated_user_id, level_id,reject_level_id)
VALUES (NEXTVAL('global_login.role_details_role_id_seq'), 'RM', 2, 'ACTIVE',now(),'854063', now(), '854063', 0,0);

select max(auth_id) from global_login.user_authorization_details;
Select * from global_login.user_authorization_details;

--take role_id from role details table in below script
INSERT INTO global_login.user_authorization_details(auth_id, emp_no, emp_name, segment, account, role_id, role_name, app_name, 
created_date,created_user_id, updated_date, updated_user_id, app_id, application_owner, super_user, level_id)
VALUES (NEXTVAL('global_login.user_authorization_details_auth_id_seq'),'255324', 'RAVIRAJ HARIBHAU JAIN', 'IS-BFSI-US East 1.0', 'N/A', 39,'RM','iAspire', 
now(),'854063', now(), '854063',2,'N','N',0);

Update global_login.user_authorization_details set emp_no='141166', emp_name='Bhranti Desai' where auth_id=2105;
-------------------------------------------------

select * from global_login.user_authorization_details where role_name ='RM' and app_id 2;

Create table applied_requirement_29thMay20 as select * from rmg_app.applied_requirement;

--truncate table rmg_app.applied_requirement;

----------------------------------------------------

CREATE TRIGGER CLOSE_RequirmentID
  AFTER UPDATE
  ON rmg_app.applied_requirement
  FOR EACH ROW
  EXECUTE PROCEDURE changeRequirmentStatus();
  
--------------------------------------------------------
 
  CREATE OR REPLACE FUNCTION changeRequirmentStatus()
  RETURNS trigger AS
$BODY$
BEGIN
	IF NEW.rmg_status <> OLD.rmg_status AND NEW.rmg_status='Approved' THEN
		 Update rmg_app.requirement_details set requirement_status ='CLOSED' where requirement_id =new.requirement_id;
	END IF;

	RETURN NEW;
END;
$BODY$
LANGUAGE plpgsql VOLATILE -- Says the function is implemented in the plpgsql language; VOLATILE says the function has side effects.
COST 100;
--------------------
\copy (select * from rmg_app.applied_requirement s where requestor_status ='Pending' AND exists(select 1 from  rmg_app.applied_requirement a where a.rmg_Status='Approved' AND a.requirement_id = s.requirement_id
union all select 1 from  rmg_app.requirement_details a, rmg_app.applied_requirement b where a.requirement_status ='CLOSED' and a.requirement_id= b.requirement_id AND a.requirement_id = s.requirement_id))
TO  '/home/drilladmin/applied_requirement_10thJun20_EmailTrigger.csv' delimiter ',' csv HEADER;

-----------------------
select count(*) from rmg_app.applied_requirement where requestor_status ='Rejected' and requestor_comments='Requirement is closed hence Auto Rejected';

select * from rmg_app.applied_requirement s where requestor_status ='Pending'
AND exists(select 1 from  rmg_app.applied_requirement a where a.rmg_Status='Approved' AND a.requirement_id = s.requirement_id
union all
select 1 from  rmg_app.requirement_details a, rmg_app.applied_requirement b where a.requirement_status ='CLOSED' and a.requirement_id= b.requirement_id
AND a.requirement_id = s.requirement_id);

------------------------
ALTER TABLE rmg_app.applied_requirement ALTER COLUMN applicant_comments TYPE varchar(1000);


select * from rmg_app.requirement_details where requirement_id ='6873773';

Update rmg_app.requirement_details set  requestor_employee_id ='1443913',requestor_employee_name ='Shreya S' where requirement_id ='6873773';

create table rmg_app.applied_requirement_bkp_16thMar20 AS select * FROM rmg_app.applied_requirement;

alter table rmg_app.applied_requirement drop constraint applied_requirement_pkey;
alter table rmg_app.applied_requirement add constraint applied_requirement_pkey primary key (requirement_id, applicant_employeeid); 

alter table rmg_app.applied_requirement add constraint applied_requirement_pkey primary key(application_id)

select count(*) from rmg_app.emp_t_factor_details;

select count(*) from rmg_app.emp_t_factor_details where t_factor >= 1;
(select count(CAST(employee_number as varchar)) from rmg_app.emp_t_factor_details where t_factor >= 1);

update global_login.user_master set tfactor_flag ='Y' where emp_no in((select CAST(employee_number as varchar) from rmg_app.emp_t_factor_details where t_factor >= 1));

select count(*) from global_login.user_master a
where tfactor_flag ='N' and a.emp_no in (select CAST(employee_number as varchar) from rmg_app.emp_t_factor_details where t_factor >= 1);

update global_login.user_master set tfactor_flag ='N' where emp_no in((select CAST(employee_number as varchar) from rmg_app.emp_t_factor_details where t_factor < 1));

alter table rmg_app.applied_requirement ADD column new_requirment_flag character varying(100);