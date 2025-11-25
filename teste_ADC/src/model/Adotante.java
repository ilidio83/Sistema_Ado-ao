package model;

public class Adotante {
    public String nome;
    public int idade;
    public String estiloDeVida;
    public String tipoResidencia;
    public boolean temCriancas;
    public int tempoDisponivelPorDia;
    public String especiePreferida;

    public Adotante(String nome, int idade, String estiloDeVida, String tipoResidencia,
                    boolean temCriancas, int tempoDisponivelPorDia, String especiePreferida) {
        this.nome = nome;
        this.idade = idade;
        this.estiloDeVida = estiloDeVida;
        this.tipoResidencia = tipoResidencia;
        this.temCriancas = temCriancas;
        this.tempoDisponivelPorDia = tempoDisponivelPorDia;
        this.especiePreferida = especiePreferida;
    }
}

