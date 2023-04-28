package Classes;

import java.util.List;
import java.util.ArrayList;

public class DogHost {
    public String nomeAnfitriao;
    public int quantidadeMaxDeCachorros;
    public int quantidadeMaxDeRacao;
    private List<Dog> dogs = new ArrayList<Dog>();

    public DogHost(String nomeAnfitriao, int quantidadeMaxDeCachorros, int quantidadeMaxDeRacao) {
        this.nomeAnfitriao = nomeAnfitriao;
        this.quantidadeMaxDeCachorros = quantidadeMaxDeCachorros;
        this.quantidadeMaxDeRacao = quantidadeMaxDeRacao;
    }
    
    public boolean adicionaDog(String nome, String tutor, int qntdRacao, Object object) {
        return adicionaDog(nome, tutor, qntdRacao, null);
    }

    public boolean adicionaDog(String nome, String tutor, int qntdRacao, Dog dog, String tipoDeRestricao) {
        if (dogs.size() < quantidadeMaxDeCachorros) {
            int qntdRacaoTotal = getQtdRacaoTotal();
            int qntdRacaoComRestricao = qntdRacao;
            if (tipoDeRestricao != null) {
                qntdRacaoComRestricao = qntdRacaoComRestricao * 2;
            }
            if (qntdRacaoTotal + qntdRacaoComRestricao <= quantidadeMaxDeRacao) {
                dogs.add(new Dog(nome, tutor, qntdRacao, tipoDeRestricao));
                return true;
            }
        }
        return false;
    }

    public String listaDogs() {
        StringBuilder sb = new StringBuilder();
    sb.append(nomeAnfitriao + ":\n");
    for (Dog dog : dogs) {
        sb.append(dog.toString() + "\n");
 }
    return sb.toString();

}

    public double consultaValorHospedagem(Dog dog, int dias) {
        if (!dogs.contains(dog));
        throw new IllegalArgumentException("Cachorro não hospedado");
    }
    return dog.getQtdRacao() * dias * 0.4;
