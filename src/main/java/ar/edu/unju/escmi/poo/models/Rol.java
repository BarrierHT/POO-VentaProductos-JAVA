package ar.edu.unju.escmi.poo.models;

public class Rol {

    private int id;
    private String tipo;

    public Rol() {

    }

    public Rol(int id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
