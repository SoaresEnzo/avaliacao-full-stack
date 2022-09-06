import { NgModule } from '@angular/core';
import { CommonModule, CurrencyPipe, DatePipe } from '@angular/common';
import { PageComponent } from './page/page.component';
import { Route, RouterModule } from '@angular/router';
import { MatTableModule } from '@angular/material/table'
import { TransferService } from '../shared/services/transfer.service';
import { HttpClientModule } from '@angular/common/http';
import { HttpService } from '../shared/services/http.service';
const routes: Route[] = [{
  path: "",
  component: PageComponent
}]

@NgModule({
  declarations: [
    PageComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
    MatTableModule,
    HttpClientModule
  ],
  providers: [
    TransferService,
    HttpService,
    DatePipe,
    CurrencyPipe
  ]
})
export class ListTransfersModule { }
