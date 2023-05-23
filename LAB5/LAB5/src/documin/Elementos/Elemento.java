package documin.Elementos;

import java.util.HashMap;
import java.util.Map;

public class Elemento {
    private Map<String, String> propriedades = new HashMap<String, String>();
    private int prioridade;
    private String valor;
    
    public Elemento(String valor, int prioridade) {
        if (prioridade < 1) { prioridade = 1; }
        if (prioridade > 5) { prioridade = 5; }
        this.valor = valor;
        this.prioridade = prioridade;
    }

    public String getValor() { return valor; }
    public String getTipo() { return "Elemento"; }
    public int getPrioridade() { return prioridade; }

    public String representacaoCompleta() {
        return this.valor;
    }

    public String representacaoResumida() {
        return this.valor;
    }
}