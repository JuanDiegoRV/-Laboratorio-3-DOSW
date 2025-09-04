package edu.dosw.lab.testing.reto4;
import java.time.*;
import java.math.*;

public class Transaccion {
    private int id;
    private BigDecimal monto;
    private String tipo;
    private LocalDateTime fecha;

    public Transaccion(int id, BigDecimal monto, String tipo) {
        this.id = id;
        this.monto = monto;
        this.tipo = tipo;
        this.fecha = LocalDateTime.now();
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public BigDecimal getMonto() { return monto; }
    public void setMonto(BigDecimal monto) { this.monto = monto; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public LocalDateTime getFecha() { return fecha; }
}