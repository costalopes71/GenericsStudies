package com.pluralsight.generics.model;

import java.util.Objects;

public class Person {

	private String name;
	private int age;

	public Person() { }
	
	public Person(String name, int age) {
		Objects.requireNonNull(name);
		
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		return sb.append("Person{name='").append(name).append("', age=").append(age).append("'}").toString(); 
	}
	
}
