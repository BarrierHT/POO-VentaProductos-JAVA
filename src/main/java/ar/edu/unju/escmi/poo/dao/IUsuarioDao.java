package ar.edu.unju.escmi.poo.dao;

import java.util.List;

import ar.edu.unju.escmi.poo.models.Usuario;

public interface IUsuarioDao {

	public void guardarUsuario(Usuario usuario);

	public Usuario obtenerUsuario(Long dni);

	public List<Usuario> obtenerUsuarios();

	public void modificarUsuario(Usuario usuario);
	
	public void borrarUsuario(Usuario usuario);
}
