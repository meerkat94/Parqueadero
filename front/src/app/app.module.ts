import { NgModule }   from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppComponent }  from './app.component';
import { ListadoComponent } from './listaVehiculos.component';
import { ingresocarrocomponent } from './ingreso-carro.component';



@NgModule({
  imports:      [ BrowserModule,FormsModule ],
  declarations: [ AppComponent,ListadoComponent,ingresocarrocomponent],
  bootstrap:    [ AppComponent ]
})
export class AppModule { }
