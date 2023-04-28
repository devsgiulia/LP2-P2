package Classes;

/**
 * @author Giulia Leticia de Mesquita Aragão - 121210663
 */

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Classe que representa o sistema de crônicas do estudante.
 */
public class CronicasDoEstudanteSistema<Livreto> {
    private static final String leituras = null;
    String tituloCronica;
    String textoCronica;
    String autorCronica;
    String dataCronica; 
    String[] listaCronicas = new String[1000];
    Cronica[] cronicas;

    private Object contadorLeituras;

    /**
     * Construtor da classe CronicasDoEstudanteSistema.
     * @param tituloCronica
     * @param textoCronica
     * @param autorCronica
     * @param dataCronica
     */
    public CronicasDoEstudanteSistema(String tituloCronica, String textoCronica, String autorCronica, String dataCronica) {
        this.tituloCronica = tituloCronica;
        this.textoCronica = textoCronica;
        this.autorCronica = autorCronica;
        this.dataCronica = dataCronica;
        this.contadorLeituras = new ArrayList<>(Arrays.asList(new Integer[this.listaCronicas.length]));

    }

    public String getTituloCronica() {
        return tituloCronica;
    }

    public String getTextoCronica() {
        return textoCronica;
    }

    public String getAutorCronica() {
        return autorCronica;
    }

    public String getLeituras() {
        return leituras;
    }
    
    public String getDataCronica() {
        return dataCronica;
    }

    /**
     * Método que cadastra uma crônica no sistema.
     * @param tituloCronica
     * @param textoCronica
     * @param autorCronica
     * @param dataCronica
     */
    public void cadastrarCronica(String tituloCronica, String textoCronica, String autorCronica, String dataCronica) {
        for (int i = 0; i < this.listaCronicas.length; i++) {
            if (this.listaCronicas[i] == null) {
               this.listaCronicas[i] = tituloCronica + " - " + textoCronica + " - " + autorCronica + " - " + dataCronica;
                break;
            }
        }
    }
    
    public void cadastrarCronica(String tituloCronica, String textoCronica, String dataCronica) {
        cadastrarCronica(tituloCronica, textoCronica, "Anônimo", dataCronica);
    }

    /**
     * Método que lista as crônicas cadastradas no sistema.
     */
   public void listarCronica() {
        for (int i = 0; i < listaCronicas.length; i++) {
            if (this.listaCronicas[i] != null) {
            }
        }
    }

    /**
     * Método que busca uma crônica no sistema.
     * @param tituloCronica
     * @return
     */
    public String lerCronica(String tituloCronica) {
        String cronica = "";
        for (int i = 0; i < this.listaCronicas.length; i++) {
            if (this.listaCronicas[i] != null) {
                if (this.listaCronicas[i].contains(tituloCronica)) {
                    cronica = listaCronicas[i];
                    break;
                }
            }
        }
        return cronica;
    }

    /**
     * Método que conta as leituras de uma crônica.
     * @param tituloCronica
     */
    public void contadorLeituras(String tituloCronica) {
        for (int i = 0; i < this.listaCronicas.length; i++) {
            if (this.listaCronicas[i] != null) {
                if (this.listaCronicas[i].contains(tituloCronica)) {
                    ((CronicasDoEstudanteSistema) this.contadorLeituras).set(i, ((ArrayList<Integer>) this.contadorLeituras).get(i) + 1);
                    break;
                }
            }
        }
    }
    
    /**
     * Método que exibe a crônica mais lida.
     * @return
     */
    public String exibirCronicaMaisLida() {
        int maior = 0;
        int indice = 0;
        for (int i = 0; i < this.listaCronicas.length; i++) {
            if (this.listaCronicas[i] != null) {
                if (((ArrayList<Integer>) this.contadorLeituras).get(i) > maior) {
                    maior = ((ArrayList<Integer>) this.contadorLeituras).get(i);
                    indice = i;
                }
            }
        }
        return this.listaCronicas[indice];
    }

    /**
     * Método que cria um livreto com as crônicas mais lidas.
     * @param posicaoCronica
     */
    public void criarLivreto(int[] posicaoCronica){
        for (int i = 0; i < this.listaCronicas.length; i++) {
            if (this.listaCronicas[i] != null) {
                if (((ArrayList<Integer>) this.contadorLeituras).get(i) > 0) {
                    ((CronicasDoEstudanteSistema) this.contadorLeituras).set(i, ((ArrayList<Integer>) this.contadorLeituras).get(i) + 1);
                    break;
                }
            }
        }
    }

    private void set(int i, int j) {
    }

    /**
     * Método que lê o livreto.
     * @return
     */
    public String lerLivreto(){
        return null;
    }

    /**
     * Método que verifica se o livreto contém uma crônica.
     * @param tituloCronica
     * @param i
     * @return
     */
    public boolean contemCronicaNoLIvreto(String tituloCronica, String[] i){
        return false;
    }

    }

   