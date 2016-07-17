package gao.spring.service;

import java.util.List;

import gao.spring.po.Person;

public interface PersonService {
	/**
	 * 保存person
	 * @param person
	 */
	public void save(Person person) throws Exception;
	
	/**
	 * 更新person
	 * @param person
	 */
	public void update(Person person) throws Exception;
	
	/**
	 * 根据id获取person
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Person getPerson(Integer id) throws Exception;
	
	/**
	 * 获取所有person
	 * @return
	 * @throws Exception
	 */
	public List<Person> getPersons() throws Exception;
	
	/**
	 * 根据id删除Person
	 * @param id
	 * @throws Exception
	 */
	public void delete(Integer id) throws Exception;
}
