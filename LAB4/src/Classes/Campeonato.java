package Classes;
import java.util.ArrayList;
import java.util.List;

public class Campeonato<Jogo> {
    private String nome;
    private int numParticipantes;
    private List<String> participantes;
    
    public Campeonato(String nome, int numParticipantes) throws IllegalArgumentException {
        if (numParticipantes < 2) {
            throw new IllegalArgumentException("Número de participantes deve ser no mínimo 2");
        }
        this.nome = nome;
        this.numParticipantes = numParticipantes;
        this.participantes = new ArrayList<String>();
    }
    
    public String getNome() {
        return nome;
    }
    
    public int getNumParticipantes() {
        return numParticipantes;
    }
    
    public List<String> getParticipantes() {
        return participantes;
    }
    
    public void adicionarParticipante(Time time) throws IllegalArgumentException {
        if (participantes.size() >= numParticipantes) {
            throw new IllegalArgumentException("Número máximo de participantes atingido");
        }
        if (!participantes.contains(time)) {
            participantes.add(time);
        }
    }
    
    public boolean verificarParticipante(String codigoTime) {
        return participantes.contains(codigoTime);
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Campeonato: " + nome + "\n");
        sb.append("Participantes (" + participantes.size() + "/" + numParticipantes + "): ");
        for (String participante : participantes) {
            sb.append(participante + " ");
        }
        sb.append("\n");
        return sb.toString();
    }

    public boolean isCompleto() {
        return false;
    }

    public boolean contemTime(String upperCase) {
        return false;
    }

    public void adicionarTime(Jogo jogo) {
    }

    public Time getTime(String upperCase) {
        return null;
    }
    public void adicionarJogo(Jogo jogo) {
    }

    public Time[] getTimes() {
        return null;
    }
}

