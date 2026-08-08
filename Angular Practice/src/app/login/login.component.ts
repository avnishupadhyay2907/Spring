import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { HttpServiceService } from '../http-service.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html'
})
export class LoginComponent {

  endpoint = "http://localhost:8080/LoginCtl/signIn";

  constructor(private router: Router, private httpService: HttpServiceService) { }

  form: any = {
    data: {},
    errorMsg: "",
    successMsg: "",
    inputError: {},
  }

  signIn() {
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
        this.router.navigate(['/welcome']);
      }
    })


  }

  signUp() {
    this.router.navigate(['/signup']);
  }
}