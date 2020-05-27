import { TestBed } from '@angular/core/testing';

import { NotebookDataService } from './notebook-data.service';

describe('NotebookDataService', () => {
  let service: NotebookDataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NotebookDataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
