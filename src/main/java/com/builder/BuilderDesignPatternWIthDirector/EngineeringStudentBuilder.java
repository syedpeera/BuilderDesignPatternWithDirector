package com.builder.BuilderDesignPatternWIthDirector;

import java.util.ArrayList;
import java.util.List;

public class EngineeringStudentBuilder extends StudentBuilder {
	@Override
	public StudentBuilder withSubjects() {
		List<String> subjects = new ArrayList<>();
		subjects.add("Maths");
		subjects.add("Programming");
		subjects.add("Physics");
		subjects.add("Chemistry");
		this.subjects=subjects;
		return this;
	}
}
