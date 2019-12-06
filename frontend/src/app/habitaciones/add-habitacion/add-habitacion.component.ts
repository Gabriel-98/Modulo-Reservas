import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HabitacionesService } from 'src/app/Service/habitaciones.service';
import { Habitacion } from 'src/app/Modelo/Habitacion';

@Component({
  selector: 'app-add-habitacion',
  templateUrl: './add-habitacion.component.html',
  styleUrls: ['./add-habitacion.component.css']
})
export class AddHabitacionComponent implements OnInit {

  habitacion:Habitacion = new Habitacion();
  respuesta;

  constructor(private service:HabitacionesService, private router:Router) { }

  ngOnInit() {
  }

  Guardar(){
  	this.service.create(this.habitacion)
  	.subscribe(data=>{this.respuesta=data;})
  }
}
