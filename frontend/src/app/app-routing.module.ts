import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListarHabitacionesComponent } from 'src/app/habitaciones/listar-habitaciones/listar-habitaciones.component';
import { AddHabitacionComponent } from 'src/app/habitaciones/add-habitacion/add-habitacion.component';
import { AddTipoHabitacionComponent } from 'src/app/habitaciones/add-tipo-habitacion/add-tipo-habitacion.component';
import { EditHabitacionComponent } from 'src/app/habitaciones/edit-habitacion/edit-habitacion.component';
import { EditTipoHabitacionComponent } from 'src/app/habitaciones/edit-tipo-habitacion/edit-tipo-habitacion.component';
import { AddReservaComponent } from './reservas/add-reserva/add-reserva.component';
import { ConsultarReservasComponent } from './reservas/consultar-reservas/consultar-reservas.component';
import { ListarReservasComponent } from 'src/app/reservas/listar-reservas/listar-reservas.component';

const routes: Routes = [
	{path: "habitaciones", component: ListarHabitacionesComponent},
	{path: "habitaciones/agregar", component: AddHabitacionComponent},
	{path: "habitaciones/agregar_tipo", component: AddTipoHabitacionComponent},
	{path: "habitaciones/editar", component: EditHabitacionComponent},
	{path: "habitaciones/editar_tipo", component: EditTipoHabitacionComponent},
	{path: "reservas/consultar", component: ConsultarReservasComponent},
	{path: "reservas/agregar", component: AddReservaComponent},
	{path: "reservas/listar", component: ListarReservasComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
