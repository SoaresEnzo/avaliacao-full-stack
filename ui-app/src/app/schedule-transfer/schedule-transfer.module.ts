import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Route, RouterModule } from '@angular/router';
import { PageComponent } from './page/page.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatNativeDateModule } from '@angular/material/core';
import { MatInputModule } from '@angular/material/input';
import { NgxMaskModule } from 'ngx-mask';
import { MatButtonModule } from '@angular/material/button';
import { HttpService } from '../shared/services/http.service';
import { HttpClientModule } from '@angular/common/http';
import { TransferService } from '../shared/services/transfer.service';
const routes: Route[] = [{
  path: "",
  component: PageComponent
}]

@NgModule({
  declarations: [
    PageComponent
  ],
  imports: [
    MatButtonModule,
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    MatDatepickerModule,
    MatFormFieldModule,
    MatNativeDateModule, 
    HttpClientModule,
    MatInputModule,
    NgxMaskModule.forRoot(),
    RouterModule.forChild(routes)
  ], providers: [
    HttpService,
    TransferService
  ]
})
export class ScheduleTransferModule { }
