package ar.edu.unju.escmi.poo.dao;

import ar.edu.unju.escmi.poo.models.Producto;

public interface IProductoDao {

    public void guardarProducto(Producto producto);

    public Producto obtenerProducto(int codigo);

}
