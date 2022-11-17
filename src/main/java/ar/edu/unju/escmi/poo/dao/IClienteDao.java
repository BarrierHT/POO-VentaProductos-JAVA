package ar.edu.unju.escmi.poo.dao;

import ar.edu.unju.escmi.poo.models.Cliente;

public interface IClienteDao {
	public Cliente obtenerCliente(Long dni);

	public void guardarCliente(Cliente cliente);
}
