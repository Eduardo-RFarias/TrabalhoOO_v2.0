package control.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.Dados;
import model.Estudio;
import vision.CadastrarEstudio;

/**
 * Classe auxiliar que contém métodos úteis para sua respectivaa classe
 * controller.
 * 
 * @author Eduardo Rodrigues
 */
public class CadastrarEstudioHelper {

	private CadastrarEstudio view;

	/**
	 * Inicializa view.
	 * 
	 * @param view instância de CadastrarEstudio
	 */
	public CadastrarEstudioHelper(CadastrarEstudio view) {
		this.view = view;
	}

	/**
	 * Resgata as informações da tela, valida essas informações e retorna um objeto
	 * Estudio (null caso a validação falhe).
	 * 
	 * @return Estudio ou null
	 */
	public Estudio obterModelo() {
		String nome = view.getFieldNome().getText();
		String dono = view.getFieldDono().getText();
		String modeloData = view.getFieldData().getText();
		String modeloFaturamento = view.getFieldFaturamento().getText();

		if (nome.isEmpty()) {
			view.getFieldNome().setText("");
			return null;
		}

		if (dono.isEmpty()) {
			view.getFieldDono().setText("");
			return null;
		}

		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		Date data;
		try {
			data = formatador.parse(modeloData);
		} catch (ParseException ee) {
			view.getFieldData().setText("");
			return null;
		}

		double faturamento;
		try {
			faturamento = Double.parseDouble(modeloFaturamento);
		} catch (NumberFormatException p) {
			view.getFieldFaturamento().setText("");
			return null;
		}

		return new Estudio(nome, dono, data, faturamento);

	}

	/**
	 * Recebe um Estudio e o cadastra em Dados.
	 * 
	 * @param modelo Estudio para cadastrar
	 */
	public void setarModelo(Estudio modelo) {
		Dados.getEstudios().add(modelo);
	}

	/**
	 * Retorna todos as entradas para o padrão.
	 */
	public void limpaCampo() {
		view.getFieldNome().setText("");
		view.getFieldDono().setText("");
		view.getFieldData().setText("");
		view.getFieldFaturamento().setText("");
	}
}
