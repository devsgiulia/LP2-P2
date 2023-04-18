package Lab2.Classes;
/** Classe criada para conferir a disciplina que o aluno estudou, juntamente com a sua média na respectiva
 * matéria.
 * @author GIULIA LETICIA DE MESQUITA ARAGÃO
 */
public class Disciplina {
    /**
     * Abaixo criamos um ARRAY do tipo DOUBLE, que possa receber números "quebrados", para podermos calcular
     * a nota do aluno. Salientando que recebemos 4 notas, todas com valor inicial 0.
     */
    double[] valorNotas = {0, 0, 0, 0};
    /**
     * Também foi criada uma varíavel do tipo inteira, para que possamos receber números inteiros, que no caso abaixo,
     * são as horas.
     */
    private int valorHoras;
    /**
     * Para que possa ser recebido o nome da disciplina, também criamos uma varíavel do tipo String.
     */
    private String nomeDisciplina;

    /**
     * Por fim, foi criada uma varíavel do tipo Double para que a média do aluno seja calculada,
     * conforme as quatro notas que foram repassadas.
     */
    private double media;

    /**
     * Método criado com a função de chamar o nome da disciplina que o aluno estudou. Utilizamos a varíavel do tipo
     * string, criada acima.
     * @param nomeDisciplina - nomeDisciplina - varíavel do tipo string onde recebemos o nome da disciplina.
     */
    public Disciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    /**
     * Método criado para cadastrar as horas em que o aluno estudou para a disciplina.
     * @param horas - horas - varíavel do tipo inteiro onde sua função é receber a hora em que o
     *              aluno estudou para a disciplina e cadsatrar utilizando a varíavel criada no inicio,
     *              chamada cadastraHoras.
     */
    public void cadastraHoras(int horas) {
        this.valorHoras += horas;
    }

    /**
     * Método criado para receber as 4 notas do aluno na disciplina. Onde utilizamos a lista criada
     * no inicio para cadsatrar as notas.
     * @param nota - nota - varíavel do tipo inteiro, onde receberemos as 4 notas (nesse caso, não são as notas em si,
     *             e sim a quantidade de notas).
     * @param valorNota - valorNota - lista criada para recebimos das notas na disciplina do tipo double para
     *                  recebimentos de números quebrados.
     */
    public void cadastraNota(int nota, double valorNota) {
        valorNotas[nota - 1] = valorNota;
    }

    /**
     * Método do tipo boolean. Nessse método, criamos a opção aprovado. Onde o aluno só terá passado na materia
     * se sua média for igual ou superior a 7. No for, efetuamos a contagem das 4 notas, para verificar se a nota é
     * maior ou igual a 7.
     * @return - return - retorna verdadeiro se a nota do aluno for igual ou superior a 7, retorna falso caso não seja.
     */
    public boolean aprovado() {
        int totalNota = 0;
        for(double nota : valorNotas) {
            totalNota += nota;
        }
        media = totalNota / 4;
        if (media >=7) {
            return true;
        }
        return false;
    }

    /**
     * Método do tipo String, para que possamos colocar a saída. Nesse método, a saída será o nome da disciplina
     * do aluno, sua media e suas notas.
     * @return - return - retorna uma saída com a média e as notas do aluno.
     */
    public String toString(){
        return nomeDisciplina + " " + "4" + " " + media + " " + "[" + valorNotas[0] + "," +  " " + valorNotas[1] + "," + " " + valorNotas[2] + "," + " " + valorNotas[3] + "]";
    }
}
