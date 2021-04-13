package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que armazena as informações de um ator.
 * 
 * @author Eduardo Rodrigues
 */
public class Ator {
	private String nomeArtistico;
	private int numSeguroSocial;
	private String nacionalidade;
	private int idade;
	private char sexo;
	private String[] papeisPossiveis;
	private ArrayList<PapelFeito> papeisFeitos;

	/**
	 * Gera um ator, papeisFeitos recebe uma nova ArrayList em branco.
	 * 
	 * @param nomeArtistico   nome artistico do ator
	 * @param numSeguroSocial numero do seguro social
	 * @param nacionalidade   nacionalidade (nome do pais de origem)
	 * @param idade           idade do ator
	 * @param sexo            sexo do ator
	 * @param papeisPossiveis papeis que esse ator e indicado
	 */
	public Ator(String nomeArtistico, int numSeguroSocial, String nacionalidade, int idade, char sexo,
			String[] papeisPossiveis) {
		this.nomeArtistico = nomeArtistico;
		this.numSeguroSocial = numSeguroSocial;
		this.nacionalidade = nacionalidade;
		this.idade = idade;
		this.sexo = sexo;
		this.papeisPossiveis = papeisPossiveis;
		this.papeisFeitos = new ArrayList<>();
	}

	public String getNomeArtistico() {
		return nomeArtistico;
	}

	public void setNomeArtistico(String nomeArtistico) {
		this.nomeArtistico = nomeArtistico;
	}

	public int getNumSeguroSocial() {
		return numSeguroSocial;
	}

	public void setNumSeguroSocial(int numSeguroSocial) {
		this.numSeguroSocial = numSeguroSocial;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String[] getPapeisPossiveis() {
		return papeisPossiveis;
	}

	public List<PapelFeito> getPapeisFeitos() {
		return papeisFeitos;
	}
}
