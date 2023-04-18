package Lab2.Classes;
/**
 * Classe criada para armazenar os resumos com seus respectivos temas passados pelo usúario, no caso, o aluno.
 * @author GIULIA LETICIA DE MESQUITA ARAGÃO
 */
public class RegistroResumos {
    /**
     * Varíavel criada para gerar o espaço dos resumos no construtor. No caso, o aluno possui
     * um limite de 100 resumos e com a varíavel e o construtor, podemos guardar esse valor.
     */
    private int numeroDeResumos;
    private String[] recebeResumo;
    private String[] temaResumo;
    private int posicaoResumo = 0;
    private int numTotaldeResumo = 0;

    /**
     * Contador para guardar o valor máximo de resumos que o aluno pode anexar no sistema.
     * @param numeroDeResumos - varíavel para guardar a quantidade de resumos.
     */
    public RegistroResumos(int numeroDeResumos) {
        this.numeroDeResumos = numeroDeResumos;
        this.recebeResumo = new String[numeroDeResumos];
        this.temaResumo = new String[numeroDeResumos];
    }

    /**
     * Nesse método iremos retornar o tema e resumo do aluno, com a sua devida
     * posição, conforme a lista.
     * @param tema - tema do resumo do aluno;
     * @param resumo - resumo do aluno;
     */
    public void adiciona(String tema, String resumo) {
        recebeResumo[posicaoResumo] = resumo;
        temaResumo[posicaoResumo] = tema;
        if (posicaoResumo == numeroDeResumos - 1) {
            posicaoResumo = 0;
        } else {
            posicaoResumo++;
        }
        if (numTotaldeResumo != numeroDeResumos){
            numTotaldeResumo++;
        } else {
            numTotaldeResumo = numeroDeResumos;
        }
    }

    /**
     * Metodo criado para efetuar a formatação do resumo do aluno.
     * @return - retorna a formatação criada, onde temos em primeiro o nome do
     * tema e em seguida o resumo escrito.
     */
    public String[] pegaResumos() {
        String[] formataResumo = new String[numTotaldeResumo];
        for (int i = 0; i < numTotaldeResumo; i++) {
            formataResumo[i] = temaResumo[i] + ": " + recebeResumo[i];
        }
        return formataResumo;
    }

    /**
     * Metodo criado para imprimir o total de resumos do aluno e o tema de cada
     * resumo.
     * @return - retorna a formatação do tema e resumo.
     */
    public String imprimeResumos() {
        String formatacaoResumo = "";
        formatacaoResumo += "- " + numTotaldeResumo + " " + "resumo(s) cadastrado(s)\n";
        formatacaoResumo += "- ";
        for (int i =0; i < numTotaldeResumo; i++) {
            if (i != numTotaldeResumo - 1) {
                formatacaoResumo += temaResumo[i] + " | ";
            } else {
                formatacaoResumo += temaResumo[i];
            }
        } return formatacaoResumo;
    }

    /**
     * Metodo para contar a quantidade de resumos do aluno e retornar a
     * quantidade de resumos feitos pelo mesmo.
     * @return - retorna a quantidade de resumos.
     */
    public int conta() {
        return numTotaldeResumo;
    }

    /**
     * Método criado para verificar em sistema se o aluno já tem um resumo cadastrado com o tema que ele digitou.
     * Caso tenha, returna true, o aluno tem um resumo cadastrado daquele tema. CAso não, retorna falso.
     * @param tema - recebe tema do aluno;
     * @return - retorna verdadeiro se o tema já estiver cadastrado e falso se não estiver;
     */
    public boolean temResumo(String tema) {
       A
    }
}
