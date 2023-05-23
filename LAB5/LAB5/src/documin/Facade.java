package documin;

/**
 * @author Giulia Leticia de Mesquita Aragão - 121210663
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import documin.Elementos.Atalho;
import documin.Elementos.Elemento;
import documin.Elementos.Lista;
import documin.Elementos.Termo;
import documin.Elementos.Texto;
import documin.Elementos.Titulo;

public class Facade {
    private Map<String, Documento> documentos = new HashMap<String, Documento>();
    private List<String[]> visualizacoes = new ArrayList<String[]>();

   /**
    * Cria um documento com tamanho ilimitado de elementos.
    * @param titulo Titulo do documento.
    * @return Se o documento foi cadastrado, falso caso já exista um com o mesmo nome.
    */
    public boolean criarDocumento(String titulo) {
        if (documentos.containsKey(titulo))
            return false;
        
        Documento doc = new Documento(titulo);
        documentos.put(titulo, doc);
        return true;
    }

    /**
     * Cria um documento com tamanho fixo de elementos.
     * @param titulo Titulo do documento.
     * @param tamanhoMaximo Total de elementos.
     * @return Se o documento foi cadastrado, falso caso já exista um com o mesmo nome.
     */
    public boolean criarDocumento(String titulo, int tamanhoMaximo) {
        if (documentos.containsKey(titulo))
            return false;
        
        Documento doc = new Documento(titulo, tamanhoMaximo);
        documentos.put(titulo, doc);
        return true;
    }

    /**
     * Remove um documento com o nome especifica
     * @param titulo Nome do documento
     */
    public void removerDocumento(String titulo) {
        if (documentos.containsKey(titulo))
            documentos.remove(titulo);
    }

    /**
     * Verifica quantos elementos um documento possui
     * @param titulo Nome do documento
     * @return Total, -1 caso o documento não exista
     */
    public int contarElementos(String titulo) {
        if (documentos.containsKey(titulo)) 
            return documentos.get(titulo).getElementos().length;

        System.out.println("Documento não encontrado");
        return -1;
    }

    /**
     * Retorna uma lista com a represetanção completa de todos os elementos de um documento.
     * @param titulo Nome do dcumento.
     * @return Lista da represetanção dos elementos.
     */
    public String[] exibirDocumento(String titulo) {
        if (documentos.containsKey(titulo)) 
            return documentos.get(titulo).ShowElementos();

        System.out.println("Documento não encontrado");
        return new String[0];
    }

    /**
     * Adiciona um elemento a um documento especifico.
     * @param tituloDoc Nome do documento.
     * @param Elemento.
     * @return Qual o indice do elemento no documento. -1, se o documento não existir. -2, se o documento estiver cheio.
     */
    private int addElemento(String tituloDoc, Elemento e) {
        if (!documentos.containsKey(tituloDoc)) {
            System.out.println("Documento " + tituloDoc + " não encontrado");
            return -1;
        }
        
        if (!documentos.get(tituloDoc).cabe()) {
            System.out.println("Sem espaços disponiveis");
            return -2;
        } 

        System.out.println("Elemento adicionado com sucesso");
        return documentos.get(tituloDoc).newElemento(e);
    }

    /**
     * Cria um elemento de texto.
     * @param tituloDoc Titulo do documento
     * @param valor Valor do elemento.
     * @param prioridade Prioridade do elemento, valores a cima de 5 seram arredondados para 5.
     * @return Qual o indice do elemento no documento, -1 caso o documento não exista e -2 caso o documento esteja cheio.
     */
    public int criarTexto(String tituloDoc, String valor, int prioridade) {
        if (prioridade >= 5) { 
            System.out.println("A maior prioridade é 5, ela sera ajustada altomaticamente para 5");
            prioridade = 5;
        }

        Texto texto = new Texto(valor, prioridade);
        return addElemento(tituloDoc, texto);
    }

    /**
     * Cria um elemento de titulo.
     * @param tituloDoc Titulo do documento.
     * @param valor Valor do elemento.
     * @param prioridade Prioridade do elemento, valores a cima de 5 seram arredondados para 5.
     * @param nivel Nivel do titulo, valores a cima de 5 seram arredondados para 5.
     * @param linkavel Se o titulo é linkavel.
     * @return Qual o indice do elemento no documento, -1 caso o documento não exista e -2 caso o documento esteja cheio.
     */
    public int criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel) {
        if (prioridade >= 5) { 
            System.out.println("A maior prioridade é 5, ela sera ajustada altomaticamente para 5");
            prioridade = 5;
        }

        Titulo titulo = new Titulo(valor, prioridade, nivel, linkavel);
        return addElemento(tituloDoc, titulo);
    }

    /**
     * Cria um elemento de lista.
     * @param tituloDoc Titulo do documento..
     * @param valorLista Valor do elemento.
     * @param prioridade Prioridade do elemento, valores a cima de 5 seram arredondados para 5.
     * @param separador Separador dos elementos da lista.
     * @param charLista Caracter que representa um elemento da lista.
     * @return Qual o indice do elemento no documento, -1 caso o documento não exista e -2 caso o documento esteja cheio.
     */
    public int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista) {
        if (prioridade >= 5) { 
            System.out.println("A maior prioridade é 5, ela sera ajustada altomaticamente para 5");
            prioridade = 5;
        }

        Lista lista = new Lista(valorLista, prioridade, separador, charLista);
        return addElemento(tituloDoc, lista);
    }

    
    /**
     * Cria um elemento de termos.
     * @param tituloDoc Titulo do documento.
     * @param valorTermos Valor do elemento.
     * @param prioridade Prioridade do elemento, valores a cima de 5 seram arredondados para 5.
     * @param separador Separador dos elementos da lista.
     * @param ordem Ordem dos elementos da lista, pode ser "alfabetica" ou "tamanho".
     * @return Qual o indice do elemento no documento, -1 caso o documento não exista e -2 caso o documento esteja cheio.
     */
    public int criarTermos(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem) {
        if (prioridade >= 5) { 
            System.out.println("A maior prioridade é 5, ela sera ajustada altomaticamente para 5");
            prioridade = 5;
        }

        Termo termo = new Termo(valorTermos, prioridade, separador, ordem);
        return addElemento(tituloDoc, termo);
    }

    /**
     * Cria um elemento de atalho
     * @param tituloDoc Titulo do documento.
     * @param tituloDocReferenciado Titulo do documento a virar um atalho.
     * @returnQual o indice do elemento no documento, -1 caso o documento não exista e -2 caso o documento esteja cheio, -3 
     * caso o documento a virar atalho não exista e -4 caso o documento a virar um atalho possua atalhos.
     */
    public int criarAtalho(String tituloDoc, String tituloDocReferenciado) {
        if (!documentos.containsKey(tituloDoc)) {
            System.out.println("Documento " + tituloDoc + " não encontrado");
            return -1;
        }

        Documento receberAtalho = documentos.get(tituloDoc);
        if (receberAtalho.isAtalho()) {
            System.out.println("Documentos que são atalhos não podem ter atalhos");    
            return -2;
        }

        if (!documentos.containsKey(tituloDocReferenciado)) {
            System.out.println("Documento " + tituloDocReferenciado + " não encontrado");
            return -3;
        }

        Documento paraAtalho = documentos.get(tituloDocReferenciado);
        if (paraAtalho.temAtalho()) {
            System.out.println("Documentos que possuem atalhos não podem ser atalho");
            return -4;
        }

        documentos.get(tituloDocReferenciado).turnAtalho();
        int prioridade = receberAtalho.mediaPrioridades();
        String valor = paraAtalho.getTitulo();
        Atalho atalho = new Atalho(valor, prioridade, paraAtalho);
        return documentos.get(tituloDoc).newElemento(atalho);
    }

    /**
     * Retorna a representação completa de um elemento em um documento.
     * @param tituloDoc Nome do documento.
     * @param elementoPosicao Posição do elemento no documento.
     * @return Represenção, ou string vazia, caso o documento não exista ou o elemento não exista.
     */
    public String pegarRepresentacaoCompletaDeElemento(String tituloDoc, int elementoPosicao) {
        if (!documentos.containsKey(tituloDoc)) 
            return "";
        
        Documento doc = documentos.get(tituloDoc);
        if (doc.existeElemento(elementoPosicao))
            return doc.getElemento(elementoPosicao).representacaoCompleta();

        return "";
    }

    /**
     * Retorna a represetanção resumida de um elemento em um documento.
     * @param tituloDoc Nome do documento.
     * @param elementoPosicao Posição do elemento no documento.
     * @return Represenção, ou string vazia, caso o documento não exista ou o elemento não exista.
     */
    public String pegarrepresentacaoResumidaDeElemento(String tituloDoc, int elementoPosicao) {
        if (!documentos.containsKey(tituloDoc)) 
            return "";
        
        Documento doc = documentos.get(tituloDoc);
        if (doc.existeElemento(elementoPosicao))
            return doc.getElemento(elementoPosicao).representacaoResumida();

        return "";
    }

    /**
     * Apaga um elemento de um documento.
     * @param tituloDoc nome do Documento.
     * @param elementoPosicao possição do elemento no documento.
     * @return True se o elemento foi removido, false caso o elemento ou documento não exista. 
     */
    public boolean apagarElemento(String tituloDoc, int elementoPosicao) {
        if (documentos.containsKey(tituloDoc)) 
            return (documentos.get(tituloDoc).removeElemento(elementoPosicao) != null);
        return false;
    }

    /**
     * Move um elemento em um documento para posição superior.
     * @param tituloDoc Nome do documento.
     * @param elementoPosicao possição do elemento no documento.
     */
    public void moverParaCima(String tituloDoc, int elementoPosicao) {
        if (documentos.containsKey(tituloDoc)) 
            documentos.get(tituloDoc).swapUp(elementoPosicao);
    }
    
    /**
     * Move um elemento em um documento para posição inferior.
     * @param tituloDoc Nome do documento.
     * @param elementoPosicao possição do elemento no documento.
     */
    public void moverParaBaixo(String tituloDoc, int elementoPosicao) {
        if (documentos.containsKey(tituloDoc)) 
            documentos.get(tituloDoc).swapDown(elementoPosicao);
    }  

    /**
     * Cria uma visão completa de um documento.
     * @param tituloDoc Nome do documento.
     * @return indice da visão na lista de visões.
     */
    public int criarVisaoCompleta(String tituloDoc) {
        if (!documentos.containsKey(tituloDoc)) {
            System.out.println("Documento " + tituloDoc + " não encontrado");
            return -1;
        }
        visualizacoes.add(documentos.get(tituloDoc).ShowElementos());
        
        return visualizacoes.size();
    }

    /**
     * Cria uma visão resumida de um documento.
     * @param tituloDoc Nome do documento.
     * @return indice da visão na lista de visões.
     */
    public int criarVisaoResumida(String tituloDoc) {
        if (!documentos.containsKey(tituloDoc)) {
            System.out.println("Documento " + tituloDoc + " não encontrado");
            return -1;
        }

        List<Elemento> elementos = Arrays.asList(documentos.get(tituloDoc).getElementos());
        visualizacoes.add(elementos.stream()
            .map((Elemento e) -> e.representacaoResumida())
            .collect(Collectors.toList())
            .toArray(new String[elementos.size()]));
        
        return visualizacoes.size();
    }
    
    /**
     * Cria uma visão de um documento com os elementos e com uma prioridade minima.
     * @param tituloDoc Nome do documento.
     * @param prioridade Prioridade minima desejada.
     * @return indice da visão na lista de visões.
     */
    public int criarVisaoPrioritaria(String tituloDoc, int prioridade) {
        if (!documentos.containsKey(tituloDoc)) {
            System.out.println("Documento " + tituloDoc + " não encontrado");
            return -1;
        }
        List<Elemento> elementos = Arrays.asList(documentos.get(tituloDoc).getElementos());
        elementos = elementos.stream()
            .filter((Elemento e) -> e.getPrioridade() >= prioridade)
            .collect(Collectors.toList());

        visualizacoes.add(elementos.stream()
            .map((Elemento e) -> e.representacaoCompleta())
            .collect(Collectors.toList())
            .toArray(new String[elementos.size()]));
        
        return visualizacoes.size();
    }
   
    /**
     * Cria uma visão de um documento com os elementos de titulo.
     * @param tituloDoc Nome do documento.
     * @return indice da visão na lista de visões.
     */
    public int criarVisaoTitulo(String tituloDoc) {
        if (!documentos.containsKey(tituloDoc)) {
            System.out.println("Documento " + tituloDoc + " não encontrado");
            return -1;
        }
        List<Elemento> elementos = Arrays.asList(documentos.get(tituloDoc).getElementos());
        elementos = elementos.stream()
            .filter((Elemento e) -> e.getTipo().equals("Titulo"))
            .collect(Collectors.toList());

        visualizacoes.add(elementos.stream()
            .map((Elemento e) -> e.representacaoCompleta())
            .collect(Collectors.toList())
            .toArray(new String[elementos.size()]));
            
        return visualizacoes.size();
    }
   
    /**
     * Mostra uma das visões geradas.
     * @param visaoId indice da visão.
     * @return uma lista vazia será retornada caso a visão não exista.
     */
    public String[] exibirVisao(int visaoId) {
        if (visaoId > visualizacoes.size()) 
            return new String[0];
        return visualizacoes.get(visaoId - 1);
    }
}