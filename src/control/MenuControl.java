package control;

import appmain.MainFrameControl;
import control.helper.MenuControlHelper;
import vision.Menu;

/**
 * Classe auxiliar que contém a lógica por trás da classe Menu.
 * 
 * @author Eduardo Rodrigues
 * 
 * @see Menu
 * @see MenuControlHelper
 */
public class MenuControl {

	private Menu view;
	private MenuControlHelper helper;

	/**
	 * Inicializa view e helper.
	 * 
	 * @param view A tela
	 */
	public MenuControl(Menu view) {
		this.view = view;
		helper = new MenuControlHelper(view);
	}

	/**
	 * Executa uma ação de acordo com o botão selecionado na view
	 * 
	 * Casos: Mostra respectiva tela
	 * 
	 * @param botaoFonte Um botao da tela
	 */
	public void executarBotao(Object botaoFonte) {
		if (botaoFonte == view.getButtonRegistrarEstudio()) {
			MainFrameControl.mostrarCadastrarEstudio();
		} else if (botaoFonte == view.getButtonAdicionarFilme()) {
			MainFrameControl.mostrarCadastrarFilme();
		} else if (botaoFonte == view.getButtonMostrarFilmes()) {
			MainFrameControl.mostrarRelatorioFilmes();
		} else if (botaoFonte == view.getButtonMostrarAtores()) {
			MainFrameControl.mostrarRelatorioAtoresDiretores();
		} else if (botaoFonte == view.getButtonMostrarCache()) {
			MainFrameControl.mostrarRelatorioCache();
		} else if (botaoFonte == view.getButtonMostrarPersonagens()) {
			MainFrameControl.mostrarRelatorioPersonagens();
		}
	}

	/**
	 * Ativa os botões que podem ser usados no menu.
	 * 
	 * @see MenuControlHelper
	 */
	public void ativarbotao() {
		helper.checarAtivar();
	}
}