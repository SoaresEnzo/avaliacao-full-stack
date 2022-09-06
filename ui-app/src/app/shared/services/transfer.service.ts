import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { IScheduleTransferRequest } from "../models/scheduleTransfer.model";
import { HttpService } from "./http.service";

@Injectable({
    providedIn: "root"
})
export class TransferService {
    url = "http://localhost:8080/transfer"
    constructor(private httpClient: HttpService) {
    }

    getAllTransfers(page: number, size:number) {
        return this.httpClient.get(this.url);
      }

    scheduleTransfer(req: IScheduleTransferRequest) {
        return this.httpClient.post(this.url, JSON.stringify(req));
      }
}