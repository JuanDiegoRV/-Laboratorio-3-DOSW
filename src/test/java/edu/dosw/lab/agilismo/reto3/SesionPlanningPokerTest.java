package edu.dosw.lab.agilismo.reto3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SesionPlanningPokerTest {

    private Map<String, Integer> puntajesFinales;

    @BeforeEach
    void setUp() {
        puntajesFinales = new HashMap<>();
    }

    @Test
    void testVotacionHistoriasReales() {
   
        puntajesFinales.put("HU1 - Crear cuenta válida", 3);
        puntajesFinales.put("HU2 - Validar número de cuenta", 5);
        puntajesFinales.put("HU3 - Consultar saldo", 3); // ejemplo de consenso después de divergencia
        puntajesFinales.put("HU4 - Realizar depósito", 8);

        // Verificaciones
        assertEquals(3, puntajesFinales.get("HU1 - Crear cuenta válida"));
        assertEquals(5, puntajesFinales.get("HU2 - Validar número de cuenta"));
        assertEquals(3, puntajesFinales.get("HU3 - Consultar saldo"));
        assertEquals(8, puntajesFinales.get("HU4 - Realizar depósito"));
    }
}
