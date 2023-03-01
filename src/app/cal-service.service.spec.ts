import { TestBed } from '@angular/core/testing';

import { CalServiceService } from './cal-service.service';

describe('CalServiceService', () => {
  let service: CalServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CalServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
