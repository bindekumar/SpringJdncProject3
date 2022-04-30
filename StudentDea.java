package com.binde.core.jdbc;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class StudentDea implements Test {
	private JdbcTemplate jdbcTemplet;

	public JdbcTemplate getJdbcTemplet() {
		return jdbcTemplet;
	}

	public void setJdbcTemplet(JdbcTemplate jdbcTemplet) {
		this.jdbcTemplet = jdbcTemplet;
	}

	public Integer addRecord(Student student) {
		String query = "insert into Student values(?,?,?)";

		return jdbcTemplet.update(query, student.getId(), student.getName(), student.getCity());
	}

	public Integer updateRecord(Student student) {
		String query="update Student set name=?,city=? where id=?";
		return jdbcTemplet.update(query,student.getName(),student.getCity(),student.getId());
	}
	public Integer deleteRecord(Student student) {
		String query="delete from Student where id=?";
		return jdbcTemplet.update(query,student.getId());
	}
	public Student getStudent(Integer studentId) {
		//Select Single student query
		RowMapper<Student> rowMapper=(RowMapper<Student>) new RowMapperImplementation();
		String query="select * from student where id=?";
		return jdbcTemplet.queryForObject(query,rowMapper,studentId);
	}

	@Override
	public List<Student> getAllStudent() {
		//Selected Multiple Student
		String query="select * from student";
		RowMapper<Student> rowMapper=(RowMapper<Student>) new RowMapperImplementation();
		return jdbcTemplet.query(query,rowMapper);
	}
}
