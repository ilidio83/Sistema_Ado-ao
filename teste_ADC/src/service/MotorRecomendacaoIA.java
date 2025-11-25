package service;

import model.Adotante;
import model.Animal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MotorRecomendacaoIA {

    public List<Animal> recomendar(Adotante adotante, List<Animal> animaisDisponiveis) {
        List<Animal> recomendados = new ArrayList<>();

        for (Animal animal : animaisDisponiveis) {
            if (animal.adotado) continue;
            int score = calcularScore(adotante, animal);
            if (score >= 20) {
                recomendados.add(animal);
            }
        }

        recomendados.sort(Comparator.comparingInt((Animal a) -> -calcularScore(adotante, a)));
        return recomendados;
    }

    private int calcularScore(Adotante adotante, Animal animal) {
        int score = 0;
        if (animal.especie.equalsIgnoreCase(adotante.especiePreferida)) score += 10;
        if (adotante.tipoResidencia.equals("APARTAMENTO") && animal.tamanho.equals("PEQUENO")) score += 10;
        if (adotante.estiloDeVida.equals("CALMO") && animal.temperamento.equals("CALMO")) score += 8;
        if (adotante.temCriancas && animal.temperamento.equals("SOCIÁVEL")) score += 7;
        if (adotante.tempoDisponivelPorDia >= 3) score += 5;
        if (!animal.precisaDeCuidadosEspeciais) score += 5;
        return score;
    }
}

