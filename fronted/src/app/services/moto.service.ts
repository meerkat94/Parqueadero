import { Injectable } from '@angular/core';
import {Headers,Http,Response} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/observable/throw';
import 'rxjs/add/operator/map';
import'rxjs/add/operator/catch';

@Injectable()
export class MotoService {

  private _endPoint = "http://localhost:8090/ingreso";
  
  constructor(private _http: Http) {}
   
 public create(moto):Observable<any>{
    const headers = new Headers({'Content-type':'application/json'});
    return this._http.post(`${this._endPoint}/moto`,moto, headers)
    .map(this.extractData)
    .catch(this.handleError);
  }
  

  private extractData(res:Response){
    alert("El Vehiculo se ingreso correctamente.");
    return res.json()||{};
  }

  private handleError(error:Response | any){
    let errMsg: string;
    if(error instanceof Response){
      const body =error.json() || '';
      const err = body.error|| JSON.stringify(body);
      errMsg = `${error.status} - ${error.statusText || ''} ${err} `;
      alert(body.message);
    }else{
      errMsg =error.message ? error.message : error.toString();
    }
    console.error(errMsg);
    return Observable.throw(errMsg);
  }


}
