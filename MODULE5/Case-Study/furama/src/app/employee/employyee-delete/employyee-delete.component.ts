import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import {EmployeeService} from '../../services/employee.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-employyee-delete',
  templateUrl: './employyee-delete.component.html',
  styleUrls: ['./employyee-delete.component.css']
})
export class EmployyeeDeleteComponent implements OnInit {
  public employeeName;
  public employeeId;

  constructor(
    public dialogRef: MatDialogRef<EmployyeeDeleteComponent>,
    public employeeService: EmployeeService,
    public router: Router,
    @Inject(MAT_DIALOG_DATA) public data: any) {
  }

  ngOnInit(): void {
    this.employeeName = this.data.dataE.employeeName;
    this.employeeId = this.data.dataE.id;
  }

  deleteEmployee() {
    this.employeeService.deleteByIdEmployee(this.employeeId).subscribe(data => {
      this.router.navigate(['employee'], {queryParams: {messageDelete: 'Delete Successfully !!!', si: true}});
      this.dialogRef.close();
    });
  }
}
