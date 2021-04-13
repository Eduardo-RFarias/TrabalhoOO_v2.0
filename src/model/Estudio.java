package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Classe que armazena as informações de um estúdio.
 * 
 * @author Eduardo Rodrigues
 */
public class Estudio {
	private final ArrayList<Filme> filmes;
	private String nome;
	private String dono;
	private Date dataDeFundacao;
	private double faturamentoAnoAnterior;

	/**
	 * Gera um estúdio, filmes recebe uma nova ArrayList em branco.
	 * 
	 * @param nome                   nome do estudip
	 * @param dono                   dono do estudio
	 * @param dataDeFundacao         data da fundacao do estudio
	 * @param faturamentoAnoAnterior faturamento do ano anterior em reais
	 */
	public Estudio(String nome, String dono, Date dataDeFundacao, double faturamentoAnoAnterior) {
		this.nome = nome;
		this.dono = dono;
		this.dataDeFundacao = dataDeFundacao;
		this.faturamentoAnoAnterior = faturamentoAnoAnterior;
		this.filmes = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDono() {
		return dono;
	}

	public void setDono(String dono) {
		this.dono = dono;
	}

	public Date getDataDeFundacao() {
		return dataDeFundacao;
	}

	public void setDataDeFundacao(Date dataDeFundacao) {
		this.dataDeFundacao = dataDeFundacao;
	}

	public double getFaturamentoAnoAnterior() {
		return faturamentoAnoAnterior;
	}

	public void setFaturamentoAnoAnterior(double faturamentoAnoAnterior) {
		this.faturamentoAnoAnterior = faturamentoAnoAnterior;
	}

	public List<Filme> getFilmes() {
		return filmes;
	}
}
