import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListavehiculosComponent } from './listavehiculos.component';

describe('ListavehiculosComponent', () => {
  let component: ListavehiculosComponent;
  let fixture: ComponentFixture<ListavehiculosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListavehiculosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListavehiculosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
