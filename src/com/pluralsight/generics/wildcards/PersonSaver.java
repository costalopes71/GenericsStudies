package com.pluralsight.generics.wildcards;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

import com.pluralsight.generics.model.Person;

public class PersonSaver {

	private final RandomAccessFile file;
	
	public PersonSaver(final File file) throws FileNotFoundException {
		this.file = new RandomAccessFile(file, "rw");
	}
	
	public void save(Person person) throws IOException {
		file.writeUTF(person.getClass().getName());
		file.writeUTF(person.getName());
		file.writeInt(person.getAge());
	}
	
	public void saveAll(List<? extends Person> persons) throws IOException {
		for (Person person : persons) {
			save(person);
		}
	}

	public void saveAll(final Person[] people) throws IOException {
		for (Person person : people) {
			save(person);
		}
	}
	
}
