package com.pluralsight.generics.classes_and_interfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.pluralsight.generics.model.Person;

public class SortExample {

	public static void main(String[] args) {
		
		
		Person donDraper = new Person("Don Draper", 89);
		Person peggyOlson = new Person("Peggy Olson", 65);
		
		List<Person> madMen = new ArrayList<Person>();
		madMen.add(donDraper);
		madMen.add(peggyOlson);
		madMen.add(new Person("Bert Cooper", 100));
		
		System.out.println(madMen);
		
		Collections.sort(madMen, new AgeComparator());
		
		System.out.println(madMen);
		
		Collections.sort(madMen, new ReverseComparator<>(new AgeComparator()));
		
		System.out.println(madMen);
		
	}
	
}
