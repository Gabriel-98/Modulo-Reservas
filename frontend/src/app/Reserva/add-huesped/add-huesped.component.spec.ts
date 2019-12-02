import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddHuespedComponent } from './add-huesped.component';

describe('AddHuespedComponent', () => {
  let component: AddHuespedComponent;
  let fixture: ComponentFixture<AddHuespedComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddHuespedComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddHuespedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
