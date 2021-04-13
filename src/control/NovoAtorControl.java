package control;

import appmain.MainFrameControl;
import control.helper.NovoAtorHelper;
import model.Ator;
import vision.CadastrarNovoAtor;

/**
 * Classe auxiliar que contém a lógica por trás da classe NovoAtor.
 * 
 * @author Eduardo Rodrigues
 * 
 * @see CadastrarNovoAtor
 * @see NovoAtorHelper
 */
public class NovoAtorControl {

	private CadastrarNovoAtor view;
	private NovoAtorHelper helper;

	/**
	 * Inicializa view e helper.
	 * 
	 * @param view A tela
	 */
	public NovoAtorControl(CadastrarNovoAtor view) {
		this.view = view;
		helper = new NovoAtorHelper(view);
	}

	/**
	 * Executa uma ação de acordo com o botão selecionado na view
	 * 
	 * Casos: Caso botão cancelar: limpe as entradas e volte ao menu.
	 * 
	 * Caso botao confirmar: crie um modelo de Ator (null caso contenha informações
	 * erradas), cadastra o ator em Dados, limpa as entradas e mostra o menu.
	 * 
	 * @param botaoSelecionado um botao da tela
	 */
	public void executarBotao(Object botaoSelecionado) {
		if (botaoSelecionado == view.getButtonCancelar()) {
			helper.limpaCampo();
			MainFrameControl.mostrarCadastraAtor();
		} else {
			Ator modelo = helper.obterModelo();

			if (modelo != null) {
				helper.setarModelo(modelo);
				helper.limpaCampo();
				MainFrameControl.mostrarCadastraAtor();
			}
		}
	}
}
