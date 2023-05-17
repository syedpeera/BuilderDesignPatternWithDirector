package com.builder.BuilderDesignPatternWIthDirector;

import java.util.List;

public abstract class StudentBuilder {
	private String studentName;
	private String rollNumber;
	private int age;
	protected List<String> subjects;
	
	public abstract StudentBuilder withSubjects();
	
	public StudentBuilder withStudentName(String studentName) {
		this.studentName=studentName;
		return this;
	}
	
	public StudentBuilder withRollNumber(String rollNumber) {
		this.rollNumber=rollNumber;
		return this;
	}
	
	public StudentBuilder withAge(int age) {
		this.age=age;
		return this;
	}
	
	public String getStudentName() {
		return studentName;
	}
	
	public String getRollNumber() {
		return rollNumber;
	}
	
	public int getAge() {
		return age;
	}
	
	public List<String> getSubjects(){
		return subjects;
	}
	
	public Student build() {
		return new Student(this);
	}
}