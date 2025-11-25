package view;

import model.Animal;
import model.ConsultaVeterinaria;

import javax.swing.*;
import java.awt.*;

public class TelaHistoricoAnimal extends JFrame {

    public TelaHistoricoAnimal(Animal animal) {
        setTitle("Histórico do Animal - " + animal.nome);
        setSize(400, 400);
        setLayout(new BorderLayout());

        JTextArea area = new JTextArea();
        area.setEditable(false);

        StringBuilder sb = new StringBuilder();
        sb.append("🐾 ").append(animal.nome).append("\n\n");
        sb.append("📋 ").append(animal.especie).append(" | ").append(animal.tamanho).append(" | ").append(animal.temperamento).append("\n\n");

        if (animal.registroAdocao != null) {
            sb.append("✅ Adoção: ").append(animal.registroAdocao).append("\n\n");
        } else {
            sb.append("🚫 Ainda não foi adotado.\n\n");
        }

        sb.append("🩺 Consultas:\n");
        if (animal.consultas.isEmpty()) {
            sb.append("- Nenhuma registrada.\n");
        } else {
            for (ConsultaVeterinaria c : animal.consultas) {
                sb.append("- ").append(c).append("\n");
            }
        }

        area.setText(sb.toString());
        add(new JScrollPane(area), BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
