package Lab2.Classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CoisaBonus {
    public static void main(String[] args) {
        // criando uma disciplina com 2 notas e pesos 6 e 4
        Disciplina d1 = new Disciplina("Programação", 2, new int[]{6, 4});
        d1.adicionarNota(8);
        d1.adicionarNota(7);
        System.out.println("Média ponderada da disciplina " + d1.getNome() + ": " + d1.getMedia());

        // criando uma disciplina com 3 notas e pesos iguais
        Disciplina d2 = new Disciplina("Matemática", 3);
        d2.adicionarNota(6);
        d2.adicionarNota(7);
        d2.adicionarNota(8);
        System.out.println("Média aritmética da disciplina " + d2.getNome() + ": " + d2.getMedia());

        // criando registros de resumos
        RegistroResumos r1 = new RegistroResumos("Classes", "São estruturas de dados que encapsulam comportamentos e propriedades");
        RegistroResumos r2 = new RegistroResumos("Tipos", "São classificações de dados que determinam o comportamento possível desses dados");

        // adicionando registros de resumos ao sistema
        RegistroResumos sistema = new Resumos();
        sistema.adicionarResumo(r1);
        sistema.adicionarResumo(r2);

        // realizando busca por temas nos registros de resumos
        String[] resultadosBusca = sistema.busca("Um");
        System.out.println("Resultados da busca por 'Um': " + Arrays.toString(resultadosBusca));

        // criando registro de rotina de descanso
        RegistroRotinaDescanso rotina = new RegistroRotinaDescanso("2022-03-27", 7);
        rotina.definirEstadoCansaco(3);
        rotina.definirEmoji(":)");

        // exibindo o status geral da rotina de descanso
        System.out.println("Status geral da rotina de descanso: " + rotina.getStatusGeral());

        // alterando a rotina de descanso e removendo o último emoji registrado
        rotina.adicionarHorasDescanso(1);
        rotina.definirEstadoCansaco(2);
        rotina.definirEmoji(":(");
        System.out.println("Status geral da rotina de descanso: " + rotina.getStatusGeral());
    }
}

class Disciplina {
    private String nome;
    private int[] pesos;
    private ArrayList<Integer> notas;

    public Disciplina(String nome, int numNotas) {
        this.nome = nome;
        pesos = new int[numNotas];
        Arrays.fill(pesos, 1);
        notas = new ArrayList<>();
    }

    public Disciplina(String nome, int numNotas, int[] pesos) {
        this.nome = nome;
        this.pesos = pesos;
        notas = new ArrayList<>();
    }

    public void adicionarNota(int nota) {
        notas.add(nota);
    }

    public double getMedia() {
        int soma = 0;
        for (int i = 0; i < notas.size(); i++) {
            soma += notas.get(i) * pesos[i];
        }
        return (double) soma / Arrays.stream(pesos).sum();
    }

