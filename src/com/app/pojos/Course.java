package com.app.pojos;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Course {
	private Integer Id;
	private String courseName;
	private double courseFee;
	private Date startDate,endDate ;
	private List<Student> students =  new ArrayList<>();
	private List<Subject> subjects = new ArrayList<>();
	private Set<Faculty> faculties = new HashSet<>();
	
	public Course() {
		System.out.println("In Course ctor");
	}

	public Course(String courseName, double courseFee, Date startDate, Date endDate) {
		super();
		this.courseName = courseName;
		this.courseFee = courseFee;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_id")
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}
	
	@Column(name = "course_name",length = 50)
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	@Column(name = "course_fee")
	public double getCourseFee() {
		return courseFee;
	}

	public void setCourseFee(double courseFee) {
		this.courseFee = courseFee;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "start_date")
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "end_date")
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@OneToMany(mappedBy = "courseId", cascade = CascadeType.ALL,orphanRemoval = true)
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@OneToMany(mappedBy = "courseId", cascade = CascadeType.ALL,orphanRemoval = true)
	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name="courses_faculty",joinColumns = @JoinColumn( name = "c_id"),inverseJoinColumns = @JoinColumn(name="fac_id"))
	public Set<Faculty> getFaculties() {
		return faculties;
	}

	public void setFaculties(Set<Faculty> faculties) {
		this.faculties = faculties;
	}

	@Override
	public String toString() {
		return "Course [Id=" + Id + ", courseName=" + courseName + ", courseFee=" + courseFee + ", startDate="
				+ startDate + ", endDate=" + endDate + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((faculties == null) ? 0 : faculties.hashCode());
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
		Course other = (Course) obj;
		if (faculties == null) {
			if (other.faculties != null)
				return false;
		} else if (!faculties.equals(other.faculties))
			return false;
		return true;
	}
	
	public void addStudent(Student s)
	{
		this.students.add(s);
		s.setCourseId(this);
	}
	
	public void removeStudent(Student s)
	{
		this.students.remove(s);
		s.setCourseId(null);
	}
	
	public void addSubject(Subject sb)
	{
		this.subjects.add(sb);
		sb.setCourseId(this);
	}
	
	public void removeSubject(Subject sb)
	{
		this.subjects.remove(sb);
		sb.setCourseId(null);
	}
	
	public void addFaculty(Faculty f)
	{
		this.faculties.add(f);
		f.getCourseId().add(this);
	}
	
	public void removeFaculty(Faculty f)
	{
		this.faculties.remove(f);
		f.getCourseId().remove(this);
	}
}
