package ar.edu.unju.escmi.poo.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;

import ar.edu.unju.escmi.poo.config.EmfSingleton;
import ar.edu.unju.escmi.poo.dao.IUsuarioDao;
import ar.edu.unju.escmi.poo.models.Usuario;

public class UsuarioDaoImp implements IUsuarioDao {
	private static EntityManager manager = EmfSingleton.getInstance().getEmf().createEntityManager();

	@Override
	public Usuario obtenerUsuario(Long dni) {

		return manager.find(Usuario.class, dni);
	}

	@Override
	public void guardarUsuario(Usuario usuario) {
		manager.getTransaction().begin();
		manager.persist(usuario);
		manager.getTransaction().commit();

	}

	@Override
	public List<Usuario> obtenerUsuarios() {
		@SuppressWarnings("unchecked")
		List<Usuario> usuarios = (List<Usuario>) manager.createQuery("SELECT e FROM Usuario e").getResultList();
		return usuarios;
	}

	@Override
	public void modificarUsuario(Usuario usuario) {
		manager.getTransaction().begin();
		manager.merge(usuario);
		manager.getTransaction().commit();
	}
	
	@Override
	public void borrarUsuario(Usuario usuario) {
		manager.getTransaction().begin();
		manager.remove(usuario);
		manager.getTransaction().commit();
	}
}
