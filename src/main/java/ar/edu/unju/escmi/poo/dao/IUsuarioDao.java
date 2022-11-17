package ar.edu.unju.escmi.poo.dao;

import ar.edu.unju.escmi.poo.models.Usuario;

public interface IUsuarioDao {
	public Usuario obtenerUsuario(Long dni);

	public void guardarUsuario(Usuario cliente);
}
