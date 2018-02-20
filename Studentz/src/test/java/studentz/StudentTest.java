package studentz;


import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import studentz.controller.StudentRetriever;
import studentz.model.Student;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = StudentApplication.class)

public class StudentTest {
	
	@Autowired
	StudentRetriever dog = new StudentRetriever();
	
	
	
		String addOne;
		String deleteAll;
		Iterable<Student> getAll;
		String getOne;
		String updateOne;
		String deleteOne;
		
		@Autowired
		HttpServletResponse rep;
		
		@Test
		public void testtest() throws NullPointerException, SQLException {
		System.out.println("testing!");
		
		
		
		//test the header?
		
		
		//(c) ADD user
		addOne = dog.addStudent("Josh", "Lee", "jhl2274", "hello", rep); 
/*---*/	assertEquals("The student has been added", addOne);
		addOne = dog.addStudent("Andrew", "Dao", "ahd343", "hello", rep);
/*---*/	assertEquals("The student has been added", addOne);
		
		//(c - 1) ADD a user that already exists (same studId)
		String userAlreadyExists = dog.addStudent("John", "Berry", "jhl2274", "hello", rep);
/*---*/	assertEquals("A student with this ID already exists", userAlreadyExists);
		
		//(c - 2) ADD but missing a field
		String missingField = dog.addStudent("Frank", "Gomez", "", "hello", rep);
/*---*/	assertEquals("Please make sure you've inputted all the correct fields", missingField);

		//(a)GETALL students
		getAll = dog.getAll("hello");
/*---*/	assertEquals("[Student(studId=jhl2274, firstName=Josh, lastName=Lee), "
		+ "Student(studId=ahd343, firstName=Andrew, lastName=Dao)]", getAll.toString());

		//(b) GET student info
		getOne = dog.getStudent("jhl2274", "hello", rep); //get single user
/*---*/	assertEquals("Josh Lee jhl2274", getOne);

		//(b - 1) GET a user that doesn't exist
		getOne = dog.getStudent("de2341", "hello", rep);
/*---*/	assertEquals("There is no such student", getOne);
				
		//(d) UPDATE student info
		updateOne = dog.updateStudent("jhl2274", "Jae", "Lee", "hello", rep);
/*---*/	assertEquals("The student has been updated", updateOne);

		//check to make sure the student has been updated
		getOne = dog.getStudent("jhl2274", "hello", rep);
/*---*/	assertEquals(getOne, "Jae Lee jhl2274");
		
		//(d - 1) try to UPDATE a student that doesn't exist
		updateOne = dog.updateStudent("jhl227", "Jae", "Lee", "hello", rep);
/*---*/	assertEquals("There is no such student", updateOne);
		
		
		//(e)DELETE a specific student
		deleteOne = dog.deleteStudent("jhl2274", "hello", rep);
/*---*/	assertEquals("Student(studId=jhl2274, firstName=Jae, lastName=Lee) has been deleted", deleteOne);

		//check after deletion
		getAll = dog.getAll("hello");
/*---*/	assertEquals("[Student(studId=ahd343, firstName=Andrew, lastName=Dao)]", getAll.toString());
		
		//(f) DELETE ALL students
		deleteAll = dog.deleteAll("hello");
/*---*/	assertEquals("Deleted all students", deleteAll);

		
		getAll = dog.getAll("hello");
/*---*/	assertEquals("[]", getAll.toString());
		

		
		
		
		
		

		
		
		
		
		
		
		

	}
	
	
	
}
