package ar.edu.unju.escmi.poo.dao.imp;

import javax.persistence.EntityManager;

import ar.edu.unju.escmi.poo.config.EmfSingleton;
import ar.edu.unju.escmi.poo.dao.IRolDao;
import ar.edu.unju.escmi.poo.models.Rol;

public class RolDaoImp implements IRolDao {

    private static EntityManager manager = EmfSingleton.getInstance().getEmf().createEntityManager();

    @Override
    public void guardarRol(Rol rol) {
        manager.getTransaction().begin();
        manager.persist(rol);
        manager.getTransaction().commit();

    }

    @Override
    public Rol obtenerRol(int idRol) {
        return manager.find(Rol.class, idRol);
    }

}
