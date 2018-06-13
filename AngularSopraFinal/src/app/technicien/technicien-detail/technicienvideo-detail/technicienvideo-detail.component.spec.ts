import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TechnicienvideoDetailComponent } from './technicienvideo-detail.component';

describe('TechnicienvideoDetailComponent', () => {
  let component: TechnicienvideoDetailComponent;
  let fixture: ComponentFixture<TechnicienvideoDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TechnicienvideoDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TechnicienvideoDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
