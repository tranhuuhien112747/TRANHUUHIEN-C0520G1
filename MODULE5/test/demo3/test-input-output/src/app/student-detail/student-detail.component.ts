import {Component, Input, OnInit} from '@angular/core';
import {Student} from '../student-model';

@Component({
  selector: 'app-student-detail',
  templateUrl: './student-detail.component.html',
  styleUrls: ['./student-detail.component.css']
})
export class StudentDetailComponent implements OnInit {
  // tslint:disable-next-line:no-input-rename
  @Input('studentDetail') studentDe: Student;

  constructor() {
  }

  ngOnInit(): void {
  }

}
