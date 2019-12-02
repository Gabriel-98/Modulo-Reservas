import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from '../../Service/service.service';
import { Reserva } from 'src/app/Modelo/Reserva';

@Component({
  selector: 'app-listar-reservas',
  templateUrl: './listar-reservas.component.html',
  styleUrls: ['./listar-reservas.component.css']
})
export class ListarReservasComponent implements OnInit {

  reservas:Reserva[];

  constructor(private service:ServiceService, private router:Router) { }

  ngOnInit() {
  	console.log("enviar peticion")
  	this.service.getReservas()
  	.subscribe(data=>{this.reservas=data;})
  }

}
