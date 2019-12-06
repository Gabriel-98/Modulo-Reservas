import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TipoHabitacionService } from 'src/app/Service/tipo-habitacion.service';
import { TipoHabitacion } from 'src/app/Modelo/TipoHabitacion';

@Component({
  selector: 'app-add-tipo-habitacion',
  templateUrl: './add-tipo-habitacion.component.html',
  styleUrls: ['./add-tipo-habitacion.component.css']
})
export class AddTipoHabitacionComponent implements OnInit {

  tipoHabitacion:TipoHabitacion = new TipoHabitacion();
  respuesta;

  constructor(private service:TipoHabitacionService, private router:Router) { }

  ngOnInit() {
  }

  Guardar(){
  	this.service.create(this.tipoHabitacion)
  	.subscribe(data=>{this.respuesta=data;})
  }

}
