package edu.dosw.lab.testing.reto4;
import java.time.*;

public class Cuenta {
    private int numeroCuenta;
    private int saldo;
    private LocalDateTime fechaCreacion;
    private boolean esValida;

    public Cuenta(int numeroCuenta, int saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.fechaCreacion = LocalDateTime.now();
        this.esValida = true;
    }

    public int getNumeroCuenta() { 
        return numeroCuenta; }
    public void setNumeroCuenta(int numeroCuenta) { 
        this.numeroCuenta = numeroCuenta; }

    public int getSaldo() { return saldo; }
    public void setSaldo(int saldo) { 
        this.saldo = saldo; }

    public LocalDateTime getFechaCreacion() { 
        return fechaCreacion; }

    public boolean isEsValida() { 
        return esValida; }
        
    public void setEsValida(boolean esValida) { 
        this.esValida = esValida; }
}