import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployyeeDeleteComponent } from './employyee-delete.component';

describe('EmployyeeDeleteComponent', () => {
  let component: EmployyeeDeleteComponent;
  let fixture: ComponentFixture<EmployyeeDeleteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployyeeDeleteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployyeeDeleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
