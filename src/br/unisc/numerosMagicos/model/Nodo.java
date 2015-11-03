package br.unisc.numerosMagicos.model;

import br.unisc.numerosMagicos.model.LadoPai;
import java.io.Serializable;

import br.unisc.numerosMagicos.model.operadores.Operador;

public class Nodo implements Serializable {

	private Boolean eNodoFolha;
	private Operador operador;
	private Integer valor;
	private Nodo pai = null;
	private LadoPai ladoPai = null;
	private Nodo esquerda = null;
	private Nodo direita = null;
	
	public Nodo(Nodo pai, LadoPai ladoPai, Operador operador) {
		this.pai = pai;
		this.ladoPai = ladoPai;
		this.eNodoFolha = false;
		this.operador = operador;
	}
	
	public Nodo(Nodo pai, LadoPai ladoPai, Integer valor) {
		this.pai = pai;
		this.ladoPai = ladoPai;
		this.eNodoFolha = true;
		this.valor = valor;
	}
	
	public Boolean geteNodoFolha() {
		return eNodoFolha;
	}
	public void seteNodoFolha(Boolean eNodoFolha) {
		this.eNodoFolha = eNodoFolha;
	}
	public Operador getOperador() {
		return operador;
	}
	public void setOperador(Operador operador) {
		this.operador = operador;
	}
	public Integer getValor() {
		return valor;
	}
	public void setValor(Integer valor) {
		this.valor = valor;
	}
	public Nodo getEsquerda() {
		return esquerda;
	}
	public void setEsquerda(Nodo esquerda) {
		this.esquerda = esquerda;
	}
	public Nodo getDireita() {
		return direita;
	}
	public void setDireita(Nodo direita) {
		this.direita = direita;
	}

	public Nodo getPai() {
		return pai;
	}

	public void setPai(Nodo pai) {
		this.pai = pai;
	}
	
	public LadoPai getLadoPai() {
		return ladoPai;
	}

	public void setLadoPai(LadoPai ladoPai) {
		this.ladoPai = ladoPai;
	}

	@Override
	public String toString() {
		return eNodoFolha ? Integer.toString(valor) : operador.toString();
	}
	
}