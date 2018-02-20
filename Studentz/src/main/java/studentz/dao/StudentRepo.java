package studentz.dao;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import studentz.model.Student;


@Component
public interface StudentRepo{ 
	public Student findOne(String studId);
	public boolean validIdAdd(String studId, HttpServletResponse rep) throws NullPointerException; 
	public String addStudent(Student student);
	public boolean validId(String studId, HttpServletResponse rep) throws NullPointerException;
	public List<Student> getAll();
	public String getStudent(String studId);
	public String deleteStudent(String studId);
	public String updateStudent(String firstName, String lastName, String studId);
	public String deleteAll();
}
