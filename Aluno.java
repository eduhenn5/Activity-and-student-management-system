public class Aluno {
    private String nome;
    private int idade;
    private String registro;

    public Aluno(String nome, int idade, String registro) {
        this.nome = nome;
        this.idade = idade;
        this.registro = registro;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getRegistro() {
        return registro;
    }

    @Override
    public String toString() {
        return String.format("Aluno: %s, Idade: %d, Registro: %s", nome, idade, registro);
    }
}
