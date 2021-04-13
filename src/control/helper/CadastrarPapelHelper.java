package control.helper;

import model.Ator;
import model.Filme;
import model.PapelFeito;
import vision.CadastrarPapel;

/**
 * Classe auxiliar que contém métodos úteis para sua respectivaa classe
 * controller.
 * 
 * @author Eduardo Rodrigues
 */
public class CadastrarPapelHelper {

	CadastrarPapel view;

	/**
	 * Inicializa view.
	 * 
	 * @param view instância de CadastrarPapel
	 */
	public CadastrarPapelHelper(CadastrarPapel view) {
		this.view = view;
	}

	/**
	 * Retorna todos as entradas para o padrão.
	 */
	public void limpaCampo() {
		view.getFieldNomePersonagem().setText("");
		view.getFieldCache().setText("");
	}

	/**
	 * Resgata as informações da tela, valida essas informações e retorna um objeto
	 * PapelFeito (null caso a validação falhe).
	 * 
	 * @return PapelFeito ou null
	 */
	public PapelFeito obterModelo() {
		String nomePersonagem = view.getFieldNomePersonagem().getText();
		String modeloCache = view.getFieldCache().getText();
		double cache;

		if (nomePersonagem.isEmpty()) {
			view.getFieldNomePersonagem().setText("");
			return null;
		}

		try {
			cache = Double.parseDouble(modeloCache);
		} catch (NumberFormatException e) {
			view.getFieldCache().setText("");
			return null;
		}

		return new PapelFeito(cache, nomePersonagem);
	}

	/**
	 * Recebe um PapelFeito e o cadastra no ator escolhido, depois cadastra o nome
	 * desse ator na lista de atores do filme escolhido.
	 * 
	 * @param modelo PapelFeito para cadastrar
	 */
	public void setarModelo(PapelFeito modelo) {
		int indiceUltimoFilme = view.getController().getEstudioEscolhido().getFilmes().size() - 1;
		Filme filmeEscolhido = view.getController().getEstudioEscolhido().getFilmes().get(indiceUltimoFilme);
		Ator atorEscolhido = view.getController().getAtorEscolhido();

		atorEscolhido.getPapeisFeitos().add(modelo);
		filmeEscolhido.getNomeAtores().add(atorEscolhido.getNomeArtistico());

		view.getController().setAdicionado(true);
	}

}
