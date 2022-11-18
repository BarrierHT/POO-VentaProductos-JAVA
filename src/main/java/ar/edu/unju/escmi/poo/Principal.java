package ar.edu.unju.escmi.poo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import javax.persistence.EntityManager;

import ar.edu.unju.escmi.poo.config.EmfSingleton;
import ar.edu.unju.escmi.poo.models.Rol;
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

			 credencial = "null";
			
			 System.out.println("\n Ingreso de Credenciales");
			 System.out.println("\n Ingrese E-Mail");
			 credencial = scanner.next();
			 System.out.println("\n Ingreso Contrasena");
			 credencial = scanner.next();
			
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
			
			 //try {
			 //idCard = scanner.nextLong();
			 //} catch (Exception e) {
			 //scanner.next();
			 //System.out.println("\nINGRESE UN NUMERO");
			 //}
				 
				 Rol rolDeAlta = new Rol();
                 Usuario usuarioDeAlta = new Usuario();
                 String descripcionRol = null;
                 int dia = 0, mes = 0, anio = 0;
                 String nombreDeAlta = null, apellidoDeAlta = null, domicilioDeAlta = null; 
                 Long dniDeAlta = null;
                 boolean band = true;
                 LocalDate fechaNacimientoDeAlta;
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
                                     DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("d/MM/yyyy");
                                     String dateString = scanner.next();
                                     fechaNacimientoDeAlta = LocalDate.parse(dateString, formatter); //se toma el dato como string y se formate a LocalDate
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

                 } else if (option == 2) {
         		
         		 System.out.println("\nHa salido correctamente del programa");
         		 break;
         		
                 } else if (option == 3) {
              		
             		 System.out.println("\nHa salido correctamente del programa");
             		 break;
             		 
                 } else if (option == 4) {
              		
             		 System.out.println("\nHa salido correctamente del programa");
             		 break;
             		 
                 } else if (option == 5) {
              		
             		 System.out.println("\nHa salido correctamente del programa");
             		 break;
             		 
                 } else if (option == 6) {
              		
             		 System.out.println("\nHa salido correctamente del programa");
             		 break;
             		 
                 } else if (option == 7) {
              		
             		 System.out.println("\nHa salido correctamente del programa");
             		 break;
			
                 } else if (option == 8) {
			
                	 System.out.println("\nHa salido correctamente del programa");
                	 break;
			
                 } else
                	 System.out.println("\nOpcion incorrecta");
                 break;

		} while (1 == 1);

		scanner.close();
	}
}