import { Component, OnInit } from '@angular/core';
import { Student } from '../student';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { StudentService } from '../student.service';

@Component({
  selector: 'app-student-form',
  templateUrl: './student-form.component.html',
  styleUrls: ['./student-form.component.css']
})
export class StudentFormComponent implements OnInit {
  

  constructor(private studServ: StudentService) { }

  ngOnInit() {
  }

	func = ['addStudent', 'getStudent', 'getAll', 'deleteStudent', 'deleteAll', 'updateStudent'];
	

	
	changeHandler(meth: HTMLInputElement, header: HTMLInputElement, studId: HTMLInputElement, 
	firstName: HTMLInputElement, lastName: HTMLInputElement){
		if(meth.value === 'addStudent'){
			return this.studServ.addStudent(header.value, firstName.value, lastName.value, studId.value).subscribe();
		}
		else if(meth.value === 'getStudent'){
			return this.studServ.getStudent(header.value, studId.value).subscribe();
		}
		else if(meth.value === 'getAll'){
			return this.studServ.getAll(header.value).subscribe();
		}
		else if(meth.value === 'deleteStudent'){
			return this.studServ.deleteStudent(header.value, studId.value).subscribe();
		}
		else if(meth.value === 'deleteAll'){
			return this.studServ.deleteAll(header.value).subscribe();
		}
		else{
			return this.studServ.updateStudent(header.value, firstName.value, lastName.value, studId.value).subscribe();
		}
	}
	
	submitted = false;

 	onSubmit() { this.submitted = true;}
 	
	
	
}
