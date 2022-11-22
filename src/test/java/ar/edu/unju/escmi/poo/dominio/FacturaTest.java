package ar.edu.unju.escmi.poo.dominio;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import ar.edu.unju.escmi.poo.dao.IFacturaDao;
import ar.edu.unju.escmi.poo.dao.IUsuarioDao;
import ar.edu.unju.escmi.poo.dao.imp.FacturaDaoImp;
import ar.edu.unju.escmi.poo.dao.imp.UsuarioDaoImp;
import ar.edu.unju.escmi.poo.models.Detalle;
import ar.edu.unju.escmi.poo.models.Factura;
import ar.edu.unju.escmi.poo.models.Usuario;
import junit.framework.TestCase;

@TestMethodOrder(OrderAnnotation.class)
class FacturaTest extends TestCase{

	IFacturaDao facturaDao = new FacturaDaoImp();
	IUsuarioDao usuarioDao = new UsuarioDaoImp();
	static Factura factura;
	static ArrayList<Detalle> detalles;
	static Usuario usuario;
	
	@BeforeAll
	public static void inicioTest() {
		factura = new Factura();
		detalles = null;
		usuario = null;
	}
	
	@Test
	@Order(1)
	public void testGuardarFactura() {
		factura.setFechaGeneracion(LocalDate.now());
		factura.setTotal(0);
		factura.setUsuario(usuarioDao.obtenerUsuario((long) 1));
		factura.setDetalles(detalles);
		
		facturaDao.guardarFactura(factura);
		assertNotNull(facturaDao.obtenerFactura(factura.getNroFactura()));
	}
	
	@Test
	@Order(2)
	public void testCalcularTotal() {
		detalles = new ArrayList<Detalle>();
		detalles.add(new Detalle(1, 10000, null, null));
		detalles.add(new Detalle(1, 1200, null, null));
		detalles.add(new Detalle(1, 1000, null, null));
		detalles.add(new Detalle(1, 20000, null, null));
		
		factura.setDetalles(detalles);
		factura.calcularTotal();
		assertEquals(32200.0, factura.getTotal());
	}
	
	@Test
	@Order(3)
	public void testBorrarFactura() {
		factura = facturaDao.obtenerFactura(factura.getNroFactura());
		assertNotNull(factura);
		
		facturaDao.borrarFactura(factura);
		assertNull(facturaDao.obtenerFactura(factura.getNroFactura()));
	}

}
