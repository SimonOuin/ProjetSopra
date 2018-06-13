import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InscriptiongestionnaireComponent } from './inscriptiongestionnaire.component';

describe('InscriptiongestionnaireComponent', () => {
  let component: InscriptiongestionnaireComponent;
  let fixture: ComponentFixture<InscriptiongestionnaireComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InscriptiongestionnaireComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InscriptiongestionnaireComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
