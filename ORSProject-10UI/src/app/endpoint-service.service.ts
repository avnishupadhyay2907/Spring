import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EndpointServiceService {

  constructor() { }

  public SERVER_URL = 'http://localhost:8080';

  public USER = this.SERVER_URL + '/UserCtl';
  public ROLE = this.SERVER_URL + "/RoleCtl";
  public COLLEGE = this.SERVER_URL + "/CollegeCtl";
  public MARKSHEET = this.SERVER_URL + "/MarksheetCtl";
  public STUDENT = this.SERVER_URL + "/StudentCtl";
  public SUBJECT = this.SERVER_URL + "/SubjectCtl";
  public COURSE = this.SERVER_URL + "/CourseCtl";
  public TIMETABLE = this.SERVER_URL + "/TimeTableCtl";
  public FACULTY = this.SERVER_URL + "/FacultyCtl";
}
