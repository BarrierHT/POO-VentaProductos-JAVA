package ar.edu.unju.escmi.poo.dao;

import java.util.List;

import ar.edu.unju.escmi.poo.models.Factura;

public interface IFacturaDao {

    public void guardarFactura(Factura factura);

    public Factura obtenerFactura(Long nroFactura);

    public List<Factura> obtenerFacturas();
}
