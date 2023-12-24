import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateProdutoComponent } from './create-produtos.component';

describe('CreateProdutoComponent', () => {
  let component: CreateProdutoComponent;
  let fixture: ComponentFixture<CreateProdutoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CreateProdutoComponent]
    })
      .compileComponents();

    fixture = TestBed.createComponent(CreateProdutoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
