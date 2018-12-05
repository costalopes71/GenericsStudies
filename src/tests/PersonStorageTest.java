package tests;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.pluralsight.generics.model.Employee;
import com.pluralsight.generics.model.Partner;
import com.pluralsight.generics.model.Person;
import com.pluralsight.generics.wildcards.PersonLoader;
import com.pluralsight.generics.wildcards.PersonSaver;

public class PersonStorageTest {

	private Partner donDraper = new Partner("Don Draper", 89);
	private Partner bertCooper = new Partner("Bert Cooper", 100);
	private Employee peggyOlson = new Employee("Peggy Olson", 65);
	
	private File file;
	private PersonSaver saver;
	private PersonLoader loader;
	
	@Before
	public void setUp() throws Exception {
		file = File.createTempFile("tmp", "people");
		saver = new PersonSaver(file);
		loader = new PersonLoader(file);
	}
	
	@Test
	public void cannotLoadFromEmptyFile() throws Exception {
		PersonLoader loader = new PersonLoader(file);
		assertNull(loader.load());
	}
	
	@Test
	public void savesAndLoadsPerson() throws Exception {
		PersonSaver saver = new PersonSaver(file);
		PersonLoader loader = new PersonLoader(file);
		
		saver.save(donDraper);
		
		assertEquals(donDraper, loader.load());
	}
	
	@Test
	public void savesAndLoadsTwoPeople() throws Exception {
		
		saver.save(donDraper);
		saver.save(peggyOlson);
		
		assertEquals(donDraper, loader.load());
		assertEquals(peggyOlson, loader.load());
		
	}
	
	@Test
	public void savesArraysOfPeople() throws Exception {
		
		Person[] people = new Partner[2];
		people[0] = donDraper;
		people[1] = bertCooper;
		
		saver.saveAll(people);
		
		assertEquals(donDraper, loader.load());
		assertEquals(bertCooper, loader.load());
	}
	
	@Test
	public void savesListOfPeople() throws Exception {

		List<Partner> persons = new ArrayList<>();
		persons.add(donDraper);
		persons.add(bertCooper);
		
		saver.saveAll(persons);
		
		assertEquals(donDraper, loader.load());
		assertEquals(bertCooper, loader.load());
	
	}

	@Test
	public void loadsListsOfPeople() throws Exception {
		
		saver.save(donDraper);
		saver.save(peggyOlson);
		
		List<Object> people = new ArrayList<>();
		loader.loadAll(people);
		
		assertEquals(donDraper, people.get(0));
		assertEquals(peggyOlson, people.get(1));
	}
	
	@After
	public void tearDown() {
		if (file.exists()) {
			file.delete();
		}
	}
	
}
