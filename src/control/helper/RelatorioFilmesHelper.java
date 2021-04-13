package control.helper;

import java.util.ArrayList;
import java.util.List;

import model.Dados;
import model.Estudio;
import model.Filme;
import vision.RelatorioFilmes;

/**
 * Classe auxiliar que contém métodos úteis para sua respectivaa classe
 * controller.
 * 
 * @author Eduardo Rodrigues
 */
public class RelatorioFilmesHelper {
	RelatorioFilmes view;

	/**
	 * Inicializa view.
	 * 
	 * @param view instância de CadastrarFilme
	 */
	public RelatorioFilmesHelper(RelatorioFilmes view) {
		this.view = view;
	}

	/**
	 * Pesquisa todos os estudios em Data e os armazena em uma array de String
	 * 
	 * @return Object[] a array com todos os estudios (sempre uma array de string)
	 */
	public Object[] criarArrayEstudios() {
		List<String> modelo = new ArrayList<>();

		modelo.add(null);

		for (Estudio estudio : Dados.getEstudios()) {
			modelo.add(estudio.getNome());
		}

		return modelo.toArray();
	}

	/**
	 * Gera um texto formatado contendo todos os filmes desse estúdio.
	 * 
	 * O método pesquisa nas arrays na classe Dados e simplesmente adiciona todos os
	 * nomes de filme em um modelo StringBuilder com o metodo append().
	 * 
	 * @return String o texto de relatorio completo
	 */
	public String gerarRelatorio() {
		boolean flag = false;
		StringBuilder modelo = new StringBuilder();

		modelo.append("Filmes:\n");

		for (Estudio estudioAtual : Dados.getEstudios()) {
			if (estudioAtual.getNome().equals(view.getFieldEstudio().getSelectedItem())) {
				flag = true;
				for (Filme filmeAtual : estudioAtual.getFilmes()) {
					modelo.append("    -");
					modelo.append(filmeAtual.getNome());
					modelo.append("\n");
				}
			}
		}

		if (!flag) {
			return "Não há filmes cadastrados nesse estúdio";
		}

		return modelo.toString();
	}

}
