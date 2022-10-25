package com.amar.DPServiceComponent.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name= "delivery_partner_details")
public class DpEntity {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name = "dp_id")
	private Integer dpId;
	
	@Column(name = "dp_name")
	private String dpName;
	

	public String getDpName() {
		return dpName;
	}
	public void setDpName(String dpName) {
		this.dpName = dpName;
	}
	
	public DpEntity(String dpName) {
		this.dpName = dpName;
	}
	
	public DpEntity() {
	
	}
	public Integer getDpId() {
		return dpId;
	}
	
	

}
