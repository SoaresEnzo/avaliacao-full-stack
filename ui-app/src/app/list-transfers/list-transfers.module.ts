import { NgModule } from '@angular/core';
import { CommonModule, CurrencyPipe, DatePipe } from '@angular/common';
import { PageComponent } from './page/page.component';
import { Route, RouterModule } from '@angular/router';
import { MatTableModule } from '@angular/material/table'
import { TransferService } from '../shared/services/transfer.service';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { HttpService } from '../shared/services/http.service';
import { ErrorCatchingInterceptor } from '../interceptors/error-catching.interceptor';
import { MatPaginatorModule } from '@angular/material/paginator';
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
    MatPaginatorModule,
    HttpClientModule
  ],
  providers: [
    TransferService,
    HttpService,
    DatePipe,
    CurrencyPipe,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: ErrorCatchingInterceptor,
      multi: true
  }
  ]
})
export class ListTransfersModule { }
