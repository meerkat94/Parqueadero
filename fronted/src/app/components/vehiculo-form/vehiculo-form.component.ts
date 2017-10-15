import { Component, OnInit,Input,Output,EventEmitter } from '@angular/core';

@Component({
  selector: 'app-vehiculo-form',
  templateUrl: './vehiculo-form.component.html',
  styleUrls: ['./vehiculo-form.component.css']
})
export class VehiculoFormComponent implements OnInit {

  @Output() onSubmit=new EventEmitter<any>();
  
  @Input() moto;
  constructor() { }

  ngOnInit() {
  }

  public submit(){
    console.log("hola");
    this.onSubmit.emit({moto:this.moto});
  }
}
