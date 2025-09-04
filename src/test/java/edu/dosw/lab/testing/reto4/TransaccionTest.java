package edu.dosw.lab.testing.reto4;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TransaccionTest {

    @Test
    void constructor_inicializa_campos_y_fecha_en_rango() {
        LocalDateTime before = LocalDateTime.now();
        Transaccion t = new Transaccion(1, new BigDecimal("123.45"), "DEPOSITO");
        LocalDateTime after = LocalDateTime.now();

        assertEquals(1, t.getId());
        assertEquals(0, t.getMonto().compareTo(new BigDecimal("123.45")));
        assertEquals("DEPOSITO", t.getTipo());

        assertNotNull(t.getFecha());
        assertFalse(t.getFecha().isBefore(before), "fecha no debe ser anterior a la construcción");
        assertFalse(t.getFecha().isAfter(after), "fecha no debe ser posterior a la construcción");
    }

    @Test
    void setters_actualizan_campos() {
        Transaccion t = new Transaccion(10, new BigDecimal("1.00"), "X");
        t.setId(99);
        t.setMonto(new BigDecimal("0.00"));
        t.setTipo("RETIRO");

        assertEquals(99, t.getId());
        assertEquals(0, t.getMonto().compareTo(BigDecimal.ZERO));
        assertEquals("RETIRO", t.getTipo());
    }

    @Test
    void fecha_permanece_constante_tras_cambios() {
        Transaccion t = new Transaccion(2, new BigDecimal("5"), "PAGO");
        LocalDateTime creada = t.getFecha();

        t.setId(3);
        t.setMonto(new BigDecimal("7.50"));
        t.setTipo("AJUSTE");

        assertEquals(creada, t.getFecha(), "fecha debe permanecer inmutable (sin setter)");
    }

    @Test
    void admite_nulls_y_cadenas_vacias_en_tipo_y_monto() {
        Transaccion t = new Transaccion(3, new BigDecimal("1"), "ABC");

        t.setTipo(null);
        assertNull(t.getTipo());
        t.setTipo("");
        assertEquals("", t.getTipo());

        t.setMonto(null);
        assertNull(t.getMonto());
    }

    @Test
    void precision_bigdecimal_se_conserva() {
        Transaccion t = new Transaccion(4, new BigDecimal("0"), "Z");
        t.setMonto(new BigDecimal("10.123456789"));
        assertEquals(0, t.getMonto().compareTo(new BigDecimal("10.123456789")));
        assertEquals(9, t.getMonto().scale(), "espera 9 decimales de precisión");
    }

    @Test
    void admite_montos_negativos_y_cero() {
        Transaccion t = new Transaccion(5, new BigDecimal("1"), "Y");

        t.setMonto(BigDecimal.ZERO);
        assertEquals(0, t.getMonto().compareTo(BigDecimal.ZERO));

        t.setMonto(new BigDecimal("-50.00"));
        assertTrue(t.getMonto().signum() < 0);
        assertEquals(0, t.getMonto().compareTo(new BigDecimal("-50.00")));
    }
}
