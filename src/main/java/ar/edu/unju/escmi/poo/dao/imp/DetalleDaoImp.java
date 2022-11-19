package ar.edu.unju.escmi.poo.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ar.edu.unju.escmi.poo.config.EmfSingleton;
import ar.edu.unju.escmi.poo.dao.IDetalleDao;
import ar.edu.unju.escmi.poo.models.Detalle;

public class DetalleDaoImp implements IDetalleDao {

    private static EntityManager manager = EmfSingleton.getInstance().getEmf().createEntityManager();

    @Override
    public void guardarDetalle(Detalle detalle) {
        manager.getTransaction().begin();
        manager.persist(detalle);
        manager.getTransaction().commit();

    }

    @Override
    public Detalle obtenerDetalle(Long idDetalle) {
        return manager.find(Detalle.class, idDetalle);
    }

    @Override
    public List<Detalle> obtenerDetalles(Long nroFactura) {

        Query query = manager.createQuery("SELECT d FROM Detalle d WHERE d.factura.nroFactura = " + nroFactura);

        @SuppressWarnings("unchecked")
        List<Detalle> detalles = (List<Detalle>) query.getResultList();

        return detalles;
    }
}
