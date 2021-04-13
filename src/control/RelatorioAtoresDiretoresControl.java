package control;

import appmain.MainFrameControl;
import control.helper.RelatorioAtoresDiretoresHelper;
import vision.RelatorioAtoresDiretores;

/**
 * Classe auxiliar que contém a lógica por trás da classe
 * RelatorioAtoresDiretores.
 * 
 * @author Eduardo Rodrigues
 * 
 * @see RelatorioAtoresDiretores
 * @see RelatorioAtoresDiretoresHelper
 */
public class RelatorioAtoresDiretoresControl {
	private RelatorioAtoresDiretores view;
	private RelatorioAtoresDiretoresHelper helper;

	/**
	 * Inicializa view e helper.
	 * 
	 * @param view A tela
	 */
	public RelatorioAtoresDiretoresControl(RelatorioAtoresDiretores view) {
		this.view = view;
		helper = new RelatorioAtoresDiretoresHelper(view);
	}

	/**
	 * Executa uma ação de acordo com o botão selecionado na view
	 * 
	 * Casos: Caso botão cancelar: limpe as entradas e volte ao menu.
	 * 
	 * @param botaoSelecionado Um botao da tela
	 */
	public void executarBotao(Object botaoSelecionado) {
		view.getFieldRelatorio().setText("");
		MainFrameControl.mostrarMenu();
	}

	/**
	 * Metodo chama o helper para gerar o relatório e o retorna em seguida.
	 * 
	 * @return String
	 */
	public String obterRelatorio() {
		return helper.gerarRelatorio();
	}
}
