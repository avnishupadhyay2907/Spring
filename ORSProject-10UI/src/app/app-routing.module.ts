import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CollegeListComponent } from './college/college-list.component';
import { CollegeComponent } from './college/college.component';
import { CourseListComponent } from './course/course-list.component';
import { CourseComponent } from './course/course.component';
import { FacultyListComponent } from './faculty/faculty-list.component';
import { FacultyComponent } from './faculty/faculty.component';
import { FooterComponent } from './footer/footer.component';
import { NavbarComponent } from './navbar/navbar.component';
import { RoleListComponent } from './role/role-list.component';
import { RoleComponent } from './role/role.component';
import { StudentListComponent } from './student/student-list.component';
import { StudentComponent } from './student/student.component';
import { SubjectListComponent } from './subject/subject-list.component';
import { SubjectComponent } from './subject/subject.component';
import { TimetableListComponent } from './timetable/timetable-list.component';
import { TimetableComponent } from './timetable/timetable.component';
import { UserListComponent } from './user/user-list.component';
import { UserComponent } from './user/user.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { MarksheetComponent } from './marksheet/marksheet.component';
import { MarksheetListComponent } from './marksheet/marksheet-list.component';

const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    redirectTo: 'welcome'
  },
  {
    path: 'welcome',
    component: WelcomeComponent
  },
  {
    path: 'navbar',
    component: NavbarComponent
  },
  {
    path: 'footer',
    component: FooterComponent
  },
  {
    path: 'role',
    component: RoleComponent
  },
  {
    path: 'roleList',
    component: RoleListComponent
  },
  {
    path: 'user',
    component: UserComponent
  },
  {
    path: 'userList',
    component: UserListComponent
  },
  {
    path: 'college',
    component: CollegeComponent
  },
  {
    path: 'collegeList',
    component: CollegeListComponent
  },
  {
    path: 'student',
    component: StudentComponent
  },
  {
    path: 'studentList',
    component: StudentListComponent
  },
  {
    path: 'course',
    component: CourseComponent
  },
  {
    path: 'courseList',
    component: CourseListComponent
  },
  {
    path: 'subject',
    component: SubjectComponent
  },
  {
    path: 'subjectList',
    component: SubjectListComponent
  },
  {
    path: 'timetable',
    component: TimetableComponent
  },
  {
    path: 'timetableList',
    component: TimetableListComponent
  },
  {
    path: 'faculty',
    component: FacultyComponent
  },
  {
    path: 'facultyList',
    component: FacultyListComponent
  },
  {
    path: 'marksheet',
    component: MarksheetComponent
  },
  {
    path: 'marksheetList',
    component: MarksheetListComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
