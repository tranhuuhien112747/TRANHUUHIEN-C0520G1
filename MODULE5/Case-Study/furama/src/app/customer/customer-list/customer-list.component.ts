import {Component, OnInit} from '@angular/core';
import {CustomerService} from '../../services/customer.service';
import {ActivatedRoute} from '@angular/router';
import {MatDialog} from '@angular/material/dialog';
import {CustomerDeleteComponent} from '../customer-delete/customer-delete.component';
import {CustomerViewDetailComponent} from '../customer-view-detail/customer-view-detail.component';
import {CustomerAddComponent} from '../customer-add/customer-add.component';
import {CustomerEditComponent} from '../customer-edit/customer-edit.component';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  public customerList;
  public p: any;
  public term: any;
  public key = 'id';
  public reverse = false;

  public messageCreate = '';
  public messageEdit = '';
  public messageDelete = '';

  constructor(
    public customerService: CustomerService,
    public route: ActivatedRoute,
    public dialog: MatDialog,
  ) {
  }

  ngOnInit(): void {
    this.customerService.getAllCustomer().subscribe(data => {
      this.customerList = data;
      this.sendAllMessage();
      console.log(this.customerList);
    });
  }

  sort(key) {
    console.log(this.customerList);
    this.key = key;
    this.reverse = !this.reverse;
  }

  sendAllMessage() {
    this.messageCreate = this.route.snapshot.queryParamMap.get('messageCreate');
    this.messageEdit = this.route.snapshot.queryParamMap.get('messageEdit');
    this.messageDelete = this.route.snapshot.queryParamMap.get('messageDelete');
  }

  openDialogDelete(customerId) {
    this.customerService.getCustomerById(customerId).subscribe(dataCustomer => {
      const dialogRef = this.dialog.open(CustomerDeleteComponent, {
        width: '550px',
        height: '240px',
        data: {dataC: dataCustomer},
        disableClose: true
      });

      dialogRef.afterClosed().subscribe(result => {
        console.log('The dialog was closed');
        this.ngOnInit();
      });
    });
  }

  openDialogView(customerId) {
    this.customerService.getCustomerById(customerId).subscribe(dataCustomer => {
      const dialogRef = this.dialog.open(CustomerViewDetailComponent, {
        width: '400px',
        height: '500px',
        data: {dataC: dataCustomer},
        disableClose: true
      });

      dialogRef.afterClosed().subscribe(result => {
        console.log('The dialog was closed');
        this.ngOnInit();
      });
    });
  }

  openAddNew() {
    const dialogRef = this.dialog.open(CustomerAddComponent, {
      width: '830px',
      height: '550px',
      disableClose: true
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      this.ngOnInit();
    });
  }

  openDialogEdit(customerId) {
    this.customerService.getCustomerById(customerId).subscribe(dataCustomer => {
      const dialogRef = this.dialog.open(CustomerEditComponent, {
        width: '800px',
        height: '490px',
        data: {dataC: dataCustomer.id},
        disableClose: true
      });
      console.log('data:' + dataCustomer.id);
      dialogRef.afterClosed().subscribe(result => {
        console.log('The dialog was closed');
        this.ngOnInit();
      });
    });
  }
}
