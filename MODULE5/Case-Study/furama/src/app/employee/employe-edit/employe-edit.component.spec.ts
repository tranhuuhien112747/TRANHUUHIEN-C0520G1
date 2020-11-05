import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeEditComponent } from './employe-edit.component';

describe('EmployeEditComponent', () => {
  let component: EmployeEditComponent;
  let fixture: ComponentFixture<EmployeEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
