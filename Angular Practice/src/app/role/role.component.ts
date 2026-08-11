import { Component } from '@angular/core';
import { HttpServiceService } from '../http-service.service';
@Component({
  selector: 'app-role',
  templateUrl: './role.component.html'
})
export class RoleComponent {

  endpoint = "http://localhost:8080/RoleCtl/save";

  form: any = {
    data: {},
    errorMsg: "",
    successMsg: "",
    inputError: {}
  };

  constructor(private httpService: HttpServiceService) { }

  save() {
    this.form.errorMsg = "";
    this.form.successMsg = "";
    this.form.inputError = {};
    let self = this;

    this.httpService.post(this.endpoint, this.form.data, function (response: any) {
      // Handle the response
      console.log("response", response);
      if (response.success == false && response.result.inputerror != null) {
        self.form.inputError = response.result.inputerror;
      }
      if (response.success == false && response.result.message) {
        self.form.errorMsg = response.result.message;
      }
      if (response.success == true) {
        self.form.successMsg = response.result.message;
      }
    });
  }

}