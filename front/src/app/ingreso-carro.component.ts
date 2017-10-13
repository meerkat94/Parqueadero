import{Component,Output,EventEmitter}from '@angular/core';
import{Vehiculo} from './Vehiculo';

@Component({
selector:'ingreso-carro',
templateUrl:'./index2.html'
})

export class ingresocarrocomponent{
  model: Vehiculo= new Vehiculo('',0);
  @Output() onsubmit=new EventEmitter<any>();

  public submit(){
    this.onsubmit.emit(this.model);
    console.log(this.model);
    this.model= new Vehiculo('',0);
  }
}
