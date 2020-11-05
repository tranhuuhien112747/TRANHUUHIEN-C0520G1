import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {CustomerService} from '../../services/customer.service';
import {Router} from '@angular/router';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';

@Component({
  selector: 'app-customer-add',
  templateUrl: './customer-add.component.html',
  styleUrls: ['./customer-add.component.css']
})
export class CustomerAddComponent implements OnInit {
  formAddCustomer: FormGroup;
  public maxDate = new Date();
  public minDate = new Date(1910, 0, 1);
  public typeCustomer;

  constructor(
    private fb: FormBuilder,
    public customerService: CustomerService,
    public router: Router,
    public dialogRef: MatDialogRef<CustomerAddComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any) {
  }

  ngOnInit(): void {
    this.formAddCustomer = this.fb.group({
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
  }

  addNewCustomer() {
    if (this.formAddCustomer.valid) {
      this.customerService.addNewCustomer(this.formAddCustomer.value).subscribe(data => {
        this.router.navigate(['customer'], {queryParams: {messageCreate: 'Create Successfully !!!', si: true}});
        this.dialogRef.close();
      });
    }
  }
}
