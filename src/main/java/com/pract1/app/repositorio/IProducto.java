package com.pract1.app.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pract1.app.entitys.Producto;

@Repository
public interface IProducto extends JpaRepository<Producto,Long>{

}
