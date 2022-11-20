package ar.edu.unju.escmi.poo.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;

import ar.edu.unju.escmi.poo.config.EmfSingleton;
import ar.edu.unju.escmi.poo.dao.IProductoDao;
import ar.edu.unju.escmi.poo.models.Producto;

public class ProductoDaoImp implements IProductoDao {

	private static EntityManager manager = EmfSingleton.getInstance().getEmf().createEntityManager();

	@Override
	public void guardarProducto(Producto producto) {
		manager.getTransaction().begin();
		manager.persist(producto);
		manager.getTransaction().commit();

	}

	@Override
	public Producto obtenerProducto(int codigo) {
		return manager.find(Producto.class, codigo);
	}

	@Override
	public List<Producto> obtenerProductos() {
		@SuppressWarnings("unchecked")
		List<Producto> productos = (List<Producto>) manager.createQuery("SELECT p FROM Producto p").getResultList();
		return productos;
	}

}
