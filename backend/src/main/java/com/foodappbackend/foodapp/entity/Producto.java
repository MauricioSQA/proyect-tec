package com.foodappbackend.foodapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private Double precioOriginal;

    @Column(nullable = false)
    private Double precioOferta;

    @Column(nullable = false)
    private Integer cant_disponible;

   @ManyToOne(fetch = FetchType.LAZY)
   @JsonBackReference
    @JoinColumn(name = "empresa_id", referencedColumnName = "id")
    private Empresa empresa;
}
