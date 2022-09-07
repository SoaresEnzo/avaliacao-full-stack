import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ErrorManagerService {

  hasError= false;

  constructor() { }

  setError() {
    this.hasError = true;
    setTimeout(()=>{
      this.hasError = false;
    }, 5000)
  }
}
