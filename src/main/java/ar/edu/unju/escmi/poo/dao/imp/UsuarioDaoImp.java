package ar.edu.unju.escmi.poo.dao.imp;

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

}
