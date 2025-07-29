package com.expensohub.expensohub_api.entites;

import java.util.Date;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.expensohub.expensohub_api.common.TimeStampDeserializer;
import com.expensohub.expensohub_api.common.TimeStampSerialiser;
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
@Table(name = "TB_PS_ExpensoHub_Emp")
public class TbPsExpensohubEmp {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TB_PS_ExpensoHub_Emp")
	@SequenceGenerator(name = "SEQ_TB_PS_ExpensoHub_Emp", sequenceName = "SEQ_TB_PS_ExpensoHub_Emp", allocationSize = 1)
	@Column(name = "ID", unique = true)

	private Long id;
	@Column(name = "EMP_FIRST_NAME")
	private String empFirstName;

	@Column(name = "EMP_Last_NAME")
	private String empLastName;

	@Column(name = "EMP_CODE")
	private String empCode;

	@Column(name = "EMP_EMAIL")

	private String empEmail;

	@Column(name = "EMP_PSWD")
	private String empPswd;

	@Column(name = "EMP_ROLE")
	private String empRole;

	@Column(name = "EMP_DEPARTMENT")
	private String empDepartment;

	@Column(name = "EMP_DESIGNATION")
	private String empDesignation;

	@Column(name = "EMP_COMP_ID")
	private Long empCompId;

	@Column(name = "EMP_COMP_NAME")
	private String empCompName;

	@Column(name = "EMP_PHONE_NO")
	private Long empPhoneNo;
	@Column(name = "EMP_JOIN_DATE")
	private Date empJoinDate;
	@Column(name = "EMP_ADDRESS")
	private String empAddress;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonSerialize(using = TimeStampSerialiser.class)
	@JsonDeserialize(using = TimeStampDeserializer.class)
	@Column(name = "CRT_TS")
	private Date crtTs;
	

	@Column(name = "CRT_BY")
	private String crtBy;

	public TbPsExpensohubEmp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TbPsExpensohubEmp(Long id, String empFirstName, String empLastName, String empCode, String empEmail,
			String empPswd, String empRole, String empDepartment, String empDesignation, Long empCompId,
			String empCompName, Date crtTs, String crtBy) {
		super();
		this.id = id;
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
		this.empCode = empCode;
		this.empEmail = empEmail;
		this.empPswd = empPswd;
		this.empRole = empRole;
		this.empDepartment = empDepartment;
		this.empDesignation = empDesignation;
		this.empCompId = empCompId;
		this.empCompName = empCompName;
		this.crtTs = crtTs;
		this.crtBy = crtBy;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmpFirstName() {
		return empFirstName;
	}

	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}

	public String getEmpLastName() {
		return empLastName;
	}

	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpPswd() {
		return empPswd;
	}

//	public void setEmpPswd(String empPswd) {
//		this.empPswd = empPswd;
//	}

	public void setEmpPswd(String empPswd) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		this.empPswd = passwordEncoder.encode(empPswd);
	}

	public String getEmpRole() {
		return empRole;
	}

	public void setEmpRole(String empRole) {
		this.empRole = empRole;
	}

	public String getEmpDepartment() {
		return empDepartment;
	}

	public void setEmpDepartment(String empDepartment) {
		this.empDepartment = empDepartment;
	}

	public String getEmpDesignation() {
		return empDesignation;
	}

	public Long getEmpCompId() {
		return empCompId;
	}

	public void setEmpCompId(Long empCompId) {
		this.empCompId = empCompId;
	}

	public String getEmpCompName() {
		return empCompName;
	}

	public void setEmpCompName(String empCompName) {
		this.empCompName = empCompName;
	}

	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}

	public Long getEmpPhoneNo() {
		return empPhoneNo;
	}

	public void setEmpPhoneNo(Long empPhoneNo) {
		this.empPhoneNo = empPhoneNo;
	}

	public Date getEmpJoinDate() {
		return empJoinDate;
	}

	public void setEmpJoinDate(Date empJoinDate) {
		this.empJoinDate = empJoinDate;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public Date getCrtTs() {
		return crtTs;
	}

	public void setCrtTs(Date crtTs) {
		this.crtTs = crtTs;
	}

	public String getCrtBy() {
		return crtBy;
	}

	public void setCrtBy(String crtBy) {
		this.crtBy = crtBy;
	}

}
