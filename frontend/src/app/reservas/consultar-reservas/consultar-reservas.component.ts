import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { ReservaService } from 'src/app/Service/reserva.service';
import { HuespedService } from 'src/app/Service/huesped.service';
import { Reserva } from 'src/app/Modelo/Reserva';
import { Huesped } from 'src/app/Modelo/Huesped';
import { PeticionReserva } from 'src/app/Modelo/PeticionReserva';
import { ListarReservasComponent } from 'src/app/reservas/listar-reservas/listar-reservas.component';

@Component({
  selector: 'app-consultar-reservas',
  templateUrl: './consultar-reservas.component.html',
  styleUrls: ['./consultar-reservas.component.css']
})
export class ConsultarReservasComponent implements OnInit {

  @ViewChild(ListarReservasComponent, {static: true}) listarRes:ListarReservasComponent;

  reserva:Reserva = new Reserva();
  huesped:Huesped = new Huesped();
  respuesta;

  constructor(private hService:HuespedService, private rService:ReservaService, private router:Router) { }

  ngOnInit() {
  }

  Consultar(){
  	this.hService.validar(this.huesped)
  		.subscribe(	data=>{ 
  		this.VerificarListar(data);
  		/*console.log(this.respuesta);
  		this.listarRes.Listar(this.huesped);*/
  	})
  	//console.log(this.respuesta);

  	/*this.service.create(this.peticionReserva).subscribe();*/
  }

  VerificarListar(data){
  	if(data)
  	this.listarRes.Listar(this.huesped);
  }
}
