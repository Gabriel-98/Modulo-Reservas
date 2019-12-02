import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListarReservasComponent } from './Reserva/listar-reservas/listar-reservas.component';
import { AddReservaComponent } from './Reserva/add-reserva/add-reserva.component';
import { EditReservaComponent } from './Reserva/edit-reserva/edit-reserva.component';
import { FormsModule } from '@angular/forms';
import { ServiceService } from '../app/Service/service.service';
import { HttpClientModule } from '@angular/common/http';
import { AddHuespedComponent } from './Reserva/add-huesped/add-huesped.component';

@NgModule({
  declarations: [
    AppComponent,
    ListarReservasComponent,
    AddReservaComponent,
    EditReservaComponent,
    AddHuespedComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [ServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
