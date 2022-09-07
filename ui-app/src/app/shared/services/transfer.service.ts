import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { IPage } from "../models/pageable.model";
import { IScheduleTransferRequest } from "../models/scheduleTransfer.model";
import { ITransfer } from "../models/transfer.model";
import { HttpService } from "./http.service";

@Injectable({
  providedIn: "root"
})
export class TransferService {
  url = "http://localhost:8080/transfer"
  constructor(private httpClient: HttpService) {
  }

  getAllTransfersPaged(page: number, size: number): Observable<IPage<ITransfer>> {
    return this.httpClient.get<IPage<ITransfer>>(this.url + `?page=${page}&size=${size}`).pipe();
  }

  scheduleTransfer(req: IScheduleTransferRequest) {
    return this.httpClient.post(this.url, JSON.stringify(req));
  }

  getFee(value: number, scheduledDate: string): Observable<number> {
    return this.httpClient.get<number>(this.url + `/fee?scheduledDate=${scheduledDate}&value=${value}`).pipe();
  }
}