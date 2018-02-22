package studentz.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;


import studentz.model.Student;
import studentz.service.StudentService;

@Controller
public class StudentRetriever{
	
	@Autowired
	public StudentService studentserviceimpl;

	//add a student
	@PostMapping(path="/addStudent")
	public @ResponseBody String addStudent(@RequestParam(value = "firstName") String firstName,
			@RequestParam(value = "lastName") String lastName,
			@RequestParam(value = "studId") String studId,
			@RequestHeader(value = "Authentication") String header,
			HttpServletResponse rep
			){		
		 return studentserviceimpl.addStudent(firstName, lastName, studId, rep); //StudentServiceImpl --> studentserviceimpl
	}	
	
	//get all on the database
	@GetMapping(path = "/getAll")
	public @ResponseBody List<Student> getAll(@RequestHeader(value = "Authentication") String header){
		return studentserviceimpl.getAll();
	}
	
	
	//get specific student on the database
	@GetMapping(path = "/getStudent")
	public @ResponseBody List<Student> getStudent(@RequestParam(value = "studId") String studId,
//	public @ResponseBody String getStudent(@RequestParam(value = "studId") String studId,

			@RequestHeader(value = "Authentication") String header,
			HttpServletResponse rep) {
		return studentserviceimpl.getStudent(studId, rep);
		
		
//		Gson gson = new Gson();
//		String json = gson.toJson(studentserviceimpl.getStudent(studId, rep));
//		return json;

	}
	
	//update student info except ID
	@PutMapping(path = "/updateStudent")
	public @ResponseBody String updateStudent(@RequestParam(value = "studId") String studId,
			@RequestParam(value = "firstName") String firstName,
			@RequestParam(value = "lastName") String lastName,
			@RequestHeader(value = "Authentication") String header,
			HttpServletResponse rep
			){
		return studentserviceimpl.updateStudent(firstName, lastName, studId, rep);
	}
	
	//delete all students
	@DeleteMapping(path = "/deleteAll")
	public @ResponseBody String deleteAll(@RequestHeader(value = "Authentication") String header) {
		return studentserviceimpl.deleteAll();
	}
	
	//delete specific student
	@PostMapping(path= "/deleteStudent")
	public @ResponseBody String deleteStudent(@RequestParam(value = "studId") String studId,
			@RequestHeader(value = "Authentication") String header,
			HttpServletResponse rep) {
		return studentserviceimpl.deleteStudent(studId, rep);
	}
	
	
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public @ResponseBody String handleMissingParams(MissingServletRequestParameterException ex, HttpServletResponse rep) {
		System.out.println("here?");
		rep.setStatus(400);
	    String name = ex.getParameterName();
	    return "Please input a " + name + " field!";
	}
	
	@ExceptionHandler(NullPointerException.class)
	public @ResponseBody String handleMissingParam(NullPointerException ex) {
	    return "Null";
	}
	

	
}
