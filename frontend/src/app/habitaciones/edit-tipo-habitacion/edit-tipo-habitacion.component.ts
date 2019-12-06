import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TipoHabitacionService } from 'src/app/Service/tipo-habitacion.service';
import { TipoHabitacion } from 'src/app/Modelo/TipoHabitacion';

@Component({
  selector: 'app-edit-tipo-habitacion',
  templateUrl: './edit-tipo-habitacion.component.html',
  styleUrls: ['./edit-tipo-habitacion.component.css']
})
export class EditTipoHabitacionComponent implements OnInit {

  tipoHabitacion:TipoHabitacion = new TipoHabitacion();
  respuesta;

  constructor(private service:TipoHabitacionService, private router:Router) { }

  ngOnInit() {
  }

  Guardar(){
  	this.service.edit(this.tipoHabitacion)
  	.subscribe(data=>{this.respuesta=data;})
  }
}
