import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddTipoHabitacionComponent } from './add-tipo-habitacion.component';

describe('AddTipoHabitacionComponent', () => {
  let component: AddTipoHabitacionComponent;
  let fixture: ComponentFixture<AddTipoHabitacionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddTipoHabitacionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddTipoHabitacionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
