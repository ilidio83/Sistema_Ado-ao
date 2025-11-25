package model;

import java.time.LocalDate;

public class ConsultaVeterinaria {
    public LocalDate data;
    public String descricao;

    public ConsultaVeterinaria(LocalDate data, String descricao) {
        this.data = data;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Consulta em " + data + ": " + descricao;
    }
}

