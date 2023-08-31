package com.capstone.dad.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "excel_data")
public class LoanAccount3 {

	@Id
    private String id;
    private String sol_id;
    private String processing_status;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSol_id() {
		return sol_id;
	}
	public void setSol_id(String sol_id) {
		this.sol_id = sol_id;
	}
	public String getProcessing_status() {
		return processing_status;
	}
	public void setProcessing_status(String processing_status) {
		this.processing_status = processing_status;
	}
	public LoanAccount3(String id, String sol_id, String processing_status) {
		super();
		this.id = id;
		this.sol_id = sol_id;
		this.processing_status = processing_status;
	}
	public LoanAccount3(String id, String sol_id) {
		super();
		this.id = id;
		this.sol_id = sol_id;
	}
	public LoanAccount3(String id) {
		super();
		this.id = id;
	}
	public LoanAccount3() {
		super();
	}
	@Override
	public String toString() {
		return "LoanAccount3 [id=" + id + ", sol_id=" + sol_id + ", processing_status=" + processing_status + "]";
	}
  
}
