import { Component } from '@angular/core';
import { BaseCtl } from '../base.component';
import { ActivatedRoute } from '@angular/router';
import { ServiceLocatorService } from '../service-locator.service';
@Component({
  selector: 'app-student',
  templateUrl: './student.component.html'
})
export class StudentComponent extends BaseCtl {

  constructor(public override serviceLocator: ServiceLocatorService, public override route: ActivatedRoute) {
    super(serviceLocator.endpoints.STUDENT, serviceLocator, route);
  }

}
