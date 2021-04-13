package control;

import javax.swing.DefaultComboBoxModel;

import appmain.MainFrameControl;
import control.helper.CadastraFilmeHelper;
import model.Estudio;
import model.Filme;
import vision.CadastrarFilme;

/**
 * Classe auxiliar que cont�m a l�gica por tr�s da classe CadastraFilme.
 * 
 * @author Eduardo Rodrigues
 * 
 * @see CadastrarFilme
 * @see CadastraFilmeHelper
 */
public class CadastrarFilmeControl {
	private CadastrarFilme view;
	private CadastraFilmeHelper helper;
	private Estudio estudioEscolhido;

	/**
	 * Inicializa view e helper.
	 * 
	 * @param view A tela
	 */
	public CadastrarFilmeControl(CadastrarFilme view) {
		this.view = view;
		helper = new CadastraFilmeHelper(view);
	}

	/**
	 * Executa uma a��o de acordo com o bot�o selecionado na view
	 * 
	 * Casos: Caso bot�o cancelar: limpe as entradas e volte ao menu.
	 * 
	 * Caso botao confirmar: crie um modelo de Filme (null caso contenha informa��es
	 * erradas), cadastra o filme em Dados, limpa as entradas e mostra o menu.
	 * 
	 * @param botaoFonte um botao do tela
	 */
	public void executarBotao(Object botaoFonte) {
		if (botaoFonte == view.getButtonCancelar()) {
			helper.limpaCampo();
			MainFrameControl.mostrarMenu();
		} else {
			estudioEscolhido = helper.resgatarEstudioEscolhido(view.getFieldEstudio().getSelectedItem().toString());

			Filme modelo = helper.obterModelo();

			if (modelo != null) {
				helper.setarModelo(modelo);
				helper.limpaCampo();
				MainFrameControl.mostrarCadastraAtor();
			}
		}
	}

	/**
	 * Usado para preencher a caixa com os est�dios.
	 * 
	 * @return model para ComboBox
	 * 
	 * @see MainFrameControl
	 */
	public DefaultComboBoxModel<Object> atualizarModelo() {
		return new DefaultComboBoxModel<>(helper.criarArrayEstudios());
	}

	public Estudio getEstudioEscolhido() {
		return estudioEscolhido;
	}
}
