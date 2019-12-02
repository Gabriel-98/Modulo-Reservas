import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Reserva } from '../Modelo/Reserva';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {
  
  constructor(private http:HttpClient) { }

  Url="http://localhost:8080/reservas";

  getReservas(){
  	console.log(this.Url);
  	return this.http.get<Reserva[]>(this.Url);
  }

  createReserva(reserva:Reserva){
  	console.log("crear reserva");
  	console.log(reserva);
  	return this.http.post<Reserva>(this.Url,reserva);
  }
}
