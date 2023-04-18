package Lab2.Classes;
/**
 * Classe onde registramos e verificamos o tempo online do aluno.
 * @author GIULIA LETICIA DE MESQUITA ARAGÃO
 */

public class RegistroTempoOnline {
    /**
     * Varíavel do tipo String, onde será retornado o nome da disciplina.
     */
    private final String nomeDaDisciplina;

    /**
     * Varíavel do tipo Inteiro, onde será retornado o tempo gasto online do aluno.
     */
    private int tempoGastoOnline = 0;

    /**
     * Varíavel do tipo Inteiro, onde será retornado o tempo esperado que o aluno deveria
     * ter ficado online.
     */
    private int tempoEsperado;

    /**
     * Método onde retornaremos o nome da disciplina que o aluno estudou e o tempo esperado
     * que ele devia ter estudado para aquele disciplina.
     * @param nome nome - parametro do tipo String, que retorna o nome da disciplina.
     * @param tempo tempo - parametro do tipo INTEIRO, onde irá retornar o tempo esperado
     *              para aquela disciplina.
     */
    public RegistroTempoOnline(String nome, int tempo) {
        this.nomeDaDisciplina = nome;
        this.tempoEsperado = tempo;
    }

    /**
     * Método onde retornaremos o nome da disciplina e o tempo esperado que
     * são 120 horas.
     * @param nome -  nome - parametro do tipo String, que retorna o nome da disciplina.
     */
    public RegistroTempoOnline(String nome) {
        this.nomeDaDisciplina = nome;
        this.tempoEsperado = 120;
    }

    /**
     * Método onde retornaremos o tempo online do aluno.
     * @param tempo - tempo - parametro do tipo Inteiro, que retorna o tempo
     *             online do usúario.
     */
    public void adicionaTempoOnline(int tempo) {
        tempoGastoOnline += tempo;
    }

    /**
     * Método criado para verificar se o tempo online do aluno no site, atingiu a meta.
     * @return - return - cálcula se o tempo gasto é maior ou igual ao tempo esperado.
     */
    public boolean atingiuMetaTempoOnline() {
        return tempoGastoOnline >= tempoEsperado;
    }

    /**
     * Método criado com a função de "printar" no System.out.print do MAIN, todos
     * os cálculos e variaveis criadas nesse programa.
     * @return - return - retorna a saída correta para o System.out.print.
     */
    public String toString() {

        return nomeDaDisciplina + " " + tempoGastoOnline + "/" + tempoEsperado;
    }
}

