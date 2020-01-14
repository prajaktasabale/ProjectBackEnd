package com.app.pojos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Faculty {
	private Integer facultyId;
	private String facultyName;
	private String facultyEmail;
	private String password;
	private String gender;
	private String address;
	private String contactNo;
	private Set<Course> courseId = new HashSet<>();
	
	public Faculty() {
		System.out.println("In Faculty Ctor");
	}

	public Faculty(String facultyName, String facultyEmail, String password, String gender, String address,
			String contactNo) {
		super();
		this.facultyName = facultyName;
		this.facultyEmail = facultyEmail;
		this.password = password;
		this.gender = gender;
		this.address = address;
		this.contactNo = contactNo;
	}

	@Column(name = "name",length = 50)
	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}
	@Column(name = "email",length = 50,unique = true)
	public String getFacultyEmail() {
		return facultyEmail;
	}
	
	public void setFacultyEmail(String facultyEmail) {
		this.facultyEmail = facultyEmail;
	}
	@Column(name = "password",length = 50)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Column(length = 20)
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	@Column(length = 70)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	@Column(name = "contact_no",length = 13)
	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "faculty_id")
	public Integer getFacultyId() {
		return facultyId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseId == null) ? 0 : courseId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Faculty other = (Faculty) obj;
		if (courseId == null) {
			if (other.courseId != null)
				return false;
		} else if (!courseId.equals(other.courseId))
			return false;
		return true;
	}

	public void setFacultyId(Integer facultyId) {
		this.facultyId = facultyId;
	}


	@ManyToMany(mappedBy = "faculties")
	public Set<Course> getCourseId() {
		return courseId;
	}

	public void setCourseId(Set<Course> courseId) {
		this.courseId = courseId;
	}

	@Override
	public String toString() {
		return "Faculty [facultyId=" + facultyId + ", facultyName=" + facultyName + ", facultyEmail=" + facultyEmail
				+ ", gender=" + gender + ", address=" + address + ", contactNo=" + contactNo + "]";
	}
	
}

