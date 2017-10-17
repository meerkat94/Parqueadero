import { TestBed, inject } from '@angular/core/testing';

import { ListaVehiculosService } from './lista-vehiculos.service';

describe('ListaVehiculosService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ListaVehiculosService]
    });
  });

  it('should be created', inject([ListaVehiculosService], (service: ListaVehiculosService) => {
    expect(service).toBeTruthy();
  }));
});
