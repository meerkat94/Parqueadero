import {Routes} from '@angular/router';
import{IngresoMotoComponent} from './components/ingreso-moto/ingreso-moto.component';
import{IngresoCarroComponent} from './components/ingreso-carro/ingreso-carro.component';
import {SalidaVehiculoComponent}from './components/salida-vehiculo/salida-vehiculo.component';
export const appRoutes:Routes = [
    {path: 'moto/ingreso', component: IngresoMotoComponent},   
    {path: 'carro/ingreso', component: IngresoCarroComponent},
    {path: 'vehiculo/salida', component: SalidaVehiculoComponent},
    {path: '', redirectTo :'/moto',pathMatch : 'full'}
    
];