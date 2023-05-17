package com.builder.BuilderDesignPatternWIthDirector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BuilderDesignPatternWIthDirectorApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuilderDesignPatternWIthDirectorApplication.class, args);
		Director directorObj1 = new Director(new EngineeringStudentBuilder());
		Director directorObj2 = new Director(new MBAStudentBuilder());
		Student engineerStudent = directorObj1.createStudent();
		Student mbaStudent = directorObj2.createStudent();
		System.out.println(engineerStudent.toString());
		System.out.println(mbaStudent.toString());
	}
}