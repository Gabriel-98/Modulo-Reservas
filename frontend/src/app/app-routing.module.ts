import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListarReservasComponent } from './Reserva/listar-reservas/listar-reservas.component';
import { AddReservaComponent } from './Reserva/add-reserva/add-reserva.component';
import { EditReservaComponent } from './Reserva/edit-reserva/edit-reserva.component';
import { AddHuespedComponent } from './Reserva/add-huesped/add-huesped.component';

const routes: Routes = [
	{path: "listar", component: ListarReservasComponent},
	{path: "addReserva", component: AddReservaComponent},
	{path: "editReserva", component: EditReservaComponent},
	{path: "addHuesped", component: AddHuespedComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
