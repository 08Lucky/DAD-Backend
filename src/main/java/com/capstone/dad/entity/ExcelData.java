package com.capstone.dad.entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "excel_data")
public class ExcelData {

    @Id
    private String id;

    private Double sr_no;
    private Double sol_id;
    private String acct_name;
    private String schm_code;
    private String principal_payment_due_date;
    private Double principal_payment_amount;
    private String interest_payment_due_date;
    private String primary_manager_id;
    private Double secondary_manager_id;
    private Double tertiary_manager_id;
    private Double cbo_srm_id;
    private Double credit_admin_manager_id;
    private Double normal_interest;
    private String interest_calc_status;
    private Double penal_interest;
    private String penal_calc_status;
    private String processing_status;
    
    public ExcelData() {
    }
    
	public ExcelData(String id, Double sr_no, Double sol_id, String acct_name, String schm_code,
			String principal_payment_due_date, Double principal_payment_amount, String interest_payment_due_date,
			String primary_manager_id, Double secondary_manager_id, Double tertiary_manager_id, Double cbo_srm_id,
			Double credit_admin_manager_id, Double normal_interest, String interest_calc_status, Double penal_interest,
			String penal_calc_status, String processing_status) {
		super();
		this.id = id;
		this.sr_no = sr_no;
		this.sol_id = sol_id;
		this.acct_name = acct_name;
		this.schm_code = schm_code;
		this.principal_payment_due_date = principal_payment_due_date;
		this.principal_payment_amount = principal_payment_amount;
		this.interest_payment_due_date = interest_payment_due_date;
		this.primary_manager_id = primary_manager_id;
		this.secondary_manager_id = secondary_manager_id;
		this.tertiary_manager_id = tertiary_manager_id;
		this.cbo_srm_id = cbo_srm_id;
		this.credit_admin_manager_id = credit_admin_manager_id;
		this.normal_interest = normal_interest;
		this.interest_calc_status = interest_calc_status;
		this.penal_interest = penal_interest;
		this.penal_calc_status = penal_calc_status;
		this.processing_status = processing_status;
	}

	public ExcelData(Double sr_no, Double sol_id, String acct_name, String schm_code, String principal_payment_due_date,
			Double principal_payment_amount, String interest_payment_due_date, String primary_manager_id,
			Double secondary_manager_id, Double tertiary_manager_id, Double cbo_srm_id, Double credit_admin_manager_id,
			Double normal_interest, String interest_calc_status, Double penal_interest, String penal_calc_status,
			String processing_status) {
		super();
		this.sr_no = sr_no;
		this.sol_id = sol_id;
		this.acct_name = acct_name;
		this.schm_code = schm_code;
		this.principal_payment_due_date = principal_payment_due_date;
		this.principal_payment_amount = principal_payment_amount;
		this.interest_payment_due_date = interest_payment_due_date;
		this.primary_manager_id = primary_manager_id;
		this.secondary_manager_id = secondary_manager_id;
		this.tertiary_manager_id = tertiary_manager_id;
		this.cbo_srm_id = cbo_srm_id;
		this.credit_admin_manager_id = credit_admin_manager_id;
		this.normal_interest = normal_interest;
		this.interest_calc_status = interest_calc_status;
		this.penal_interest = penal_interest;
		this.penal_calc_status = penal_calc_status;
		this.processing_status = processing_status;
	}

	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}

	public Double getSr_no() {
		return sr_no;
	}

	public void setSr_no(Double sr_no) {
		this.sr_no = sr_no;
	}

	public Double getSol_id() {
		return sol_id;
	}



	public void setSol_id(Double sol_id) {
		this.sol_id = sol_id;
	}



	public String getAcct_name() {
		return acct_name;
	}



	public void setAcct_name(String acct_name) {
		this.acct_name = acct_name;
	}



	public String getSchm_code() {
		return schm_code;
	}



	public void setSchm_code(String schm_code) {
		this.schm_code = schm_code;
	}



	public String getPrincipal_payment_due_date() {
		return principal_payment_due_date;
	}



	public void setPrincipal_payment_due_date(String principal_payment_due_date) {
		this.principal_payment_due_date = principal_payment_due_date;
	}



	public Double getPrincipal_payment_amount() {
		return principal_payment_amount;
	}



	public void setPrincipal_payment_amount(Double principal_payment_amount) {
		this.principal_payment_amount = principal_payment_amount;
	}



	public String getInterest_payment_due_date() {
		return interest_payment_due_date;
	}



	public void setInterest_payment_due_date(String interest_payment_due_date) {
		this.interest_payment_due_date = interest_payment_due_date;
	}



	public String getPrimary_manager_id() {
		return primary_manager_id;
	}



	public void setPrimary_manager_id(String primary_manager_id) {
		this.primary_manager_id = primary_manager_id;
	}



	public Double getSecondary_manager_id() {
		return secondary_manager_id;
	}



	public void setSecondary_manager_id(Double secondary_manager_id) {
		this.secondary_manager_id = secondary_manager_id;
	}



	public Double getTertiary_manager_id() {
		return tertiary_manager_id;
	}



	public void setTertiary_manager_id(Double tertiary_manager_id) {
		this.tertiary_manager_id = tertiary_manager_id;
	}



	public Double getCbo_srm_id() {
		return cbo_srm_id;
	}



	public void setCbo_srm_id(Double cbo_srm_id) {
		this.cbo_srm_id = cbo_srm_id;
	}



	public Double getCredit_admin_manager_id() {
		return credit_admin_manager_id;
	}



	public void setCredit_admin_manager_id(Double credit_admin_manager_id) {
		this.credit_admin_manager_id = credit_admin_manager_id;
	}



	public Double getNormal_interest() {
		return normal_interest;
	}



	public void setNormal_interest(Double normal_interest) {
		this.normal_interest = normal_interest;
	}



	public String getInterest_calc_status() {
		return interest_calc_status;
	}



	public void setInterest_calc_status(String interest_calc_status) {
		this.interest_calc_status = interest_calc_status;
	}



	public Double getPenal_interest() {
		return penal_interest;
	}



	public void setPenal_interest(Double penal_interest) {
		this.penal_interest = penal_interest;
	}



	public String getPenal_calc_status() {
		return penal_calc_status;
	}



	public void setPenal_calc_status(String penal_calc_status) {
		this.penal_calc_status = penal_calc_status;
	}



	public String getProcessing_status() {
		return processing_status;
	}



	public void setProcessing_status(String processing_status) {
		this.processing_status = processing_status;
	}



	public boolean isEmpty() {
        return sr_no == 0 && sol_id == 0 && acct_name == null && schm_code == null &&
        		principal_payment_due_date == null && principal_payment_amount == null &&
        		interest_payment_due_date == null && primary_manager_id == null &&
        		secondary_manager_id == null && tertiary_manager_id == null && cbo_srm_id == null &&
        		credit_admin_manager_id == null && normal_interest == null &&
        		interest_calc_status == null && penal_interest == null &&
                penal_calc_status == null && processing_status == null;
    }
}
