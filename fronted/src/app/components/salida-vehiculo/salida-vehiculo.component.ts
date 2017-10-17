import { Component, OnInit,Output,Input,EventEmitter  } from '@angular/core';
import {Router} from '@angular/router';
import{SalidavehiculoService} from '../../services/salidavehiculo.service'

@Component({
  selector: 'app-salida-vehiculo',
  templateUrl: './salida-vehiculo.component.html',
  styleUrls: ['./salida-vehiculo.component.css']
})
export class SalidaVehiculoComponent implements OnInit {

   public recibo={
     valor:0
   };

  public vehiculo={
    placa:''
  };
  
  constructor(private _router: Router,
    private _service:SalidavehiculoService) { }

  ngOnInit() {
  }

  salidaVehiculo(obj){
    console.log(obj);
        this. _service.darSalida(obj.vehiculo).subscribe(res=>{
           this.recibo = res;
       this._router.navigate(['lista/vehiculo']);
    });
  }

}
