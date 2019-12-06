import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Huesped } from 'src/app/Modelo/Huesped';

@Injectable({
  providedIn: 'root'
})
export class HuespedService {

  constructor(private http:HttpClient) { }

  Url="http://localhost:8080/huespedes";

  create(huesped:Huesped){
  	console.log("crear huesped");
  	return this.http.post<Huesped>(this.Url, huesped);
  }

  validar(huesped:Huesped){
  	console.log("validar huesped");
  	return this.http.get<boolean>(this.Url + "/" + huesped.cedula + "/" + huesped.codigo)
  }
}
