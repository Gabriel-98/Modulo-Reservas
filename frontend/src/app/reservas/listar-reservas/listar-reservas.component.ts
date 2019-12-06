import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Router } from '@angular/router';
import { ReservaService } from 'src/app/Service/reserva.service';
import { Reserva } from 'src/app/Modelo/Reserva';
import { Huesped } from 'src/app/Modelo/Huesped';

@Component({
  selector: 'app-listar-reservas',
  templateUrl: './listar-reservas.component.html',
  styleUrls: ['./listar-reservas.component.css']
})
export class ListarReservasComponent implements OnInit {

  @Output() emitEvent:EventEmitter<boolean> = new EventEmitter<boolean>();
  reservas:Reserva[];

  constructor(private service:ReservaService, private router:Router) { }

  ngOnInit() {
  	
  }

  CancelarReserva(reserva:Reserva){
	this.service.cancel(reserva)
	.subscribe()
  }

  Listar(huesped:Huesped){
  	console.log("peticion get-reservas")
  	this.service.list(huesped)
  	.subscribe(data=>{this.reservas=data;})
  }

}
