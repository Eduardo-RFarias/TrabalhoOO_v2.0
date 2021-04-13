package model;

/**
 * Classe que armazena as informações de um Papel para um ator em um filme.
 * 
 * @author Eduardo Rodrigues
 */
public class PapelFeito {
	private double cache;
	private String nomePersonagem;

	/**
	 * Gera o papel.
	 * 
	 * @param cache          cache que o ator recebeu no filme
	 * @param nomePersonagem nome do personagem que ele atuou
	 */
	public PapelFeito(double cache, String nomePersonagem) {
		this.cache = cache;
		this.nomePersonagem = nomePersonagem;
	}

	public double getCache() {
		return cache;
	}

	public void setCache(double cache) {
		this.cache = cache;
	}

	public String getNomePersonagem() {
		return nomePersonagem;
	}

	public void setNomePersonagem(String nomePersonagem) {
		this.nomePersonagem = nomePersonagem;
	}
}
