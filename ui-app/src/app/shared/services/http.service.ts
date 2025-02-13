import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { IPage } from '../models/pageable.model';
import { ITransfer } from '../models/transfer.model';
import { IScheduleTransferRequest } from '../models/scheduleTransfer.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HttpService {
  
  headers = new HttpHeaders({
    'Content-Type': 'application/json'
  })
  constructor(private http: HttpClient) { }

  get<T>(url: string):Observable<T> {
    return this.http.get<T>(url, {headers: this.headers});
  }

  post(url: string, body: any) {
    return this.http.post(url, body, {headers: this.headers, observe: 'response'})
  }
}
