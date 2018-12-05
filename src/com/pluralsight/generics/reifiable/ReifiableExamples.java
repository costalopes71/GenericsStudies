package com.pluralsight.generics.reifiable;

import java.util.ArrayList;
import java.util.List;

public class ReifiableExamples {

	// Reifiable significa reificar em portugues. Isso quer dizer, tornar algo abstrato em algo concreto. Os tipos que podem ser refletidos em tempo de execucao
	// sao aqueles que podem ser reificados, ou seja, como em tempo de execucao os tipos parametrizados com tipo generico sofrem a tecnica de ERASURE (ou apagamento
	// em portgues) eles nao podem ser refletidos em tempo de execucao
	// Em java: tipo que contem toda sua informacao de descricao
	
	// Reifiable Types
		// Primitivos -> int, long
		// Classes ou Interfaces nao parametrizadas -> String, ActionListener
		// Unbonded Wildcards -> List<?> , Map<?, ?>
		// Raw Types -> List, Map
		// Arrays -> int[] , int[][], List<?>[]
	
	public static void main(String[] args) {
		
		System.out.println(int.class);
		System.out.println(String.class);
		
		List<?> wildcards = new ArrayList<>();
		System.out.println(wildcards.getClass());
		
		List raw = new ArrayList<>();
		System.out.println(raw.getClass());
		System.out.println(raw.getClass() == wildcards.getClass());
		
		System.out.println(int[].class);
		System.out.println(List[].class);
		
		
	}
	
}
