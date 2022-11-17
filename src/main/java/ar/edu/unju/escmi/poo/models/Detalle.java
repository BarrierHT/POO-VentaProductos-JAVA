package ar.edu.unju.escmi.poo.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "detalles")
public class Detalle implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;

	private int cantidad;
	private double importe;
	private Producto producto;

	public Detalle() {

	}

	public Detalle(Long id, int cantidad, double importe, Producto producto) {
		this.id = id;
		this.cantidad = cantidad;
		this.importe = importe;
		this.producto = producto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public void calcularImporte() {
		this.setImporte(this.cantidad * this.producto.getPrecioUnitario());
	}

	@Override
	public String toString() {
		return "PRODUCTO: " + producto + "\nCANTIDAD: " + cantidad + " | IMPORTE: " + importe + "\n";
	}
}
