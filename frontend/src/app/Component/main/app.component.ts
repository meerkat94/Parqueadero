import { Component } from '@angular/core';

@Component({
  selector: 'my-app',
  template: `<h1>Parqueadero {{name}}</h1>`,
})
export class AppComponent  { name = 'Sebastian'; }
