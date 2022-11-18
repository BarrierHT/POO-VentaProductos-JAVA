package ar.edu.unju.escmi.poo.models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "facturas")
public class Factura implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long nroFactura;

	private LocalDate fechaGeneracion;
	private double total;
	private Usuario usuario;
	// private List<Detalle> detalles = new ArrayList<Detalle>();

	public Factura() {

	}

	public Factura(Long nroFactura, LocalDate fechaGeneracion, double total,
			Usuario usuario/* , List<Detalle> detalles */) {
		this.nroFactura = nroFactura;
		this.fechaGeneracion = fechaGeneracion;
		this.total = total;
		this.usuario = usuario;
		// this.detalles = detalles;
	}

	public Long getNroFactura() {
		return nroFactura;
	}

	public void setNroFactura(Long nroFactura) {
		this.nroFactura = nroFactura;
	}

	public LocalDate getFechaGeneracion() {
		return fechaGeneracion;
	}

	public void setFechaGeneracion(LocalDate fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	// public List<Detalle> getDetalles() {
	// return detalles;
	// }
	//
	// public void setDetalles(List<Detalle> detalles) {
	// this.detalles = detalles;
	// }

	// public void calcularTotal() {
	//
	// for (Detalle detalle : detalles) {
	// this.total += detalle.getImporte();
	// }
	//
	// }

	@Override
	public String toString() {
		return "\n\n******************** Factura ********************" + "\nFecha: " + fechaGeneracion
				+ " N° de Factura: " + nroFactura + "\nUsuario: " + usuario.getNombre() + " " + usuario.getApellido()
				+ "\n************ Detalles de la Factura *************" + "\n";
		// + detalles.toString().replaceAll("\\[|\\]", "").replaceAll(", ", "") + "\n";
	}
}
