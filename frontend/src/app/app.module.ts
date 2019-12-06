import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';


import { AddHabitacionComponent } from './habitaciones/add-habitacion/add-habitacion.component';
import { AddTipoHabitacionComponent } from './habitaciones/add-tipo-habitacion/add-tipo-habitacion.component';
import { ListarHabitacionesComponent } from './habitaciones/listar-habitaciones/listar-habitaciones.component';
import { EditHabitacionComponent } from './habitaciones/edit-habitacion/edit-habitacion.component';
import { EditTipoHabitacionComponent } from './habitaciones/edit-tipo-habitacion/edit-tipo-habitacion.component';

import { AddReservaComponent } from './reservas/add-reserva/add-reserva.component';
import { ConsultarReservasComponent } from './reservas/consultar-reservas/consultar-reservas.component';
import { ListarReservasComponent } from './reservas/listar-reservas/listar-reservas.component';



@NgModule({
  declarations: [
    AppComponent,
    AddHabitacionComponent,
    AddTipoHabitacionComponent,
    ListarHabitacionesComponent,
    AddReservaComponent,
    ConsultarReservasComponent,
    EditHabitacionComponent,
    EditTipoHabitacionComponent,
    ListarReservasComponent    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
