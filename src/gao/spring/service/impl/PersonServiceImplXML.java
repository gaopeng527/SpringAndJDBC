package gao.spring.service.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import gao.spring.po.Person;
import gao.spring.service.PersonService;
/**
 * 基于XML方式来配置事务
 * @author DELL
 *
 */

public class PersonServiceImplXML implements PersonService {
	// Spring中封装了数据库操作的一个类
	private JdbcTemplate jdbcTemplate ;
	
	@Override
	public void save(Person person) throws Exception {
		jdbcTemplate.update("insert into person(name) values(?)", new Object[]{person.getName()},
				new int[]{java.sql.Types.VARCHAR});
	}

	@Override
	public void update(Person person) throws Exception {
		jdbcTemplate.update("update person set name=? where id=?", new Object[]{person.getName(), person.getId()},
				new int[]{java.sql.Types.VARCHAR, java.sql.Types.INTEGER});
	}

	@Override
	public Person getPerson(Integer id) throws Exception {
		Person person = jdbcTemplate.queryForObject("select * from person where id=?", new Object[]{id},
				new int[]{java.sql.Types.INTEGER}, new PersonRowMapper());
		return person;
	}

	@Override
	public List<Person> getPersons() throws Exception {
		List<Person> persons = jdbcTemplate.query("select * from person", new PersonRowMapper());
		return persons;
	}

	@Override
	public void delete(Integer id) throws Exception {
		jdbcTemplate.update("delete from person where id=?", new Object[]{id},
				new int[]{java.sql.Types.INTEGER});
		// 测试事务是否配置成功（表名故意写错）
		jdbcTemplate.update("delete from persons where id=10");
	}

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

}
