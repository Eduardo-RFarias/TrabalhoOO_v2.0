package control;

import javax.swing.DefaultComboBoxModel;

import appmain.MainFrameControl;
import control.helper.RelatorioFilmesHelper;
import vision.RelatorioFilmes;

/**
 * Classe auxiliar que contém a lógica por trás da classe RelatorioFilmes.
 * 
 * @author Eduardo Rodrigues
 * 
 * @see RelatorioFilmes
 * @see RelatorioFilmesHelper
 */
public class RelatorioFilmesControl {

	private RelatorioFilmes view;
	private RelatorioFilmesHelper helper;

	/**
	 * Inicializa view e helper.
	 * 
	 * @param view A tela
	 */
	public RelatorioFilmesControl(RelatorioFilmes view) {
		this.view = view;
		helper = new RelatorioFilmesHelper(view);
	}

	/**
	 * Executa uma ação de acordo com o botão selecionado na view
	 * 
	 * Casos: Caso botão cancelar: limpe as entradas e volte ao menu. Caso botão
	 * ComboBox Estudio: mostre o relatório com esse estudio.
	 * 
	 * @param botaoFonte Um botao da tela
	 */
	public void executarBotao(Object botaoFonte) {
		if (botaoFonte == view.getButtonVoltar()) {
			view.getFieldRelatorio().setText("");
			MainFrameControl.mostrarMenu();
		} else {
			if (view.getFieldEstudio().getSelectedItem() != null) {
				view.getFieldRelatorio().setText(helper.gerarRelatorio());
			}
		}
	}

	/**
	 * Metodo chama o helper para criar a array de estudios e retorna um
	 * DefaultComboBoxModel com essa array.
	 * 
	 * @return DefaultComboBoxModel o model cadastrado para um comboBox
	 */
	public DefaultComboBoxModel<Object> atualizarModelo() {
		return new DefaultComboBoxModel<>(helper.criarArrayEstudios());
	}
}
