import { Component } from '@angular/core';
import { ErrorManagerService } from './error-manager.service';
import { ErrorCatchingInterceptor } from './interceptors/error-catching.interceptor';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ui-app';

  hasError = false;

  constructor(public error: ErrorManagerService) {
  }
}
