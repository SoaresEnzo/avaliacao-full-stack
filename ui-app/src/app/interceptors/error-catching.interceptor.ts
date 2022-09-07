import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
  HttpErrorResponse
} from '@angular/common/http';
import { catchError, map, Observable, throwError } from 'rxjs';
import { ErrorManagerService } from '../error-manager.service';

@Injectable()
export class ErrorCatchingInterceptor implements HttpInterceptor {
  constructor(private errorService: ErrorManagerService) { }

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    return next.handle(request).pipe(map(res => {
      console.log("Passed through the interceptor in response");
      return res
  }),
  catchError((error: HttpErrorResponse) => {
      let errorMsg = '';
      if (error.error instanceof ErrorEvent) {
          console.log('This is client side error');
          errorMsg = `Error: ${error.error.message}`;
      } else {
          console.log('This is server side error');
          errorMsg = `Error Code: ${error.status},  Message: ${error.message}`;
      }
      this.errorService.setError();
      return throwError(errorMsg);
  })
)
  }
}
