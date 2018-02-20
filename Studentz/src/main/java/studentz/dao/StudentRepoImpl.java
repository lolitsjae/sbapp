package studentz.dao;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import studentz.model.Student;

@Component
public class StudentRepoImpl implements StudentRepo{
	
	@Autowired JdbcTemplate jdbcTemplate;
	
	public Student findOne(String studId) {
		try{
			return jdbcTemplate.queryForObject("SELECT studentid AS studId, last AS lastName, first AS firstName"
					+ " from studenttable where studentid = ?", new Object[] {studId}, 
					new BeanPropertyRowMapper<Student>(Student.class)); 
		}
		catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	
	//check validity of ID for adding a student; if the student doesn't exist, their select value will be null, so we can return true
	public boolean validIdAdd(String studId, HttpServletResponse rep) throws NullPointerException{
		Student select = findOne(studId);
		try {
				if(select!=null) {
					throw new NullPointerException();
				}
				else {			
					return true;					
				}
		}
		catch (NullPointerException e){	
			rep.setStatus(404);
			return false;
		}
	}
	
	//check validity of ID for everything other than add; if the student doesn't exist, their select value will be null, so we can return false
	public boolean validId(String studId, HttpServletResponse rep) throws NullPointerException{
		Student select = findOne(studId);
		try {
				if(select!=null) {
					return false;
				}
				else {				
					throw new NullPointerException();					
				}
		}
		catch (NullPointerException e){	
			rep.setStatus(404);
			return true;
		}
	}

	public String addStudent(Student student) {
		jdbcTemplate.update("INSERT INTO studenttable (studentid, first, last) VALUES(?, ?, ?)",
			         student.getStudId(), student.getFirstName(), student.getLastName());
		System.out.println("The student has been added");
		return "The student has been added";
	}
	
	public List<Student> getAll(){
		List<Student> estudiante  = jdbcTemplate.query("select studentid AS studId, first AS firstName, last AS lastName FROM studenttable",
				new BeanPropertyRowMapper<Student>(Student.class));
		System.out.println(estudiante.toString());
		return estudiante;
	}
	
	
	public String getStudent(String studId) {
		Student select = findOne(studId);
		System.out.println(select.toString());
		return select.toString();
	}
	
	public String updateStudent(String firstName, String lastName, String studId) {
		jdbcTemplate.update("UPDATE studenttable SET first = ?, last = ? WHERE studentid = ?", 
				new Object[] {firstName, lastName, studId});
		Student select = findOne(studId);
		System.out.println("The student has been updated to " + select);
		return select.toString();
	}
	
	public String deleteStudent(String studId) {
		Student select = findOne(studId);
		jdbcTemplate.update("DELETE FROM studenttable WHERE studentid = ? ", new Object[]{studId});
		System.out.println(select.toString() + " has been deleted");
		return select.toString() + " has been deleted";
	}
	
	public String deleteAll() {
		jdbcTemplate.update("DELETE FROM studenttable");
		System.out.println("Deleted all students");
		return "Deleted all students";
	}

}
