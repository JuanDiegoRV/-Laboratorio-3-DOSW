package edu.dosw.lab.agilismo.src.reto3;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EstrategiaDeConsensoTest {

    @Test
    void todos_iguales_devuelve_consenso() {
        EstrategiaDeConsenso e = new EstrategiaDeConsenso();
        int r = e.estimar(List.of(5, 5, 5));
        assertEquals(5, r);
    }

    @Test
    void divergentes_devuelve_menos_uno() {
        EstrategiaDeConsenso e = new EstrategiaDeConsenso();
        int r = e.estimar(List.of(1, 13));
        assertEquals(-1, r);
    }

    @Test
    void un_solo_voto_devuelve_ese_valor() {
        EstrategiaDeConsenso e = new EstrategiaDeConsenso();
        int r = e.estimar(List.of(8));
        assertEquals(8, r);
    }

    @Test
    void lista_vacia_lanza_IndexOutOfBoundsException() {
        EstrategiaDeConsenso e = new EstrategiaDeConsenso();
        assertThrows(IndexOutOfBoundsException.class, () -> e.estimar(List.of()));
    }

    @Test
    void lista_null_lanza_NullPointerException() {
        EstrategiaDeConsenso e = new EstrategiaDeConsenso();
        assertThrows(NullPointerException.class, () -> e.estimar(null));
    }
}
