import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InscriptionformateurComponent } from './inscriptionformateur.component';

describe('InscriptionformateurComponent', () => {
  let component: InscriptionformateurComponent;
  let fixture: ComponentFixture<InscriptionformateurComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InscriptionformateurComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InscriptionformateurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
