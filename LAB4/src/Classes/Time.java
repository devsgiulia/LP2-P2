package Classes;

public class Time {
    private String codigo;
    private String nome;
    private String mascote;

    public Time(String codigo) {
        this.codigo = codigo;
        this.nome = nome;
        this.mascote = mascote;
    }

    public Time(String codigo2, String nome2, String mascote2) {
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getMascote() {
        return mascote;
    }

    @Override
    public String toString() {
        return "[" + codigo + "] " + nome + " / " + mascote;
    }

    public String tentarSorte() {
        return null;
    }
}
