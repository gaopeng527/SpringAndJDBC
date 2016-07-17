package gao.spring.service;

import java.util.List;

import gao.spring.po.Person;

public interface PersonService {
	/**
	 * ����person
	 * @param person
	 */
	public void save(Person person) throws Exception;
	
	/**
	 * ����person
	 * @param person
	 */
	public void update(Person person) throws Exception;
	
	/**
	 * ����id��ȡperson
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Person getPerson(Integer id) throws Exception;
	
	/**
	 * ��ȡ����person
	 * @return
	 * @throws Exception
	 */
	public List<Person> getPersons() throws Exception;
	
	/**
	 * ����idɾ��Person
	 * @param id
	 * @throws Exception
	 */
	public void delete(Integer id) throws Exception;
}
