package studentz.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import studentz.model.Student;

public interface StudentService {
	public String addStudent(String firstName, String lastName, String studId, HttpServletResponse rep);
	public List<Student> getAll();
	public List<Student> getStudent(String studId, HttpServletResponse rep);
//	public String getStudent(String studId, HttpServletResponse rep);
	public String updateStudent(String firstName, String lastName, String studId, HttpServletResponse rep);
	public String deleteStudent(String studId, HttpServletResponse rep);
	public String deleteAll();




}
