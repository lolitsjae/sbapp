import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { URLSearchParams } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { Student } from './student';



@Injectable()
export class StudentService {

  constructor(private http: HttpClient) { }
  headers = new Headers();
  private urlz = 'http://localhost:4200';
  
  public addStudent(Authentication, firstName, lastName, studId): Observable<any>{
  	let headers = new HttpHeaders({'Authentication':Authentication});
  	let params = new HttpParams().set('firstName', firstName).set('lastName', lastName).set('studId',studId);
 	return this.http.post(this.urlz+ '/addStudent', "", {params: params, headers: headers});
  }
  
  public getStudent(Authentication, studId){
  	let headers = new HttpHeaders({'Authentication':Authentication});
  	let params = new HttpParams().set('studId',studId);
  	return this.http.get(this.urlz+ '/getStudent', {headers: headers, params: params});
  }
  public getAll(Authentication){
  	let headers = new HttpHeaders({'Authentication':Authentication});
  	return this.http.get(this.urlz+ '/getAll', {headers: headers});
  }
  public deleteStudent(Authentication, studId){
  	let headers = new HttpHeaders({'Authentication':Authentication});
  	let params = new HttpParams().set('studId',studId);
  	return this.http.post(this.urlz+ '/deleteStudent', "", {params: params, headers: headers});
  }
  public deleteAll(Authentication){
  	let headers = new HttpHeaders({'Authentication':Authentication});
  	return this.http.delete(this.urlz+ '/deleteAll', {headers: headers});
  }
  public updateStudent(Authentication, firstName, lastName, studId){
  	let headers = new HttpHeaders({'Authentication':Authentication});
  	let params = new HttpParams().set('studId',studId).set('firstName', firstName).set('lastName', lastName);
  	return this.http.put(this.urlz+ '/updateStudent', "", {params: params, headers: headers});
  }

}
