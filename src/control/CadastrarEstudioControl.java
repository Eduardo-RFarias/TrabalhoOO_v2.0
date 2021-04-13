package control;

import appmain.MainFrameControl;
import control.helper.CadastrarEstudioHelper;
import model.Estudio;
import vision.CadastrarEstudio;

/**
 * Classe auxiliar que cont�m a l�gica por tr�s da classe CadastraEstudio.
 * 
 * @author Eduardo Rodrigues
 * 
 * @see CadastrarEstudio
 * @see CadastrarEstudioHelper
 */
public class CadastrarEstudioControl {

	private CadastrarEstudio view;
	private CadastrarEstudioHelper helper;

	/**
	 * Inicializa view e helper.
	 * 
	 * @param view A tela
	 */
	public CadastrarEstudioControl(CadastrarEstudio view) {
		this.view = view;
		this.helper = new CadastrarEstudioHelper(view);
	}

	/**
	 * Executa uma a��o de acordo com o bot�o selecionado na view
	 * 
	 * Casos: Caso bot�o cancelar: limpe as entradas e volte ao menu.
	 * 
	 * Caso botao confirmar: crie um modelo de Estudio (null caso contenha
	 * informa��es erradas), cadastra o est�dio em Dados, limpa as entradas e mostra
	 * o menu.
	 * 
	 * @param botaoSelecionado Um botao da tela
	 */
	public void executarBotao(Object botaoSelecionado) {
		if (botaoSelecionado == view.getButtonCancelar()) {
			helper.limpaCampo();
			MainFrameControl.mostrarMenu();
		} else {
			Estudio modelo = helper.obterModelo();

			if (modelo != null) {
				helper.setarModelo(modelo);
				helper.limpaCampo();
				MainFrameControl.mostrarMenu();
			}
		}
	}

	public CadastrarEstudioHelper getHelper() {
		return helper;
	}
}
