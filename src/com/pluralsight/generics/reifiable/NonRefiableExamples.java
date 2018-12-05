package com.pluralsight.generics.reifiable;

import java.util.ArrayList;
import java.util.List;

public class NonRefiableExamples<T> {

	// Non Refiable Types
		// Type Variables -> T
		// Tipos Parametrizados com parametros -> ArrayList<String>, Map<Integer, String>
		// Tipos parametrizados com limites -> List<? extends Number>, Consumer<? super String>
	
	public static void main(String[] args) {
		
		// erro de compilacao
//		System.out.println(T.class);
		
		List<String> strings = new ArrayList<>();
		List<Integer> integers = new ArrayList<>();
		System.out.println(strings.getClass());
		System.out.println(integers.getClass());
		System.out.println(integers.getClass() == strings.getClass());
		
		List<? extends Number> numbers = new ArrayList<>();
		System.out.println(numbers.getClass());
		System.out.println(integers.getClass() == numbers.getClass());		
		
	}
	
}
