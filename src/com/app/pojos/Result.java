package com.app.pojos;

import java.util.List;

import javax.persistence.*;

@Entity
public class Result 
{
	private Integer id;
	private Student studId;
	private Subject subId;
	private int marks;
	
	public Result() {
		System.out.println("in ctor of result");
	}

	public Result( int marks,Student studId) {
		
		this.marks = marks;
		this.studId = studId;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@OneToOne
	@JoinColumn(name="sub_id")
	public Subject getSubId() {
		return subId;
	}

	public void setSubId(Subject subId) {
		this.subId = subId;
	}
	@OneToOne(mappedBy = "result")
	@JoinColumn(name="stud_id")
	public Student getStudId() {
		return studId;
	}

	public void setStudId(Student studId) {
		this.studId = studId;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Result [studId=" + studId + ", subId=" + subId + ", marks=" + marks + "]";
	}

	
	
}
