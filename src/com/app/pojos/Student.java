package com.app.pojos;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Student {
	private Integer regId;
	private String studName;
	private String studEmail;
	private String password;
	private Date dob;
	private String gender;
	private String address;
	private String nationality;
	private String contactNo;
	private Course courseId;
	private Fee fee;
	private Result result;
	
	public Student() 
	{
		System.out.println("In Student ctor");
	}
	public Student(String studName, String studEmail, String password, Date dob, String gender, String address,
			String nationality, String contactNo) {
		super();
		this.studName = studName;
		this.studEmail = studEmail;
		this.password = password;
		this.dob = dob;
		this.gender = gender;
		this.address = address;
		this.nationality = nationality;
		this.contactNo = contactNo;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reg_id")
	public Integer getRegId() {
		return regId;
	}
	public void setRegId(Integer regId) {
		this.regId = regId;
	}
	
	@Column(name = "name",length = 50)
	public String getStudName() {
		return studName;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}
	@Column(name = "email",length = 50,unique = true)
	public String getStudEmail() {
		return studEmail;
	}
	public void setStudEmail(String studEmail) {
		this.studEmail = studEmail;
	}
	@Column(name = "password",length = 50)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	@Column(name = "gender",length = 50)
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	@Column(length = 100)
	public void setAddress(String address) {
		this.address = address;
	}
	@Column(length = 20)
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	@Column(length = 13)
	public String getContactNo() {
		return contactNo;
	}
	
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	
	@ManyToOne
	@JoinColumn(name = "course_id")
	public Course getCourseId() {
		return courseId;
	}
	public void setCourseId(Course courseId) {
		this.courseId = courseId;
	}
	@OneToOne
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	@Embedded
	public Fee getFee() {
		return fee;
	}
	public void setFee(Fee fee) {
		this.fee = fee;
	}
	@Override
	public String toString() {
		return "Student [regId=" + regId + ", studName=" + studName + ", studEmail=" + studEmail + ", dob=" + dob
				+ ", gender=" + gender + ", address=" + address + ", nationality=" + nationality + ", contactNo="
				+ contactNo + "]";
	}

}
