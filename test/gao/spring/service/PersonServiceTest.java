package gao.spring.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import gao.spring.po.Person;

public class PersonServiceTest {
	private static PersonService personService;
	
	@Before
	public void setUp() throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		this.personService = (PersonService) applicationContext.getBean("personService");
	}

	@Test
	public void testSave() throws Exception {
		for(int i=0;i<6;i++){
			personService.save(new Person("张三"+i));
		}
	}
	
	@Test
	public void testgetPerson() throws Exception {
		Person person = personService.getPerson(1);
		System.out.println(person);
	}
	
	@Test
	public void testUpdate() throws Exception {
		Person person = personService.getPerson(1);
		person.setName("李四");
		personService.update(person);
	}
	
	@Test
	public void testDelete() throws Exception {
		personService.delete(1);
	}
	
	@Test
	public void testgetPersons() throws Exception {
		List<Person> persons = personService.getPersons();
		System.out.println(persons);
	}
}
