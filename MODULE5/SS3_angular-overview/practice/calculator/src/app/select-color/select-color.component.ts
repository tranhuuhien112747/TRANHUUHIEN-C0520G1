import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-select-color',
  templateUrl: './select-color.component.html',
  styleUrls: ['./select-color.component.scss']
})
export class SelectColorComponent implements OnInit {
  background = '#800080';

  constructor() {
  }

  ngOnInit(): void {
  }

  onChange(color) {
    this.background = color;
  }

}
