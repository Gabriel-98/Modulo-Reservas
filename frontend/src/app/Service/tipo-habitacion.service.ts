import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { TipoHabitacion } from 'src/app/Modelo/TipoHabitacion';

@Injectable({
  providedIn: 'root'
})
export class TipoHabitacionService {

  constructor(private http:HttpClient) { }

  Url="http://localhost:8080/tipos_habitaciones";

  list(){
  	console.log(this.Url);
  	return this.http.get<TipoHabitacion[]>(this.Url);
  }

  create(tipoHabitacion:TipoHabitacion){
  	console.log("crear tipo de habitacion");
  	return this.http.post<TipoHabitacion>(this.Url,tipoHabitacion);
  }

  edit(tipoHabitacion:TipoHabitacion){
  	console.log("modificar tipo de habitacion");
  	return this.http.put<TipoHabitacion>(this.Url,tipoHabitacion);
  }

  delete(idTipoHabitacion:string){
  	console.log("eliminar tipo de habitacion");
  	return this.http.delete<string>(this.Url + "/eliminar/" + idTipoHabitacion);
  }
}
