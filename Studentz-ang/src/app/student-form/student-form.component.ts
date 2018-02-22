import { Component, OnInit } from '@angular/core';
import { Student } from '../student';
import { Observable } from 'rxjs/Observable';
import { StudentService } from '../student.service';
import { Router } from '@angular/router';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';





@Component({
  selector: 'app-student-form',
  templateUrl: './student-form.component.html',
  styleUrls: ['./student-form.component.css']
})
export class StudentFormComponent implements OnInit {

  route = '/dd'

  constructor(private studServ: StudentService, private router: Router) { }

  students: Student[];
  student: Student;
  

	func = ['addStudent', 'getStudent', 'getAll', 'deleteStudent', 'deleteAll', 'updateStudent'];

	
    changeHandler(meth: HTMLInputElement, header: HTMLInputElement, studId: HTMLInputElement, firstName: HTMLInputElement, lastName: HTMLInputElement) {
      if (meth.value === 'addStudent') {
        this.studServ.addStudent(header.value, firstName.value, lastName.value, studId.value).subscribe();
		  }
      else if (meth.value === 'getStudent') {
        this.router.navigate(['student-detail', {header:header.value, studId: studId.value}]);
		  }
      else if (meth.value === 'getAll') {
        this.router.navigate(['student-list', { header: header.value }]);
      }
      else if (meth.value === 'deleteStudent') {
        this.studServ.deleteStudent(header.value, studId.value).subscribe();
		  }
      else if (meth.value === 'deleteAll') {
        this.studServ.deleteAll(header.value).subscribe();
		  }
      else {
        this.studServ.updateStudent(header.value, firstName.value, lastName.value, studId.value).subscribe();
		  }
    }


    ngOnInit() {
    }

 	
	
	
}
