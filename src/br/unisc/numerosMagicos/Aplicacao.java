/*
package br.unisc.numerosMagicos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.SerializationUtils;

import br.unisc.numerosMagicos.builder.ArvoreAleatoriaSemRepeticaoDeTerminais;
import br.unisc.numerosMagicos.excecoes.CalculoException;
import br.unisc.numerosMagicos.excecoes.ResultadoEncontradoException;
import br.unisc.numerosMagicos.genetico.Crossover;
import br.unisc.numerosMagicos.genetico.Individuo;
import br.unisc.numerosMagicos.genetico.Roleta;
import br.unisc.numerosMagicos.logger.Logger;
import br.unisc.numerosMagicos.model.Arvore;
import br.unisc.numerosMagicos.model.operadores.Operador;
import br.unisc.numerosMagicos.model.operadores.OperadorFactory;

//Fazer: passar tudo para o logger do string
//Fazer 2: converter o c�digo para a interface do netbeans
public class Aplicacao {
	
	//public static final int TAMANHO_POPULACAO_INICIAL = 10; //Sempre um valor par
	//public static final int MAXIMO_GERACOES = 100;
	//public static final double TAXA_MUTACAO = 2.0;
	//public static final int resultadoEsperado = 569; //Alterar para receber da interface
	
	//public static final ArvoreAleatoriaSemRepeticaoDeTerminais geradorIndividuo = new ArvoreAleatoriaSemRepeticaoDeTerminais();
	//public static final List<Integer> numeros = Arrays.asList(1, 5, 7, 9, 15, 25); //FIXME Depois ser�o escolhidos aleatoriamente
	//public static final List<Operador> operadores = Arrays.asList(OperadorFactory.ADICAO, OperadorFactory.SUBTRACAO, OperadorFactory.MULTIPLICACAO, OperadorFactory.DIVISAO);
	
	public static void main(String[] args) {
		int melhorResultado = Integer.MIN_VALUE;
		double fitnessMelhorResultado = Double.MIN_VALUE;
		Arvore melhorExpressao = null;
		
		//Primeiro passo: Gera��o da popula��o inicial
		Individuo[] populacao = gerarPopulacaoInicial(numeros, operadores);
		
		//Segundo passo: Avalia��o da popula��o
		Crossover crossover = new Crossover();
		int geracao = 1;
		
		try {
			while(geracao <= MAXIMO_GERACOES) {
				Logger.append(String.format("Gera��o %d\n", geracao));
				
				//Inicio de gera��o
				Roleta roleta = new Roleta(populacao);
				roleta.print();
				Individuo[] novaPopulacao = new Individuo[TAMANHO_POPULACAO_INICIAL];
				
				//Segundo passo: Fazer o crossover (cortes) nas �rvores bin�rias para produzir novas
				int metadePopulacao = TAMANHO_POPULACAO_INICIAL/2; 
				for(int i = 0; i < metadePopulacao; i++) {
					Individuo pai = roleta.getIndividuo();
					Individuo mae = roleta.getIndividuo();
					
					List<Individuo> novosIndividuos = crossover.crossover(pai, mae);
					
					//temporario
					try {
						int resultado1 = novosIndividuos.get(0).getArvore().calcularResultado();
						if(resultado1 == resultadoEsperado) {
							Logger.append(novosIndividuos.get(0).getArvore().inFixado());
							throw new ResultadoEncontradoException();
						}
						if(novosIndividuos.get(0).getFitness() > fitnessMelhorResultado) {
							melhorResultado = resultado1;
							fitnessMelhorResultado = novosIndividuos.get(0).getFitness();
							melhorExpressao = novosIndividuos.get(0).getArvore();
						}
					} catch(CalculoException ex) {
						
					}
					
					try {
						int resultado2 = novosIndividuos.get(1).getArvore().calcularResultado();
						if(resultado2 == resultadoEsperado) {
							Logger.append(novosIndividuos.get(1).getArvore().inFixado());
							throw new ResultadoEncontradoException();
						}
						if(novosIndividuos.get(1).getFitness() > fitnessMelhorResultado) {
							melhorResultado = resultado2;
							fitnessMelhorResultado = novosIndividuos.get(1).getFitness();
							melhorExpressao = novosIndividuos.get(1).getArvore();
						}
					} catch(CalculoException ex) {
						
					}
					//temporario
					
					novaPopulacao[i] = novosIndividuos.get(0);
					novaPopulacao[i+metadePopulacao] = novosIndividuos.get(1); 
					
					//Limpar vari�veis para a cole��o de lixo
					pai = null;
					mae = null;
					novosIndividuos = null;
				}
				
				//Limpar vari�veis para a cole��o de lixo
				populacao = null;
				roleta = null;
				
				//Atribuindo nova populacao para a variavel de popula��o atual
				populacao = novaPopulacao;
				//Somando a gera��o
				geracao++;
			}
		} catch(ResultadoEncontradoException e) {
			System.out.println("Resultado encontrado.");
		}
		
		Logger.append("Melhor resultado => " + melhorResultado);
		Logger.novaLinha();
		Logger.append("Express�o => ");
		Logger.append(melhorExpressao.inFixado());
		
		//Escrever resultado em arquivo de texto
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter(new File("C:/resultado-arvore.txt")));
			writer.append(Logger.getString());
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static Individuo[] gerarPopulacaoInicial(List<Integer> numeros, List<Operador> operadores) {
		Individuo[] populacao = new Individuo[TAMANHO_POPULACAO_INICIAL];
		for(int i = 0; i < Aplicacao.TAMANHO_POPULACAO_INICIAL; i++) {
			populacao[i] = new Individuo(geradorIndividuo.construir(numeros, operadores));
		}
		return populacao;
	}
	
	public static Operador getOperadorAleatorio() {
		int indiceRandomico = (int) (Math.random() * operadores.size());
		return operadores.get(indiceRandomico);
	}
	
	public static Integer getNumeroAleatorio() {
		int indiceRandomico = (int) (Math.random() * numeros.size());
		return numeros.get(indiceRandomico);
	}
	
	public static int getLadoAleatorio() {
		return (int) Math.round(Math.random() * 1);	
	}
}
*/