import { Component } from '@angular/core';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html'
})
export class SignupComponent {

  form: any = {
    error: "",
    successmsg: ""

  }
  signUp() {
    console.log(this.form.login);
    console.log(this.form.password);
    console.log(this.form.firstName);
    console.log(this.form.lastName);
  }
}
