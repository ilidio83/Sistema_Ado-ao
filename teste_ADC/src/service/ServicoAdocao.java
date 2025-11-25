package service;

import model.Adotante;
import model.Animal;
import model.RegistroAdocao;

import java.time.LocalDate;

public class ServicoAdocao {

    public void realizarAdocao(Adotante adotante, Animal animal) {
        animal.registrarAdocao(new RegistroAdocao(
                adotante.nome,
                LocalDate.now(),
                "Adoção realizada com sucesso."
        ));
        System.out.println("🎉 " + adotante.nome + " adotou o animal: " + animal.nome);
    }
}

