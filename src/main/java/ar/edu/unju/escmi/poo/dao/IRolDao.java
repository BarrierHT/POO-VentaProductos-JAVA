package ar.edu.unju.escmi.poo.dao;

import ar.edu.unju.escmi.poo.models.Rol;

public interface IRolDao {

    public void guardarRol(Rol rol);

    public Rol obtenerRol(int idRol);
}
