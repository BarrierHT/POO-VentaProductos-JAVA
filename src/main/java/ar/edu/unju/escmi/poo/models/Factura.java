package ar.edu.unju.escmi.poo.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@OneToMany(mappedBy = "", fetch = FetchType.EAGER)
	private List<Detalle> detalles = new ArrayList<Detalle>();

	public Factura() {

	}

	public Factura(Long nroFactura) {
		this.nroFactura = nroFactura;
	}

	public Factura(LocalDate fechaGeneracion, double total, Usuario usuario, List<Detalle> detalles) {
		this.fechaGeneracion = fechaGeneracion;
		this.total = total;
		this.usuario = usuario;
		this.detalles = detalles;
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

	public List<Detalle> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<Detalle> detalles) {
		this.detalles = detalles;
	}

	public double calcularTotal() {
		double total = 0;
		for (Detalle detalle : detalles) {
			total += detalle.getImporte();
		}
		return total;
	}

	@Override
	public String toString() {
		return "\n\n******************** Factura ********************" + "\nFecha: " + fechaGeneracion
				+ " N° de Factura: " + nroFactura + "\nUsuario: " + usuario.getNombre() + " " + usuario.getApellido()
				+ "\n************ Detalles de la Factura *************" + "\n"
				+ detalles.toString().replaceAll("\\[|\\]", "").replaceAll(", ", "") + "\n";
	}
}
