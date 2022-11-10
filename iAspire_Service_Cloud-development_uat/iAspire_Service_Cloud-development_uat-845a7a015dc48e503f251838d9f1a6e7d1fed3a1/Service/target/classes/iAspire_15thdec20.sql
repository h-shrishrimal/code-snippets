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
-----------------------------------
create table rmg_app.applied_requirement_bkp_15thDec20 AS select * FROM rmg_app.applied_requirement;

alter table rmg_app.applied_requirement drop constraint applied_requirement_pkey;
alter table rmg_app.applied_requirement add constraint applied_requirement_pkey primary key (requirement_id, applicant_employeeid); 

--alter table rmg_app.applied_requirement add constraint applied_requirement_pkey primary key(application_id)

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
----------------------------------------------------------

update global_login.user_master set tfactor_flag ='Y'; --execute this for now for 6 users test data

-----------------------------------------------------------

CREATE TRIGGER update_tfactor
  AFTER INSERT OR UPDATE
  ON rmg_app.emp_t_factor_details
  FOR EACH ROW
  EXECUTE PROCEDURE rmg_app.updatetfactorflag();
  
--------------------------------------------------------
 
  CREATE OR REPLACE FUNCTION rmg_app.UpdateTfactorFlag()
  RETURNS trigger AS
$BODY$
BEGIN
	IF NEW.t_factor >= 1 THEN
		update global_login.user_master set tfactor_flag ='Y' where emp_no in( CAST(NEW.employee_number AS character varying));
	ELSE
		update global_login.user_master set tfactor_flag ='N' where emp_no in( CAST(NEW.employee_number AS character varying));
	END IF;

	RETURN NEW;
END;
$BODY$
LANGUAGE plpgsql VOLATILE -- Says the function is implemented in the plpgsql language; VOLATILE says the function has side effects.
COST 100;