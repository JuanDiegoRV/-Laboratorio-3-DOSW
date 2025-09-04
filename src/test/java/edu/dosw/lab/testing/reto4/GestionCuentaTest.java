package edu.dosw.lab.testing.reto4;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GestionCuentaTest {
    @Test
    void testCrearCuentaYConsultarSaldo() {
        GestionCuenta service = new GestionCuenta();
        service.crearCuenta(1, 500);
        assertEquals(500, service.consultarSaldo(1));
    }

    @Test
    void testDepositar() {
        GestionCuenta service = new GestionCuenta();
        service.crearCuenta(2, 100);
        assertTrue(service.depositar(2, 50));
        assertEquals(150, service.consultarSaldo(2));
    }

    @Test
    void testConsultarCuentaInexistente() {
        GestionCuenta service = new GestionCuenta();
        Exception ex = assertThrows(IllegalArgumentException.class, () -> service.consultarSaldo(99));
        assertEquals("Cuenta no encontrada", ex.getMessage());
    }
}
