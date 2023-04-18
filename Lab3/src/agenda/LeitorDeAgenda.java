package agenda;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Lógica para ler de arquivos csv os dados necessários e povoar uma agenda. 
 * 
 * @author nazarenoandrade
 *
 */
public class LeitorDeAgenda {

	private static final int COLUNA_NOME = 0;
	private static final int COLUNA_SOBRENOME = 1;
	private static final int COLUNA_TELEFONE = 2;

	/**
	 * Lê contatos de um arquivo CSV e os coloca em uma agenda.
	 * @param arquivoContatos Caminho para arquivo contendo contatos.
	 * @param agenda A agenda a manipular.
	 * @return O número de contatos adicionados à agenda.
	 * @throws IOException Caso não tenhamos permissão de ler o arquivo.
	 * @throws FileNotFoundException Caso o arquivo não exista.
	 */
	public int carregaContatos(String arquivoContatos, Agenda agenda) throws FileNotFoundException, IOException {
		int carregados = 0;

		try (BufferedReader br = new BufferedReader(new FileReader(arquivoContatos))) {
			String linha;
			while ((linha = br.readLine()) != null) {
				carregados += 1;
				if (carregados == 1) {
					// pulamos a primeira linha, o cabeçalho
					continue;
				}
				String[] campos = linha.split(",");
				cadastraContato(campos, agenda);
			}
		}
		
		return carregados;
	}

	/**
	 * Coloca na agenda os dados de uma linha do arquivo de agenda inicial. 
	 * 
	 * @param campos As informações lidas do csv. 
 	 * @param agenda A agenda a manipular.
	 */
	private void cadastraContato(String[] campos, Agenda agenda) {
		String[] contato = processaLinhaCsvContatos(campos);
		agenda.addContato(contato[0], contato[1], contato[2]);
	}

	/**
	 * Recebe a linha do arquivo CSV e retorna uma lsita com os elementos
	 * 
	 * @param campos As informações lidas do csv. 
	 * @return A lista com os dados do contato
	 */
	private static String[] processaLinhaCsvContatos(String[] campos) {
		String nome = campos[COLUNA_NOME].trim();
		String sobrenome = campos[COLUNA_SOBRENOME].trim();
		String telefone = campos[COLUNA_TELEFONE].trim();
		String[] dados = {nome, sobrenome, telefone};
		return dados;
	}

}