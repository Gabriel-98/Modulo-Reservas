import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Reserva } from 'src/app/Modelo/Reserva';
import { PeticionReserva } from 'src/app/Modelo/PeticionReserva';
import { Huesped } from 'src/app/Modelo/Huesped';

@Injectable({
  providedIn: 'root'
})
export class ReservaService {

  constructor(private http:HttpClient) { }

  Url="http://localhost:8080/reservas";

  list(huesped:Huesped){
  	console.log("listar reservas");
  	return this.http.get<Reserva[]>(this.Url + "/" + huesped.cedula);
  }

  create(peticionReserva:PeticionReserva){
  	console.log("listar reserva");
  	return this.http.post<Reserva>(this.Url, peticionReserva);
  }

  cancel(reserva:Reserva){
  	return this.http.put<Reserva>(this.Url + "/" + reserva.idReserva, null);
  }
}
