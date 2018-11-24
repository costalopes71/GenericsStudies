package com.pluralsight.generics.classes_and_interfaces;

import java.util.Comparator;

import com.pluralsight.generics.model.Person;

public class AgeComparator implements Comparator<Person> {

	@Override
	public int compare(Person left, Person right) {
		return Integer.compare(left.getAge(), right.getAge());
	}

}
