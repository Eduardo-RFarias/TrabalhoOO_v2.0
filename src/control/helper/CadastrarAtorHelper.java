package control.helper;

import javax.swing.DefaultListModel;

import model.Ator;
import model.Dados;
import vision.CadastrarAtores;

/**
 * Classe auxiliar que contém métodos úteis para sua respectiva classe
 * controller.
 * 
 * @author Eduardo Rodrigues
 */
public class CadastrarAtorHelper {
	CadastrarAtores view;

	/**
	 * Inicializa view.
	 * 
	 * @param view instância de CadastrarAtor
	 */
	public CadastrarAtorHelper(CadastrarAtores view) {
		this.view = view;
	}

	/**
	 * Procura nos atores cadastrados e retorna o ator cujo nome seja igual ao
	 * escolhido (null caso não exista).
	 * 
	 * @param nome Nome do ator escolhido
	 * 
	 * @return ator escolhido
	 */
	public Ator resgatarAtorEscolhido(String nome) {
		for (Ator atorAtual : Dados.getAtores()) {
			if (nome.equals(atorAtual.getNomeArtistico())) {
				return atorAtual;
			}
		}
		return null;
	}

	/**
	 * Gera um Model com o nome de todos os atores cadastrados.
	 * 
	 * @return DefaultListModel
	 */
	public DefaultListModel<String> resgatarAtoresCadastrados() {
		DefaultListModel<String> nomes = new DefaultListModel<>();

		for (Ator atorAtual : Dados.getAtores()) {
			nomes.addElement(atorAtual.getNomeArtistico());
		}

		return nomes;
	}
}
