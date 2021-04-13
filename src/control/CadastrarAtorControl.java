package control;

import javax.swing.DefaultListModel;

import appmain.MainFrameControl;
import control.helper.CadastrarAtorHelper;
import model.Ator;
import vision.CadastrarAtores;
import vision.CadastrarPapel;
import vision.CadastrarNovoAtor;

/**
 * Classe auxiliar que contém toda a lógica por trás da classe CadastraAtor.
 * 
 * @author Eduardo Rodrigues
 * 
 * @see CadastrarAtores
 * @see CadastrarAtorHelper
 */
public class CadastrarAtorControl {

	private CadastrarAtores view;
	private CadastrarAtorHelper helper;
	private Ator atorEscolhido;

	/**
	 * Inicializa view e helper.
	 * 
	 * @param view A tela
	 */
	public CadastrarAtorControl(CadastrarAtores view) {
		this.view = view;
		helper = new CadastrarAtorHelper(view);
	}

	/**
	 * Executa uma ação de acordo com o botão selecionado na view
	 * 
	 * Casos: Caso botão finalizar: Retorna ao menu.
	 * 
	 * Caso botao selecionar: Escolhe o nome selecionado na lista, preenche o campo
	 * atorEscolhido e mostra segue para cadastrar um papel.
	 * 
	 * Caso botao novo ator: segue para cadastrar um novo ator
	 * 
	 * botaoSelecionado
	 * 
	 * @param botaoSelecionado Um botao de sua tela.
	 * 
	 * @see CadastrarPapel
	 * @see CadastrarNovoAtor
	 */
	public void executarBotao(Object botaoSelecionado) {
		if (botaoSelecionado == view.getButtonFinalizar()) {
			MainFrameControl.mostrarMenu();
		} else if (botaoSelecionado == view.getButtonSelecionar()) {
			String nomeEscolhido = view.getFieldAtores().getSelectedValue();

			if (nomeEscolhido != null) {
				atorEscolhido = helper.resgatarAtorEscolhido(nomeEscolhido);
				MainFrameControl.mostrarCadastraPapel();
			}
		} else {
			MainFrameControl.mostrarNovoAtor();
		}
	}

	/**
	 * Usado para preencher a lista de atores.
	 * 
	 * @return model para JList
	 * 
	 * @see MainFrameControl
	 */
	public DefaultListModel<String> atualizarModeloLista() {
		return helper.resgatarAtoresCadastrados();
	}

	public Ator getAtorEscolhido() {
		return atorEscolhido;
	}
}
