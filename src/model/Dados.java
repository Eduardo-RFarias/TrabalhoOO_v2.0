package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que armazena as arrays com os estúdios e atores cadastrados.
 * 
 * @author Eduardo Rodrigues
 */
public abstract class Dados {
	private static final ArrayList<Estudio> estudios = new ArrayList<>();
	private static final ArrayList<Ator> atores = new ArrayList<>();

	/**
	 * Construtor privado para que não seja possível instanciar ou herdar a classe.
	 */
	private Dados() {
	}

	public static List<Estudio> getEstudios() {
		return estudios;
	}

	public static List<Ator> getAtores() {
		return atores;
	}
}
