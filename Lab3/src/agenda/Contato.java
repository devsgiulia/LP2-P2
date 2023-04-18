package agenda;

/**
 * Classe responsavel por representar um contato
 * 
 * @author Giulia Aragão - 121210663  
 */

public class Contato {
    /**
     * Atributos da classe contato.
     */
    private String nome;
    private String numero;

    /**
     * Construtor da classe contato.
     */
    Contato(String nome, String numero) {
        this.nome = nome;
        this.numero = numero;
    }

    /**
     * Getters e setters da classe contato.
     */
    public String getNome() { 
        return this.nome; 
    }
    public void setNome(String nome) { 
        this.nome = nome; 
    }

    public String getNumero() { 
        return this.numero; 
    }
    public void setNumero(String numero) { 
        this.numero = numero; 
    }

    public String toString() {
        return String.format("%s - %s", nome, numero);
    }

    /**
     * Metodo que verifica se dois contatos são iguais.
     */
    public boolean equals(Contato contato) {
        boolean nome = this.nome.equals(contato.getNome());
        boolean numero = this.numero.equals(contato.getNumero());
        return (nome && numero);
    }
}