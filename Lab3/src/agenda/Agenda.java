package agenda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100 contatos. 
 * 
 * @author nazareno
 *
 */
public class Agenda {
	private List<Contato> contatos = new ArrayList<Contato>(); 
	private List<Contato> favoritos = new ArrayList<Contato>();

	/**
	 * Cria uma agenda.
	 */
	public Agenda() {
		this.contatos = new ArrayList<Contato>();
	}
		
	/**
	 * Acessa a lista de contatos mantida.
	 * @return O array de contatos.
	 */
	public String[] getContatos() {
		String[] retorno = new String[contatos.size()];
		for (int i = 0; i != contatos.size(); i++) 
			retorno[i] = contatos.get(i).toString();
		return retorno;
	}

	/**
	 * Acessa a lista de favoritos.
	 * @return O array de favoritos.
	 */
	public String[] getFavoritos() {
		String[] retorno = new String[favoritos.size()];
		for (int i = 0; i != favoritos.size(); i++) 
			retorno[i] = favoritos.get(i).toString();
		return retorno;	}

	/**
	 * Retorna os dados de um contato específico.
	 * @param posicao Posição do contato na agenda.
	 * @return Contato. 
	 */
	public String getContatoString(int posicao) {
		if (posicao > contatos.size()) 
			return "Não existe contato em uma posição tão alta";
		
		Contato c = contatos.get(posicao - 1);
		String resultado = new String(); 
		if (favoritos.contains(c))
			resultado += "❤️ ";
		resultado += c.getNome() + "\n" + c.getNumero();
		return resultado;
	}

	/**
	 * 
	 * @param posicao Indice do contato na lista de favoritos
	 * @return String que representa este favorito
	 */
	public String getFavoritoString(int posicao) {
		if (posicao > favoritos.size())
			return "Não existe favoritos em uma posição tão alta";
		Contato c = favoritos.get(posicao - 1);
		return "❤️ " + c.getNome() + "\n" + c.getNumero();
	}

	/**
	 * 
	 * @return quantidade de favoritos
	 */
	public int getFavoritosLen() {
		return this.favoritos.size();
	}

	/**
	 * 
	 * @return quantidade de contatos
	 */
	public int getContatosLen() {
		return this.contatos.size();
	}

	/**
	 * Retorna um contato pelo seu indice
	 * @param posicao Indice do contato na lista de contatos
	 * @return Contato
	 */
	public Contato getContato(int posicao) {
		return contatos.get(posicao - 1);
	}

	/**
	 * Verifica se já existe um contato com mesmo nome
	 * @param nome Nome a ser procurado
	 * @return Resultado se o nome já foi cadastrado
	 */
	public boolean nomeCadastrado(String nome) {
		for (Contato c : this.contatos) 
			if (c.getNome().equals(nome))
				return true;
		return false;
	}

	/**
	 * Verifica se já existe um contato com mesmo numero
	 * @param numero Numero a ser procurado
	 * @return Resultado se o numero já foi cadastrado
	 */
	public boolean numeroCadastrado(String numero) {
		for (Contato c : this.contatos) 
			if (c.getNumero().equals(numero))
				return true;
		return false;
	}

	/**
	 * Busca um contato pelo numero
	 * @param numero Numero a ser procurado
	 * @return Indice do contato
	 */
	public int indiceByNumero(String numero) {
		for (Contato c : contatos) 
			if (c.getNumero().equals(numero))
				return contatos.indexOf(c);
		return -1;
	}
	
	/**
	 * Busca um contato pelo nome
	 * @param name Nome a ser procurado
	 * @return Indice do contato
	 */
	public int indiceByName(String name) {
		for (Contato c : contatos) 
			if (c.getNome().equals(name))
				return contatos.indexOf(c);
		return -1;
	}

	/**
	 * Adiciona um contato na lista de contatos 
	 * @param nome Nome do contato
	 * @param sobrenome Sobrenome do contato
	 * @param telefone Telefone do contato
	 */
	public void addContato(String nome, String sobrenome, String telefone) {
		String nome_compĺeto = nome + " " + sobrenome;
		this.contatos.add(new Contato(nome_compĺeto, telefone));
	}

	/**
	 * 
	 * @return Se a lista de favoritos esta cheia ou não
	 */
	public boolean favoritoCheio() {
		return this.favoritos.size() >= 10;
	}

	/**
	 * Adiciona um contato a lista de favoritos
	 * @param contato Contato a ser adicionado
	 */
	public void addFavorito(Contato contato) {
		this.favoritos.add(contato);
	}

	/**
	 * Remove um contato da lista de favoritos
	 * @param posicao Posição a qual adicionar o contato
	 */
	public void removeFavorito(int posicao) {
		this.favoritos.remove(posicao - 1);
	}

	/**
	 * Cadastra um contato em uma posição. Um cadastro em uma posição que já existe sobrescreve o anterior. 
	 * @param posicao Posição do contato.
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param telefone Telefone do contato.
	 */
	public void cadastraContato(int posicao, String nome, String sobrenome, String telefone, Scanner input) {
		if (posicao < 0) {
			System.out.println("Posicao invalida");
		} else if (nome.equals("")) {
			System.out.println("Nome invalido");
		} else if (sobrenome.equals("")) {
			System.out.println("Sobrenome invalido");
		} else if (telefone.equals("")) {
			System.out.println("Telefone invalido");
		} else {
			String nome_completo = nome + " " + sobrenome;
			if (nomeCadastrado(nome_completo)) {
				System.out.println("\nUm contato com o mesmo nome já foi cadastrado.");
				System.out.print("Deseja atualizar [s/n]: ");
				String escolha = input.next();
				if (escolha.toLowerCase().equals("s")) {
					int indice = indiceByName(nome_completo);
					if (indice == -1) {
						System.out.println("Algo deu errado. Nome não encontrado");
					} else {
						contatos.set(indice, new Contato(nome_completo, telefone));
						System.out.println("Contato atualizado");
					}
				}
			} else if (numeroCadastrado(telefone)) {
				System.out.println("\nUm contato com o mesmo numero já foi cadastrado.");
				System.out.print("Deseja atualizar [s/n]: ");
				String escolha = input.next();
				if (escolha.toLowerCase().equals("s")) {
					int indice = indiceByNumero(telefone);
					if (indice == -1) {
						System.out.println("Algo deu errado. Numero não encontrado");
					} else {
						contatos.set(indice, new Contato(nome_completo, telefone));
						System.out.println("Contato atualizado");
					}
				}
			} else {
				if (posicao <= contatos.size()) {
					contatos.set(posicao - 1, new Contato(nome_completo, telefone));
				} else {
					contatos.add(new Contato(nome_completo, telefone));
				}
			}
		}
	}
}