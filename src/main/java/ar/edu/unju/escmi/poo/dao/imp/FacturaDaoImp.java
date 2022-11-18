package ar.edu.unju.escmi.poo.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;

import ar.edu.unju.escmi.poo.config.EmfSingleton;
import ar.edu.unju.escmi.poo.dao.IFacturaDao;
import ar.edu.unju.escmi.poo.models.Factura;

public class FacturaDaoImp implements IFacturaDao {

    private static EntityManager manager = EmfSingleton.getInstance().getEmf().createEntityManager();

    @Override
    public void guardarFactura(Factura factura) {
        manager.getTransaction().begin();
        manager.persist(factura);
        manager.getTransaction().commit();

    }

    @Override
    public Factura obtenerFactura(Long nroFactura) {
        return manager.find(Factura.class, nroFactura);
    }

    @Override
    public List<Factura> obtenerFacturas() {
        @SuppressWarnings("unchecked")
        List<Factura> facturas = (List<Factura>) manager.createQuery("SELECT e FROM Factura e").getResultList();
        return facturas;
    }
}
