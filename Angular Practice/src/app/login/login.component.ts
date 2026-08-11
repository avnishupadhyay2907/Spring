import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { HttpServiceService } from '../http-service.service';
import { ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html'
})
export class LoginComponent {

  endpoint = "http://localhost:8080/LoginCtl/signIn";

  constructor(private router: Router, private httpService: HttpServiceService, private activatedRoute: ActivatedRoute) {
    this.activatedRoute.queryParams.subscribe(params => {
      if (params['message']) {
        this.form.successMsg = params['message'];
      }
    });

  }

  form: any = {
    data: {},
    errorMsg: "",
    successMsg: "",
    inputError: {},
  }

  signIn() {

    this.form.errorMsg = ''
    this.form.successMsg = ''
    this.form.inputerror = {}

    let self = this;
    this.httpService.post(this.endpoint, this.form.data, (response: any) => {
      console.log("response", response);

      if (response.success == false && response.result.inputerror != null) {
        self.form.inputError = response.result.inputerror;
      }
      if (response.success == false && response.result.message) {
        self.form.errorMsg = response.result.message;
      }
      if (response.success == true) {
        self.form.successMsg = response.result.message;

        localStorage.setItem('firstName', response.result.data.firstName);
        localStorage.setItem('roleName', response.result.data.roleName);
        localStorage.setItem('id', response.result.data.id);
        this.router.navigate(['/welcome']);
      }
    })


  }

  signUp() {
    this.router.navigate(['/signup']);
  }
}