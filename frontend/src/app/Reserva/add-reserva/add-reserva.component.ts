import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from '../../Service/service.service';
import { Reserva } from 'src/app/Modelo/Reserva';
import { Huesped } from 'src/app/Modelo/Huesped';
//import { AddHuespedComponent } from 'src/app/Reserva/add-huesped/add-huesped.component';
import { AddHuespedComponent } from '../add-huesped/add-huesped.component';

@Component({
  selector: 'app-add-reserva',
  templateUrl: './add-reserva.component.html',
  styleUrls: ['./add-reserva.component.css']
})
export class AddReservaComponent implements OnInit {

  @ViewChild(AddHuespedComponent, {static: true}) userCreator:AddHuespedComponent;

  reserva:Reserva= new Reserva();
  huesped:Huesped = new Huesped();
  constructor(private router:Router, private service:ServiceService) { }

  ngOnInit() {
  }

  Guardar(){
  	this.huesped = this.userCreator.LeerDatosHuesped();
  	console.log("Huesped ");
  	console.log(this.huesped.cedula);
  	this.service.createReserva(this.reserva)
  	.subscribe(data=>{
  		alert("Se agrego con exito!!!");
  		this.router.navigate(["listar"]);
  	})
  }
}
