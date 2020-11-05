import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {EmployeeService} from '../../services/employee.service';
import {Router, ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-employe-edit',
  templateUrl: './employe-edit.component.html',
  styleUrls: ['./employe-edit.component.css']
})
export class EmployeEditComponent implements OnInit {

  formEditNewEmployee: FormGroup;
  public maxDate = new Date();
  public minDate = new Date(1910, 0, 1);
  public dataEmployeeId;
  public educationList;
  public positionList;
  public divisionList;

  constructor(
    public fb: FormBuilder,
    public employeeService: EmployeeService,
    public router: Router,
    public activatedRoute: ActivatedRoute
  ) {
  }

  ngOnInit(): void {
    this.formEditNewEmployee = this.fb.group({
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
    this.activatedRoute.params.subscribe(data => {
      this.dataEmployeeId = data.id;
      this.employeeService.getEmployeeById(this.dataEmployeeId).subscribe(getData => {
        console.log(getData);
        this.formEditNewEmployee.patchValue(getData);
      });
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

  updateEmployee() {
    if (this.formEditNewEmployee.valid) {
      this.employeeService.editEmployeeById(this.formEditNewEmployee.value, this.dataEmployeeId).subscribe(data => {
        this.router.navigate(['employee'], {queryParams: {messageEdit: 'Update Successfully !!!', si: true}});
      });
    }

  }
}
