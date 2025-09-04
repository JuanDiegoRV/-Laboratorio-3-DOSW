package edu.dosw.lab.testing.reto4;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    void constructor_inicializa_campos_y_lista_vacia() {
        Cliente c = new Cliente("cli-1", "Ana", "ana@mail.com");
        assertEquals("cli-1", c.getId());
        assertEquals("Ana", c.getNombre());
        assertEquals("ana@mail.com", c.getEmail());
        assertNotNull(c.getCuentas());
        assertTrue(c.getCuentas().isEmpty(), "La lista de cuentas debe iniciar vacía");
    }

    @Test
    void setters_actualizan_valores() {
        Cliente c = new Cliente("a", "b", "c@x");
        c.setId("cli-99");
        c.setNombre("Carlos");
        c.setEmail("carlos@example.org");
        assertEquals("cli-99", c.getId());
        assertEquals("Carlos", c.getNombre());
        assertEquals("carlos@example.org", c.getEmail());
    }

    @Test
    void agregarCuenta_agrega_instancia_y_preserva_referencia() {
        Cliente c = new Cliente("id", "nom", "e@mail");
        Cuenta cu1 = new Cuenta(100, 500);
        Cuenta cu2 = new Cuenta(200, 0);

        c.agregarCuenta(cu1);
        c.agregarCuenta(cu2);

        List<Cuenta> lista = c.getCuentas();
        assertEquals(2, lista.size());
        assertSame(cu1, lista.get(0), "Debe ser la misma instancia agregada");
        assertSame(cu2, lista.get(1));
    }

    @Test
    void getCuentas_devuelve_lista_viva_modificable() {
        Cliente c = new Cliente("id", "nom", "e@mail");
        // Lista inicialmente vacía
        assertTrue(c.getCuentas().isEmpty());

        // Si el diseño permite, modificar directamente la lista:
        c.getCuentas().add(new Cuenta(1, 10));
        assertEquals(1, c.getCuentas().size());

        // También agregar por método dedicado:
        c.agregarCuenta(new Cuenta(2, 20));
        assertEquals(2, c.getCuentas().size());
    }

    @Test
    void agregarCuenta_permite_null_y_duplicados_si_no_hay_validaciones() {
        Cliente c = new Cliente("id", "nom", "e@mail");
        Cuenta cu = new Cuenta(1, 100);

        c.agregarCuenta(cu);
        c.agregarCuenta(cu);      // duplicado (mismo objeto)
        c.agregarCuenta(null);    // null permitido por implementación actual

        assertEquals(3, c.getCuentas().size());
        assertSame(cu, c.getCuentas().get(0));
        assertSame(cu, c.getCuentas().get(1));
        assertNull(c.getCuentas().get(2));
    }

    @Test
    void soporta_valores_null_vacios_y_unicode_en_campos() {
        Cliente c = new Cliente("α-01", "María 💫", "maria@correo.com");
        assertEquals("α-01", c.getId());
        assertEquals("María 💫", c.getNombre());

        c.setId(null);
        c.setNombre("");
        c.setEmail("ñandú@ejemplo.co");
        assertNull(c.getId());
        assertEquals("", c.getNombre());
        assertEquals("ñandú@ejemplo.co", c.getEmail());
    }
}
