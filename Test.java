package com.binde.core.jdbc;

import java.util.List;

public interface Test {
	public Integer addRecord(Student student);
	public Integer updateRecord(Student student);
	public Integer deleteRecord(Student student);
	public Student getStudent(Integer studentId);
	public List<Student> getAllStudent();
}
