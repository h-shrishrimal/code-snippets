package com.tcs.iaspire.entities

import com.vladmihalcea.hibernate.type.json.JsonBinaryType
import org.hibernate.annotations.TypeDef

import javax.persistence.*

@Entity
@Table(name = "tcs_mlt_user")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class UserInformation {

   employee_number
   employee_grade
   local_expat
   assignment_status
   employee_depute_branch
   region
   geography
   group_customer
   project_iou
   project_type
   department
   employee_parent_iou
   mapped_parent_ou_excluding_bps
   mapped_sub_iou_parent_ou_excluding_bps
   mapped_project_ou
   mapped_sub_project_ou
   tcs_exp
   total_rel_exp
   won_swon
   delivery_unit
   bg
   role
   mlt_pool_category
   status
   completion_certification_id
   completion_certification_name
   completion_date
   source

}
