package control.helper;

import java.util.ArrayList;

import model.Ator;
import model.Dados;
import model.Estudio;
import model.Filme;
import vision.RelatorioAtoresDiretores;

/**
 * Classe auxiliar que contém métodos úteis para sua respectivaa classe
 * controller.
 * 
 * @author Eduardo Rodrigues
 */
public class RelatorioAtoresDiretoresHelper {
	RelatorioAtoresDiretores view;

	/**
	 * Inicializa view.
	 * 
	 * @param view instância de CadastrarFilme
	 */
	public RelatorioAtoresDiretoresHelper(RelatorioAtoresDiretores view) {
		this.view = view;
	}

	/**
	 * Gera um texto formatado contendo todos os atores e diretores cadastrados.
	 * 
	 * O método pesquisa nas arrays na classe Dados e simplesmente adiciona todos os
	 * nomes artisticos em um modelo StringBuilder com o metodo append()
	 * 
	 * @return String o texto de relatorio completo
	 */
	public String gerarRelatorio() {
		StringBuilder modelo = new StringBuilder();

		modelo.append("Atores:\n");

		for (Ator atorAtual : Dados.getAtores()) {
			modelo.append("    -");
			modelo.append(atorAtual.getNomeArtistico());
			modelo.append("\n");
		}

		modelo.append("\nDiretores:\n");

		for (Estudio estudioAtual : Dados.getEstudios()) {
			modelo.append(verTodosDiretores(estudioAtual));
		}

		return modelo.toString();
	}

	/**
	 * Procura os diretores cadastrados no estudio e retorna um texto formatado com
	 * todos eless
	 * 
	 * @param estudioAtual O estudio escolhido
	 * @return String o texto com todos os diretores
	 */
	public String verTodosDiretores(Estudio estudioAtual) {
		ArrayList<String> arrDiretores = new ArrayList<>();

		for (Filme filme : estudioAtual.getFilmes()) {
			if (!arrDiretores.contains(filme.getDiretor())) {
				arrDiretores.add(filme.getDiretor());
			}
		}

		StringBuilder diretores = new StringBuilder();
		for (String diretorAtual : arrDiretores) {
			diretores.append("    -");
			diretores.append(diretorAtual);
			diretores.append("\n");
		}
		return diretores.toString();
	}
}
