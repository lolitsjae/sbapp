import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { StudentFormComponent } from '../student-form/student-form.component'


@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {

  constructor(public router: Router) { }

  ngOnInit() {
  }

  showForm() {
    this.router.navigate(['student-form']);
  }

}
