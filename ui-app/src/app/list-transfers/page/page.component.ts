import { CurrencyPipe, DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
import { ITransfer } from 'src/app/shared/models/transfer.model';
import { TransferService } from 'src/app/shared/services/transfer.service';

@Component({
  selector: 'app-page',
  templateUrl: './page.component.html',
  styleUrls: ['./page.component.css']
})
export class PageComponent implements OnInit {
  displayedColumns: string[] = ['originAccount', 'destinationAccount', 'value', 'requestedDate', 'scheduledDate', 'finalValue', 'fee'];
  transfers: ITransfer[] = [];
  page = 0;
  pageSize = 20;
  length = 0;

  constructor(private transferService: TransferService, private datePipe: DatePipe, private currencyPipe: CurrencyPipe) { }

  ngOnInit(): void {
    this.refreshTransfers()
  }

  refreshTransfers() {
    this.transferService.getAllTransfersPaged(this.page, this.pageSize).subscribe((response) => {
      this.transfers = response.content;
      this.page = response.pageable.pageNumber;
      this.pageSize = response.pageable.pageSize;
      this.length = response.totalElements
      this.transfers.map((transfer)=>{
        transfer.scheduledDate = this.datePipe.transform(transfer.scheduledDate, "dd/MM/yyyy")!
        transfer.requestedDate = this.datePipe.transform(transfer.requestedDate, "dd/MM/yyyy")!
        transfer.fee = this.currencyPipe.transform(transfer.fee, 'USD')!
        transfer.value = this.currencyPipe.transform(transfer.value, 'USD')!
        transfer.finalValue = this.currencyPipe.transform(transfer.finalValue, 'USD')!
      })
    });
  }

  paginate(event: PageEvent) {
    this.page = event.pageIndex;
    this.pageSize = event.pageSize;
    console.log(event)
    this.refreshTransfers()
  }
}
