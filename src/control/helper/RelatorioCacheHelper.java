package control.helper;

import java.util.ArrayList;
import java.util.List;

import model.Ator;
import model.Dados;
import model.Estudio;
import model.Filme;
import model.PapelFeito;
import vision.RelatorioCache;

/**
 * Classe auxiliar que contém métodos úteis para sua respectivaa classe
 * controller.
 * 
 * @author Eduardo Rodrigues
 */
public class RelatorioCacheHelper {
	private RelatorioCache view;

	/**
	 * Inicializa view.
	 * 
	 * @param view instância de CadastrarFilme
	 */
	public RelatorioCacheHelper(RelatorioCache view) {
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
	 * Gera um texto formatado contendo todos os filmes que o ator escolhido fez e a
	 * soma de todos os seus caches.
	 * 
	 * O método pesquisa nas arrays na classe Dados e simplesmente adiciona todos os
	 * nomes de filme em um modelo StringBuilder com o metodo append() e a soma dos
	 * caches logo em seguida.
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

		modelo.append("\nCache total: R$");

		modelo.append(resgatarCacheTotal(atorEscolhido.getPapeisFeitos()));

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
	 * Procura na array passada por parametro todos os caches e os soma.
	 * 
	 * @param papeisFeitos lista com os papeis feitos de um ator
	 * @return double soma dos caches
	 */
	private double resgatarCacheTotal(List<PapelFeito> papeisFeitos) {
		double soma = 0;

		for (PapelFeito papelAtual : papeisFeitos) {
			soma = papelAtual.getCache();
		}

		return soma;
	}
}
