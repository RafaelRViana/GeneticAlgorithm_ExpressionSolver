package br.unisc.numerosMagicos.genetico;

import br.unisc.numerosMagicos.logger.Logger;
import br.unisc.numerosMagicos.utils.NumeroUtils;
import java.util.List;

/**
 * 
 * @author Rafael
 *
 * 1 - 0.005 = 2,79%
 * 2 - 0.005 = 2,79%
 * 3 - 0.030 = 16,76%
 * 4 - 0.030 = 16,76%
 * 5 - 0.001 = 0,56%
 * 6 - 0.045 = 25,14%
 * 7 - 0.050 = 27,93%
 * 8 - 0.001 = 0,56%
 * 9 - 0.002 = 1,12%
 * 10 - 0.010 = 5,59%
 * 
 * Sorteia um n�mero entre 0 e 100.
 * Ex: 5.62
 * 
 * ----------------
 * 
 * Cria um vetor com os fitness cumulativos
 * 
 * [0] = 2.79
 * [1] = 5.58
 * [2] = 22.34
 * [3] = 39,10
 * [4] = 39,66
 * [5] = 64,80
 * [6] = 92,73
 * [7] = 93,29
 * [8] = 94,41
 * [9] = 100
 * 
 * Total = 0,179
 * 
 * -os fitness precisam 
 */
public class Roleta {

        private Integer tamanhoPopulacao;
	private List<Individuo> populacao;
	private double[] fitnessCumulativo;
	
	public Roleta(List<Individuo> populacao) {
                this.tamanhoPopulacao = populacao.size();
		this.populacao = populacao;
		this.fitnessCumulativo = new double[tamanhoPopulacao];
		
                //Faz a montagem do vetor da roleta
		double total = 0.0;
		
		for(int i = 0; i < tamanhoPopulacao; i++) {
			total += populacao.get(i).getFitness();
		}
		
		for(int i = 0; i < tamanhoPopulacao; i++) {
			double percentualRoleta = NumeroUtils.arredondar(populacao.get(i).getFitness() / total, 3.0) * 100;
			if(i == 0) {
				fitnessCumulativo[i] = percentualRoleta;
			} else {
				fitnessCumulativo[i] = fitnessCumulativo[i-1] + percentualRoleta;
			}
		}
	}
	
        /**
         * Retorna um individuo da roleta.
         * @return 
         */
	public Individuo getIndividuo() {
		double numeroAleatorio = NumeroUtils.gerarNumeroAleatorio(100, 3.0); //Sorteia um número entre 0 e
		
		for(int i = 0; i < tamanhoPopulacao; i++) {
			if(fitnessCumulativo[i] > numeroAleatorio) {
				return populacao.get(i);
			}
		}
		
		return populacao.get(tamanhoPopulacao-1); //retorna o último elemento se não retornou nada antes.
	}

        /**
         * Função para escrever a tabela da roleta.
         */
	public void print() {
		for(int i = 0; i < tamanhoPopulacao; i++) {
			Logger.append(String.format("Pop. %d - Resultado: %d | Fitness: %f | Árvore: %s \n", i, populacao.get(i).getResultado(), fitnessCumulativo[i], populacao.get(i).getArvore().inFixado()));
		}
		Logger.novaLinha();
	}
	
}