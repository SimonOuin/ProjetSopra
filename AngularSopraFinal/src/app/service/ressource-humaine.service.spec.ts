import { TestBed, inject } from '@angular/core/testing';

import { RessourceHumaineService } from './ressource-humaine.service';

describe('RessourceHumaineService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [RessourceHumaineService]
    });
  });

  it('should be created', inject([RessourceHumaineService], (service: RessourceHumaineService) => {
    expect(service).toBeTruthy();
  }));
});
