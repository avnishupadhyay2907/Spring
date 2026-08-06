import { Component } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html'
})
export class LoginComponent {

  constructor(private router: Router) { }
  form: any = {
    error: "",
    successmsg: ""
  }

  signIn() {

    console.log(this.form.login);
    console.log(this.form.password);

    if (this.form.login == "uavnish2907@gmail.com" && this.form.password == "admin") {
      this.form.successmsg = "Login Successful";
      this.form.error = "";
      this.router.navigate(['/welcome']);
    } else {
      this.form.error = "Invalid Login or Password";
      this.form.successmsg = "";
    }

  }

  signUp() {
    this.router.navigate(['/signup']);
  }
}