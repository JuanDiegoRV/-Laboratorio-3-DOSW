package edu.dosw.lab.agilismo.src.reto3;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;


class PlanningPokerTest {
    private String runWithInput(PlanningPoker pp, String input, int integrantes) {

        PrintStream originalOut = System.out;
        java.io.InputStream originalIn = System.in;

        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        try {
            System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
            System.setOut(new PrintStream(bout, true, StandardCharsets.UTF_8));

            pp.ejecutar(integrantes);
            return bout.toString(StandardCharsets.UTF_8);
        } finally {
            System.setOut(originalOut);
            System.setIn(originalIn);
        }
    }

    @Test
    void consenso_inmediato_en_una_historia() {
        EstrategiaDeVotacion estrategia = mock(EstrategiaDeVotacion.class);
        when(estrategia.estimar(anyList())).thenReturn(5);

        PlanningPoker pp = new PlanningPoker(estrategia, List.of("H1"));

        String input = "5\n5\n";
        String out = runWithInput(pp, input, 2);

        assertTrue(out.contains("Historia: H1"));
        assertTrue(out.contains("Consenso alcanzado: 5"));
        assertTrue(out.contains("=== RESULTADOS FINALES ==="));
        assertTrue(out.contains("H1: 5"));

        verify(estrategia, times(1)).estimar(anyList());
    }

    @Test
    void sin_consenso_luego_consenso_en_la_segunda_ronda() {
        EstrategiaDeVotacion estrategia = mock(EstrategiaDeVotacion.class);
        when(estrategia.estimar(anyList())).thenReturn(-1, 8);

        PlanningPoker pp = new PlanningPoker(estrategia, List.of("H2"));

        String input = "1\n13\n8\n8\n";
        String out = runWithInput(pp, input, 2);

        assertTrue(out.contains("Historia: H2"));
        assertTrue(out.contains("Votos divergentes"), "Debe avisar que no hubo consenso en la 1a ronda");
        assertTrue(out.contains("Consenso alcanzado: 8"));
        assertTrue(out.contains("H2: 8"));

        verify(estrategia, times(2)).estimar(anyList());
    }

    @Test
    void reintenta_pregunta_si_voto_no_esta_en_fibonacci() {
        EstrategiaDeVotacion estrategia = mock(EstrategiaDeVotacion.class);
        when(estrategia.estimar(anyList())).thenReturn(3);

        PlanningPoker pp = new PlanningPoker(estrategia, List.of("H3"));

        String input = "4\n3\n0\n3\n";
        String out = runWithInput(pp, input, 2);

        assertTrue(out.contains("Historia: H3"));
        assertTrue(out.contains("Consenso alcanzado: 3"));
        assertTrue(out.contains("H3: 3"));

        verify(estrategia, times(1)).estimar(anyList());
    }
}
