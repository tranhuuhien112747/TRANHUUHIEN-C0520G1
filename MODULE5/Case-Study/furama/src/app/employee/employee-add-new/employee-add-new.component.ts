import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {EmployeeService} from '../../services/employee.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-employee-add-new',
  templateUrl: './employee-add-new.component.html',
  styleUrls: ['./employee-add-new.component.css']
})
export class EmployeeAddNewComponent implements OnInit {
  formAddNewEmployee: FormGroup;
  public maxDate = new Date();
  public minDate = new Date(1910, 0, 1);
  public educationList;
  public positionList;
  public divisionList;

  constructor(
    public fb: FormBuilder,
    public employeeService: EmployeeService,
    public router: Router
  ) {
  }

  ngOnInit(): void {
    this.formAddNewEmployee = this.fb.group({
      employeeName: ['', Validators.required],
      employeeBirthday: ['', Validators.required],
      employeeIdCard: ['', [Validators.required, Validators.pattern('^\\d{9}$')]],
      employeeSalary: ['', [Validators.required, Validators.pattern('^\\d+([.]\\d+)?$')]],
      employeePhone: ['', [Validators.required, Validators.pattern('^(090|091|(84)+90|(84)+91)\\d{7}$')]],
      employeeEmail: ['', [Validators.required, Validators.pattern('\\w+@\\w+[.]\\w+$')]],
      employeeAddress: ['', [Validators.required]],
      employeePosition: ['', Validators.required],
      employeeDivision: ['', Validators.required],
      employeeEducation: ['', Validators.required]
    });
    this.employeeService.getDivision().subscribe(data => {
      this.divisionList = data;
    }),
      this.employeeService.getPosition().subscribe(data => {
        this.positionList = data;
      }),
      this.employeeService.getEducation().subscribe(data => {
        this.educationList = data;
      });
  }

  addNewEmployee() {
    if (this.formAddNewEmployee.valid) {
      this.employeeService.addNewEmployee(this.formAddNewEmployee.value).subscribe(data => {
          console.log(data);
          this.router.navigate(['employee'], {queryParams: {messageCreate: 'Create Successfully !!!', si: true}});
        }
      );
    }
  }
}
