import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InscriptiontechnicienComponent } from './inscriptiontechnicien.component';

describe('InscriptiontechnicienComponent', () => {
  let component: InscriptiontechnicienComponent;
  let fixture: ComponentFixture<InscriptiontechnicienComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InscriptiontechnicienComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InscriptiontechnicienComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
