package com.capstone.dad.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "excel_data")
public class LoanAccount5 {
	
	@Id
    private String id;
    private String cbo_srm_id;
    private String processing_status;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCbo_srm_id() {
		return cbo_srm_id;
	}
	public void setCbo_srm_id(String cbo_srm_id) {
		this.cbo_srm_id = cbo_srm_id;
	}
	public String getProcessing_status() {
		return processing_status;
	}
	public void setProcessing_status(String processing_status) {
		this.processing_status = processing_status;
	}
	public LoanAccount5(String id, String cbo_srm_id, String processing_status) {
		super();
		this.id = id;
		this.cbo_srm_id = cbo_srm_id;
		this.processing_status = processing_status;
	}
	public LoanAccount5(String id, String cbo_srm_id) {
		super();
		this.id = id;
		this.cbo_srm_id = cbo_srm_id;
	}
	public LoanAccount5(String id) {
		super();
		this.id = id;
	}
	public LoanAccount5() {
		super();
	}
	@Override
	public String toString() {
		return "FailureReason4Count [id=" + id + ", cbo_srm_id=" + cbo_srm_id + ", processing_status="
				+ processing_status + "]";
	}	
	
}
