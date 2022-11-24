package ar.edu.unju.escmi.poo.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;

import ar.edu.unju.escmi.poo.config.EmfSingleton;
import ar.edu.unju.escmi.poo.dao.IStockDao;
import ar.edu.unju.escmi.poo.models.Producto;
import ar.edu.unju.escmi.poo.models.Stock;

public class StockDaoImp implements IStockDao {

	private static EntityManager manager = EmfSingleton.getInstance().getEmf().createEntityManager();

	@Override
	public void guardarStock(Stock stock) {
		manager.getTransaction().begin();
		manager.persist(stock);
		manager.getTransaction().commit();

	}

	@Override
	public Stock obtenerStock(Producto producto) {
		@SuppressWarnings("unchecked")
		List<Stock> stocks = (List<Stock>) manager.createQuery("SELECT s FROM Stock s").getResultList();
		for (Stock stock : stocks) {
			if (stock.getProducto().getCodigo() == producto.getCodigo()) {
				return stock;
			}
		}
		return null;
	}

	@Override
	public void modificarStock(Stock stock) {
		manager.getTransaction().begin();
		manager.merge(stock);
		manager.getTransaction().commit();

	}

}
