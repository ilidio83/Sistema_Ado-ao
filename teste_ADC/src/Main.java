import model.Animal;
import model.ConsultaVeterinaria;
import service.RepositorioDeAnimais;
import view.TelaPrincipal;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        RepositorioDeAnimais repo = new RepositorioDeAnimais();

        // Animais cadastrados
        Animal a1 = new Animal("Mimi", "GATO", "PEQUENO", "CALMO", false);
        a1.adicionarConsulta(new ConsultaVeterinaria(LocalDate.now(), "Vacina antirrábica"));

        Animal a2 = new Animal("Thor", "CÃO", "GRANDE", "ATIVO", true);
        Animal a3 = new Animal("Luna", "GATO", "PEQUENO", "SOCIÁVEL", false);
        Animal a4 = new Animal("Bidu", "CÃO", "MÉDIO", "SOCIÁVEL", false);

        repo.adicionar(a1);
        repo.adicionar(a2);
        repo.adicionar(a3);
        repo.adicionar(a4);

        new TelaPrincipal(repo);
    }
}
