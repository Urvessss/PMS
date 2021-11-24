package com.pms.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bank_table")
public class BankDetails implements Serializable {
	private static final long serialVersionUID = -9165581216674129315L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Accno;

	@Column
	private String BankName;

	@Column
	private String Branch;
	@Column
	private String IFSCCode;
	@Column
	private String AccHolderName;

	public BankDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankDetails(String bankName, Long accno, String branch, String iFSCCode, String accHolderName) {
		super();
		BankName = bankName;
		Accno = accno;
		Branch = branch;
		IFSCCode = iFSCCode;
		AccHolderName = accHolderName;
	}

	public String getBankName() {
		return BankName;
	}

	public void setBankName(String bankName) {
		BankName = bankName;
	}

	public Long getAccno() {
		return Accno;
	}

	public void setAccno(Long accno) {
		Accno = accno;
	}

	public String getBranch() {
		return Branch;
	}

	public void setBranch(String branch) {
		Branch = branch;
	}

	public String getIFSCCode() {
		return IFSCCode;
	}

	public void setIFSCCode(String iFSCCode) {
		IFSCCode = iFSCCode;
	}

	public String getAccHolderName() {
		return AccHolderName;
	}

	public void setAccHolderName(String accHolderName) {
		AccHolderName = accHolderName;
	}

	@Override
	public String toString() {
		return "BankDetails [BankName=" + BankName + ", Accno=" + Accno + ", Branch=" + Branch + ", IFSCCode="
				+ IFSCCode + ", AccHolderName=" + AccHolderName + "]";
	}

}