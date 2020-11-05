import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';


@Component({
  selector: 'app-employee-view-detail',
  templateUrl: './employee-view-detail.component.html',
  styleUrls: ['./employee-view-detail.component.css']
})
export class EmployeeViewDetailComponent implements OnInit {
  public dataEmployee;

  constructor(
    public dialogRef: MatDialogRef<EmployeeViewDetailComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any) {
  }

  ngOnInit(): void {
    this.dataEmployee = this.data.dataE;
    console.log(this.dataEmployee);
  }

}
