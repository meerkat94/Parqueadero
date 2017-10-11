import { Component } from '@angular/core';
import{ Vehiculo } from '../../Classes/Vehiculo';
@Component({
  moduleId: module.id,
  selector: 'my-app',
  templateUrl: 'indexvehiculo.html',
})
export class AppComponent  {
vehiculo: Vehiculo= new Vehiculo("FCM308");
 }
