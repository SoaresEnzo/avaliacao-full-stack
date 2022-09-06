import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Route } from '@angular/router';

import { AppComponent } from './app.component';

const routes: Route[] = [
    {
        path: "",
        loadChildren: () => import('./landing-page/landing-page.module').then((m) => m.LandingPageModule)
    },
    {
        path: "transfers",
        loadChildren: () => import('./list-transfers/list-transfers.module').then((m) => m.ListTransfersModule)
    },
    {
        path: "schedule",
        loadChildren: () => import('./schedule-transfer/schedule-transfer.module').then((m) => m.ScheduleTransferModule)
    }
]

@NgModule({
    declarations: [
    ],
    imports: [
        BrowserModule,
        RouterModule.forRoot(routes)
    ],
    exports: [
        RouterModule
    ],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppRoutingModule { }
