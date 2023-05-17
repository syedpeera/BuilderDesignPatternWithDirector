package com.builder.BuilderDesignPatternWIthDirector;

import java.util.List;

public class Student {
	private String studentName;
	private String rollNumber;
	private int age;
	protected List<String> subjects;
	
	public Student(StudentBuilder studentBuilder) {
		this.studentName=studentBuilder.getStudentName();
		this.rollNumber=studentBuilder.getRollNumber();
		this.age=studentBuilder.getAge();
		this.subjects=studentBuilder.getSubjects();
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

	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", rollNumber=" + rollNumber + ", age=" + age + ", subjects="
				+ subjects + "]";
	}
}
