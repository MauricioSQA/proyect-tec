package com.foodappbackend.foodapp.controller;

import com.foodappbackend.foodapp.entity.Empresa;
import com.foodappbackend.foodapp.entity.Producto;
import com.foodappbackend.foodapp.service.IEmpresaService;
import com.foodappbackend.foodapp.service.IProductoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@AllArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200"})
public class ProductoController {

    @Autowired
    private IProductoService productoService;



    @GetMapping("/empresa/{id}")
    public  ResponseEntity<List<Producto>> getProductosByEmpresa(@PathVariable Long id){
        List<Producto> productos = productoService.findByEmpresaId(id);
        return ResponseEntity.ok(productos);
    }


    @PostMapping
    public ResponseEntity<Producto> createProducto(@RequestBody Producto producto) {
        Producto savedProducto = productoService.save(producto);
        return new ResponseEntity<>(savedProducto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Producto>> getAllProductos() {
        List<Producto> productoList = productoService.findAll();
        return new ResponseEntity<>(productoList, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Producto> findProductoById(@PathVariable("id") Long id) {
        Producto producto = productoService.findById(id);
        return new ResponseEntity<>(producto, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Producto> updateProducto(@PathVariable("id") Long id, @RequestBody Producto producto) {
        producto.setId(id);
        Producto updatedProducto = productoService.updateProducto(producto);
        return new ResponseEntity<>(updatedProducto, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProducto(@PathVariable("id") Long id) {
        productoService.deleteById(id);
        return new ResponseEntity<>("Producto was deleted successfully", HttpStatus.OK);
    }


}
