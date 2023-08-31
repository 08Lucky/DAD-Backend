package com.capstone.dad.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "excel_data")
public class LoanAccount6 {

	@Id
    private String id;
    private String cbo_srm_id;
    private String principal_payment_due_date;
    private Double normal_interest;
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
	public String getPrincipal_payment_due_date() {
		return principal_payment_due_date;
	}
	public void setPrincipal_payment_due_date(String principal_payment_due_date) {
		this.principal_payment_due_date = principal_payment_due_date;
	}
	public Double getNormal_interest() {
		return normal_interest;
	}
	public void setNormal_interest(Double normal_interest) {
		this.normal_interest = normal_interest;
	}
	public LoanAccount6(String id, String cbo_srm_id, String principal_payment_due_date, Double normal_interest) {
		super();
		this.id = id;
		this.cbo_srm_id = cbo_srm_id;
		this.principal_payment_due_date = principal_payment_due_date;
		this.normal_interest = normal_interest;
	}
	public LoanAccount6(String cbo_srm_id, String principal_payment_due_date, Double normal_interest) {
		super();
		this.cbo_srm_id = cbo_srm_id;
		this.principal_payment_due_date = principal_payment_due_date;
		this.normal_interest = normal_interest;
	}
	public LoanAccount6() {
		super();
	}
	@Override
	public String toString() {
		return "LoanAccount6 [id=" + id + ", cbo_srm_id=" + cbo_srm_id + ", principal_payment_due_date="
				+ principal_payment_due_date + ", normal_interest=" + normal_interest + "]";
	}
    
    
}
