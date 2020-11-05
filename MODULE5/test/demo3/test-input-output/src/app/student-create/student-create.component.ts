import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Student} from '../student-model';

@Component({
  selector: 'app-student-create',
  templateUrl: './student-create.component.html',
  styleUrls: ['./student-create.component.css']
})
export class StudentCreateComponent implements OnInit {
  // tslint:disable-next-line:no-output-rename
  @Output('studentCreate') createStudent = new EventEmitter<Student>();

  // tslint:disable-next-line:variable-name
  private _student: Student;

  constructor() {
  }

  ngOnInit(): void {
  }

  onClickCreate(nameStudent: string, age: number) {
    this._student = new Student(nameStudent, age);
    this.createStudent.emit(this._student);
    console.log(this._student);
  }

}
