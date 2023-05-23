package documin.Elementos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Termo extends Elemento {
    private List<String> lista = new ArrayList<String>();
    private String separador;

    public Termo(String valor, int prioridade, String separador, String ordem) {
        super(valor, prioridade);
        for (String p : valor.split(separador)) 
            lista.add(p);
        
        if (ordem.toLowerCase().equals("alfabetica")) 
            Collections.sort(lista);
        else if (ordem.toLowerCase().equals("tamanho")) {
            int maior = lista.stream().max(Comparator.comparingInt(String::length)).get().length();
            lista.sort((s1, s2) -> 
                Math.abs(s1.length() - maior) - Math.abs(s2.length() - maior));
        }
        
        this.separador = separador;
    }

    @Override
    public String getTipo() { return "Termo"; }

    @Override   
    public String representacaoCompleta() {
        String result = "Total termos: " + lista.size() + "\n - ";
        for (int i = 0; i != lista.size(); i++) {
            result += lista.get(i);
            result += (i == lista.size() - 1) ? "" : ", "; 
        }
        return result;
    }

    @Override
    public String representacaoResumida() {
        String result = "";
        for (int i = 0; i != lista.size(); i++) {
            result += lista.get(i);
            result += (i == lista.size() - 1) ? "" : separador; 
        }
        return result;
    }
}
