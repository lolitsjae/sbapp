import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { StudentListComponent } from './student-list/student-list.component'
import { StudentFormComponent } from './student-form/student-form.component'
import { StudentDetailComponent } from './student-detail/student-detail.component'

const routes: Routes = [
  {
    path: 'student-form', component: StudentFormComponent
  },
  {
    path: 'student-detail', component: StudentDetailComponent
  },
  {
    path: 'student-list', component: StudentListComponent
  },
  {
    path: 'home', redirectTo: '/'
  }
]

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})

export class AppRoutingModule {

  
}
