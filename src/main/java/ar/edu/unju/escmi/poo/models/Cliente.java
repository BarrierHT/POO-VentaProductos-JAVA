package ar.edu.unju.escmi.poo.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
@NamedQuery(name = "listarClientes", query = "SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long dni;

	private String nombre;

	public Cliente(Long dni, String nombre) {
		this.dni = dni;
		this.nombre = nombre;
	}

	public Long getDni() {
		return dni;
	}

	public void setDni(Long dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
