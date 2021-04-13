package control.helper;

import model.Ator;
import model.Dados;
import vision.CadastrarNovoAtor;

/**
 * Classe auxiliar que contém métodos úteis para sua respectivaa classe
 * controller.
 * 
 * @author Eduardo Rodrigues
 */
public class NovoAtorHelper {

	private CadastrarNovoAtor view;

	/**
	 * Inicializa view.
	 * 
	 * @param view instância de NovoAtor
	 */
	public NovoAtorHelper(CadastrarNovoAtor view) {
		this.view = view;
	}

	/**
	 * Retorna todos as entradas para o padrão.
	 */
	public void limpaCampo() {
		view.getFieldIdade().setText("");
		view.getFieldNacionalidade().setText("");
		view.getFieldNome().setText("");
		view.getFieldPapeisPossiveis().setText("");
		view.getFieldSeguro().setText("");
	}

	/**
	 * Resgata as informações da tela, valida essas informações e retorna um objeto
	 * Ator (null caso a validação falhe).
	 * 
	 * @return Ator ou null
	 */
	public Ator obterModelo() {
		String nome = view.getFieldNome().getText();
		String modeloIdade = view.getFieldIdade().getText();
		String nacionalidade = view.getFieldNacionalidade().getText();
		String[] papeisPossiveis = view.getFieldPapeisPossiveis().getText().split("\n");
		String modeloSeguro = view.getFieldSeguro().getText();
		char sexo = view.getFieldSexo().getSelectedItem().toString().charAt(0);
		int idade;
		int seguro;

		if (nome.isEmpty()) {
			view.getFieldNome().setText("");
			return null;
		}
		if (nacionalidade.isEmpty()) {
			view.getFieldNacionalidade().setText("");
			return null;
		}
		if (papeisPossiveis.length == 1 && papeisPossiveis[0].isEmpty()) {
			view.getFieldPapeisPossiveis().setText("");
			return null;
		}
		try {
			idade = Integer.parseInt(modeloIdade);
		} catch (NumberFormatException e) {
			view.getFieldIdade().setText("");
			return null;
		}
		try {
			seguro = Integer.parseInt(modeloSeguro);
		} catch (NumberFormatException e) {
			view.getFieldSeguro().setText("");
			return null;
		}

		return new Ator(nome, seguro, nacionalidade, idade, sexo, papeisPossiveis);
	}

	/**
	 * Recebe um Ator e o cadastra em Dados.
	 * 
	 * @param modelo Filme para cadastrar
	 */
	public void setarModelo(Ator modelo) {
		Dados.getAtores().add(modelo);
	}
}
