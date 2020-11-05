import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {CustomerService} from '../../services/customer.service';
import {ActivatedRoute, Router} from '@angular/router';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.css']
})
export class CustomerEditComponent implements OnInit {

  formEditCustomer: FormGroup;
  public maxDate = new Date();
  public minDate = new Date(1910, 0, 1);
  public typeCustomer;
  public dataId;

  constructor(
    private fb: FormBuilder,
    public customerService: CustomerService,
    public router: Router,
    public activatedRoute: ActivatedRoute,
    public dialogRef: MatDialogRef<CustomerEditComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {
  }

  ngOnInit(): void {
    this.formEditCustomer = this.fb.group({
      nameCus: ['', Validators.required],
      birthday: ['', Validators.required],
      idCard: ['', [Validators.required, Validators.pattern('^\\d{9}$')]],
      phoneCus: ['', [Validators.required, Validators.pattern('^(090|091|(84)+90|(84)+91)\\d{7}$')]],
      email: ['', [Validators.required, Validators.pattern('\\w+@\\w+[.]\\w+$')]],
      addressCus: ['', Validators.required],
      customerType: ['', Validators.required]
    });
    this.customerService.getAllTypeCustomer().subscribe(data => {
      this.typeCustomer = data;
    });
    this.dataId = this.data.dataC;
    this.customerService.getCustomerById(this.dataId).subscribe(getData => {
      this.formEditCustomer.patchValue(getData);
    });
  }

  editCustomer() {
    if (this.formEditCustomer.valid) {
      this.customerService.editCustomer(this.formEditCustomer.value, this.dataId).subscribe(data => {
        this.router.navigate(['customer'], {queryParams: {messageEdit: 'Update Successfully !!!', si: true}});
        this.dialogRef.close();
      }, error => {
        console.log(error);
      });
    }
  }
}
