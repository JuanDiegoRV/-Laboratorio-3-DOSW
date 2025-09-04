package edu.dosw.lab.testing.reto4;
import java.util.*;

public class GestionCuenta {
    private final List<Cuenta> cuentas = new ArrayList<>();

    /**
     * Crea una nueva cuenta.
     * @param numero Número de cuenta
     * @param saldoInicial Saldo inicial
     * @return Cuenta creada
     */
    public Cuenta crearCuenta(int numero, int saldoInicial) {
        Cuenta cuenta = new Cuenta(numero, saldoInicial);
        cuentas.add(cuenta);
        return cuenta;
    }

    /**
     * Realiza un depósito en una cuenta existente.
     * @param numeroCuenta Número de cuenta
     * @param monto Monto a depositar
     * @return true si el depósito fue exitoso, false si no existe la cuenta
     */
    public boolean depositar(int numeroCuenta, int monto) {
        Optional<Cuenta> cuentaOpt = cuentas.stream()
                .filter(c -> c.getNumeroCuenta() == numeroCuenta)
                .findFirst();
        cuentaOpt.ifPresent(c -> c.setSaldo(c.getSaldo() + monto));
        return cuentaOpt.isPresent();
    }

    /**
     * Consulta el saldo de una cuenta.
     * @param numeroCuenta Número de cuenta
     * @return Saldo actual
     * @throws IllegalArgumentException si no existe la cuenta
     */
    public int consultarSaldo(int numeroCuenta) {
        return cuentas.stream()
                .filter(c -> c.getNumeroCuenta() == numeroCuenta)
                .map(Cuenta::getSaldo)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Cuenta no encontrada"));
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }
}