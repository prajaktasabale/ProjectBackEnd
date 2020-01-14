package com.app.pojos;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Subject {
	private Integer subId;
	private String subName;
	private Course courseId;
	private byte[] syllabus;

	
	public Subject() {
		System.out.println("In Subject ctor");
	}

	public Subject(String subName, byte[] syllabus) {
		super();
		this.subName = subName;
		this.syllabus = syllabus;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sub_id")
	public Integer getSubId() {
		return subId;
	}

	public void setSubId(Integer subId) {
		this.subId = subId;
	}

	public String getSubName() {
		return subName;
	}
	@Column(name = "sub_name",length = 50)
	public void setSubName(String subName) {
		this.subName = subName;
	}

	@ManyToOne
	@JoinColumn(name = "course_id")
	public Course getCourseId() {
		return courseId;
	}

	public void setCourseId(Course courseId) {
		this.courseId = courseId;
	}
	@Lob
	public byte[] getSyllabus() {
		return syllabus;
	}

	public void setSyllabus(byte[] syllabus) {
		this.syllabus = syllabus;
	}


	@Override
	public String toString() {
		return "Subject [subId=" + subId + ", subName=" + subName + ", syllabus=" + Arrays.toString(syllabus) + "]";
	}
	
	
}