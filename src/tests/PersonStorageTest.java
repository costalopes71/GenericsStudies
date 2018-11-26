package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.pluralsight.generics.model.Employee;
import com.pluralsight.generics.model.Partner;
import com.pluralsight.generics.wildcards.PersonLoader;
import com.pluralsight.generics.wildcards.PersonSaver;

public class PersonStorageTest {

	private Partner donDraper = new Partner("Don Draper", 89);
	private Partner bertCooper = new Partner("Bert Cooper", 100);
	private Employee peggyOlson = new Employee("Peggy Olson", 65);
	
	private File file;
	private PersonSaver saver;
	private PersonLoader loader;
	
	@Test
	public void savesAndLoadsArraysOfPeople() throws Exception {

		List<Partner> persons = new ArrayList<>();
		persons.add(donDraper);
		persons.add(bertCooper);
		
		saver.saveAll(persons);
		
		assertEquals(donDraper, loader.load());
		assertEquals(bertCooper, loader.load());
	
	}

}
