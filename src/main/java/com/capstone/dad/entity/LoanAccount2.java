package com.capstone.dad.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "excel_data")
public class LoanAccount2 {

	@Id
    private String id;
    private String sol_id;
    private double normal_interest;
    private double penal_interest;
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
	public LoanAccount2(String id, String sol_id, double normal_interest, double penal_interest) {
		super();
		this.id = id;
		this.sol_id = sol_id;
		this.normal_interest = normal_interest;
		this.penal_interest = penal_interest;
	}
	public LoanAccount2(String sol_id, double normal_interest, double penal_interest) {
		super();
		this.sol_id = sol_id;
		this.normal_interest = normal_interest;
		this.penal_interest = penal_interest;
	}
	public LoanAccount2() {
    }
	@Override
	public String toString() {
		return "LoanAccount2 [id=" + id + ", sol_id=" + sol_id + ", normal_interest=" + normal_interest
				+ ", penal_interest=" + penal_interest + "]";
	}
}
