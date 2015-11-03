package br.unisc.numerosMagicos.model.operadores;

import java.io.Serializable;

import br.unisc.numerosMagicos.excecoes.CalculoException;

public abstract class Operador implements Serializable {
	
	public abstract double calcular(int a, int b) throws CalculoException;

	public abstract String toString();
	
	public int fazerOperacao(int a, int b) throws CalculoException {
		double resultado = calcular(a, b);
		
		if(resultado % 1 != 0) {
			throw new CalculoException("N�mero n�o � inteiro");
		}
		
		if(resultado < 0) {
			throw new CalculoException("N�mero n�o � positivo");
		}
		
		return (int) resultado;
	}
	
}