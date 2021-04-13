package control;

import javax.swing.DefaultComboBoxModel;

import appmain.MainFrameControl;
import control.helper.RelatorioCacheHelper;
import vision.RelatorioCache;

/**
 * Classe auxiliar que contém a lógica por trás da classe RelatorioCache.
 * 
 * @author Eduardo Rodrigues
 * 
 * @see RelatorioCache
 * @see RelatorioCacheHelper
 */
public class RelatorioCacheControl {
	private RelatorioCache view;
	private RelatorioCacheHelper helper;

	/**
	 * Inicializa view e helper.
	 * 
	 * @param view A tela
	 */
	public RelatorioCacheControl(RelatorioCache view) {
		this.view = view;
		helper = new RelatorioCacheHelper(view);
	}

	/**
	 * Executa uma ação de acordo com o botão selecionado na view
	 * 
	 * Casos: Caso botão cancelar: limpe as entradas e volte ao menu. Caso botão
	 * ComboBox Ator: mostre o relatório com esse ator.
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
