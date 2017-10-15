import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IngresoMotoComponent } from './ingreso-moto.component';

describe('IngresoMotoComponent', () => {
  let component: IngresoMotoComponent;
  let fixture: ComponentFixture<IngresoMotoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IngresoMotoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IngresoMotoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
