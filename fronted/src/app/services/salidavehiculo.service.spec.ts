import { TestBed, inject } from '@angular/core/testing';

import { SalidavehiculoService } from './salidavehiculo.service';

describe('SalidavehiculoService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SalidavehiculoService]
    });
  });

  it('should be created', inject([SalidavehiculoService], (service: SalidavehiculoService) => {
    expect(service).toBeTruthy();
  }));
});
