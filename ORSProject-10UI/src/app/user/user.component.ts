import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BaseCtl } from '../base.component';
import { ServiceLocatorService } from '../service-locator.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html'
})
export class UserComponent extends BaseCtl {

  constructor(public override serviceLocator: ServiceLocatorService, public override route: ActivatedRoute) {
    super(serviceLocator.endpoints.USER, serviceLocator, route);
  }

}
