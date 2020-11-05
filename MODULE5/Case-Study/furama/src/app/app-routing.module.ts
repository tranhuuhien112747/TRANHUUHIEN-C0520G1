import {NgModule} from '@angular/core';
import {NgxPaginationModule} from 'ngx-pagination';
import {CommonModule} from '@angular/common';
import {MaterialModule} from './material.module';
import {RouterModule, Routes} from '@angular/router';
import {Ng2SearchPipeModule} from 'ng2-search-filter';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import {HomePageComponent} from './home-page/home-page.component';
import {PageNotFoundComponent} from './page-not-found/page-not-found.component';

import {CustomerListComponent} from './customer/customer-list/customer-list.component';
import {CustomerAddComponent} from './customer/customer-add/customer-add.component';

import {EmployeeListComponent} from './employee/employee-list/employee-list.component';
import {EmployeeAddNewComponent} from './employee/employee-add-new/employee-add-new.component';
import {EmployyeeDeleteComponent} from './employee/employyee-delete/employyee-delete.component';
import {EmployeEditComponent} from './employee/employe-edit/employe-edit.component';
import {EmployeeViewDetailComponent} from './employee/employee-view-detail/employee-view-detail.component';
import { CustomerEditComponent } from './customer/customer-edit/customer-edit.component';
import { CustomerDeleteComponent } from './customer/customer-delete/customer-delete.component';
import { CustomerViewDetailComponent } from './customer/customer-view-detail/customer-view-detail.component';
import {OrderModule} from 'ngx-order-pipe';

const routes: Routes = [
  {path: '', component: HomePageComponent},
  {path: 'customer', component: CustomerListComponent},
  {path: 'customer-create', component: CustomerAddComponent},
  {path: 'employee', component: EmployeeListComponent},
  {path: 'employee-create', component: EmployeeAddNewComponent},
  {path: 'employee-edit/:id', component: EmployeEditComponent},


  {path: '**', component: PageNotFoundComponent},
];

@NgModule({
  declarations: [HomePageComponent,
    PageNotFoundComponent,
    CustomerListComponent,
    EmployeeListComponent,
    EmployeeAddNewComponent,
    EmployyeeDeleteComponent,
    EmployeEditComponent,
    EmployeeViewDetailComponent,
    CustomerAddComponent,
    CustomerEditComponent,
    CustomerDeleteComponent,
    CustomerViewDetailComponent,
  ],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes),
    NgxPaginationModule,
    Ng2SearchPipeModule,
    FormsModule,
    ReactiveFormsModule,
    MaterialModule,
    OrderModule
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
