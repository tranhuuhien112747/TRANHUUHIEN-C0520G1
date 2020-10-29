import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.scss']
})
export class CalculatorComponent implements OnInit {
  output: number;
  first: number;
  second: number;
  operator = '+';

  constructor() {
  }

  ngOnInit(): void {
  }

  onFirstChange(value) {
    this.first = value;
  }

  onSecondChange(value) {
    this.second = value;
  }

  onSelectChange(value) {
    this.operator = value;
  }

  calculate() {
    switch (this.operator) {
      case '+':
        this.output = 1 * this.first + 1 * this.second;
        break;
      case '-':
        this.output = this.first - this.second;
        break;
      case '*':
        this.output = this.first * this.second;
        break;
      case '/':
        this.output = this.first / this.second;
        break;

    }
  }
}

