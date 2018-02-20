import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms'; 



import { AppComponent } from './app.component';
import { StudentFormComponent } from './student-form/student-form.component';
import { StudentService } from './student.service';




@NgModule({
  declarations: [
    AppComponent,
    StudentFormComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule
    ],
  providers: [StudentService], 
  bootstrap: [AppComponent]
})
export class AppModule { }
