import { Component, OnInit } from '@angular/core';
import {ListaVehiculosService} from '../../services/lista-vehiculos.service';
@Component({
  selector: 'app-listavehiculos',
  templateUrl: './listavehiculos.component.html',
  styleUrls: ['./listavehiculos.component.css']
})
export class ListavehiculosComponent implements OnInit {

  public vehiculos;

  constructor(private _service:ListaVehiculosService) {
    _service.all().subscribe(vehiculos=>{this.vehiculos=vehiculos;});

   }
  ngOnInit() {
  }

}
