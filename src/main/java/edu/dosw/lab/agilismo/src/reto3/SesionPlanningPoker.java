package edu.dosw.lab.agilismo.src.reto3;

import java.util.*;

public class SesionPlanningPoker {
    public static void ejecutarReto3(int numIntegrantes) {
        List<String> historias = Arrays.asList(
               "HU1 - Crear cuenta válida",
                    "HU2 - Validar número de cuenta",
                    "HU3 - Consultar saldo",
                    "HU4 - Realizar deposito",
                    "HU5 - Mantener lista de bancos registrados",
                    "HU6 - Mostrar mensajes de error claros en cuentas inválidas"
        );

        EstrategiaDeVotacion strategy = new EstrategiaDeConsenso();
        PlanningPoker contexto = new PlanningPoker(strategy, historias);

        contexto.ejecutar(numIntegrantes);
    }
}
