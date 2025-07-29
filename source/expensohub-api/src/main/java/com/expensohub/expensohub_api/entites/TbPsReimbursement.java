package com.expensohub.expensohub_api.entites;

import java.sql.Blob;
import java.util.Date;

import org.hibernate.annotations.CurrentTimestamp;
import org.springframework.web.multipart.MultipartFile;

import com.expensohub.expensohub_api.common.TimeStampDeserializer;
import com.expensohub.expensohub_api.common.TimeStampSerialiser;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "TB_PS_Reimbursement")
public class TbPsReimbursement {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_PS_Reimbursement_SEQ")
	@SequenceGenerator(name = "TB_PS_Reimbursement_SEQ", sequenceName = "TB_PS_Reimbursement_SEQ", allocationSize = 1)
	@Column(name = "REIMB_ID", unique = true)

	private Long reimbId;
	@Column(name = "REIMB_TYPE")
	private String reimbType;
	@Column(name = "REIMB_AMOUNT")
	private Double reimbAmount;
	@Column(name = "EMP_ID")
	private Long empId;
	@Column(name = "REIMB_DESC")
	private String reimbDesc;
	@Column(name = "REIMB_UPLOAD_FILE")
	private Blob reimbUploadFile;
	
	@Column(name = "CRT_BY")
	private String crtBy;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonSerialize(using = TimeStampSerialiser.class)
	@JsonDeserialize(using = TimeStampDeserializer.class)
	@Column(name = "CRT_TS")
	private Date crtTs;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonSerialize(using = TimeStampSerialiser.class)
	@JsonDeserialize(using = TimeStampDeserializer.class)
	@Column(name = "ISSUE_DATE")
	private Date issueDate;


	public TbPsReimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TbPsReimbursement(Long reimbId, String reimbType, Double reimbAmount, Long empId, String reimbDesc,
			Blob reimbUploadFile, Date issueDate) {
		super();
		this.reimbId = reimbId;
		this.reimbType = reimbType;
		this.reimbAmount = reimbAmount;
		this.empId = empId;
		this.reimbDesc = reimbDesc;
		this.reimbUploadFile = reimbUploadFile;
		this.issueDate = issueDate;
	}

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

	public Blob getReimbUploadFile() {
		return reimbUploadFile;
	}

	public void setReimbUploadFile(Blob reimbUploadFile) {
		this.reimbUploadFile = reimbUploadFile;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
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
	
	

}
