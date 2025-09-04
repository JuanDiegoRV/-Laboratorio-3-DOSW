package edu.dosw.lab.testing.reto4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdministradorTest {

    @Test
    void constructor_inicializa_campos() {
        Administrador a = new Administrador("adm-001", "Ana Pérez");
        assertEquals("adm-001", a.getId());
        assertEquals("Ana Pérez", a.getNombre());
    }

    @Test
    void setters_actualizan_valores() {
        Administrador a = new Administrador("x", "y");
        a.setId("adm-999");
        a.setNombre("Carlos López");
        assertEquals("adm-999", a.getId());
        assertEquals("Carlos López", a.getNombre());
    }

    @Test
    void permite_null_y_cadenas_vacias() {
        Administrador a = new Administrador("id", "nombre");

        a.setId(null);
        a.setNombre(null);
        assertNull(a.getId());
        assertNull(a.getNombre());

        a.setId("");
        a.setNombre("");
        assertEquals("", a.getId());
        assertEquals("", a.getNombre());
    }

    @Test
    void soporta_unicode() {
        Administrador a = new Administrador("管理员-01", "María 💫");
        assertEquals("管理员-01", a.getId());
        assertEquals("María 💫", a.getNombre());

        a.setNombre("José Ñandú");
        assertEquals("José Ñandú", a.getNombre());
    }

    @Test
    void cambios_en_id_no_afectan_nombre_y_viceversa() {
        Administrador a = new Administrador("a1", "N1");
        a.setId("a2");
        assertEquals("a2", a.getId());
        assertEquals("N1", a.getNombre());

        a.setNombre("N2");
        assertEquals("a2", a.getId());
        assertEquals("N2", a.getNombre());
    }
}
