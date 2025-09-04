package edu.dosw.lab.testing.reto4;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ValidadorCuentaTest {
    @Test
    void testTodasValidas() {
        Cuenta c1 = new Cuenta(1, 100);
        Cuenta c2 = new Cuenta(2, 200);
        ValidadorCuenta validator = new ValidadorCuenta();
        assertTrue(validator.todasValidas(List.of(c1, c2)));
    }

    @Test
    void testExisteCuenta() {
        Cuenta c1 = new Cuenta(1, 100);
        ValidadorCuenta validator = new ValidadorCuenta();
        assertTrue(validator.existeCuenta(List.of(c1), 1));
        assertFalse(validator.existeCuenta(List.of(c1), 99));
    }
}