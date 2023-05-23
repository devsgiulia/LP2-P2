package documin.Elementos;

import documin.Documento;

public class Atalho extends Elemento {
    private Documento doc;

    public Atalho(String valor, int prioridade, Documento doc) {
        super(valor, prioridade);
        this.doc = doc;
    }

    @Override
    public String getTipo() { return "Atalho"; }

    @Override   
    public String representacaoCompleta() {
        String result = "";
        for (Elemento e : doc.getElementos()) 
            if (e.getPrioridade() >= 4) 
                result += e.representacaoCompleta() + "\n";
        return result;
    }

    @Override
    public String representacaoResumida() {
        String result = "";
        for (Elemento e : doc.getElementos()) 
            if (e.getPrioridade() >= 4) 
                result += e.representacaoResumida() + "\n";
        return result;
    }
}