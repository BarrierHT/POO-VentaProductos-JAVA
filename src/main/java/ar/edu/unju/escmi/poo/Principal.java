package ar.edu.unju.escmi.poo;

import java.time.LocalDate;
import java.util.Scanner;

import javax.persistence.EntityManager;

import ar.edu.unju.escmi.poo.config.EmfSingleton;
import ar.edu.unju.escmi.poo.models.Usuario;

public class Principal {

	private static EntityManager manager = EmfSingleton.getInstance().getEmf().createEntityManager();

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int option;
		String credencial;

		do {

			option = -1;

			Usuario usuario = new Usuario((long) 123, "a", "b", "c", "d", "e", LocalDate.now());

			usuario.setNombre("bar");

			// MANERA 1
			// IUsuarioDao usuarioDao = new UsuarioDaoImp();
			// usuarioDao.guardarUsuario(usuario);

			// MANERA2
			manager.getTransaction().begin();
			manager.persist(usuario);
			manager.getTransaction().commit();

			// credencial = "null";
			//
			// System.out.println("\n Ingreso de Credenciales");
			// System.out.println("\n Ingrese E-Mail");
			// credencial = scanner.next();
			// System.out.println("\n Ingreso Contrasena");
			// credencial = scanner.next();
			//
			// System.out.println("\nMenu Principal");
			// System.out.println("1- Alta de cliente");
			// System.out.println("2- Venta (se genera venta)");
			// System.out.println("3- Listado de clientes");
			// System.out.println("4- Listado de facturas");
			// System.out.println("6- Buscar Factura por numero de factura");
			//
			// System.out.println("6- Buscar Factura por numero de factura");
			// System.out.println("7- Listar todas sus facturas");
			// System.out.println("8- Salir");
			//
			// System.out.println("Ingrese su opcion: ");
			//
			// try {
			// option = scanner.nextInt();
			// } catch (Exception e) {
			// scanner.next();
			// System.out.println("\nINGRESE UN NUMERO");
			// }
			//
			// if (option == 1) {
			//
			// System.out.println("\nIngrese DNI del cliente: ");
			// long idCard = -1;
			//
			// try {
			// idCard = scanner.nextLong();
			// } catch (Exception e) {
			// scanner.next();
			// System.out.println("\nINGRESE UN NUMERO");
			// }
			//
			//// Cliente client = CollectionCliente.buscarCliente(idCard);
			//
			// if (client != null) {
			//
			// System.out.println("\nCliente: " + client.getApellido() + ", " +
			// client.getNombre()
			// + "\nSaldo de Tarjeta: $" + client.getTarjeta().getLimiteCompra());
			//
			// Factura bill = new Factura();
			// boolean generateBill = false;
			// Producto p = null;
			//
			// System.out.println("\nIngrese codigo del producto: ");
			//
			// try {
			// long code = scanner.nextLong();
			// // p = CollectionProducto.buscarProducto(code);
			// } catch (Exception e) {
			// scanner.next();
			// System.out.println("\nINGRESE UN NUMERO");
			// }
			//
			// if (p != null) {
			//
			// System.out.println("\nProducto: " + p.getDescripcion() + "\nPrecio: $" +
			// p.getPrecioUnitario());
			//
			// if (CollectionStock.buscarStock(p) != null) {
			//
			// int cantidad = 0;
			//
			// System.out.println("Stock Disponible: " +
			// CollectionStock.buscarStock(p).getCantidad());
			// System.out.println("\nIngrese cantidad: ");
			//
			// try {
			// cantidad = scanner.nextInt();
			// } catch (Exception e) {
			// scanner.next();
			// System.out.println("\nINGRESE UN NUMERO");
			// }
			//
			// if (cantidad != 0 && CollectionStock.buscarStock(p).getCantidad() >=
			// cantidad) {
			//
			// Detalle details = new Detalle(cantidad, 0, p);
			//
			// if (details.getProducto().getDescripcion().contains("Celular")
			// && details.getImporte() > 120000) {
			//
			// System.out.println("\nLos celulares no pueden superar los $120.000");
			//
			// } else if (details.getImporte() > 200000) {
			//
			// System.out.println("\nLos productos no pueden superar los $200.000");
			//
			// } else {
			//
			// bill.getDetalles().add(details);
			// if (client.getTarjeta().getLimiteCompra() >= bill.calcularTotal()) {
			// generateBill = true;
			// client.getTarjeta().setLimiteCompra(
			// (long) (client.getTarjeta().getLimiteCompra() - bill.calcularTotal()));
			// Stock stock = CollectionStock.buscarStock(p);
			// CollectionStock.reducirStock(stock, cantidad);
			// } else {
			// System.out.println("\nSe excedio el limite de compra de la tarjeta");
			// }
			//
			// }
			//
			// } else {
			//
			// System.out.println("\nNo hay suficiente stock");
			//
			// }
			//
			// } else {
			//
			// System.out.println("\nNo hay stock");
			//
			// }
			//
			// } else {
			//
			// System.out.println("\nNo se encontro el producto");
			//
			// }
			//
			// if (generateBill) {
			//
			// bill.setFecha(LocalDate.now());
			// billNumber++;
			// bill.setNroFactura(billNumber);
			// bill.setCliente(client);
			//
			// CollectionFactura.agregarFactura(bill);
			//
			// List<Cuota> cuotas = new ArrayList<Cuota>();
			// Credito credito = new Credito(client.getTarjeta(), bill, cuotas);
			// CollectionCredito.agregarCredito(credito);
			//
			// System.out.println(bill);
			// } else {
			// System.out.println("\nOcurrio un error al generar la factura");
			// }
			//
			// } else {
			// System.out.println("\nNo se encontro el cliente");
			// }
			//
			// } else if (option == 2) {
			//
			// Cliente client = null;
			//
			// System.out.println("\nIngrese el DNI del cliente:");
			//
			// try {
			// long idCard = scanner.nextLong();
			// client = CollectionCliente.buscarCliente(idCard);
			// } catch (Exception e) {
			// scanner.next();
			// System.out.println("\nINGRESE UN NUMERO");
			// }
			//
			// if (client != null) {
			// List<Factura> shoppingList = client.consultarCompras();
			// if (!shoppingList.isEmpty()) {
			// System.out.println(
			// "COMPRAS: \n" + shoppingList.toString().replaceAll("\\[|\\]",
			// "").replaceAll(", ", ""));
			// } else {
			// System.out.println("\nNo hay compras hechas por el cliente " +
			// client.getApellido() + ", "
			// + client.getNombre());
			// }
			// } else
			// System.out.println("\nEl DNI ingresado no corresponde a ningun cliente");
			//
			// } else if (option == 3) {
			//
			// List<Producto> products = CollectionProducto.productos;
			//
			// for (Producto pro : products) {
			//
			// Stock stock = CollectionStock.buscarStock(pro);
			//
			// if (stock.getCantidad() > 0) {
			// System.out.println("\n" + pro.toString());
			// }
			// }
			//
			// } else if (option == 4) {
			//
			// Producto producto = null;
			//
			// System.out.println("\nIngrese el codigo el producto:");
			//
			// try {
			// long codigo = scanner.nextLong();
			// producto = CollectionProducto.buscarProducto(codigo);
			// } catch (Exception e) {
			// scanner.next();
			// System.out.println("\nINGRESE UN NUMERO");
			// }
			//
			// if (producto != null) {
			// Stock stock = CollectionStock.buscarStock(producto);
			// if (stock != null) {
			// System.out.println("\nEl stock del producto: " +
			// stock.getProducto().getDescripcion()
			// + " es de: " + stock.getCantidad());
			// } else {
			// System.out.println("\nNo se cargo stock del producto");
			// }
			// } else {
			// System.out.println("\nNo se encontro el producto");
			// }
			//
			// } else if (option == 5) {
			//
			// Cliente client = null;
			// boolean band = true; // verifica si tiene creditos
			//
			// System.out.println("\nIngrese el DNI del cliente:");
			//
			// try {
			// long idCard = scanner.nextLong();
			// client = CollectionCliente.buscarCliente(idCard);
			// } catch (Exception e) {
			// scanner.next();
			// System.out.println("\nINGRESE UN NUMERO");
			// }
			//
			// if (client != null) {
			//
			// long numeroTarjeta = client.getTarjeta().getNumero();
			//
			// if (!CollectionCredito.creditos.isEmpty()) {
			//
			// for (Credito cre : CollectionCredito.creditos) {
			// if (numeroTarjeta == cre.getTarjetaCredito().getNumero()) {
			// System.out.println("\nCREDITOS:\n" + cre.toString());
			// band = false;
			// }
			// }
			//
			// }
			// if (band) {
			// System.out.println(
			// "\nEl cliente " + client.apellido + ", " + client.nombre + " no realizo
			// compras");
			// }
			//
			// } else
			// System.out.println("\nEl DNI ingresado no corresponde a ningun cliente");
			//
			// } else if (option == 6) {
			//
			// System.out.println("\nHa salido correctamente del programa");
			// break;
			//
			// } else
			// System.out.println("\nOpcion incorrecta");
			//

			break;

		} while (1 == 1);

		System.out.println("foo");
		scanner.close();
	}
}