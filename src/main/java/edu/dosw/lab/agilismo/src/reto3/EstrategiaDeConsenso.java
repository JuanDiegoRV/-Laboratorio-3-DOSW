package edu.dosw.lab.agilismo.src.reto3;

import java.util.*;

public class EstrategiaDeConsenso implements EstrategiaDeVotacion{
        @Override
        public int estimar(List<Integer> votos) {
            // Verificar si todos los votos son iguales
            int primerVoto = votos.get(0);
            for (int voto : votos) {
                if (voto != primerVoto) {
                    return -1; // Divergencia
                }
            }
            return primerVoto; // Consenso
        }
}
