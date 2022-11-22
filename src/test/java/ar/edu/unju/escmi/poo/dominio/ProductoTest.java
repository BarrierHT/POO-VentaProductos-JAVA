package ar.edu.unju.escmi.poo.dominio;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import ar.edu.unju.escmi.poo.dao.IProductoDao;
import ar.edu.unju.escmi.poo.dao.imp.ProductoDaoImp;
import ar.edu.unju.escmi.poo.models.Producto;
import junit.framework.TestCase;

class ProductoTest extends TestCase{

	IProductoDao productoDao = new ProductoDaoImp();
	
	@Test
	public void testObtenerProducto() {
		Producto productoObtenido = new Producto();	
		productoObtenido = productoDao.obtenerProducto(111);
		
		assertNotNull(productoObtenido);
		System.out.println("Producto Encontrado: " + productoObtenido.toString());
	}
	
	@Test
	public void testObtenerProductos() {
		List<Producto> productos = new ArrayList<Producto>();
		productos = productoDao.obtenerProductos();
		
		assertNotNull(productos);
		System.out.println("Lista de Productos: " + productos.toString());
	}

}
