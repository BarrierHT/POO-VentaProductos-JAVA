package ar.edu.unju.escmi.poo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ar.edu.unju.escmi.poo.config.EmfSingleton;
import ar.edu.unju.escmi.poo.dao.IDetalleDao;
import ar.edu.unju.escmi.poo.dao.IFacturaDao;
import ar.edu.unju.escmi.poo.dao.IUsuarioDao;
import ar.edu.unju.escmi.poo.dao.imp.DetalleDaoImp;
import ar.edu.unju.escmi.poo.dao.imp.FacturaDaoImp;
import ar.edu.unju.escmi.poo.dao.imp.UsuarioDaoImp;
import ar.edu.unju.escmi.poo.models.Detalle;
import ar.edu.unju.escmi.poo.models.Factura;
import ar.edu.unju.escmi.poo.models.Rol;
import ar.edu.unju.escmi.poo.models.Usuario;

public class Principal {

	private static EntityManager manager = EmfSingleton.getInstance().getEmf().createEntityManager();

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int option;
		boolean credencial = false;

		String email, password;

		IUsuarioDao usuarioDao = new UsuarioDaoImp();
		IDetalleDao detalleDao = new DetalleDaoImp();
		IFacturaDao facturaDao = new FacturaDaoImp();

		// Muestra los detalles del nroFactura que ingreses (mirar imp)
		// System.out.println(detalleDao.obtenerDetalles((long) 1).toString());

		// Factura de test (crear usuario y detalles)

		// Factura bill = new Factura(LocalDate.now(), 20,
		// usuarioDao.obtenerUsuario((long) 123),
		// detalleDao.obtenerDetalles((long) 1));

		// facturaDao.guardarFactura(bill);

		// Test de que los detalles se cargaron bien
		// System.out.println(facturaDao.obtenerFactura((long) 2).toString());

		do {

			option = -1;

			// Rol rol = new Rol("newrol");
			// manager.getTransaction().begin();
			// manager.persist(rol);
			// manager.getTransaction().commit();

			// Usuario usuario = new Usuario((long) 12345, "a", "b", "c", "d", "e",
			// LocalDate.now(), new Rol(2, null));
			// Al ingresar el id del rol, tiene que ser una id que exista ya en la bd

			// usuario.setNombre("bar");

			// MANERA 1
			// IUsuarioDao usuarioDao = new UsuarioDaoImp();
			// usuarioDao.guardarUsuario(usuario);

			// MANERA2

			// manager.getTransaction().begin();
			// manager.persist(usuario);
			// manager.getTransaction().commit();

			System.out.println("\n Ingreso de Credenciales");
			System.out.println("\n Ingrese E-Mail");
			email = scanner.next();
			System.out.println("\n Ingreso Contrasena");
			password = scanner.next();

			// corroborar si email y passw concuerdan a un usuario registrado
			// ToDo if(email && password) {}

			System.out.println("\nMenu Principal");
			System.out.println("1- Alta de cliente");
			System.out.println("2- Venta (se genera venta)");
			System.out.println("3- Listado de clientes");
			System.out.println("4- Listado de facturas");
			System.out.println("5- Buscar Factura por numero de factura");

			System.out.println("6- Buscar Factura por numero de factura");
			System.out.println("7- Listar todas sus facturas");
			System.out.println("8- Salir");

			System.out.println("Ingrese su opcion: ");

			try {
				option = scanner.nextInt();
			} catch (Exception e) {
				scanner.next();
				System.out.println("\nINGRESE UN NUMERO");
			}

			if (option == 1) {

				// System.out.println("\nIngrese DNI del cliente: ");
				// long idCard = -1;

				// try {
				// idCard = scanner.nextLong();
				// } catch (Exception e) {
				// scanner.next();
				// System.out.println("\nINGRESE UN NUMERO");
				// }

				Rol rolDeAlta = new Rol();
				Usuario usuarioDeAlta = new Usuario();
				String descripcionRol = null;
				int dia = 0, mes = 0, anio = 0;
				String nombreDeAlta = null, apellidoDeAlta = null, domicilioDeAlta = null;
				Long dniDeAlta = null;
				boolean band = true;
				LocalDate fechaNacimientoDeAlta = LocalDate.now();
				try {
					System.out.println("Ingrese el Nombre del usuario: ");
					nombreDeAlta = scanner.next();
					try {
						System.out.println("Ingrese el Apellido del usuario: ");
						apellidoDeAlta = scanner.next();
						try {
							System.out.println("Ingrese el DNI del usuario: ");
							dniDeAlta = scanner.nextLong();
							try {
								System.out.println("Ingrese el Domicilio del usuario: ");
								domicilioDeAlta = scanner.next();
								try {
									System.out.println("Ingrese la Fecha de Nacimiento del usuario : ");
									DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
									String dateString = scanner.next();
									fechaNacimientoDeAlta = LocalDate.parse(dateString, formatter); // se toma el dato
																									// como string y se
																									// formate a
																									// LocalDate
								} catch (Exception e) {
									scanner.nextLine();
									System.out.println("\nIngrese una Fecha de Nacimiento posible");
									band = false;
								}
							} catch (Exception e) {
								scanner.nextLine();
								System.out.println("\nIngrese un Domicilio posible");
								band = false;
							}
						} catch (Exception e) {
							scanner.nextLine();
							System.out.println("\nIngrese un DNI posible");
							band = false;
						}
					} catch (Exception e) {
						scanner.nextLine();
						System.out.println("\nIngrese un Apellido posible");
						band = false;
					}
				} catch (Exception e) {
					scanner.nextLine();
					System.out.println("\nIngrese un Nombre posible");
					band = false;
				}

				if (band) {

					usuarioDeAlta.setNombre(nombreDeAlta);
					usuarioDeAlta.setApellido(apellidoDeAlta);
					usuarioDeAlta.setDni(dniDeAlta);
					usuarioDeAlta.setEmail(domicilioDeAlta);
					usuarioDeAlta.setFechaNacimiento(fechaNacimientoDeAlta);
				}

				System.out.println("\nOpcion de Alta de Cliente Finalizada");
			} else if (option == 2) {

				System.out.println("\nOpcion de Venta Finalizada");

			} else if (option == 3) {

				// List<Usuario> usuarios = CollectionProducto.productos;
				//
				// for (Usuario usu : usuarios) {
				//
				// Usuario cliente = CollectionStock.buscarStock(pro);
				//
				// if (cliente.getClass() > 0) {
				// System.out.println("\n" + usu.toString());
				// }
				// }

				System.out.println("\nOpcion de Listado de Clientes Finalizada");

			} else if (option == 4) {

				// List<Factura> facturas = CollectionProducto.productos;

				// for (Factura fac : facturas) {
				//
				// Stock stock = CollectionStock.buscarStock(pro);
				//
				// if (stock.getCantidad() > 0) {
				// System.out.println("\n" + fac.toString());
				// }
				// }

				System.out.println("\nOpcion de Listado de Facturas Finalizada");

			} else if (option == 5) {

				System.out.println("\nOpcion de Buscar Factura por numero Finalizada");

			} else if (option == 6) {

				System.out.println("\nOpcion de Buscar Factura por numero Finalizada");

			} else if (option == 7) {

				System.out.println("\nOpcion de Listado de todas las Facturas Finalizada");

			} else if (option == 8) {

				System.out.println("\nHa salido correctamente del programa");
				break;

			} else
				System.out.println("\nOpcion incorrecta");

			System.out.println("\n\n\n");

		} while (1 == 1);

		scanner.close();
	}
}