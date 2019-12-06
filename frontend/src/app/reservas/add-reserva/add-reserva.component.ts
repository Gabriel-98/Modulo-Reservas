import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ReservaService } from 'src/app/Service/reserva.service';
import { Reserva } from 'src/app/Modelo/Reserva';
import { Huesped } from 'src/app/Modelo/Huesped';
import { PeticionReserva } from 'src/app/Modelo/PeticionReserva';

@Component({
  selector: 'app-add-reserva',
  templateUrl: './add-reserva.component.html',
  styleUrls: ['./add-reserva.component.css']
})
export class AddReservaComponent implements OnInit {

  peticionReserva:PeticionReserva = new PeticionReserva();
  reserva:Reserva = new Reserva();
  huesped:Huesped = new Huesped();
  respuesta;

  constructor(private service:ReservaService, private router:Router) { }

  ngOnInit() {
  }

  Guardar(){
  	this.service.create(this.peticionReserva).subscribe();
  }

}
