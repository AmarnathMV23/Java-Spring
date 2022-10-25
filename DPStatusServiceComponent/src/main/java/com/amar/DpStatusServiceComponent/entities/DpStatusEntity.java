package com.amar.DpStatusServiceComponent.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DpStatusEntity {
	
	@Id
	@Column(name = "dp_id")
	private Integer dpid;
	
	
	@Column(name ="dp_status")
	private boolean dpstatus;



	public Integer getDpid() {
		return dpid;
	}


	public void setDpid(Integer dpid) {
		this.dpid = dpid;
	}

	public void setDpstatus(boolean dpstatus) {
		this.dpstatus = dpstatus;
	}
	

	public boolean getDpstatus() {
		return dpstatus;
	}
	public DpStatusEntity(Integer dpid, boolean dpstatus) {
		
		this.dpid = dpid;
		this.dpstatus = dpstatus;
	}
	
	public DpStatusEntity() {

		
	}




	}
