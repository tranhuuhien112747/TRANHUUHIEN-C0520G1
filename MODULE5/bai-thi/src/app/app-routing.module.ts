import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FormsModule} from '@angular/forms';
import {NgxPaginationModule} from 'ngx-pagination';
import {Ng2SearchPipeModule} from 'ng2-search-filter';
import {OrderModule} from 'ngx-order-pipe';
import {RouterModule, Routes} from '@angular/router';
import {MaterialModule} from './material.module';

const routes: Routes = [];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    FormsModule,
    NgxPaginationModule,
    Ng2SearchPipeModule,
    OrderModule,
    RouterModule.forRoot(routes),
    MaterialModule,
  ]
})
export class AppRoutingModule { }
