package appmain;

import java.awt.CardLayout;
import model.Ator;
import model.Estudio;
import vision.CadastrarAtores;
import vision.CadastrarFilme;
import vision.CadastrarPapel;
import vision.Menu;
import vision.RelatorioAtoresDiretores;
import vision.RelatorioCache;
import vision.RelatorioFilmes;
import vision.RelatorioPersonagens;

/**
 * Classe auxiliar que contém toda a lógica por trás da classe MainFrame.
 * 
 * @author Eduardo Rodrigues
 * 
 * @see MainFrame
 */
public class MainFrameControl {

	private MainFrame view;

	/**
	 * Construtor que inicializa o campo view.
	 * 
	 * @param view A tela
	 */
	public MainFrameControl(MainFrame view) {
		this.view = view;
	}

	/**
	 * Método que atualiza certas informações na tela que acabou de ser mostrada. O
	 * parametro tela é o JPanel que foi mostrado pelo método show() (é necessário
	 * fazer um casting para a sua respectiva classe).
	 * 
	 * Casos possíveis: Caso tela for Menu: reseta variavel de cadastro e faz
	 * validacao dos botoes. Caso tela for CadastrarFilme: atualiza o ComboBox de
	 * estudios. Caso tela for CadastrarAtores: atualiza a Jlist de atores e faz
	 * validacao do botao finalizar. Caso tela for CadastrarPapel: preenche o ator
	 * escolhido e o estudio escolhido. Caso tela for RelatorioAtoresDiretores:
	 * atualiza o relatorio. Caso tela for RelatorioFilmes: atualiza o ComboBox de
	 * estudios. Caso tela for RelatorioCache: atualiza o ComboBox de atores. Caso
	 * tela for RelatorioPersonagens: atualiza o ComboBox de atores.
	 * 
	 * @param tela tela recebida
	 */
	public void mudarTela(Object tela) {
		if (tela == view.getMenu()) {
			Menu telaAtual = (Menu) tela;
			view.getCadastrarPapel().getController().setAdicionado(false);
			telaAtual.getController().ativarbotao();
		} else if (tela == view.getCadastrarFilme()) {
			CadastrarFilme telaAtual = (CadastrarFilme) tela;
			telaAtual.getFieldEstudio().setModel(telaAtual.getController().atualizarModelo());
		} else if (tela == view.getCadastrarAtores()) {
			CadastrarAtores telaAtual = (CadastrarAtores) tela;
			telaAtual.getFieldAtores().setModel(telaAtual.getController().atualizarModeloLista());
			telaAtual.getButtonFinalizar().setEnabled(view.getCadastrarPapel().getController().isAdicionado());
		} else if (tela == view.getCadastrarPapel()) {
			CadastrarPapel telaAtual = (CadastrarPapel) tela;
			Ator atorEscolhido = view.getCadastrarAtores().getController().getAtorEscolhido();
			telaAtual.getController().setAtorEscolhido(atorEscolhido);
			telaAtual.getLabelNomeAtor().setText(atorEscolhido.getNomeArtistico());
			Estudio estudioEscolhido = view.getCadastrarFilme().getController().getEstudioEscolhido();
			telaAtual.getController().setEstudioEscolhido(estudioEscolhido);
		} else if (tela == view.getRelatorioAtoresDiretores()) {
			RelatorioAtoresDiretores telaAtual = (RelatorioAtoresDiretores) tela;
			telaAtual.getFieldRelatorio().setText(telaAtual.getController().obterRelatorio());
		} else if (tela == view.getRelatorioFilmes()) {
			RelatorioFilmes telaAtual = (RelatorioFilmes) tela;
			telaAtual.getFieldEstudio().setModel(telaAtual.getController().atualizarModelo());
		} else if (tela == view.getRelatorioCache()) {
			RelatorioCache telaAtual = (RelatorioCache) tela;
			telaAtual.getFieldAtor().setModel(telaAtual.getController().atualizarModelo());
		} else if (tela == view.getRelatorioPersonagens()) {
			RelatorioPersonagens telaAtual = (RelatorioPersonagens) tela;
			telaAtual.getFieldAtor().setModel(telaAtual.getController().atualizarModelo());
		}
	}

	///////////////////////////////////////////////////////////////
	/**
	 * Muda a tela para Menu
	 */
	public static void mostrarMenu() {
		CardLayout cl = (CardLayout) MainFrame.getCont().getLayout();
		cl.show(MainFrame.getCont(), "menu");
	}

	/**
	 * Muda a tela para Registrar estúdio
	 */
	public static void mostrarCadastrarEstudio() {
		CardLayout cl = (CardLayout) MainFrame.getCont().getLayout();
		cl.show(MainFrame.getCont(), "cadastrarEstudio");
	}

	/**
	 * Muda a tela para Registrar filme
	 */
	public static void mostrarCadastrarFilme() {
		CardLayout cl = (CardLayout) MainFrame.getCont().getLayout();
		cl.show(MainFrame.getCont(), "cadastrarFilme");
	}

	/**
	 * Muda a tela para Registrar Ator
	 */
	public static void mostrarCadastraAtor() {
		CardLayout cl = (CardLayout) MainFrame.getCont().getLayout();
		cl.show(MainFrame.getCont(), "cadastrarAtores");
	}

	/**
	 * Muda a tela para Cadastrar Papel
	 */
	public static void mostrarCadastraPapel() {
		CardLayout cl = (CardLayout) MainFrame.getCont().getLayout();
		cl.show(MainFrame.getCont(), "cadastrarPapel");
	}

	/**
	 * Muda a tela para Novo Ator
	 */
	public static void mostrarNovoAtor() {
		CardLayout cl = (CardLayout) MainFrame.getCont().getLayout();
		cl.show(MainFrame.getCont(), "cadastrarNovoAtor");
	}

	/**
	 * Muda a tela para RelatorioAtoresDiretores
	 */
	public static void mostrarRelatorioAtoresDiretores() {
		CardLayout cl = (CardLayout) MainFrame.getCont().getLayout();
		cl.show(MainFrame.getCont(), "relatorioAtoresDiretores");
	}

	/**
	 * Muda a tela para RelatorioFilmes
	 */
	public static void mostrarRelatorioFilmes() {
		CardLayout cl = (CardLayout) MainFrame.getCont().getLayout();
		cl.show(MainFrame.getCont(), "relatorioFilmes");
	}

	/**
	 * Muda a tela para RelatorioCache
	 */
	public static void mostrarRelatorioCache() {
		CardLayout cl = (CardLayout) MainFrame.getCont().getLayout();
		cl.show(MainFrame.getCont(), "relatorioCache");
	}

	/**
	 * Muda a tela para RelatorioPersonagens
	 */
	public static void mostrarRelatorioPersonagens() {
		CardLayout cl = (CardLayout) MainFrame.getCont().getLayout();
		cl.show(MainFrame.getCont(), "relatorioPersonagens");
	}
}
