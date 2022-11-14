package com.tcs.rmg.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emp_isu_flag", schema = "rmg_iaspire")
public class EmpIsuFlag {

  @Id @Column(name ="employee_id") private Integer employeeId;

  @Column(name ="is_mlt_flag") private String flag;

  public String getFlag() {
    return flag;
  }

  public void setFlag(String flag) {
    this.flag = flag;
  }

  public Integer getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(Integer employeeId) {
    this.employeeId = employeeId;
  }
}
