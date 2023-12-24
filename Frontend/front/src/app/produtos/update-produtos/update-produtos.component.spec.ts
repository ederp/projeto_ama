import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateProdutoComponent } from './update-produtos.component';

describe('UpdateProdutoComponent', () => {
  let component: UpdateProdutoComponent;
  let fixture: ComponentFixture<UpdateProdutoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UpdateProdutoComponent]
    })
      .compileComponents();

    fixture = TestBed.createComponent(UpdateProdutoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
