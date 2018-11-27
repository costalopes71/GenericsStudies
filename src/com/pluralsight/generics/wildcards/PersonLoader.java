package com.pluralsight.generics.wildcards;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.pluralsight.generics.model.Person;

public class PersonLoader {

	private RandomAccessFile file;
	
	public PersonLoader(final File file) throws FileNotFoundException {
		this.file = new RandomAccessFile(file, "rw");
	}
	
	public Person load() throws ClassNotFoundException {
		
		try {
			final String className = file.readUTF();
			final String personName = file.readUTF();
			final int age = file.readInt();
			
			final Class<?> personClass = Class.forName(className);
			final Constructor<?> constructor = personClass.getConstructor(String.class, int.class);
			return (Person) constructor.newInstance(personName, age);
		} catch (IOException e) {
			return null;
		} catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	//contravariante -> parametro generico que pode ser uma superclasse ou interface que eh implementada
	public void loadAll(List<? super Person> people) throws ClassNotFoundException {
		Person person;
		while ((person = load()) != null) {
			people.add(person);
		}
	}

}
