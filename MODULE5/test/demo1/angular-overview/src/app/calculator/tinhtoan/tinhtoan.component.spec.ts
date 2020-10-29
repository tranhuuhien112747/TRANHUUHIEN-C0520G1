import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TinhtoanComponent } from './tinhtoan.component';

describe('TinhtoanComponent', () => {
  let component: TinhtoanComponent;
  let fixture: ComponentFixture<TinhtoanComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TinhtoanComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TinhtoanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
