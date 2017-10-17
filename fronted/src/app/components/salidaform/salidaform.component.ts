import { Component,Input, OnInit,Output,EventEmitter} from '@angular/core';
import {SalidavehiculoService} from'../../services/salidavehiculo.service';

@Component({
  selector: 'app-salidaform',
  templateUrl: './salidaform.component.html',
  styleUrls: ['./salidaform.component.css']
})
export class SalidaformComponent implements OnInit {

  @Output() onSubmit=new EventEmitter<any>();
  
  @Input() vehiculo;

  constructor( ) { }

  ngOnInit() {
  
  }

  public submit(){
      this.onSubmit.emit({vehiculo:this.vehiculo});
  }
}
