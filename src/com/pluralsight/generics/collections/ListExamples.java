package com.pluralsight.generics.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.pluralsight.generics.model.Person;

public class ListExamples {

	public static void main(String[] args) {
		Person donDraper = new Person("Don Draper", 89);
		Person peggyOlson = new Person("Peggy Olson", 65);
		
		List<Person> madMen = new ArrayList<Person>();
		
		// a partir do java 7 foi introduzio o diamond operator (<>) que siginifca que ele ira deduzir qual eh o
		//generico a partir do contexto (deduz que eh um ArrayList de pessoas a partir da interface de lista de pessoas do lado
		//esquerdo
		//List<Person> madMen = new ArrayList<>();
		
		madMen.add(donDraper);
		madMen.add(peggyOlson);
		
		System.out.println(madMen);
		
		madMen.add(new Person("Bert Cooper", 100));
		
		System.out.println(madMen);
		
		System.out.println(madMen.size());
		
		Iterator<Person> personIterator = madMen.iterator();
		
		while (personIterator.hasNext()) {
			Person person = personIterator.next();
			System.out.println(person);
		}
		
		//melhor e menos propenso ao erro (introduzido no Java 5)
		for (Person person : madMen) {
			System.out.println(person);
		}
		
		
		
	}
	
	
	
	
	
}
