import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-pet',
  templateUrl: './pet.component.html',
  styleUrls: ['./pet.component.scss']
})
export class PetComponent implements OnInit {
  public petName = 'Hải Chó Điên';
  public petImage = 'https://azpet.com.vn/wp-content/uploads/2019/01/cho-pug-1.png';

  constructor() {
  }

  ngOnInit(): void {
  }

  updateName(name) {
    this.petName = name;
  }

  updateImage(image) {
    this.petImage = image;
  }
}
