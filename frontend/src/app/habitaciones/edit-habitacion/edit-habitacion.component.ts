import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HabitacionesService } from 'src/app/Service/habitaciones.service';
import { Habitacion } from 'src/app/Modelo/Habitacion';

@Component({
  selector: 'app-edit-habitacion',
  templateUrl: './edit-habitacion.component.html',
  styleUrls: ['./edit-habitacion.component.css']
})
export class EditHabitacionComponent implements OnInit {

  habitacion:Habitacion = new Habitacion();
  respuesta;

  constructor(private service:HabitacionesService, private router:Router) { }

  ngOnInit() {
  }

  Guardar(){
  	this.service.edit(this.habitacion)
  	.subscribe(data=>{this.respuesta=data;})
  }

}
