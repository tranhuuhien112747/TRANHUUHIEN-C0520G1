import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeViewDetailComponent } from './employee-view-detail.component';

describe('EmployeeViewDetailComponent', () => {
  let component: EmployeeViewDetailComponent;
  let fixture: ComponentFixture<EmployeeViewDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeeViewDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeViewDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
