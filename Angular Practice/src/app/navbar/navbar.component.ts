import { Component } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html'
})
export class NavbarComponent {

  form: any = {
    user: ''

  };



  ngOnInit() {

    this.form.user = null;
    let data = localStorage.getItem("user");

    if (data) {
      this.form.user = JSON.parse(data);
    }

  }
}
