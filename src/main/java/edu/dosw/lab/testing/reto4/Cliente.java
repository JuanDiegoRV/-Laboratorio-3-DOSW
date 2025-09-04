package edu.dosw.lab.testing.reto4;
import java.util.*;

public class Cliente {
    private String id;
    private String nombre;
    private String email;
    private List<Cuenta> cuentas = new ArrayList<>();

    public Cliente(String id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<Cuenta> getCuentas() { return cuentas; }
    public void agregarCuenta(Cuenta cuenta) { cuentas.add(cuenta); }
}