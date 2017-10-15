import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarMotosComponent } from './listar-motos.component';

describe('ListarMotosComponent', () => {
  let component: ListarMotosComponent;
  let fixture: ComponentFixture<ListarMotosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListarMotosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListarMotosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
