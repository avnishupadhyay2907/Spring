import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BaseCtl } from '../base.component';
import { ServiceLocatorService } from '../service-locator.service';

@Component({
  selector: 'app-timetable',
  templateUrl: './timetable.component.html'
})
export class TimetableComponent extends BaseCtl {

  constructor(public override serviceLocator: ServiceLocatorService, public override route: ActivatedRoute) {
    super(serviceLocator.endpoints.TIMETABLE, serviceLocator, route);
  }
}
