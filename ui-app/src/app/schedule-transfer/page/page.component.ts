import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms'
import { IScheduleTransferRequest } from 'src/app/shared/models/scheduleTransfer.model';
import { HttpService } from 'src/app/shared/services/http.service';
import { TransferService } from 'src/app/shared/services/transfer.service';
import {minTwoDigits} from 'src/app/shared/functions';

@Component({
  selector: 'app-page',
  templateUrl: './page.component.html',
  styleUrls: ['./page.component.css']
})
export class PageComponent implements OnInit {
  form = new FormGroup({
    origin: new FormControl("", [Validators.required]),
    destination: new FormControl("", [Validators.required]),
    value: new FormControl(0.00, [Validators.required]),
    scheduledDate: new FormControl("", [Validators.required])
  })
  minDate = new Date();
  success = false;
  fail = false;
  failMessage = "";
  constructor(private http: TransferService) { }

  ngOnInit(): void {
  }

  formHandler() {
    if (this.form.valid) {
      const today = new Date();
      const parsedToday =  today.getFullYear()+ '-'+ minTwoDigits(today.getMonth()+1)  + '-' + minTwoDigits(today.getDate());

      console.log(this.form.get("value")!.value,)
      const body: IScheduleTransferRequest = {
        originAccount: this.form.get("origin")!.value,
        destinationAccount: this.form.get("destination")!.value,
        value: this.form.get("value")!.value,
        requestedDate: parsedToday,
        scheduledDate: this.form.get("scheduledDate")!.value
      }

      console.log(body)
      const request = this.http.scheduleTransfer(body);
      request.subscribe(response => {
        if (response.status == 201) {
          this.success = true;
          this.form.reset();
        } else {
          this.fail = true;
          this.failMessage = "Houve um erro ao agendar sua transferência"
        }
      })
    } else {
      this.success = false;
      this.fail = true;
      this.failMessage = "Preencha todos os campos para agendar sua transferência"
    }
  }
}
