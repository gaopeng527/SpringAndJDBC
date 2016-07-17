package gao.spring.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import gao.spring.po.Person;
/**
 * 将查询出的结果转换为java对象
 * @author DELL
 *
 */
public class PersonRowMapper implements RowMapper<Person> {

	@Override
	public Person mapRow(ResultSet resultSet, int index) throws SQLException {
		Person person = new Person(resultSet.getString("name"));
		person.setId(resultSet.getInt("id"));
		return person;
	}

}
