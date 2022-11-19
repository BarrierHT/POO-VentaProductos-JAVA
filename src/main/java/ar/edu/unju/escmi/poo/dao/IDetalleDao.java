package ar.edu.unju.escmi.poo.dao;

import java.util.List;

import ar.edu.unju.escmi.poo.models.Detalle;

public interface IDetalleDao {

    public void guardarDetalle(Detalle detalle);

    public Detalle obtenerDetalle(Long idDetalle);

    public List<Detalle> obtenerDetalles(Long nroFactura);

}
