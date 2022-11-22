package ar.edu.unju.escmi.poo.dominio;

import org.junit.jupiter.api.Test;

import ar.edu.unju.escmi.poo.dao.IFacturaDao;
import ar.edu.unju.escmi.poo.dao.imp.FacturaDaoImp;
import junit.framework.TestCase;

class FacturaTest extends TestCase{

	IFacturaDao facturaDao = new FacturaDaoImp();
	
	@Test
	public void testGuardarFactura() {
		
	}

}
