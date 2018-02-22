import { Component, Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { HttpClient } from '@angular/common/http';
import { Location } from '@angular/common';
import { Router } from '@angular/router';



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})


@Injectable()
export class AppComponent {
  title = 'Student DB';
  constructor(public location: Location, public router: Router) { }

  showForm() {
    this.router.navigate(['student-form']);
  }

  goBack() {
    this.location.back();
  }
}
