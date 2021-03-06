import { Injectable } from '@angular/core';
import {Headers,Http,Response} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/observable/throw';
import 'rxjs/add/operator/map';
import'rxjs/add/operator/catch';
import { DatePipe } from '@angular/common';


@Injectable()
export class ListaVehiculosService {
  
  private _endPoint = "http://localhost:8090/lista/Vehiculosparqueados";
  constructor(private _http: Http) {}

  public all():Observable<any>{
    return this._http.get(`${this._endPoint}`)
    .map(this.extractData)
    .catch(this.handleError);
  }

  private extractData(res:Response){
    return res.json()||{};
  }

  private handleError(error:Response | any){
    let errMsg: string;
    if(error instanceof Response){
      const body =error.json() || '';
      const err = body.error|| JSON.stringify(body);
      errMsg = `${error.status} - ${error.statusText || ''} ${err} `;
    }else{
      errMsg =error.message ? error.message : error.toString();
    }
    console.error(errMsg);
    return Observable.throw(errMsg);
  }

}
