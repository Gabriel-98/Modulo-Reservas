import { TestBed } from '@angular/core/testing';

import { HuespedService } from './huesped.service';

describe('HuespedService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: HuespedService = TestBed.get(HuespedService);
    expect(service).toBeTruthy();
  });
});
