package com.pluralsight.generics.onmethods;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.pluralsight.generics.classes_and_interfaces.AgeComparator;
import com.pluralsight.generics.model.Person;

public class SortingExamples {

	public static void main(String[] args) {
		
		Person donDraper = new Person("Don Draper", 89);
		Person peggyOlson = new Person("Peggy Olson", 65);
		Person bertCooper = new Person("Bert Cooper", 100);
		
		List<Person> madMen = new ArrayList<Person>();
		madMen.add(donDraper);
		madMen.add(peggyOlson);
		madMen.add(bertCooper);
		
		final Person youngestCastMember = (Person) min(madMen, new AgeComparator());
	
		System.out.println(youngestCastMember);
		
		List<Integer> numbers = new ArrayList<>();
		numbers.add(5);
		numbers.add(2);
		numbers.add(3);
		
		// Referencia de metodo eh um recurso introduzido no Java 8 (ex: Integer::compare)
		final int minimium = min(numbers, Integer::compare);
		
		System.out.println(minimium);
		
	}
	
	// T eh o type parameter para o metodo, dessa maneira o parametro de tipo pode ser usado no escopo do metodo, ou seja,
	// para definir o tipo de retorno, de parametros, e tipo de variaveis dentro do metodo
	public static <T> T min(List<T> values, Comparator<T> comparator) {
		
		if (values.isEmpty()) {
			throw new IllegalArgumentException("List is empty, cannot find minimum");
		}
		
		T lowestElement = values.get(0);
		
		for (int i = 1; i < values.size(); i++) {
			
			final T element = values.get(i);
			
			if (comparator.compare(element, lowestElement) < 0) {
				lowestElement = element;
			}
			
		}
		
		return lowestElement;
	}
	
}
