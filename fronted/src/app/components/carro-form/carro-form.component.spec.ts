import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CarroFormComponent } from './carro-form.component';

describe('CarroFormComponent', () => {
  let component: CarroFormComponent;
  let fixture: ComponentFixture<CarroFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CarroFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CarroFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
