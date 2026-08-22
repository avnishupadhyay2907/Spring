import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BaseCtl } from '../base.component';
import { ServiceLocatorService } from '../service-locator.service';

@Component({
  selector: 'app-subject',
  templateUrl: './subject.component.html'
})
export class SubjectComponent extends BaseCtl {

  constructor(public override serviceLocator: ServiceLocatorService, public override route: ActivatedRoute) {
    super(serviceLocator.endpoints.SUBJECT, serviceLocator, route);
  }
}
