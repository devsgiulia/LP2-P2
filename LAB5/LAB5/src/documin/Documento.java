package documin;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import documin.Elementos.Elemento;

public class Documento {
    private List<Elemento> elementos = new ArrayList<Elemento>();
    private boolean atalhos = false;
    private boolean eAtalho = false;
    private int tamanho = 0; 
    private String titulo;

    public Documento(String titulo) {
        this.titulo = titulo;
    }

    public Documento(String titulo, int tamanho) {
        this.titulo = titulo;
        this.tamanho = tamanho;
    }

    public boolean cabe() {
        return (tamanho == 0) ? true : (elementos.size() < tamanho);
    }

    public void turnAtalho() { eAtalho = true; }
    public String getTitulo() { return titulo; }
    public boolean isAtalho() { return eAtalho; }
    public boolean temAtalho() { return atalhos; }

    public int newElemento(Elemento e) {
        if (eAtalho) 
            return elementos.size();
        else if (e.getTipo().equals("Atalho"))
            atalhos = true;
        elementos.add(e);
        return elementos.size();
    }

    public Elemento removeElemento(int indice) {
        return elementos.remove(indice);
    }

    public Elemento getElemento(int indice) {
        return elementos.get(indice - 1);
    }

    public boolean existeElemento(int indice) {
        return (indice <= elementos.size());
    }

    public String[] ShowElementos() {
        List<String> resultado = new ArrayList<String>();
        for (Elemento e : elementos) 
            resultado.add(e.representacaoCompleta());

        return resultado.toArray(new String[tamanho]);
    }

    public Elemento[] getElementos() {
        return this.elementos.toArray(new Elemento[tamanho]);
    }

    public void swapUp(int indice) {
        if (indice < elementos.size() - 1) 
            Collections.swap(elementos, indice, indice + 1);
    }
    
    public void swapDown(int indice) {
        if (indice > 0) 
            Collections.swap(elementos, indice, indice - 1);
    }

    public int mediaPrioridades() {
        if (elementos.size() == 0) { return 0; }
        int result = 0;
        for (Elemento e : elementos) 
            result += e.getPrioridade();
        return result / elementos.size();
    }
}
