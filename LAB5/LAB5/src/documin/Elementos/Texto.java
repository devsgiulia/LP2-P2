package documin.Elementos;

public class Texto extends Elemento {
    public Texto(String valor, int prioridade) {
        super(valor, prioridade);
    }

    @Override
    public String getTipo() { return "Texto"; }
}
