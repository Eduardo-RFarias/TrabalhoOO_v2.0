package control;

import javax.swing.DefaultComboBoxModel;

import appmain.MainFrameControl;
import control.helper.RelatorioPersonagensHelper;
import vision.RelatorioPersonagens;

/**
 * Classe auxiliar que cont?m a l?gica por tr?s da classe RelatorioPersonagens
 * 
 * @author Eduardo Rodrigues
 * 
 * @see RelatorioPersonagens
 * @see RelatorioPersonagensHelper
 */
public class RelatorioPersonagensControl {

	private RelatorioPersonagens view;
	private RelatorioPersonagensHelper helper;

	/**
	 * Inicializa view e helper.
	 * 
	 * @param view A tela
	 */
	public RelatorioPersonagensControl(RelatorioPersonagens view) {
		this.view = view;
		helper = new RelatorioPersonagensHelper(view);
	}

	/**
	 * Executa uma a??o de acordo com o bot?o selecionado na view
	 * 
	 * Casos: Caso bot?o cancelar: limpe as entradas e volte ao menu. Caso bot?o
	 * ComboBox Ator: mostre o relat?rio com esse ator.
	 * 
	 * @param botaoFonte Um botao da tela
	 */
	public void executarBotao(Object botaoFonte) {
		if (botaoFonte == view.getButtonVoltar()) {
			view.getFieldRelatorio().setText("");
			MainFrameControl.mostrarMenu();
		} else {
			if (view.getFieldAtor().getSelectedItem() != null) {
				view.getFieldRelatorio().setText(helper.gerarRelatorio());
			}
		}
	}

	/**
	 * Metodo chama o helper para criar a array de atores e retorna um
	 * DefaultComboBoxModel com essa array.
	 * 
	 * @return DefaultComboBoxModel o model cadastrado para um comboBox
	 */
	public DefaultComboBoxModel<Object> atualizarModelo() {
		return new DefaultComboBoxModel<>(helper.criarArrayAtores());
	}
}
