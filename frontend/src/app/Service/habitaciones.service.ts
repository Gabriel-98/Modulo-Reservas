import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Habitacion } from 'src/app/Modelo/Habitacion';

@Injectable({
  providedIn: 'root'
})
export class HabitacionesService {

  constructor(private http:HttpClient) { }

  Url="http://localhost:8080/habitaciones";

  list(){
  	console.log("get Habitaciones");
  	console.log(this.Url);
  	return this.http.get<Habitacion[]>(this.Url);
  }

  create(habitacion:Habitacion){
  	console.log("crear habitacion");
  	console.log(habitacion);
  	return this.http.post<Habitacion>(this.Url,habitacion);
  }

  edit(habitacion:Habitacion){
  	console.log("modificar habitacion");
  	return this.http.put<Habitacion>(this.Url,habitacion);
  }

  delete(idHabitacion:string){
  	console.log("eliminar habitacion " + idHabitacion);
  	console.log(this.Url + "/eliminar/" + idHabitacion);
  	return this.http.delete<Habitacion>(this.Url + "/eliminar/" + idHabitacion)
  }
}
