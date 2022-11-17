package ar.edu.unju.escmi.poo.models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientes")
@NamedQuery(name = "listarClientes", query = "SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	@Id
	// @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long dni;

	private String nombre;
	private String apellido;
	private String direccion;
	private String email;
	private String password;
	private LocalDate fechaNacimiento;

	public Cliente() {

	}

	public Cliente(Long dni, String nombre, String apellido, String direccion, String email, String password,
			LocalDate fechaNacimiento) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.email = email;
		this.password = password;
		this.fechaNacimiento = fechaNacimiento;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public List<Factura> consultarCompras() {
		List<Factura> shoppingList = new ArrayList<Factura>();
		// if (CollectionFactura.facturas != null) {
		// for (Factura fac : CollectionFactura.facturas) {
		// if (fac.getCliente().getDni() == this.dni) {
		// shoppingList.add(fac);
		// }
		// }
		// } else {
		shoppingList = null;
		// }
		return shoppingList;
	}
}
