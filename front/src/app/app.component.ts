import { Component, OnInit} from '@angular/core';
import { Vehiculo } from './Vehiculo';

@Component({
  selector: 'my-app',
  templateUrl: './index2.html'
})
export class AppComponent implements OnInit {
  vehiculos:Array<Vehiculo>=[];

  ngOnInit(){
    this.vehiculos.push(new Vehiculo('FCM308',0));
    this.vehiculos.push(new Vehiculo('SDD',0));
  }

  guardar(model:Vehiculo){
    this.vehiculos.push(model);
  }
}
