package view;

import model.Animal;
import service.RepositorioDeAnimais;

import javax.swing.*;
import java.awt.*;

public class TelaCadastroAnimal extends JFrame {

    private JTextField txtNome;
    private JComboBox<String> cbEspecie, cbTamanho, cbTemperamento;
    private JCheckBox chkCuidados;
    private JButton btnSalvar;

    public TelaCadastroAnimal(RepositorioDeAnimais repo) {
        setTitle("Cadastro de Novo Animal");
        setSize(400, 300);
        setLayout(new GridLayout(6, 2));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        txtNome = new JTextField();
        cbEspecie = new JComboBox<>(new String[]{"GATO", "CÃO"});
        cbTamanho = new JComboBox<>(new String[]{"PEQUENO", "MÉDIO", "GRANDE"});
        cbTemperamento = new JComboBox<>(new String[]{"CALMO", "ATIVO", "SOCIÁVEL"});
        chkCuidados = new JCheckBox();
        btnSalvar = new JButton("Salvar Animal");

        add(new JLabel("Nome:")); add(txtNome);
        add(new JLabel("Espécie:")); add(cbEspecie);
        add(new JLabel("Tamanho:")); add(cbTamanho);
        add(new JLabel("Temperamento:")); add(cbTemperamento);
        add(new JLabel("Cuidados especiais?")); add(chkCuidados);
        add(btnSalvar); add(new JLabel(""));

        btnSalvar.addActionListener(e -> {
            String nome = txtNome.getText();
            if (nome.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Informe o nome do animal.");
                return;
            }
            Animal a = new Animal(nome,
                    cbEspecie.getSelectedItem().toString(),
                    cbTamanho.getSelectedItem().toString(),
                    cbTemperamento.getSelectedItem().toString(),
                    chkCuidados.isSelected());
            repo.adicionar(a);
            JOptionPane.showMessageDialog(this, "Animal cadastrado!");
            dispose();
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}

