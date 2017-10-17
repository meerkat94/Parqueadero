import { Component, OnInit,Output,Input,EventEmitter } from '@angular/core';
import {Router} from '@angular/router';
import{ CarroService } from '../../services/carro.service'

@Component({
  selector: 'app-ingreso-carro',
  templateUrl: './ingreso-carro.component.html',
  styleUrls: ['./ingreso-carro.component.css']
})
export class IngresoCarroComponent implements OnInit {

  public carro={
    placa:''
  };

  constructor(private _router: Router,
    private _service:CarroService) { }

  ngOnInit() {
  }

  ingresoCarro(obj){
    console.log(obj);
        this. _service.create(obj.carro).subscribe(res=>{
      this._router.navigate(['/lista/vehiculo']);
    });
  }

}
