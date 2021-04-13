package control.helper;

import model.Dados;
import vision.Menu;

/**
 * Classe auxiliar que contém métodos úteis para sua respectivaa classe
 * controller.
 * 
 * @author Eduardo Rodrigues
 */
public class MenuControlHelper {

	Menu view;

	/**
	 * Inicializa view.
	 * 
	 * @param view instância de Menu
	 */
	public MenuControlHelper(Menu view) {
		this.view = view;
	}

	/**
	 * Faz alguns testes e habilita os botões que poderão ser utilizados
	 * 
	 * Testes: 1 - caso exista algum estúdio cadastrado: habilite o botão Adicionar
	 * filme.
	 * 
	 * 2 - caso exista algum ator cadastrado: habilite o restante dos botões.
	 */
	public void checarAtivar() {
		if (!Dados.getEstudios().isEmpty()) {
			view.getButtonAdicionarFilme().setEnabled(true);
		}

		if (!Dados.getAtores().isEmpty()) {
			view.getButtonMostrarFilmes().setEnabled(true);
			view.getButtonMostrarAtores().setEnabled(true);
			view.getButtonMostrarCache().setEnabled(true);
			view.getButtonMostrarPersonagens().setEnabled(true);
		}
	}

}
