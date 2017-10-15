import { Component, OnInit } from '@angular/core';
import {MotoService} from '../../services/moto.service';

@Component({
  selector: 'app-listar-motos',
  templateUrl: './listar-motos.component.html',
  styleUrls: ['./listar-motos.component.css']
})
export class ListarMotosComponent implements OnInit {
  public motos;
  constructor(private _service:MotoService) {
    _service.all().subscribe(motos=>{this.motos=motos;});

   }

  ngOnInit() {
  }

}
