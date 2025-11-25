package view;

import model.Adotante;
import model.Animal;
import service.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaPrincipal extends JFrame {

    private RepositorioDeAnimais repo;
    private ServicoAdocao servicoAdocao = new ServicoAdocao();
    private List<Animal> recomendados;

    public TelaPrincipal(RepositorioDeAnimais repo) {
        this.repo = repo;
        initUI();
    }

    private void initUI() {
        setTitle("Sistema de Adoção com IA");
        setSize(600, 600);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(11, 2));
        JTextField txtNome = new JTextField();
        JSpinner spIdade = new JSpinner(new SpinnerNumberModel(25, 1, 100, 1));
        JComboBox<String> cbEstilo = new JComboBox<>(new String[]{"ATIVO", "CALMO"});
        JComboBox<String> cbResidencia = new JComboBox<>(new String[]{"CASA", "APARTAMENTO"});
        JCheckBox chkCriancas = new JCheckBox();
        JSpinner spTempo = new JSpinner(new SpinnerNumberModel(2, 0, 24, 1));
        JComboBox<String> cbEspecie = new JComboBox<>(new String[]{"GATO", "CÃO"});

        JComboBox<Animal> cbAnimais = new JComboBox<>();
        repo.listarDisponiveis().forEach(cbAnimais::addItem);

        JButton btnRecomendar = new JButton("Recomendar");
        JButton btnAdotar = new JButton("Adotar");
        JButton btnCadastrar = new JButton("Cadastrar Animal");
        JButton btnHistorico = new JButton("Ver Histórico");

        JTextArea txtResultado = new JTextArea();
        txtResultado.setEditable(false);

        panel.add(new JLabel("Nome:")); panel.add(txtNome);
        panel.add(new JLabel("Idade:")); panel.add(spIdade);
        panel.add(new JLabel("Estilo de vida:")); panel.add(cbEstilo);
        panel.add(new JLabel("Residência:")); panel.add(cbResidencia);
        panel.add(new JLabel("Tem crianças?")); panel.add(chkCriancas);
        panel.add(new JLabel("Tempo livre (h):")); panel.add(spTempo);
        panel.add(new JLabel("Prefere espécie:")); panel.add(cbEspecie);
        panel.add(btnRecomendar); panel.add(btnAdotar);
        panel.add(btnCadastrar); panel.add(btnHistorico);
        panel.add(new JLabel("Selecionar animal:")); panel.add(cbAnimais);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(txtResultado), BorderLayout.CENTER);

        btnRecomendar.addActionListener(e -> {
            Adotante adotante = new Adotante(
                    txtNome.getText(),
                    (int) spIdade.getValue(),
                    cbEstilo.getSelectedItem().toString(),
                    cbResidencia.getSelectedItem().toString(),
                    chkCriancas.isSelected(),
                    (int) spTempo.getValue(),
                    cbEspecie.getSelectedItem().toString()
            );
            MotorRecomendacaoIA ia = new MotorRecomendacaoIA();
            recomendados = ia.recomendar(adotante, repo.listarDisponiveis());
            txtResultado.setText("Recomendações:\n");
            recomendados.forEach(a -> txtResultado.append("- " + a + "\n"));
        });

        btnAdotar.addActionListener(e -> {
            if (recomendados != null && !recomendados.isEmpty()) {
                Adotante adotante = new Adotante(
                        txtNome.getText(),
                        (int) spIdade.getValue(),
                        cbEstilo.getSelectedItem().toString(),
                        cbResidencia.getSelectedItem().toString(),
                        chkCriancas.isSelected(),
                        (int) spTempo.getValue(),
                        cbEspecie.getSelectedItem().toString()
                );
                Animal animal = recomendados.get(0);
                servicoAdocao.realizarAdocao(adotante, animal);
                txtResultado.append("\n🎉 Adoção realizada: " + animal.nome);
            }
        });

        btnCadastrar.addActionListener(e -> new TelaCadastroAnimal(repo));
        btnHistorico.addActionListener(e -> {
            Animal sel = (Animal) cbAnimais.getSelectedItem();
            if (sel != null) new TelaHistoricoAnimal(sel);
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
