package ar.edu.unju.escmi.poo.dao;

import ar.edu.unju.escmi.poo.models.Stock;

public interface IStockDao {

	public void guardarStock(Stock stock);

	public Stock obtenerStock(int idStock);

	public void modificarStock(Stock stock);

}
