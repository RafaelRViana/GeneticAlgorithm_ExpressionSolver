package br.unisc.numerosMagicos.genetico;

import java.io.Serializable;
import java.util.List;

import br.unisc.numerosMagicos.excecoes.CalculoException;
import br.unisc.numerosMagicos.excecoes.CrossoverException;
import br.unisc.numerosMagicos.model.Arvore;
import br.unisc.numerosMagicos.model.Nodo;
import br.unisc.numerosMagicos.utils.NumeroUtils;

public class Individuo implements Serializable, Comparable<Individuo> {

	private Arvore arvore;
	private double fitness;
        private Integer resultadoEsperado;
        
	public Individuo(Arvore arvore, Integer resultadoEsperado) {
		this.arvore = arvore;
                this.resultadoEsperado = resultadoEsperado;
		this.fitness = calcularFitness();
	}
	
	//Quanto maior o valor, melhor a avaliação.
        //Função de Fitness => 1.000 / |Resultado da expressão - Resultado que está buscando|
	private double calcularFitness() {
		try {
			int resultado = Math.abs(arvore.calcularResultado() - resultadoEsperado); 
			
			return (double) Math.round((1000.0 / resultado) * 1000000) / 1000000;
		} catch (CalculoException e) {
			return 0.15;
		}
	}
	
	public Arvore getArvore() {
		return arvore;
	}
	
	public int getResultado() {
		try {
			return arvore.calcularResultado();
		} catch (CalculoException e) {
			return -1;
		}
	}
	
	public double getFitness() {
		return fitness;
	}

	@Override
	public String toString() {
		return arvore.toString();
	}

    @Override
    public int compareTo(Individuo o) {
        if(fitness > o.getFitness()) {
            return -1;
        } else if(fitness == o.getFitness()) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Individuo) {
            return getArvore().equals(((Individuo) o).getArvore());
        }
        
        return false;
    }
    
}