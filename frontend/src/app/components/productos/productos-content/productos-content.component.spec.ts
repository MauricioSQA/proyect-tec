import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductosContentComponent } from './productos-content.component';

describe('ProductosContentComponent', () => {
  let component: ProductosContentComponent;
  let fixture: ComponentFixture<ProductosContentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProductosContentComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ProductosContentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
