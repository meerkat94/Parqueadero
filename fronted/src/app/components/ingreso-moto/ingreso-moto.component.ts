import { Component, OnInit,Output,Input,EventEmitter} from '@angular/core';
import {Router} from '@angular/router';
import {MotoService} from '../../services/moto.service';

@Component({
  selector: 'app-ingreso-moto',
  templateUrl: './ingreso-moto.component.html',
  styleUrls: ['./ingreso-moto.component.css']
})
export class IngresoMotoComponent implements OnInit {



  public moto={
    placa:'',cilindraje:0
  };

  constructor(private _router: Router,
    private _service:MotoService)    
  {}

  ngOnInit() {

  }

  ingresoMoto(obj){
    console.log(obj);
      this. _service.create(obj.moto).subscribe(res=>{
      this._router.navigate(['lista/vehiculo']);
    });
  }

 

}
