package com.pluralsight.generics.collections;

import java.util.HashMap;
import java.util.Map;

import com.pluralsight.generics.model.Person;

public class MapExample {

	public static void main(String[] args) {
	
		Person donDraper = new Person("Don Draper", 89);
		Person peggyOlson = new Person("Peggy Olson", 65);
		Person bertCooper = new Person("Bert Cooper", 100);
		
		Map<String, Person> madMen = new HashMap<>();
		madMen.put(donDraper.getName(), donDraper);
		madMen.put(peggyOlson.getName(), peggyOlson);
		madMen.put(bertCooper.getName(), bertCooper);
		
		System.out.println(madMen);
		
		// iterar sobre as chaves
		for (String name : madMen.keySet()) {
			System.out.println(name);
		}
		
		//iterar sobre os valores
		for (Person person : madMen.values()) {
			System.out.println(person);
		}
		
		//iterar sobre as chaves e valores
		for (Map.Entry<String, Person> entry : madMen.entrySet()) {
			System.out.println(entry);
		}
		
	}
	
}
