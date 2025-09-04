package edu.dosw.lab.testing.reto4;
import java.util.*;

public class ValidadorCuenta {

    /**
     * Verifica si todas las cuentas en la lista son válidas.
     * @param cuentas Lista de cuentas
     * @return true si todas son válidas, false en caso contrario
     */
    public boolean todasValidas(List<Cuenta> cuentas) {
        return cuentas.stream().allMatch(Cuenta::isEsValida);
    }

    /**
     * Verifica si una cuenta existe por número.
     * @param cuentas Lista de cuentas
     * @param numero Número de cuenta
     * @return true si existe, false en caso contrario
     */
    public boolean existeCuenta(List<Cuenta> cuentas, int numero) {
        return cuentas.stream().anyMatch(c -> c.getNumeroCuenta() == numero);
    }
}