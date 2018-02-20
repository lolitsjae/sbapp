import { Component, Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})



@Injectable()
export class AppComponent {
  title = 'Student DB';  
}
