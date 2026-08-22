import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AuthServiceService } from './auth-service.service';
import { CollegeComponent } from './college/college.component';
import { EndpointServiceService } from './endpoint-service.service';
import { FooterComponent } from './footer/footer.component';
import { HttpServiceService } from './http-service.service';
import { NavbarComponent } from './navbar/navbar.component';
import { RoleComponent } from './role/role.component';
import { ServiceLocatorService } from './service-locator.service';
import { UserComponent } from './user/user.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { StudentComponent } from './student/student.component';
import { CourseComponent } from './course/course.component';
import { SubjectComponent } from './subject/subject.component';
import { TimetableComponent } from './timetable/timetable.component';
import { FacultyComponent } from './faculty/faculty.component';
import { RoleListComponent } from './role/role-list.component';
import { UserListComponent } from './user/user-list.component';
import { CollegeListComponent } from './college/college-list.component';
import { CourseListComponent } from './course/course-list.component';
import { FacultyListComponent } from './faculty/faculty-list.component';
import { StudentListComponent } from './student/student-list.component';
import { SubjectListComponent } from './subject/subject-list.component';
import { TimetableListComponent } from './timetable/timetable-list.component';
import { MarksheetComponent } from './marksheet/marksheet.component';
import { MarksheetListComponent } from './marksheet/marksheet-list.component';


@NgModule({
  declarations: [
    AppComponent,
    RoleComponent,
    UserComponent,
    CollegeComponent,
    NavbarComponent,
    WelcomeComponent,
    FooterComponent,
    StudentComponent,
    CourseComponent,
    SubjectComponent,
    TimetableComponent,
    FacultyComponent,
    RoleListComponent,
    UserListComponent,
    CollegeListComponent,
    CourseListComponent,
    FacultyListComponent,
    StudentListComponent,
    SubjectListComponent,
    TimetableListComponent,
    MarksheetComponent,
    MarksheetListComponent
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    HttpServiceService,
    EndpointServiceService,
    ServiceLocatorService,
    AuthServiceService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
