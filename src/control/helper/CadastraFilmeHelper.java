package control.helper;

import java.util.ArrayList;
import java.util.List;

import model.Dados;
import model.Estudio;
import model.Filme;
import vision.CadastrarFilme;

/**
 * Classe auxiliar que cont�m m�todos �teis para sua respectivaa classe
 * controller.
 * 
 * @author Eduardo Rodrigues
 */
public class CadastraFilmeHelper {

	CadastrarFilme view;

	/**
	 * Inicializa view.
	 * 
	 * @param view inst�ncia de CadastrarFilme
	 */
	public CadastraFilmeHelper(CadastrarFilme view) {
		this.view = view;
	}

	/**
	 * Procura nos est�dios cadastrados e retorna o est�dio cujo nome seja igual ao
	 * escolhido (null caso n�o exista).
	 * 
	 * @param nome Nome do estudio
	 * @return estudio escolhido
	 */
	public Estudio resgatarEstudioEscolhido(String nome) {
		for (Estudio estudioAtual : Dados.getEstudios()) {
			if (estudioAtual.getNome().equals(nome)) {
				return estudioAtual;
			}
		}

		return null;
	}

	/**
	 * Gera uma array de Object (sempre String) com o nome de todos os est�dios
	 * cadastrados.
	 * 
	 * @return Object[] nomes dos est�dios
	 */
	public Object[] criarArrayEstudios() {
		List<String> modelo = new ArrayList<>();

		for (Estudio estudio : Dados.getEstudios()) {
			modelo.add(estudio.getNome());
		}

		return modelo.toArray();
	}

	/**
	 * Resgata as informa��es da tela, valida essas informa��es e retorna um objeto
	 * Filme (null caso a valida��o falhe).
	 * 
	 * @return Filme ou null
	 */
	public Filme obterModelo() {
		String nome = view.getFieldNome().getText();
		String modeloMeses = view.getFieldMeses().getText();
		String modeloAno = view.getFieldAno().getText();
		String modeloCopy = view.getFieldCopy().getText();
		String modeloCusto = view.getFieldCusto().getText();
		String diretor = view.getFieldDiretor().getText();

		int meses;
		int ano;
		int copy;
		double custo;

		if (nome.isEmpty()) {
			view.getFieldNome().setText("");
			return null;
		}

		try {
			meses = Integer.parseInt(modeloMeses);
		} catch (NumberFormatException e) {
			view.getFieldMeses().setText("");
			return null;
		}

		try {
			ano = Integer.parseInt(modeloAno);
		} catch (NumberFormatException e) {
			view.getFieldAno().setText("");
			return null;
		}

		try {
			copy = Integer.parseInt(modeloCopy);
		} catch (NumberFormatException e) {
			view.getFieldCopy().setText("");
			return null;
		}

		try {
			custo = Integer.parseInt(modeloCusto);
		} catch (NumberFormatException e) {
			view.getFieldCusto().setText("");
			return null;
		}

		if (diretor.isEmpty()) {
			view.getFieldDiretor().setText("");
			return null;
		}

		return new Filme(nome, meses, ano, copy, custo, diretor);

	}

	/**
	 * Recebe um Filme e o cadastra no est�dio escolhido.
	 * 
	 * @param modelo filme escolhido
	 */
	public void setarModelo(Filme modelo) {
		view.getController().getEstudioEscolhido().getFilmes().add(modelo);
	}

	/**
	 * Retorna todos as entradas para o padr�o.
	 */
	public void limpaCampo() {
		view.getFieldNome().setText("");
		view.getFieldMeses().setText("");
		view.getFieldAno().setText("");
		view.getFieldCopy().setText("");
		view.getFieldCusto().setText("");
		view.getFieldDiretor().setText("");
	}
}
