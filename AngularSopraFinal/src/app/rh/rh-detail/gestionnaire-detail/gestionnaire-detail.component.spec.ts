import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GestionnaireDetailComponent } from './gestionnaire-detail.component';

describe('GestionnaireDetailComponent', () => {
  let component: GestionnaireDetailComponent;
  let fixture: ComponentFixture<GestionnaireDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GestionnaireDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GestionnaireDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
