package control.helper;

import java.util.ArrayList;
import java.util.List;

import model.Ator;
import model.Dados;
import model.Estudio;
import model.Filme;
import model.PapelFeito;
import vision.RelatorioPersonagens;

/**
 * Classe auxiliar que contém métodos úteis para sua respectivaa classe
 * controller.
 * 
 * @author Eduardo Rodrigues
 */
public class RelatorioPersonagensHelper {

	private RelatorioPersonagens view;

	/**
	 * Inicializa view.
	 * 
	 * @param view instância de CadastrarFilme
	 */
	public RelatorioPersonagensHelper(RelatorioPersonagens view) {
		this.view = view;
	}

	/**
	 * Pesquisa todos os atores em Data e os armazena em uma array de String
	 * 
	 * @return Object[] a array com todos os atores (sempre uma array de string)
	 */
	public Object[] criarArrayAtores() {
		List<String> modelo = new ArrayList<>();

		modelo.add(null);

		for (Ator ator : Dados.getAtores()) {
			modelo.add(ator.getNomeArtistico());
		}

		return modelo.toArray();
	}

	/**
	 * Gera um texto formatado contendo todos os filmes e personagens que o ator
	 * escolhido fez.
	 * 
	 * O método pesquisa nas arrays na classe Dados e simplesmente adiciona todos os
	 * filmes e personagens do ator em um modelo StringBuilder com o metodo
	 * append().
	 * 
	 * @return String o texto de relatorio completo
	 */
	public String gerarRelatorio() {
		Ator atorEscolhido = resgatarAtor(view.getFieldAtor().getSelectedItem().toString());
		StringBuilder modelo = new StringBuilder();

		if (atorEscolhido == null) {
			return null;
		}

		modelo.append("Participou dos filmes:\n");

		for (Estudio estudioAtual : Dados.getEstudios()) {
			for (Filme filmeAtual : estudioAtual.getFilmes()) {
				if (filmeAtual.getNomeAtores().contains(atorEscolhido.getNomeArtistico())) {
					modelo.append("    -");
					modelo.append(filmeAtual.getNome() + "\n");
				}
			}
		}

		modelo.append("\nPersonagens Feitos:\n");

		modelo.append(resgatarPersonagensFeitos(atorEscolhido.getPapeisFeitos()));

		return modelo.toString();
	}

	/**
	 * Procura nos Dados o ator que corresponde ao nome passado como parametro e
	 * retorna o objeto ator correspondente.
	 * 
	 * @param nomeAtor o nome do ator escolhido
	 * @return Ator objeto ator correspondente
	 */
	private Ator resgatarAtor(String nomeAtor) {
		for (Ator atorAtual : Dados.getAtores()) {
			if (nomeAtor.equals(atorAtual.getNomeArtistico())) {
				return atorAtual;
			}
		}
		return null;
	}

	/**
	 * Procura na array passada por parametro todos os personagens e o adiciona em
	 * um StringBuilder.
	 * 
	 * @param papeisFeitos lista com os papeis feitos de um ator
	 * @return String texto formatado com todos os personagens feitos
	 */
	private String resgatarPersonagensFeitos(List<PapelFeito> papeisFeitos) {
		StringBuilder modelo = new StringBuilder();

		for (PapelFeito papelAtual : papeisFeitos) {
			modelo.append("    -");
			modelo.append(papelAtual.getNomePersonagem());
			modelo.append("\n");
		}

		return modelo.toString();
	}
}
