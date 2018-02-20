package studentz.service;

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
				System.out.println(select.toString());
				return studentrepo.addStudent(select);
				}
		}
	}
	
	public List<Student> getAll(){
		return studentrepo.getAll();
	}
	
	public String getStudent(String studId, HttpServletResponse rep) {
		if(studentrepo.validId(studId, rep)) {
			rep.setStatus(404);
			System.out.println("There is no such student");
			return "There is no such student";
		}
		else {
			return studentrepo.getStudent(studId);
		}
	}
	
	
	public String updateStudent(String firstName, String lastName, String studId, HttpServletResponse rep) {
		if(studentrepo.validId(studId, rep)) { //there isn't a student to be updated
			rep.setStatus(404);
			System.out.println("There is no such student");
			return "There is no such student";
		}
		else { //the student exists and can be updated
			if(firstName.length() != 0 && lastName.length() != 0) { //updated fields cannot be empty!
				return studentrepo.updateStudent(firstName, lastName, studId);
			}
			else {
				System.out.println("Please make sure you've inputted all the correct field");
				return "Please make sure you've inputted all the correct field";
			}
		}
	}
	
	public String deleteStudent(String studId, HttpServletResponse rep) {
		if(studentrepo.validId(studId, rep)) { //student must exist or cannot be deleted
			rep.setStatus(404);
			System.out.println("There is no such student");
			return "There is no such student";
		}
		else {
			return studentrepo.deleteStudent(studId);
		}
	}
	
	public String deleteAll() {
		return studentrepo.deleteAll();
	}

}
