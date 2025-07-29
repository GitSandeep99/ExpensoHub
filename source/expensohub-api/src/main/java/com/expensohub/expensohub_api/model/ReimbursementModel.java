package com.expensohub.expensohub_api.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

public class ReimbursementModel {

	private Long reimbId;

	private String reimbType;

	private Double reimbAmount;

	private Long empId;

	private String reimbDesc;

	private String crtBy;

	private Date crtTs;

	//@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private Date issueDate;

	private MultipartFile reimbUploadFile;
	

	public Long getReimbId() {
		return reimbId;
	}

	public void setReimbId(Long reimbId) {
		this.reimbId = reimbId;
	}

	public String getReimbType() {
		return reimbType;
	}

	public void setReimbType(String reimbType) {
		this.reimbType = reimbType;
	}

	public Double getReimbAmount() {
		return reimbAmount;
	}

	public void setReimbAmount(Double reimbAmount) {
		this.reimbAmount = reimbAmount;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getReimbDesc() {
		return reimbDesc;
	}

	public void setReimbDesc(String reimbDesc) {
		this.reimbDesc = reimbDesc;
	}

	public String getCrtBy() {
		return crtBy;
	}

	public void setCrtBy(String crtBy) {
		this.crtBy = crtBy;
	}

	public Date getCrtTs() {
		return crtTs;
	}

	public void setCrtTs(Date crtTs) {
		this.crtTs = crtTs;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public MultipartFile getReimbUploadFile() {
		return reimbUploadFile;
	}

	public void setReimbUploadFile(MultipartFile reimbUploadFile) {
		this.reimbUploadFile = reimbUploadFile;
	}

}
