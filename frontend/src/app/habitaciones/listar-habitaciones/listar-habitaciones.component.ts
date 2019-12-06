import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HabitacionesService } from 'src/app/Service/habitaciones.service';
import { TipoHabitacionService } from 'src/app/Service/tipo-habitacion.service';
import { TipoHabitacion } from 'src/app/Modelo/TipoHabitacion';
import { Habitacion } from 'src/app/Modelo/Habitacion';

@Component({
  selector: 'app-listar-habitaciones',
  templateUrl: './listar-habitaciones.component.html',
  styleUrls: ['./listar-habitaciones.component.css']
})
export class ListarHabitacionesComponent implements OnInit {

  tiposHabitacion:TipoHabitacion[];
  habitaciones:Habitacion[];

  constructor(private hService:HabitacionesService, private thService:TipoHabitacionService, private router:Router) { }

  ngOnInit() {
  	console.log("peticion get-habitaciones")
  	this.thService.list()
  	.subscribe(data=>{this.tiposHabitacion=data;})
  	this.hService.list()
  	.subscribe(data=>{this.habitaciones=data;})
  }

  AddTipoHabitacion(){
  	this.router.navigate(["habitaciones/agregar_tipo"]);
  }

  AddHabitacion(){
  	this.router.navigate(["habitaciones/agregar"])
  }

  EditTipoHabitacion(){
  	this.router.navigate(["habitaciones/editar_tipo"]);
  }

  EditHabitacion(){
  	this.router.navigate(["habitaciones/editar"]);
  }

  DeleteTipoHabitacion(idTipoHabitacion:string){
  	this.thService.delete(idTipoHabitacion).subscribe();
  }

  DeleteHabitacion(idHabitacion:string){
  	this.hService.delete(idHabitacion).subscribe();
  }
}
