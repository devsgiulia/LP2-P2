package Testes;

import com.sun.tools.javac.util.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Assert;

public class CronicasDoEstudanteSistemaTeste{

    @Test
    public void testCriarLivreto() {
        String[] livreto = new Livreto("Meu Livreto");
        assertNotNull(livreto);
        assertEquals("Meu Livreto", livreto.length);
        Assert.assertNotNull(livreto.length);
        assertTrue(livreto.length);
    }

    private void assertTrue(int length) {
    }

    private void isEmpty() {
        // TODO
    }

    private void assertEquals(String string, int length) {
        // TODO
    }

    private void assertNotNull(String[] livreto) {
        // TODO
    }

    @Test
    public void testAdicionarCronica() {
        Livreto livreto = new Livreto("Meu Livreto");
        Cronica cronica1 = new Cronica("Título 1", "Autor 1", "Conteúdo 1");
        Cronica cronica2 = new Cronica("Título 2", "Autor 2", "Conteúdo 2");
        livreto.adicionarCronica(cronica1);
        livreto.adicionarCronica(cronica2);
        assertEquals(2, livreto.getCronicas().size());
        assertTrue(livreto.getCronicas().contains(cronica1));
        assertTrue(livreto.getCronicas().contains(cronica2));
    }

    @Test
    public void testCronicaMaisLida() {
        Livreto livreto = new Livreto("Meu Livreto");
        Cronica cronica1 = new Cronica("Título 1", "Autor 1", "Conteúdo 1");
        Cronica cronica2 = new Cronica("Título 2", "Autor 2", "Conteúdo 2");
        Cronica cronica3 = new Cronica("Título 3", "Autor 3", "Conteúdo 3");
        livreto.adicionarCronica(cronica1);
        livreto.adicionarCronica(cronica2);
        livreto.adicionarCronica(cronica3);
        cronica2.aumentarVisualizacoes();
        cronica2.aumentarVisualizacoes();
        cronica3.aumentarVisualizacoes();
        assertEquals(cronica2, livreto.getCronicaMaisLida());
    }
}