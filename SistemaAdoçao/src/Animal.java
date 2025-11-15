public class Animal {
    private int id;
    private String nome;
    private Especie especie;
    private boolean adotado;

    public Animal(int id, String nome, Especie especie) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.adotado = false;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public Especie getEspecie() { return especie; }
    public boolean isAdotado() { return adotado; }

    public void marcarComoAdotado() {
        this.adotado = true;
    }

    @Override
    public String toString() {
        return "[" + id + "] " + nome + " (" + especie + ") - " +
                (adotado ? "ADOTADO" : "DISPONÍVEL");
    }
}
