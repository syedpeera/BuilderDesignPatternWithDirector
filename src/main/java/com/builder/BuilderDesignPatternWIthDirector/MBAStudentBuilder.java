package com.builder.BuilderDesignPatternWIthDirector;

import java.util.ArrayList;
import java.util.List;

public class MBAStudentBuilder extends StudentBuilder{
	@Override
	public StudentBuilder withSubjects() {
		List<String> subjects = new ArrayList<>();
		subjects.add("Marketing");
		subjects.add("Sales");
		subjects.add("Human Resource");
		subjects.add("Finance");
		this.subjects=subjects;
		return this;
	}
}
