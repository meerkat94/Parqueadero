import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IngresoCarroComponent } from './ingreso-carro.component';

describe('IngresoCarroComponent', () => {
  let component: IngresoCarroComponent;
  let fixture: ComponentFixture<IngresoCarroComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IngresoCarroComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IngresoCarroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
