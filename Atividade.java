import java.util.ArrayList;
import java.util.List;

public class Atividade {
    private String nome;
    private String horario;
    private List<Aluno> alunosInscritos;

    public Atividade(String nome, String horario) {
        this.nome = nome;
        this.horario = horario;
        this.alunosInscritos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getHorario() {
        return horario;
    }

    public void inscreverAluno(Aluno aluno) {
        if (!alunosInscritos.contains(aluno)) {
            alunosInscritos.add(aluno);
        }
    }

    public void removerAluno(Aluno aluno) {
        alunosInscritos.remove(aluno);
    }

    @Override
    public String toString() {
        return String.format("Atividade: %s, Horário: %s, Alunos Inscritos: %d", nome, horario, alunosInscritos.size());
    }
}
