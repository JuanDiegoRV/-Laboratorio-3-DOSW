package edu.dosw.lab.testing.reto4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BancoTest {

    @Test
    void constructor_inicializa_campos() {
        Banco b = new Banco("B001", "Banco Central");
        assertEquals("B001", b.getCodigo());
        assertEquals("Banco Central", b.getNombre());
    }

    @Test
    void setters_actualizan_valores() {
        Banco b = new Banco("X", "Y");
        b.setCodigo("B999");
        b.setNombre("Banco de Prueba");
        assertEquals("B999", b.getCodigo());
        assertEquals("Banco de Prueba", b.getNombre());
    }

    @Test
    void permite_null_y_cadenas_vacias() {
        Banco b = new Banco("C", "N");

        b.setCodigo(null);
        b.setNombre(null);
        assertNull(b.getCodigo());
        assertNull(b.getNombre());

        b.setCodigo("");
        b.setNombre("");
        assertEquals("", b.getCodigo());
        assertEquals("", b.getNombre());
    }

    @Test
    void soporta_unicode() {
        Banco b = new Banco("银行-01", "Banco Ñandú 🪙");
        assertEquals("银行-01", b.getCodigo());
        assertEquals("Banco Ñandú 🪙", b.getNombre());
    }

    @Test
    void cambios_en_codigo_no_afectan_nombre_y_viceversa() {
        Banco b = new Banco("C1", "N1");
        b.setCodigo("C2");
        assertEquals("C2", b.getCodigo());
        assertEquals("N1", b.getNombre());

        b.setNombre("N2");
        assertEquals("C2", b.getCodigo());
        assertEquals("N2", b.getNombre());
    }
}
