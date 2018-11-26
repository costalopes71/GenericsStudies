package com.pluralsight.generics.wildcards;

import java.io.IOException;
import java.util.List;

import com.pluralsight.generics.model.Person;

public class PersonSaver {

	public void saveAll(List<? extends Person> persons) throws IOException {
		
		for (Person person : persons) {
			save(person);
		}
		
	}

	private void save(Person person) {
		
	}

}
