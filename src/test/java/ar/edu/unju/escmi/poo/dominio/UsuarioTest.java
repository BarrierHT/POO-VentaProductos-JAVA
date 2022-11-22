package ar.edu.unju.escmi.poo.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import ar.edu.unju.escmi.poo.dao.IRolDao;
import ar.edu.unju.escmi.poo.dao.IUsuarioDao;
import ar.edu.unju.escmi.poo.dao.imp.RolDaoImp;
import ar.edu.unju.escmi.poo.dao.imp.UsuarioDaoImp;
import ar.edu.unju.escmi.poo.models.Rol;
import ar.edu.unju.escmi.poo.models.Usuario;
import junit.framework.TestCase;

@TestMethodOrder(OrderAnnotation.class)
public class UsuarioTest extends TestCase {

	IUsuarioDao usuarioDao = new UsuarioDaoImp();
	Usuario usuario;

	@BeforeEach
	protected void setUp() throws Exception {
		usuario = new Usuario();
	}

	@Test
	@Order(1)
	public void testGuardarUsuario() {
		IRolDao rolDao = new RolDaoImp();
		Rol rol = rolDao.obtenerRol(1);
		usuario.setDni((long) 111);
		usuario.setNombre("testNombre");
		usuario.setApellido("testApellido");
		usuario.setEmail("testEmail111");
		usuario.setPassword("testPassword");
		usuario.setFechaNacimiento(LocalDate.now());
		usuario.setRol(rol);
		// Usuario usuario = new Usuario((long) 111, "testNombre" , "testApellido",
		// "testDireccion", "testEmail111", "testPassword", LocalDate.now(), rol);
		usuarioDao.guardarUsuario(usuario);

		assertNotNull(usuarioDao.obtenerUsuario(usuario.getDni()));

		System.out.println("Usuario Guardado: " + usuario.toString());
	}

	@Test
	@Order(2)
	public void testObtenerUsuario() {
		usuario = usuarioDao.obtenerUsuario((long) 1);

		assertNotNull(usuario);
		System.out.println("Usuario Encontrado: " + usuario.toString());
	}

	@Test
	@Order(3)
	public void testObtenerUsuarios() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios = usuarioDao.obtenerUsuarios();

		assertNotNull(usuarios);
		System.out.println("Lista de Usuarios: " + usuarios.toString());
	}

	@Test
	@Order(4)
	public void borrarUsuario() {
		usuario = usuarioDao.obtenerUsuario((long) 111);
		assertNotNull(usuario);

		usuarioDao.borrarUsuario(usuario);
		assertNull(usuarioDao.obtenerUsuario((long) 111));

		System.out.println("Usuario Borrado: " + usuario.toString());
	}

}
