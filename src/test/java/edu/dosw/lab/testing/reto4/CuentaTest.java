package edu.dosw.lab.testing.reto4;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

    @Test
    void constructor_inicializa_campos_correctamente() {
        int numero = 12345;
        int saldo = 1000;

        LocalDateTime before = LocalDateTime.now();
        Cuenta c = new Cuenta(numero, saldo);
        LocalDateTime after = LocalDateTime.now();

        assertEquals(numero, c.getNumeroCuenta());
        assertEquals(saldo, c.getSaldo());
        assertTrue(c.isEsValida(), "Una cuenta nueva debe iniciar válida");

        assertNotNull(c.getFechaCreacion(), "fechaCreacion no debe ser null");
        assertFalse(c.getFechaCreacion().isBefore(before), "fechaCreacion no debe ser anterior al momento de creación");
        assertFalse(c.getFechaCreacion().isAfter(after), "fechaCreacion no debe ser posterior al momento de creación");
    }

    @Test
    void setters_modifican_valores_y_getters_reflejan_cambios() {
        Cuenta c = new Cuenta(1, 0);

        c.setNumeroCuenta(999);
        c.setSaldo(5000);
        c.setEsValida(false);

        assertEquals(999, c.getNumeroCuenta());
        assertEquals(5000, c.getSaldo());
        assertFalse(c.isEsValida());
    }

    @Test
    void fechaCreacion_permanece_constante_tras_cambios() {
        Cuenta c = new Cuenta(77, 10);
        LocalDateTime creada = c.getFechaCreacion();

        c.setNumeroCuenta(88);
        c.setSaldo(999);
        c.setEsValida(false);

        assertEquals(creada, c.getFechaCreacion(), "fechaCreacion no debe cambiar después de crear la cuenta");
    }

    @Test
    void saldo_admite_valores_limite_enteros() {
        Cuenta c = new Cuenta(1, 0);

        c.setSaldo(Integer.MAX_VALUE);
        assertEquals(Integer.MAX_VALUE, c.getSaldo());

        c.setSaldo(Integer.MIN_VALUE); 
        assertEquals(Integer.MIN_VALUE, c.getSaldo());
    }

    @Test
    void numeroCuenta_admite_valores_limite_enteros() {
        Cuenta c = new Cuenta(0, 0);

        c.setNumeroCuenta(Integer.MAX_VALUE);
        assertEquals(Integer.MAX_VALUE, c.getNumeroCuenta());

        c.setNumeroCuenta(Integer.MIN_VALUE);
        assertEquals(Integer.MIN_VALUE, c.getNumeroCuenta());
    }

    @Test
    void esValida_por_defecto_es_true_y_puede_setearse() {
        Cuenta c = new Cuenta(10, 10);
        assertTrue(c.isEsValida());

        c.setEsValida(false);
        assertFalse(c.isEsValida());

        c.setEsValida(true);
        assertTrue(c.isEsValida());
    }
}
