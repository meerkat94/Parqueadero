import {Routes} from '@angular/router';
import {ListarMotosComponent} from './components/listar-motos/listar-motos.component';
import{ListarCarroComponent} from './components/listar-carro/listar-carro.component';
import{IngresoMotoComponent} from './components/ingreso-moto/ingreso-moto.component';
import{IngresoCarroComponent} from './components/ingreso-carro/ingreso-carro.component';
export const appRoutes:Routes = [
    {path: 'moto/ingreso', component: IngresoMotoComponent},
    {path: 'moto', component: ListarMotosComponent},
    {path: 'carro', component: ListarCarroComponent},
    {path: 'carro/ingreso', component: IngresoCarroComponent},
    {path: '', redirectTo :'/moto',pathMatch : 'full'}
    
];