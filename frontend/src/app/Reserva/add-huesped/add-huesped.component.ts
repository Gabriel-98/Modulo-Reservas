import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from '../../Service/service.service';
import { Huesped } from 'src/app/Modelo/Huesped';

@Component({
  selector: 'app-add-huesped',
  templateUrl: './add-huesped.component.html',
  styleUrls: ['./add-huesped.component.css']
})
export class AddHuespedComponent implements OnInit {

  @Output() emitEvent:EventEmitter<boolean> = new EventEmitter<boolean>();

  huesped:Huesped = new Huesped();

  constructor(private router:Router, private service:ServiceService) { }

  ngOnInit() {
  }

  LeerDatosHuesped(){
  	return this.huesped;
  }

}
