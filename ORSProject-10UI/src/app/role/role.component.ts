import { Component } from '@angular/core';
import { BaseCtl } from '../base.component';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-role',
  templateUrl: './role.component.html'
})
export class RoleComponent extends BaseCtl {

  constructor(public override serviceLocator: ServiceLocatorService, public override route: ActivatedRoute) {
    super(serviceLocator.endpoints.ROLE, serviceLocator, route);
  }
  
}
