import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SalidaVehiculoComponent } from './salida-vehiculo.component';

describe('SalidaVehiculoComponent', () => {
  let component: SalidaVehiculoComponent;
  let fixture: ComponentFixture<SalidaVehiculoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SalidaVehiculoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SalidaVehiculoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
