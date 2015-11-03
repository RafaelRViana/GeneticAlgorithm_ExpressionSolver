package br.unisc.numerosMagicos.model.operadores;

import java.io.Serializable;

public class Subtracao extends Operador implements Serializable {

	@Override
	public double calcular(int a, int b) {
		return a - b;
	}

	@Override
	public String toString() {
		return "-";
	}

}