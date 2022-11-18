package ar.edu.unju.escmi.poo.dao;

import ar.edu.unju.escmi.poo.models.Categoria;

public interface ICategoriaDao {

    public void guardarCategoria(Categoria categoria);

    public Categoria obtenerCategoria(int idCategoria);
}
