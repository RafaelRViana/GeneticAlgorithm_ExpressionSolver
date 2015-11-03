package br.unisc.numerosMagicos.model.operadores;

import java.io.Serializable;

import br.unisc.numerosMagicos.excecoes.CalculoException;

public class Divisao extends Operador implements Serializable {

	@Override
	public double calcular(int a, int b) throws CalculoException {
		if(b == 0) {
			throw new CalculoException("Não é possível fazer divisão por zero.");
		}
		
		return a / ((double) b);
	}

	@Override
	public String toString() {
		return "/";
	}

}