import {Component,Input} from '@angular/core';
import {Vehiculo} from './Vehiculo';

@Component ({
  moduleId:module.id,
  selector:'listavehiculos',
  templateUrl: './lista.html'
})

export class ListadoComponent{
  @Input() vehiculos:Array<Vehiculo>;

  displayVehiculo(vehiculo: Vehiculo){
    console.log(vehiculo);
  }
}
