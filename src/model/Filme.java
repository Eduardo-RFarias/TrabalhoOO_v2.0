package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que armazena as informações de um filme.
 * 
 * @author Eduardo Rodrigues
 */
public class Filme {
	private String nome;
	private int mesesDesenvolvimento;
	private int anoLancamento;
	private int numCopyright;
	private double custoTotal;
	private ArrayList<String> nomeAtores;
	private String diretor;

	/**
	 * Gera um filme, nomeAtores recebe uma nova ArrayList em branco.
	 * 
	 * @param nome                 nome do filme
	 * @param mesesDesenvolvimento numero de meses de desenvolvimento
	 * @param anoLancamento        ano do lancamento
	 * @param numCopyright         numero de copyright do filme
	 * @param custoTotal           custo total de producao
	 * @param diretor              diretor do filme
	 */
	public Filme(String nome, int mesesDesenvolvimento, int anoLancamento, int numCopyright, double custoTotal,
			String diretor) {
		this.nome = nome;
		this.mesesDesenvolvimento = mesesDesenvolvimento;
		this.anoLancamento = anoLancamento;
		this.numCopyright = numCopyright;
		this.custoTotal = custoTotal;
		this.nomeAtores = new ArrayList<>();
		this.diretor = diretor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getMesesDesenvolvimento() {
		return mesesDesenvolvimento;
	}

	public void setMesesDesenvolvimento(int mesesDesenvolvimento) {
		this.mesesDesenvolvimento = mesesDesenvolvimento;
	}

	public int getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public int getNumCopyright() {
		return numCopyright;
	}

	public void setNumCopyright(int numCopyright) {
		this.numCopyright = numCopyright;
	}

	public double getCustoTotal() {
		return custoTotal;
	}

	public void setCustoTotal(double custoTotal) {
		this.custoTotal = custoTotal;
	}

	public List<String> getNomeAtores() {
		return nomeAtores;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}
}
