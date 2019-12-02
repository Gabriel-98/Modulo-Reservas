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

  Listar(){
  	console.log("listar");
  	this.router.navigate(["listar"]);
  }

  Nuevo(){
  	console.log("nuevo");
  	this.router.navigate(["addReserva"]);
  }
}
