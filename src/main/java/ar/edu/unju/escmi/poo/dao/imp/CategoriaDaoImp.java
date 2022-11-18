package ar.edu.unju.escmi.poo.dao.imp;

import javax.persistence.EntityManager;

import ar.edu.unju.escmi.poo.config.EmfSingleton;
import ar.edu.unju.escmi.poo.dao.ICategoriaDao;
import ar.edu.unju.escmi.poo.models.Categoria;

public class CategoriaDaoImp implements ICategoriaDao {

    private static EntityManager manager = EmfSingleton.getInstance().getEmf().createEntityManager();

    @Override
    public void guardarCategoria(Categoria categoria) {
        manager.getTransaction().begin();
        manager.persist(categoria);
        manager.getTransaction().commit();

    }

    @Override
    public Categoria obtenerCategoria(int idCategoria) {
        return manager.find(Categoria.class, idCategoria);
    }

}
