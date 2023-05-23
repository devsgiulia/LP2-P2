package documin.Elementos;

import java.util.ArrayList;
import java.util.List;

public class Lista extends Elemento {
    private List<String> lista = new ArrayList<String>();
    private String caracter;

    public Lista(String valor, int prioridade, String separador, String caracter) {
        super(valor, prioridade);
        for (String p : valor.split(separador)) 
            lista.add(p);
        this.caracter = caracter;
    }

    @Override
    public String getTipo() { return "Lista"; }

    @Override
    public String representacaoCompleta() {
        String result = "";
        for (String p : lista) 
            result += caracter + " " + p + "\n";
        return result;
    }

    @Override
    public String representacaoResumida() {
        return String.join(", ", lista);
    }
}