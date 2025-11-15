public class Adocao {
    private Animal animal;
    private Adotante adotante;
    private String data;

    public Adocao(Animal animal, Adotante adotante, String data) {
        this.animal = animal;
        this.adotante = adotante;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Adoção: " + animal.getNome() + " -> " + adotante.getNome() + " em " + data;
    }
}
