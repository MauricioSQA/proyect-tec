import { Component,OnInit } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import Swal from 'sweetalert2';
import { CommonModule } from '@angular/common';
import * as Aos from 'aos';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { ProductosContentComponent } from './productos-content/productos-content.component';
import { Productos } from '../../models/producto';
import { ProductosService } from '../../services/productos.service';

@Component({
  selector: 'app-productos',
  standalone: true,
  imports: [FormsModule,CommonModule,RouterLink,ProductosContentComponent],
  templateUrl: './productos.component.html',
  styleUrl: './productos.component.css'
})
export class ProductosComponent implements OnInit {
  Productos: Productos = {
  nombre: '',
    descripcion: '',
    precioOriginal: '',
    precioOferta: '',
    cant_disponible: ''
};

productos: Productos[] = [];
id: number = 0;
empresaId:number=0;
constructor(private service: ProductosService, private route: ActivatedRoute) {}

ngOnInit(): void {
  Aos.init();
  
 // Obtener el ID de la empresa de la URL
 this.route.paramMap.subscribe((params) => {
  this.empresaId = +(params.get('empresa_id') || '0');
  console.log(this.empresaId)
  if (this.empresaId > 0) {
    this.getProductsByEmpresa(this.empresaId);
  } 
});
}

getProductsByEmpresa(empresaId: number): void {
this.service.findAllByEmpresa(empresaId).subscribe((productos) => {
  console.log('Productos por Empresa: ', productos);
  this.productos = productos;
});
  /*
  this.service.findAll().subscribe((AllProductos) => {
    console.log('ALl Productos: ', AllProductos);
    this.productos = AllProductos;
  });*/

  //Get Productos ID
  this.route.paramMap.subscribe((params) => {
    const id: number = +(params.get('id') || '0');
    if (id > 0) {
      this.service.findById(id).subscribe((res) => {
        this.Productos = res;
        this.id = res.id!;
        console.log('Final ID :', this.id);
      });
    }
  });
}
onCreate() {
  this.Productos.empresa={id:this.empresaId} as any;
  
  this.service.create(this.Productos).subscribe(
    (item) => {
      console.log('Productos: ', item);
      Swal.fire({
        title: 'Productos registrados',
        text: 'Productos ' + this.Productos.nombre + ' registrados con éxito',
        icon: 'success',
      });
      this.resetProductos();
      this.service.findAllByEmpresa(this.empresaId).subscribe((Productos) => {
        console.log('Productos por Empresa: ', Productos);
        this.productos = Productos;
      });
    },
    (error) => {
      console.log('Error: ', error);
    }
  );
}

onDelete(id: number) {
  this.service.eliminar(id).subscribe(
    (response) => {
      console.log('Productos was deleted', response);
    },
    (error) => {
      console.log('On Delete Error: ', error);
      Swal.fire({
        title: 'Productos eliminados',
        text: 'Productos ' + this.Productos.nombre + ' eliminados con éxito',
        icon: 'success',
      });
      this.service.findAllByEmpresa(this.empresaId).subscribe((productos) => {
        this.productos = productos;
      });
    }
  );
}

update(id: number, productos: Productos) {
  this.service.update(id, productos).subscribe(
    (res) => {
      this.Productos = res;
      Swal.fire({
        title: 'Productos Actualizados',
        text: 'Productos ' + this.Productos.nombre + ' actualizados con éxito',
        icon: 'success',
      });
      this.service.findAllByEmpresa(this.empresaId).subscribe((Productos) => {
        this.productos =this.productos;
      });
      this.resetProductos();
    },
    (error) => {
      console.log('Error: ', error);
    }
  );
}

resetProductos() {
  this.Productos = {
    nombre: '',
    descripcion: '',
    precioOriginal: '',
    precioOferta: '',
    cant_disponible: '',
  };
  this.id = 0;
}
}


