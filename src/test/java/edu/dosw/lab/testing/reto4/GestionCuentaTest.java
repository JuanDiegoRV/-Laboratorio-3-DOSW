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

    // --- Extras sugeridos para cubrir ramas ---

    @Test
    void testDepositarEnCuentaInexistente_falla() {
        GestionCuenta service = new GestionCuenta();
        assertFalse(service.depositar(999, 50)); 
    }

    @Test
    void testDepositarMontoNegativo_noCambiaSaldo() {
        GestionCuenta service = new GestionCuenta();
        service.crearCuenta(10, 100);
        assertFalse(service.depositar(10, -5)); 
        assertEquals(100, service.consultarSaldo(10));
    }

    @Test
    void testCrearCuentaDuplicada_lanzaExcepcion() {
        GestionCuenta service = new GestionCuenta();
        service.crearCuenta(11, 100);
        Exception ex = assertThrows(IllegalArgumentException.class, () -> service.crearCuenta(11, 200));
        assertTrue(ex.getMessage() == null || !ex.getMessage().isBlank());
    }
}
