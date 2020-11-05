import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import {Router} from '@angular/router';
import {CustomerService} from '../../services/customer.service';

@Component({
  selector: 'app-customer-delete',
  templateUrl: './customer-delete.component.html',
  styleUrls: ['./customer-delete.component.css']
})
export class CustomerDeleteComponent implements OnInit {
  public nameCustomer;
  public idCustomer;

  constructor(
    public dialogRef: MatDialogRef<CustomerDeleteComponent>,
    public customerService: CustomerService,
    public router: Router,
    @Inject(MAT_DIALOG_DATA) public data: any) {
  }

  ngOnInit(): void {
    this.nameCustomer = this.data.dataC.nameCus;
    this.idCustomer = this.data.dataC.id;
    console.log(this.idCustomer);
  }

  deleteCustomer() {
    this.customerService.deleteCustomer(this.idCustomer).subscribe(data => {
      this.router.navigate(['customer'], {queryParams: {messageDelete: 'Delete Successfully !!!', si: true}});
      this.dialogRef.close();
    }, error => {
      console.log(error);
    });
  }
}
