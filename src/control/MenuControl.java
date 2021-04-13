package control;

import appmain.MainFrameControl;
import control.helper.MenuControlHelper;
import vision.Menu;

/**
 * Classe auxiliar que cont�m a l�gica por tr�s da classe Menu.
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
	 * Executa uma a��o de acordo com o bot�o selecionado na view
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
	 * Ativa os bot�es que podem ser usados no menu.
	 * 
	 * @see MenuControlHelper
	 */
	public void ativarbotao() {
		helper.checarAtivar();
	}
}