package model;

import java.util.ArrayList;
import java.util.List;

public class Animal {
    public String nome;
    public String especie;
    public String tamanho;
    public String temperamento;
    public boolean precisaDeCuidadosEspeciais;
    public boolean adotado;

    public List<ConsultaVeterinaria> consultas = new ArrayList<>();
    public RegistroAdocao registroAdocao;

    public Animal(String nome, String especie, String tamanho, String temperamento, boolean cuidados) {
        this.nome = nome;
        this.especie = especie;
        this.tamanho = tamanho;
        this.temperamento = temperamento;
        this.precisaDeCuidadosEspeciais = cuidados;
        this.adotado = false;
    }

    public void adicionarConsulta(ConsultaVeterinaria consulta) {
        consultas.add(consulta);
    }

    public void registrarAdocao(RegistroAdocao adocao) {
        this.registroAdocao = adocao;
        this.adotado = true;
    }

    @Override
    public String toString() {
        return nome + " (" + especie + ", " + tamanho + ", " + temperamento + ")";
    }
}

