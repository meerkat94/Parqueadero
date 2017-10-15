import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SalidaformComponent } from './salidaform.component';

describe('SalidaformComponent', () => {
  let component: SalidaformComponent;
  let fixture: ComponentFixture<SalidaformComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SalidaformComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SalidaformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
