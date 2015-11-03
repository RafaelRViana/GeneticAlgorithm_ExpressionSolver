package br.unisc.numerosMagicos.model.operadores;

public class OperadorFactory {

	public static final Operador ADICAO = new Adicao();
	public static final Operador SUBTRACAO = new Subtracao();
	public static final Operador MULTIPLICACAO = new Multiplicacao();
	public static final Operador DIVISAO = new Divisao();
	
}