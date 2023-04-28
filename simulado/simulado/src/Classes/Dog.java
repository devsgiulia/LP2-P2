package Classes;

public class Dog {
    public String nomeDoCachorro;
    public String nomeDoTutor;
    public int quantidadeDeRacao;
    public String tipoDeRestricao;

    public Dog(String nomeDoCachorro, String nomeDoTutor, int quantidadeDeRacao, String tipoDeRestricao) {
        this.nomeDoCachorro = nomeDoCachorro;
        this.nomeDoTutor = nomeDoTutor;
        this.tipoDeRestricao = tipoDeRestricao;
        if(quantidadeDeRacao != 0) {
            this.quantidadeDeRacao = quantidadeDeRacao * 2;
            } else {
                this.quantidadeDeRacao = quantidadeDeRacao;
            }
        }

    public String getNomeDoCachorro() {
        return nomeDoCachorro;
    }

    public String getNomeDoTutor() {
        return nomeDoTutor;
    }

    public int getQuantidadeDeRacao() {
        return quantidadeDeRacao;
    }

    public String getTipoDeRestricao() {
        return tipoDeRestricao;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Dog)) {
            return false;
        }

        Dog other = (Dog) obj;
        return this.nomeDoCachorro.equals(other.nomeDoCachorro) && this.nomeDoTutor.equals(other.nomeDoTutor);
    }

    public String toString() {
        return "Dog [nome=" + nomeDoCachorro + ", tutor=" + nomeDoTutor + "]";
    
    }
}   