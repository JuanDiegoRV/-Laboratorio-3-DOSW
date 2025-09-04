package edu.dosw.lab.agilismo.src.reto3;

import java.util.*;

public class PlanningPoker {
    private final EstrategiaDeVotacion estrategia;
    private final List<String> historias;

    public PlanningPoker(EstrategiaDeVotacion estrategia, List<String> historias) {
        this.estrategia = estrategia;
        this.historias = historias;
    }

    public void ejecutar(int numIntegrantes) {
        Map<String, Integer> resultados = new LinkedHashMap<>();
        List<Integer> fibonacci = Arrays.asList(1, 2, 3, 5, 8, 13);

        try (Scanner sc = new Scanner(System.in)) {
            for (String historia : historias) {
                int consenso = -1;
                while (consenso == -1) {
                    List<Integer> votos = new ArrayList<>();
                    System.out.println("\nHistoria: " + historia);
                    for (int i = 1; i <= numIntegrantes; i++) {
                        int voto;
                        do {
                            System.out.print("Integrante " + i + ", vote " + fibonacci + ": ");
                            voto = Integer.parseInt(sc.nextLine());
                        } while (!fibonacci.contains(voto));
                        votos.add(voto);
                    }

                    consenso = estrategia.estimar(votos);
                    if (consenso == -1) {
                        System.out.println("Votos divergentes – Discutan y vuelvan a votar");
                    } else {
                        resultados.put(historia, consenso);
                        System.out.println("? Consenso alcanzado: " + consenso);
                    }
                }
            }
        }

        System.out.println("\n=== RESULTADOS FINALES ===");
        resultados.forEach((h, p) -> System.out.println(h + ": " + p));
    }
}
