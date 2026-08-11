import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { HttpServiceService } from '../http-service.service';
@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html'
})
export class NavbarComponent {

  endpoint = "http://localhost:8080/LoginCtl/logout";

  form: any = {
    data: {},
    errorMsg: "",
    successMsg: "",
    inputError: {}
  };

  constructor(private router: Router, private httpService: HttpServiceService) { }

  isLogin() {

    let check = localStorage.getItem('firstName');

    if (check != null && check != undefined && check != '') {

      this.form.data.firstName = check;
      this.form.data.roleName = localStorage.getItem('roleName');
      this.form.data.id = localStorage.getItem('id');

      return true;

    }

    return false;
  }

  logout() {

    localStorage.clear();

    this.httpService.get(this.endpoint, (response: any) => {
      console.log('response', response)
      this.router.navigateByUrl('/login?message=User Logout Successfully');
    });

  }

}
