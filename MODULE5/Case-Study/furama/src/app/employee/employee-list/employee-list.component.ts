import {Component, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {EmployeeService} from '../../services/employee.service';
import {EmployyeeDeleteComponent} from '../employyee-delete/employyee-delete.component';
import {EmployeeViewDetailComponent} from '../employee-view-detail/employee-view-detail.component';
import {MatDialog} from '@angular/material/dialog';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  public p = 1;
  public employeeList;
  public term: any;

  public messageCreate = '';
  public messageEdit = '';
  public messageDelete = '';

  constructor(
    public employeeService: EmployeeService,
    public dialog: MatDialog,
    public route: ActivatedRoute
  ) {
  }

  ngOnInit(): void {
    this.employeeService.getAllEmployee().subscribe(data => {
      this.employeeList = data;
      this.sendAllMessage();
      console.log(this.employeeList);
    });
  }

  sendAllMessage() {
    this.messageCreate = this.route.snapshot.queryParamMap.get('messageCreate');
    this.messageEdit = this.route.snapshot.queryParamMap.get('messageEdit');
    this.messageDelete = this.route.snapshot.queryParamMap.get('messageDelete');
  }

  removeEmployeeDialog(employeeId): void {
    console.log(employeeId);
    this.employeeService.getEmployeeById(employeeId).subscribe(dataEmployee => {
      const dialogRef = this.dialog.open(EmployyeeDeleteComponent, {
        width: '550px',
        height: '240px',
        data: {dataE: dataEmployee},
        disableClose: true
      });

      dialogRef.afterClosed().subscribe(result => {
        console.log('The dialog was closed');
        this.ngOnInit();
      });
    });
  }

  openViewDetail(employeeId): void {
    console.log(employeeId);
    this.employeeService.getEmployeeById(employeeId).subscribe(dataEmployee => {
      const dialogRef = this.dialog.open(EmployeeViewDetailComponent, {
        width: '400px',
        height: '590px',
        data: {dataE: dataEmployee},
        disableClose: true
      });

      dialogRef.afterClosed().subscribe(result => {
        console.log('The dialog was closed');
        this.ngOnInit();
      });
    });
  }
}
