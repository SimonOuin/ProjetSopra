import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TechniciensalleDetailsComponent } from './techniciensalle-details.component';

describe('TechniciensalleDetailsComponent', () => {
  let component: TechniciensalleDetailsComponent;
  let fixture: ComponentFixture<TechniciensalleDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TechniciensalleDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TechniciensalleDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
