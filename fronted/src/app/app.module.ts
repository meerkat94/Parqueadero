import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import{FormsModule} from '@angular/forms';
import{HttpModule} from '@angular/http';
import { AppComponent } from './app.component';
import { IngresoMotoComponent } from './components/ingreso-moto/ingreso-moto.component';
import { ListarMotosComponent } from './components/listar-motos/listar-motos.component';
import { IngresoCarroComponent } from './components/ingreso-carro/ingreso-carro.component';
import { ListarCarroComponent } from './components/listar-carro/listar-carro.component';
import {MotoService} from './services/moto.service';
import {appRoutes} from './app.routing';
import { RouterModule } from '@angular/router';
import { VehiculoFormComponent } from './components/vehiculo-form/vehiculo-form.component';
import { CarroFormComponent } from './components/carro-form/carro-form.component';
@NgModule({
  declarations: [
    AppComponent,
    IngresoMotoComponent,
    ListarMotosComponent,
    IngresoCarroComponent,
    ListarCarroComponent,
    VehiculoFormComponent,
    CarroFormComponent
  ],
  imports: [
    RouterModule.forRoot(appRoutes),
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [MotoService],
  bootstrap: [AppComponent]
})
export class AppModule { }
