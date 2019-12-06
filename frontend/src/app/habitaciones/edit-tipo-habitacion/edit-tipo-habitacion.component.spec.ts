import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditTipoHabitacionComponent } from './edit-tipo-habitacion.component';

describe('EditTipoHabitacionComponent', () => {
  let component: EditTipoHabitacionComponent;
  let fixture: ComponentFixture<EditTipoHabitacionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditTipoHabitacionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditTipoHabitacionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
