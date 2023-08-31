package com.capstone.dad.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "CapProject")
public class LoanAccount {
    @Id
    private String id;
    private String cbo_srm_id;
    private double normal_interest;
    private double penal_interest;
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
	public double getNormal_interest() {
		return normal_interest;
	}
	public void setNormal_interest(double normal_interest) {
		this.normal_interest = normal_interest;
	}
	public double getPenal_interest() {
		return penal_interest;
	}
	public void setPenal_interest(double penal_interest) {
		this.penal_interest = penal_interest;
	}
	public LoanAccount(String id, String cbo_srm_id, double normal_interest, double penal_interest) {
		super();
		this.id = id;
		this.cbo_srm_id = cbo_srm_id;
		this.normal_interest = normal_interest;
		this.penal_interest = penal_interest;
	}
	public LoanAccount(String id, String cbo_srm_id, double normal_interest) {
		super();
		this.id = id;
		this.cbo_srm_id = cbo_srm_id;
		this.normal_interest = normal_interest;
	}
	public LoanAccount(String id, String cbo_srm_id) {
		super();
		this.id = id;
		this.cbo_srm_id = cbo_srm_id;
	}
	public LoanAccount(String id) {
		super();
		this.id = id;
	}
	public LoanAccount() {
		super();
	}
	@Override
	public String toString() {
		return "LoanAccount [id=" + id + ", cbo_srm_id=" + cbo_srm_id + ", normal_interest=" + normal_interest
				+ ", penal_interest=" + penal_interest + "]";
	}

    
}