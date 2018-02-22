package studentz.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studentz.dao.StudentRepo;
import studentz.model.Student;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	public StudentRepo studentrepo;
	
	public String addStudent(String firstName, String lastName, String studId, HttpServletResponse rep) {
		if(!studentrepo.validIdAdd(studId, rep)) { //there is already a student with that ID
			System.out.println("A student with this ID already exists");
			return "A student with this ID already exists";
		}
		else { //new student
			if(firstName.length() == 0 || lastName.length() == 0 || studId.length() == 0) { //empty field
				System.out.println("Please make sure you've inputted all the correct fields");
				return "Please make sure you've inputted all the correct fields";
			}
			else { //create the new student
				Student select = new Student(firstName, lastName, studId);
				return studentrepo.addStudent(select);
				}
		}
	}
	
	public List<Student> getAll(){
		return studentrepo.getAll();
	}
	
	
	//issue here because regardless of having no value, still does getstudent so passing null list atm
	
	public List<Student> getStudent(String studId, HttpServletResponse rep) { 
//	public String getStudent(String studId, HttpServletResponse rep) { 
//		studentrepo.validId(studId, rep);
//		return studentrepo.getStudent(studId);
		List<Student> empty = new ArrayList<Student>();
			if(!studentrepo.validId(studId, rep)) { 
				return studentrepo.getStudent(studId);
			}
			else {
				return empty;
			}
	}
	
	
	public String updateStudent(String firstName, String lastName, String studId, HttpServletResponse rep) {
		if(!studentrepo.validId(studId, rep)){ //the student exists and can be updated
			if(firstName.length() != 0 && lastName.length() != 0) { //updated fields cannot be empty!
				return studentrepo.updateStudent(firstName, lastName, studId);
			}
			else {
				System.out.println("Please make sure you've inputted all the correct field");
				return "Please make sure you've inputted all the correct field";
			}
		}
		return "There is no such student";
	}
	
	public String deleteStudent(String studId, HttpServletResponse rep) {
		if(!studentrepo.validId(studId, rep)) { 
			return studentrepo.deleteStudent(studId);
		}
		return "done with deleteStudent for now";
	}
	
	public String deleteAll() {
		return studentrepo.deleteAll();
	}

}
