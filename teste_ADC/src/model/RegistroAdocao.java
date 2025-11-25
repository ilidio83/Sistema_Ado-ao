package model;

import java.time.LocalDate;

public class RegistroAdocao {
    public String nomeAdotante;
    public LocalDate data;
    public String observacoes;

    public RegistroAdocao(String nomeAdotante, LocalDate data, String observacoes) {
        this.nomeAdotante = nomeAdotante;
        this.data = data;
        this.observacoes = observacoes;
    }

    @Override
    public String toString() {
        return "Adotado por " + nomeAdotante + " em " + data + ". " + observacoes;
    }
}
