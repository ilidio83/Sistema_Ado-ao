package service;

import model.Animal;

import java.util.ArrayList;
import java.util.List;

public class RepositorioDeAnimais {
    private final List<Animal> lista = new ArrayList<>();

    public void adicionar(Animal animal) {
        lista.add(animal);
    }

    public List<Animal> listarDisponiveis() {
        List<Animal> disponiveis = new ArrayList<>();
        for (Animal a : lista) {
            if (!a.adotado) disponiveis.add(a);
        }
        return disponiveis;
    }
}

