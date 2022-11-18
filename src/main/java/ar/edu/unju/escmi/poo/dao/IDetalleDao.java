package ar.edu.unju.escmi.poo.dao;

import ar.edu.unju.escmi.poo.models.Detalle;

public interface IDetalleDao {

    public void guardarDetalle(Detalle detalle);

    public Detalle obtenerDetalle(Long idDetalle);

}
