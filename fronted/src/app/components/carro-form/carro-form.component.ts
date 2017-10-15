import { Component,Input, OnInit,Output,EventEmitter } from '@angular/core';

@Component({
  selector: 'app-carro-form',
  templateUrl: './carro-form.component.html',
  styleUrls: ['./carro-form.component.css']
})
export class CarroFormComponent implements OnInit {
  @Output() onSubmit=new EventEmitter<any>();
  
  @Input() carro;
  constructor() { }

  ngOnInit() {
  }

  public submit(){
    console.log("hola");
    this.onSubmit.emit({carro:this.carro});
  }
}