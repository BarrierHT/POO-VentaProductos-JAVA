package ar.edu.unju.escmi.poo.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "producto_id")
	private Producto producto;

	@ManyToOne
	@JoinColumn(name = "factura_id")
	private Factura factura;

	public Detalle() {

	}

	public Detalle(Long id) {

		this.id = id;
	}

	public Detalle(int cantidad, double importe, Producto producto, Factura factura) {
		this.cantidad = cantidad;
		this.importe = importe;
		this.producto = producto;
		this.factura = factura;
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

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "DESCRIPCION: " + producto.getDescripcion() 
				+ "\nDESCUENTO: " + producto.getDescuento() + "%" + " | CANTIDAD: " 
				+ cantidad + " | PRECIO: " + producto.getPrecioUnitario() + " | IMPORTE: " + importe + "\n";
	}
}
