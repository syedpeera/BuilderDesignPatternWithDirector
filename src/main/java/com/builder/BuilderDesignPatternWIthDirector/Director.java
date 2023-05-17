package com.builder.BuilderDesignPatternWIthDirector;

public class Director {
	private StudentBuilder studentBuilder;
	
	public Director(StudentBuilder studentBuilder) {
		this.studentBuilder = studentBuilder;
	}
	
	public Student createStudent() {
		if(studentBuilder instanceof EngineeringStudentBuilder) {
			return createEngineeringStudent();
		}
		else if(studentBuilder instanceof MBAStudentBuilder) {
			return createMBAStudent();
		}
		return null;
	}
	
	private Student createEngineeringStudent(){
		return studentBuilder.withStudentName("Sam").withRollNumber("1283").withAge(24).withSubjects().build();
	}
	
	private Student createMBAStudent() {
		return studentBuilder.withStudentName("John").withRollNumber("2394").withAge(23).withSubjects().build();
	}
}
