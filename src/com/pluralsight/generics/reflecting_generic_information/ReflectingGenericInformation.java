package com.pluralsight.generics.reflecting_generic_information;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReflectingGenericInformation {

	public static class StringList extends ArrayList<String> {
		
		
	}
	
	public static void main(String[] args) {

		List<String> strings = new ArrayList<>();
		Class<?> arrayList = strings.getClass();
		System.out.println(arrayList);
		// faz o toString com as informacoes dos tipos Genericos
		System.out.println(arrayList.toGenericString());
		
		final TypeVariable<? extends Class<?>>[] typeParameters = arrayList.getTypeParameters();
		System.out.println(Arrays.toString(typeParameters));
		
		final ParameterizedType arrayListOfStrings = (ParameterizedType) StringList.class.getGenericSuperclass();
		System.out.println(Arrays.toString(arrayListOfStrings.getActualTypeArguments()));
		
	}
	
}
