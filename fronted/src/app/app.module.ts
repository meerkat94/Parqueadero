import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import{FormsModule} from '@angular/forms';
import{HttpModule} from '@angular/http';
import { AppComponent } from './app.component';
import { IngresoMotoComponent } from './components/ingreso-moto/ingreso-moto.component';

import { IngresoCarroComponent } from './components/ingreso-carro/ingreso-carro.component';

import {MotoService} from './services/moto.service';
import {CarroService} from './services/carro.service';
import {appRoutes} from './app.routing';
import { RouterModule } from '@angular/router';
import { VehiculoFormComponent } from './components/vehiculo-form/vehiculo-form.component';
import { CarroFormComponent } from './components/carro-form/carro-form.component';
import{SalidavehiculoService} from'./services/salidavehiculo.service';
import { SalidaVehiculoComponent } from './components/salida-vehiculo/salida-vehiculo.component';
import { SalidaformComponent } from './components/salidaform/salidaform.component';
import { ListavehiculosComponent } from './components/listavehiculos/listavehiculos.component';
import{ListaVehiculosService} from './services/lista-vehiculos.service';
import { DatePipe } from '@angular/common';
import{}from'./services/'
@NgModule({
  declarations: [
    AppComponent,
    IngresoMotoComponent,   
    IngresoCarroComponent,
    VehiculoFormComponent,
    CarroFormComponent,
    SalidaVehiculoComponent,
    SalidaformComponent,
    ListavehiculosComponent
  ],
  imports: [
    RouterModule.forRoot(appRoutes),
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [MotoService,CarroService,SalidavehiculoService,ListaVehiculosService],
  bootstrap: [AppComponent]
})
export class AppModule { }
