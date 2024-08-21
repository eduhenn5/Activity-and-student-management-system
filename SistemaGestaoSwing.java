import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SistemaGestaoSwing {

    private List<Atividade> atividades;
    private List<Aluno> alunos;
    private JFrame frame;
    private JTextField nomeAtividadeInput;
    private JTextField horarioAtividadeInput;
    private JTextField nomeAlunoInput;
    private JTextField registroAlunoInput;
    private JTextField idadeAlunoInput;
    private JTextArea outputArea;
    private JComboBox<String> alunosComboBox;

    public SistemaGestaoSwing() {
        atividades = new ArrayList<>();
        alunos = new ArrayList<>();
        frame = new JFrame("Sistema de Gestão de Atividades");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.fill = GridBagConstraints.HORIZONTAL;

        // Nome da Atividade
        JLabel nomeAtividadeLabel = new JLabel("Nome da Atividade:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        frame.add(nomeAtividadeLabel, constraints);

        nomeAtividadeInput = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 0;
        frame.add(nomeAtividadeInput, constraints);

        // Horário da Atividade
        JLabel horarioAtividadeLabel = new JLabel("Horário da Atividade:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        frame.add(horarioAtividadeLabel, constraints);

        horarioAtividadeInput = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 1;
        frame.add(horarioAtividadeInput, constraints);

        // ComboBox para Selecionar Alunos
        JLabel selecionarAlunoLabel = new JLabel("Selecionar Aluno:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        frame.add(selecionarAlunoLabel, constraints);

        alunosComboBox = new JComboBox<>();
        constraints.gridx = 1;
        constraints.gridy = 2;
        frame.add(alunosComboBox, constraints);

        // Botão para Adicionar Aluno na Atividade
        JButton addAlunoButton = new JButton("Adicionar Aluno à Atividade");
        constraints.gridx = 1;
        constraints.gridy = 3;
        frame.add(addAlunoButton, constraints);

        addAlunoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarAlunoNaAtividade();
            }
        });

        // Botão para Remover Aluno da Atividade
        JButton removeAlunoButton = new JButton("Remover Aluno da Atividade");
        constraints.gridx = 1;
        constraints.gridy = 4;
        frame.add(removeAlunoButton, constraints);

        removeAlunoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removerAlunoDaAtividade();
            }
        });

        // Botão para Remover Aluno da Base
        JButton deleteAlunoButton = new JButton("Apagar Aluno da Base");
        constraints.gridx = 1;
        constraints.gridy = 5;
        frame.add(deleteAlunoButton, constraints);

        deleteAlunoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagarAlunoDaBase();
            }
        });

        // Botão para Adicionar Atividade
        JButton addButton = new JButton("Adicionar Atividade");
        constraints.gridx = 1;
        constraints.gridy = 6;
        frame.add(addButton, constraints);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarAtividade();
            }
        });

        // Nome do Aluno
        JLabel nomeAlunoLabel = new JLabel("Nome do Aluno:");
        constraints.gridx = 0;
        constraints.gridy = 7;
        frame.add(nomeAlunoLabel, constraints);

        nomeAlunoInput = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 7;
        frame.add(nomeAlunoInput, constraints);

        // Registro do Aluno
        JLabel registroAlunoLabel = new JLabel("Registro do Aluno:");
        constraints.gridx = 0;
        constraints.gridy = 8;
        frame.add(registroAlunoLabel, constraints);

        registroAlunoInput = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 8;
        frame.add(registroAlunoInput, constraints);

        // Idade do Aluno
        JLabel idadeAlunoLabel = new JLabel("Idade do Aluno:");
        constraints.gridx = 0;
        constraints.gridy = 9;
        frame.add(idadeAlunoLabel, constraints);

        idadeAlunoInput = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 9;
        frame.add(idadeAlunoInput, constraints);

        // Botão para Cadastrar Aluno
        JButton cadastrarAlunoButton = new JButton("Cadastrar Aluno");
        constraints.gridx = 1;
        constraints.gridy = 10;
        frame.add(cadastrarAlunoButton, constraints);

        cadastrarAlunoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarAluno();
            }
        });

        // Botão para Listar Atividades
        JButton listButton = new JButton("Listar Atividades");
        constraints.gridx = 1;
        constraints.gridy = 11;
        frame.add(listButton, constraints);

        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarAtividades();
            }
        });

        // Botão para Listar Alunos
        JButton listarAlunosButton = new JButton("Listar Alunos");
        constraints.gridx = 1;
        constraints.gridy = 12;
        frame.add(listarAlunosButton, constraints);

        listarAlunosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarAlunos();
            }
        });

        // Área de Texto para Saída
        outputArea = new JTextArea(10, 40);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        constraints.gridx = 0;
        constraints.gridy = 13;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        frame.add(scrollPane, constraints);

        // Exibir a janela
        frame.setVisible(true);
    }

    private void adicionarAtividade() {
        String nome = nomeAtividadeInput.getText();
        String horario = horarioAtividadeInput.getText();

        if (nome.isEmpty() || horario.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Nome e Horário são obrigatórios!", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            Atividade atividade = new Atividade(nome, horario);
            atividades.add(atividade);
            JOptionPane.showMessageDialog(frame, "Atividade adicionada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            nomeAtividadeInput.setText("");
            horarioAtividadeInput.setText("");
        }
    }

    private void adicionarAlunoNaAtividade() {
        String alunoSelecionado = (String) alunosComboBox.getSelectedItem();
        if (alunoSelecionado == null || alunoSelecionado.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Selecione um aluno para adicionar à atividade!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Atividade atividade = selecionarAtividade();
        if (atividade != null) {
            Aluno aluno = buscarAlunoPorNome(alunoSelecionado);
            if (aluno != null) {
                atividade.inscreverAluno(aluno);
                JOptionPane.showMessageDialog(frame, "Aluno adicionado à atividade com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "Aluno não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void removerAlunoDaAtividade() {
        String alunoSelecionado = (String) alunosComboBox.getSelectedItem();
        if (alunoSelecionado == null || alunoSelecionado.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Selecione um aluno para remover da atividade!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Atividade atividade = selecionarAtividade();
        if (atividade != null) {
            Aluno aluno = buscarAlunoPorNome(alunoSelecionado);
            if (aluno != null) {
                atividade.removerAluno(aluno);
                JOptionPane.showMessageDialog(frame, "Aluno removido da atividade com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "Aluno não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void apagarAlunoDaBase() {
        String alunoSelecionado = (String) alunosComboBox.getSelectedItem();
        if (alunoSelecionado == null || alunoSelecionado.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Selecione um aluno para apagar!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Aluno aluno = buscarAlunoPorNome(alunoSelecionado);
        if (aluno != null) {
            // Remover aluno de todas as atividades
            for (Atividade atividade : atividades) {
                atividade.removerAluno(aluno);
            }
            // Remover aluno da lista de alunos
            alunos.remove(aluno);
            alunosComboBox.removeItem(alunoSelecionado);
            JOptionPane.showMessageDialog(frame, "Aluno apagado da base com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(frame, "Aluno não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cadastrarAluno() {
        String nome = nomeAlunoInput.getText();
        String registro = registroAlunoInput.getText();
        String idadeText = idadeAlunoInput.getText();
        int idade;

        try {
            idade = Integer.parseInt(idadeText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Idade deve ser um número inteiro!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (nome.isEmpty() || registro.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Nome e Registro são obrigatórios!", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            Aluno aluno = new Aluno(nome, idade, registro);
            alunos.add(aluno);
            alunosComboBox.addItem(nome);
            JOptionPane.showMessageDialog(frame, "Aluno cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            nomeAlunoInput.setText("");
            registroAlunoInput.setText("");
            idadeAlunoInput.setText("");
        }
    }

    private Aluno buscarAlunoPorNome(String nome) {
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equals(nome)) {
                return aluno;
            }
        }
        return null;
    }

    private Atividade selecionarAtividade() {
        if (atividades.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Nenhuma atividade disponível.", "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        String[] opcoes = new String[atividades.size()];
        for (int i = 0; i < atividades.size(); i++) {
            opcoes[i] = atividades.get(i).getNome();
        }

        String atividadeSelecionada = (String) JOptionPane.showInputDialog(
                frame,
                "Selecione a atividade:",
                "Selecionar Atividade",
                JOptionPane.PLAIN_MESSAGE,
                null,
                opcoes,
                opcoes[0]
        );

        for (Atividade atividade : atividades) {
            if (atividade.getNome().equals(atividadeSelecionada)) {
                return atividade;
            }
        }
        return null;
    }

    private void listarAtividades() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lista de Atividades:\n");
        for (Atividade atividade : atividades) {
            sb.append(atividade).append("\n");
        }
        outputArea.setText(sb.toString());
    }

    private void listarAlunos() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lista de Alunos:\n");
        for (Aluno aluno : alunos) {
            sb.append(aluno).append("\n");
        }
        outputArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SistemaGestaoSwing();
            }
        });
    }
}
