import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PageComponent } from './page/page.component';
import { Route, RouterModule } from '@angular/router';
import { MatButtonModule } from '@angular/material/button';

const routes: Route[] = [{
  path:"",
  component: PageComponent
}]

@NgModule({
  declarations: [
    PageComponent
  ],
  imports: [
    CommonModule,
    MatButtonModule,
    RouterModule.forChild(routes)
  ]
})
export class LandingPageModule { }
