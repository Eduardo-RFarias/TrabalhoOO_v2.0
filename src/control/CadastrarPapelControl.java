package control;

import appmain.MainFrameControl;
import control.helper.CadastrarPapelHelper;
import model.Ator;
import model.Estudio;
import model.PapelFeito;
import vision.CadastrarPapel;

/**
 * Classe auxiliar que contém a lógica por trás da classe CadastraPapel.
 * 
 * @author Eduardo Rodrigues
 * 
 * @see CadastrarPapel
 * @see CadastrarPapelHelper
 */
public class CadastrarPapelControl {

	private CadastrarPapel view;
	private CadastrarPapelHelper helper;
	private Ator atorEscolhido;
	private Estudio estudioEscolhido;
	private boolean adicionado;

	/**
	 * Inicializa view e helper.
	 * 
	 * @param view A tela
	 */
	public CadastrarPapelControl(CadastrarPapel view) {
		this.view = view;
		helper = new CadastrarPapelHelper(view);
		adicionado = false;
	}

	public void setAtorEscolhido(Ator atorEscolhido) {
		this.atorEscolhido = atorEscolhido;
	}

	public Ator getAtorEscolhido() {
		return atorEscolhido;
	}

	public Estudio getEstudioEscolhido() {
		return estudioEscolhido;
	}

	public boolean isAdicionado() {
		return adicionado;
	}

	public void setAdicionado(boolean adicionado) {
		this.adicionado = adicionado;
	}

	public void setEstudioEscolhido(Estudio estudioEscolhido) {
		this.estudioEscolhido = estudioEscolhido;
	}

	/**
	 * Executa uma ação de acordo com o botão selecionado na view
	 * 
	 * Casos: Caso botão cancelar: limpe as entradas e volte ao menu.
	 * 
	 * Caso botao confirmar: crie um modelo de PapelFeito (null caso contenha
	 * informações erradas), cadastra o papel no ator escolhido, limpa as entradas e
	 * mostra o menu.
	 * 
	 * @param fonte Um botao da tela
	 */
	public void executarBotao(Object fonte) {
		if (fonte == view.getButtonCancelar()) {
			helper.limpaCampo();
			MainFrameControl.mostrarCadastraAtor();
		} else {
			PapelFeito modelo = helper.obterModelo();
			if (modelo != null) {
				helper.setarModelo(modelo);
				helper.limpaCampo();
				MainFrameControl.mostrarCadastraAtor();
			}
		}
	}
}
