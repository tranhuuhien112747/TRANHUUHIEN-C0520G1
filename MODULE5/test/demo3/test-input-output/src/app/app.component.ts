import {Component} from '@angular/core';
import {Student} from './student-model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Student List';
  public students: Student[] = [
    {nameStudent: 'Tran Huu Hien', age: 20},
    {nameStudent: 'Tran Huu Han', age: 21},
    {nameStudent: 'Tran Huu Ha', age: 18},
    {nameStudent: 'Tran Huu Ho', age: 19},
  ];
  // tslint:disable-next-line:variable-name
  private _student: Student;

  get student(): Student {
    return this._student;
  }

  set student(value: Student) {
    this._student = value;
  }

  onClick(item: Student) {
    this._student = item;
  }

  onCreateStudent(value: Student) {
    this.students.unshift(value);
  }
}
