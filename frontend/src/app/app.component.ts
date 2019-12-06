import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'reservas';

  constructor(private router:Router){}

  LinkToConfiguracion(){
  	console.log("configuracion/listar");
  	this.router.navigate(["habitaciones"]);
  }

  LinkToReservar(){
  	console.log("reservas/crear");
  	this.router.navigate(["reservas/agregar"]);
  }

  LinkToConsultarReservas(){
  	console.log("reservas/listar");
  	this.router.navigate(["reservas/consultar"]);
  }
}
