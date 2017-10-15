import { Component,Input, OnInit,Output,EventEmitter} from '@angular/core';

@Component({
  selector: 'app-salidaform',
  templateUrl: './salidaform.component.html',
  styleUrls: ['./salidaform.component.css']
})
export class SalidaformComponent implements OnInit {

  @Output() onSubmit=new EventEmitter<any>();
  
  @Input() vehiculo;
  constructor() { }

  ngOnInit() {
  }

  public submit(){
    console.log("hola");
    this.onSubmit.emit({vehiculo:this.vehiculo});
  }
}
