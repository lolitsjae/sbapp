import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { StudentService } from '../student.service';
import { Student } from '../student';
import { ActivatedRoute } from '@angular/router';



@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {

  head: string;
  students: Student[];
  private sub: any;
  selectedStudent: string;

  constructor(private route: ActivatedRoute, private studServ: StudentService, private router: Router) { }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => { this.head = params['header']});
    this.studServ.getAll(this.head).then(students => this.students = students);
  }

  pickStudent(header: HTMLInputElement, studId: string) {
    this.router.navigate(['student-detail', { header: header.value, studId: studId }]);
  }

}
