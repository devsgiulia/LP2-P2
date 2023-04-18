package Lab2.Classes;
/**
 * Classe descanso criada para tratativa da primeira função do programa.
 * @author GIULIA LETICIA DE MESQUITA ARAGÃO.
 */
public class Descanso {
    private int horasDeDescanso = 0;
    /**
     * Varíavel do tipo INTEIRO com valor inicial 0, com funcionalidade para
     * poder contar a hora descansada do aluno e consequentemente, logo abaixo,
     * ser utilizada para definir se o aluno encontra-se cansado ou descansado
     */
    private int numerosDeSemanas = 1;
    /**
     * Variavel do tipo inteiro com valor inicial 1, utilizada para identificar o número
     * de semanas em que o aluno descansou, juntamente com as horas descansadas. O valor
     * inicial é 1, para que possa ser feito o cálculo no status geral, pois não é aceito
     * valor 0.
     */

    /**
     * Nesse metódo definimos a hora de descanso do aluno utilizando a varíavel que criamos
     * acima com valor inicial 0.
     * @param valor valor - horas de descanso do aluno.
     */
    public void defineHorasDescanso(int valor) {
        this.horasDeDescanso = valor;
    }

    /**
     * Nesse metodo, definimos o número de semanas do aluno. Onde deve-se retornar inteiro.
     * @param valor valor - número de semanas que o aluno estudou/descansou.
     */
    public void defineNumeroSemanas(int valor) {
        this.numerosDeSemanas = valor;
    }

    /**
    Nesse método efetuamos o cálculo para verificar se o aluno está descansado ou não.
    Onde utilizamos as variaveis que convocamos acima, efetuando a divisão de ambas.
    O valor inicial para o aluno é cansado, mas pode ser alterado, conforme os dados que ele
    nos repassa. Convocamos if e else nesse caso, pois temos um valor mínimo de descanso, e
    dessa forma, usando o valor (26) + as outras informações, podemos identifcar qual o seu
    status.
     */

    /**
     * Nesse método efetuamos o cálculo para verificar se o aluno está descansado ou não.
     * Onde utilizamos as variaveis que convocamos acima, efetuando a divisão de ambas.
     * O valor inicial para o aluno é cansado, mas pode ser alterado, conforme os dados que ele
     * nos repassa. Convocamos if e else nesse caso, pois temos um valor mínimo de descanso, e
     * dessa forma, usando o valor (26) + as outras informações, podemos identifcar qual o seu
     * status.
     * @return return - retorna se o aluno está cansado ou descansado conforme o cálculo feito no
     * if.
     */
    public String getStatusGeral() {
        int contaHorasSemana = horasDeDescanso / numerosDeSemanas;
        if (contaHorasSemana < 26) {
            return "cansado";
        } else {
            return "descansado";

        }
    }
}
