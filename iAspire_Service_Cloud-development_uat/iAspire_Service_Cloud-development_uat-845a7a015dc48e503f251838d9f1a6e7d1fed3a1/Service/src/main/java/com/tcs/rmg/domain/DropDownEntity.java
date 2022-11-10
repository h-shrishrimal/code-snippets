package com.tcs.rmg.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="dropdown_data", schema= "rmg_app")
public class DropDownEntity {
	
	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "dropdown_data_id_seq", sequenceName = "dropdown_data_id_seq", schema = "dropdown_data",initialValue=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dropdown_data_id_seq")
	private Integer id;
	
	@Column(name = "dropdown_column")
	private String dropdownColumn;
	
	@Column(name = "dropdown_value")
	private String dropdownValue;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDropdownColumn() {
		return dropdownColumn;
	}

	public void setDropdownColumn(String dropdownColumn) {
		this.dropdownColumn = dropdownColumn;
	}

	public String getDropdownValue() {
		return dropdownValue;
	}

	public void setDropdownValue(String dropdownValue) {
		this.dropdownValue = dropdownValue;
	}

}
