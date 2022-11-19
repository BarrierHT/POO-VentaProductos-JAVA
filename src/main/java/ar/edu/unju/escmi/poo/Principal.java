package ar.edu.unju.escmi.poo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import ar.edu.unju.escmi.poo.config.EmfSingleton;
import ar.edu.unju.escmi.poo.dao.IDetalleDao;
import ar.edu.unju.escmi.poo.dao.IFacturaDao;
import ar.edu.unju.escmi.poo.dao.IUsuarioDao;
import ar.edu.unju.escmi.poo.dao.imp.DetalleDaoImp;
import ar.edu.unju.escmi.poo.dao.imp.FacturaDaoImp;
import ar.edu.unju.escmi.poo.dao.imp.UsuarioDaoImp;
import ar.edu.unju.escmi.poo.models.Usuario;

public class Principal {

	private static EntityManager manager = EmfSingleton.getInstance().getEmf().createEntityManager();

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int option = -1;
		boolean credencial = false;

		String email = "", password = "";

		IUsuarioDao usuarioDao = new UsuarioDaoImp();
		IDetalleDao detalleDao = new DetalleDaoImp();
		IFacturaDao facturaDao = new FacturaDaoImp();

		List<Usuario> usuariosList = usuarioDao.obtenerUsuarios(); // Get all users
		Usuario usuarioRecovered = null; // Get user to initiate the session

		// Muestra los detalles del nroFactura que ingreses (mirar imp)
//		 System.out.println(detalleDao.obtenerDetalles((long) 1).toString());

		// Factura de test (crear usuario y detalles)

		// Factura bill = new Factura(LocalDate.now(), 20,
		// usuarioDao.obtenerUsuario((long) 123),
		// detalleDao.obtenerDetalles((long) 1));

		// facturaDao.guardarFactura(bill);

		// Test de que los detalles se cargaron bien
		// System.out.println(facturaDao.obtenerFactura((long) 2).toString());

		// Rol rol = new Rol("newrol");
		// manager.getTransaction().begin();
		// manager.persist(rol);
		// manager.getTransaction().commit();

//			Usuario usuario = new Usuario((long) 12, "a", "b", "c", "demail", "email", LocalDate.now(), new Rol(1));
		// Al ingresar el id del rol, tiene que ser una id que exista ya en la bd

		// MANERA 1
//			usuarioDao.guardarUsuario(usuario);

		// MANERA2

		// manager.getTransaction().begin();
		// manager.persist(usuario);
		// manager.getTransaction().commit();

		do {

			if (credencial == false) { // User is not logged in
				do {
					try {
						System.out.println("\nDigite el email del usuario: ");
						email = scanner.next();
						System.out.println("Digite la contraseña del usuario: ");
						password = scanner.next();
					} catch (Exception e) {
						scanner.next();
						System.out.println("\nINGRESE Los datos");
					}

					for (Usuario usuario : usuariosList) {
						if (usuario.getEmail().equals(email) && usuario.getPassword().equals(password)) {
							usuarioRecovered = usuario;
							break;
						}
					}
					if (usuarioRecovered == null) {
						System.out.println("\n\n Credenciales incorrectas \n\n");
					} else {
						credencial = true;
						break;
					}

				} while (1 == 1);
			}

			if (credencial) { // User is logged in Correctly

				option = -1;

				System.out.println("Logged in: " + usuarioRecovered.getRol().getTipo());

				if (usuarioRecovered.getRol().getTipo().equals("Vendedor")) { // Menu de vendedor
					System.out.println("\nMenu Principal");
					System.out.println("1- Alta de cliente");
					System.out.println("2- Venta (se genera venta)");
					System.out.println("3- Listado de clientes");
					System.out.println("4- Listado de facturas");
					System.out.println("5- Buscar Factura por numero de factura");
					System.out.println("6- Salir");

					System.out.println("Ingrese su opcion: ");

					try {
						option = scanner.nextInt();
					} catch (Exception e) {
						scanner.next();
						System.out.println("\nINGRESE UN NUMERO");
					}

					if (option == 1) {

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
											fechaNacimientoDeAlta = LocalDate.parse(dateString, formatter); // se
																											// formatea
																											// a
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

//							usuarioDeAlta.setNombre(nombreDeAlta);
//							usuarioDeAlta.setApellido(apellidoDeAlta);
//							usuarioDeAlta.setDni(dniDeAlta);
//							usuarioDeAlta.setEmail(domicilioDeAlta);
//							usuarioDeAlta.setFechaNacimiento(fechaNacimientoDeAlta);
						}

						System.out.println("\nOpcion de Alta de Cliente Finalizada");
					} else if (option == 2) {

						System.out.println("\nOpcion de Venta Finalizada");

					} else if (option == 3) {

						System.out.println("\nOpcion de Listado de Clientes Finalizada");

					} else if (option == 4) {

						System.out.println("\nOpcion de Listado de Facturas Finalizada");

					} else if (option == 5) {

						System.out.println("\nOpcion de Buscar Factura por numero Finalizada");

					} else if (option == 6)
						break;
					else
						System.out.println("\nOpcion incorrecta");

				} else if (usuarioRecovered.getRol().getTipo().equals("Cliente")) { // Menu de Cliente
					System.out.println("1- Buscar Factura por numero de factura");
					System.out.println("2- Listar todas sus facturas");
					System.out.println("3- Salir");

					System.out.println("Ingrese su opcion: ");

					try {
						option = scanner.nextInt();
					} catch (Exception e) {
						scanner.next();
						System.out.println("\nINGRESE UN NUMERO");
					}

					if (option == 1) {

						System.out.println("\nOpcion de Listado de todas las Facturas Finalizada");

					} else if (option == 2) {

					} else if (option == 3) {

						System.out.println("\nHa salido correctamente del programa");
						break;

					} else
						System.out.println("\nOpcion incorrecta");

				}

				System.out.println("\n\n\n\n");
			}

		} while (1 == 1);

		scanner.close();
	}
}