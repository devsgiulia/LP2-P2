package Classes;
import java.util.*;


public class MrBetSistema<Jogo> {

    private Map<String, Time> times = new HashMap<>();
    private Map<String, Campeonato> campeonatos = new HashMap<>();
    private Scanner scan = new Scanner(System.in);

    public void run() {
        String opcao = "";
        while (!opcao.equals("!")) {
            exibirMenu();
            opcao = scan.nextLine();
            try {
                switch (opcao.toUpperCase()) {
                    case "M":
                        incluirTime();
                        break;
                    case "R":
                        recuperarTime();
                        break;
                    case ".":
                        adicionarCampeonato();
                        break;
                    case "B":
                        incluirTimeEmCampeonato();
                        break;
                    case "E":
                        exibirCampeonatosDoTime();
                        break;
                    case "T":
                        tentarSorte();
                        break;
                    case "!":
                        System.out.println("Já pode fechar o programa!");
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Opção inválida!");
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida!");
                scan.next();
            } catch (Exception e) {
                System.out.println("Ocorreu um erro: " + e.getMessage());
            }
        }
    }

    public void adicionarCampeonato() {
        System.out.print("Nome: ");
        String nome = scan.nextLine();
        System.out.print("Número de participantes: ");
        int numParticipantes = scan.nextInt();
        scan.nextLine();
        Campeonato campeonato = new Campeonato(nome, numParticipantes);
        campeonatos.put(nome, campeonato);
        System.out.println("INCLUSÃO REALIZADA!\n");
    }

    private void tentarSorte() {
        System.out.print("Código do time: ");
        String codigo = scan.nextLine();
        if (!times.containsKey(codigo)) {
            System.out.println("TIME NÃO EXISTE!\n");
            return;
        }
        Time time = times.get(codigo);
        System.out.println("TIME ENCONTRADO!\n");
        System.out.println(time);
        System.out.println("Tentando a sorte...");
        System.out.println("Status: " + time.tentarSorte());
        System.out.println();
    }

    private void exibirCampeonatosDoTime() {
        System.out.print("Código do time: ");
        String codigo = scan.nextLine();
        if (!times.containsKey(codigo)) {
            System.out.println("TIME NÃO EXISTE!\n");
            return;
        }
        Time time = times.get(codigo);
        System.out.println("TIME ENCONTRADO!\n");
        System.out.println(time);
        System.out.println("Campeonatos:");
        for (Campeonato campeonato : campeonatos.values()) {
            if (campeonato.verificarParticipante(codigo)) {
                System.out.println(campeonato.getNome());
            }
        }
        System.out.println();
    }

    private void incluirTimeEmCampeonato() {
        System.out.print("Código do time: ");
        String codigo = scan.nextLine();
        if (!times.containsKey(codigo)) {
            System.out.println("TIME NÃO EXISTE!\n");
            return;
        }
        Time time = times.get(codigo);
        System.out.println("TIME ENCONTRADO!\n");
        System.out.println(time);
        System.out.print("Nome do campeonato: ");
        String nomeCampeonato = scan.nextLine();
        if (!campeonatos.containsKey(nomeCampeonato)) {
            System.out.println("CAMPEONATO NÃO EXISTE!\n");
            return;
        }
        Campeonato campeonato = campeonatos.get(nomeCampeonato);
        System.out.println("CAMPEONATO ENCONTRADO!\n");
        System.out.println(campeonato);
        campeonato.adicionarParticipante(time);
        System.out.println("INCLUSÃO REALIZADA!\n");
    }

    private void exibirMenu() {
        System.out.println("(M)Minha inclusão de times");
        System.out.println("(R)Recuperar time");
        System.out.println("(.)Adicionar campeonato");
        System.out.println("(B)Bora incluir time em campeonato e Verificar se time está em campeonato");
        System.out.println("(E)Exibir campeonatos que o time participa");
        System.out.println("(T)Tentar a sorte e status");
        System.out.println("(!)Já pode fechar o programa!\n");
        System.out.print("Opção> ");
    }

    private void incluirTime() {
        System.out.print("Código: ");
        String codigo = scan.nextLine();
        if (times.containsKey(codigo)) {
            System.out.println("TIME JÁ EXISTE!\n");
            return;
        }
        System.out.print("Nome: ");
        String nome = scan.nextLine();
        System.out.print("Mascote: ");
        String mascote = scan.nextLine();
        Time time = new Time(codigo, nome, mascote);
        times.put(codigo, time);
        System.out.println("INCLUSÃO REALIZADA!\n");
    }

    private void recuperarTime() {
        System.out.print("Código: ");
        String codigo = scan.nextLine();
        Time time = times.get(codigo);
        if (time == null) {
            System.out.println("TIME NÃO EXISTE!\n");
            return;
        }
        System.out.println(time + "\n");
    }

    private void adicionarTime() {
        System.out.print("Campeonato: ");
        String nomeCampeonato = scan.nextLine();
        if (!campeonatos.containsKey(nomeCampeonato.toUpperCase())) {
            System.out.println("CAMPEONATO NÃO EXISTE!\n");
            return;
        }
        Campeonato campeonato = campeonatos.get(nomeCampeonato.toUpperCase());
        if (campeonato.isCompleto()) {
            System.out.println("CAMPEONATO COMPLETO!\n");
            return;
        }
        System.out.print("Time: ");
        String nomeTime = scan.nextLine();
        if (campeonato.contemTime(nomeTime.toUpperCase())) {
            System.out.println("TIME JÁ CADASTRADO!\n");
            return;
        }
        Time time = new Time(nomeTime);
        campeonato.adicionarTime(time);
        System.out.println("TIME ADICIONADO AO CAMPEONATO!\n");
    }
    
    private void adicionarJogo() {
        System.out.print("Campeonato: ");
        String nomeCampeonato = scan.nextLine();
        if (!campeonatos.containsKey(nomeCampeonato.toUpperCase())) {
            System.out.println("CAMPEONATO NÃO EXISTE!\n");
            return;
        }
        Campeonato campeonato = campeonatos.get(nomeCampeonato.toUpperCase());
        if (!campeonato.isCompleto()) {
            System.out.println("CAMPEONATO NÃO ESTÁ COMPLETO!\n");
            return;
        }
        System.out.print("Time mandante: ");
        String nomeTimeMandante = scan.nextLine();
        if (!campeonato.contemTime(nomeTimeMandante.toUpperCase())) {
            System.out.println("TIME MANDANTE NÃO CADASTRADO NO CAMPEONATO!\n");
            return;
        }
        Time timeMandante = campeonato.getTime(nomeTimeMandante.toUpperCase());
        System.out.print("Time visitante: ");
        String nomeTimeVisitante = scan.nextLine();
        if (!campeonato.contemTime(nomeTimeVisitante.toUpperCase())) {
            System.out.println("TIME VISITANTE NÃO CADASTRADO NO CAMPEONATO!\n");
            return;
        }
        Time timeVisitante = campeonato.getTime(nomeTimeVisitante.toUpperCase());
        System.out.print("Gols do time mandante: ");
        int golsMandante = scan.nextInt();
        System.out.print("Gols do time visitante: ");
        int golsVisitante = scan.nextInt();
        Jogo jogo = new Jogo(timeMandante, timeVisitante, golsMandante, golsVisitante);
        campeonato.adicionarJogo(jogo);
        System.out.println("JOGO ADICIONADO AO CAMPEONATO!\n");
    }
    
    private void listarCampeonatos() {
        if (campeonatos.isEmpty()) {
            System.out.println("NÃO HÁ CAMPEONATOS CADASTRADOS!\n");
            return;
        }
        System.out.println("CAMPEONATOS CADASTRADOS:\n");
        for (Campeonato campeonato : campeonatos.values()) {
            System.out.println(campeonato);
        }
    }
    
    private void listarTimes() {
        System.out.print("Campeonato: ");
        String nomeCampeonato = scan.nextLine();
        if (!campeonatos.containsKey(nomeCampeonato.toUpperCase())) {
            System.out.println("CAMPEONATO NÃO EXISTE!\n");
            return;
        }
        Campeonato campeonato = campeonatos.get(nomeCampeonato.toUpperCase());
        System.out.println("Times do campeonato " + campeonato.getNome() + ":");
        for (Time time : campeonato.getTimes()) {
            System.out.println(time.getNome());
        }
        System.out.println();
    }
}