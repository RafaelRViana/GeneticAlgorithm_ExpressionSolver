package br.unisc.numerosMagicos.genetico;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.SerializationUtils;

import br.unisc.numerosMagicos.builder.ArvoreAleatoriaSemRepeticaoDeTerminais;
import br.unisc.numerosMagicos.excecoes.CalculoException;
import br.unisc.numerosMagicos.logger.Logger;
import br.unisc.numerosMagicos.model.Arvore;
import br.unisc.numerosMagicos.model.LadoPai;
import br.unisc.numerosMagicos.model.Nodo;
import br.unisc.numerosMagicos.model.operadores.Operador;
import br.unisc.numerosMagicos.model.operadores.OperadorFactory;
import br.unisc.numerosMagicos.utils.NumeroUtils;

public class Crossover {

        private Integer resultadoEsperado;
        private Double taxaDeMutacao;
        
        private List<Integer> numeros;
        private List<Operador> operadores;
        private ArvoreAleatoriaSemRepeticaoDeTerminais geradorIndividuo;
        
        public Crossover(Integer resultadoEsperado, Double taxaDeMutacao, List<Integer> numeros, List<Operador> operadores) {
            this.resultadoEsperado = resultadoEsperado;
            this.taxaDeMutacao = taxaDeMutacao;
            
            this.numeros = numeros;
            this.operadores = operadores;
            this.geradorIndividuo = new ArvoreAleatoriaSemRepeticaoDeTerminais(numeros, operadores);
        }   
        
	public List<Individuo> crossover(Individuo individuo1, Individuo individuo2) {
                ///teste
                /* 
                 * Exemplo de crossover com 4 números
                Nodo raiz = new Nodo(null, null, OperadorFactory.ADICAO);
		raiz.setEsquerda(new Nodo(raiz, LadoPai.ESQUERDA, 1));
		
		Nodo n11 = new Nodo(raiz, LadoPai.DIREITA, OperadorFactory.SUBTRACAO);
		n11.setEsquerda(new Nodo(n11, LadoPai.ESQUERDA, 2));
		
		Nodo n12 = new Nodo(n11, LadoPai.DIREITA, OperadorFactory.ADICAO);
		n12.setEsquerda(new Nodo(n12, LadoPai.ESQUERDA, 3));
		n12.setDireita(new Nodo(n12, LadoPai.DIREITA, 4));
		
		n11.setDireita(n12);
		raiz.setDireita(n11);
		Arvore arvore1 = new Arvore(raiz, numeros, operadores);
		//arvore1.adicionarPontoDeCorte(n11);
		//arvore1.adicionarPontoDeCorte(n12);
		
		Nodo raiz2 = new Nodo(null, null, OperadorFactory.ADICAO);
		
		Nodo n21 = new Nodo(raiz2, LadoPai.ESQUERDA, OperadorFactory.SUBTRACAO);
		n21.setEsquerda(new Nodo(n21, LadoPai.ESQUERDA, 1));
		n21.setDireita(new Nodo(n21, LadoPai.DIREITA, 2));
		
		Nodo n22 = new Nodo(raiz2, LadoPai.DIREITA, OperadorFactory.SUBTRACAO);
		n22.setEsquerda(new Nodo(n22, LadoPai.ESQUERDA, 3));
		n22.setDireita(new Nodo(n22, LadoPai.DIREITA, 4));
		
		raiz2.setEsquerda(n21);
		raiz2.setDireita(n22);
		Arvore arvore2 = new Arvore(raiz2, numeros, operadores);
		//arvore2.adicionarPontoDeCorte(n21);
		//arvore2.adicionarPontoDeCorte(n22);
	
		individuo1 = new Individuo(arvore1, resultadoEsperado);
		individuo2 = new Individuo(arvore2, resultadoEsperado);
                */
                ///teste
            
                Arvore filho1 = new Arvore(SerializationUtils.clone(individuo1.getArvore().getRaiz()), numeros, operadores);
		Arvore filho2 = new Arvore(SerializationUtils.clone(individuo2.getArvore().getRaiz()), numeros, operadores);
		
		///Mostrar informações sobre os filhos selecionados para o crossover
		Logger.append("Filho 1 => ");
		Logger.append(filho1.inFixado());
		Logger.novaLinha();
		Logger.append("Filho 2 => ");
		Logger.append(filho2.inFixado());
		Logger.novaLinha();
                Logger.novaLinha();
		//Fim Logger
		
		List<Nodo> pontosDeCorteArvore1 = filho1.getPontosDeCorte();
		List<Nodo> pontosDeCorteArvore2 = filho2.getPontosDeCorte();
                
                List<Individuo> novasArvores = new ArrayList<>();
		
                //Faço o crossover em todos os pontos possíveis da árvore.
                //Como estava gerando muitos pontos inválidos, gero todos e depois só armazeno os melhores.
                //Máximo de 16 tentativas.
                for(int pontoDeCorteArvore1 = 0; pontoDeCorteArvore1 < pontosDeCorteArvore1.size(); pontoDeCorteArvore1++) {
                    for(int pontoDeCorteArvore2 = 0; pontoDeCorteArvore2 < pontosDeCorteArvore2.size(); pontoDeCorteArvore2++) {
                        filho1 = new Arvore(SerializationUtils.clone(individuo1.getArvore().getRaiz()), numeros, operadores);
                        filho2 = new Arvore(SerializationUtils.clone(individuo2.getArvore().getRaiz()), numeros, operadores);
                        
                        pontosDeCorteArvore1 = filho1.getPontosDeCorte();
                        pontosDeCorteArvore2 = filho2.getPontosDeCorte();
                
                        Logger.append("Ponto de Corte Filho 1 => " + pontoDeCorteArvore1);
                        Logger.novaLinha();
                        Logger.append("Ponto de Corte Filho 2 => " + pontoDeCorteArvore2);
                        Logger.novaLinha();

                        Nodo pontoDeCorte1 = pontosDeCorteArvore1.get(pontoDeCorteArvore1);
                        Nodo pontoDeCorte2 = pontosDeCorteArvore2.get(pontoDeCorteArvore2);

                        //Crossover 1
                        Nodo paiDoPontoDeCorte1 = pontoDeCorte1.getPai();
                        if(pontoDeCorte1.getLadoPai().equals(LadoPai.ESQUERDA)) {
                                paiDoPontoDeCorte1.setEsquerda(pontoDeCorte2);
                        } else {
                                paiDoPontoDeCorte1.setDireita(pontoDeCorte2);
                        }

                        //Crossover 2
                        Nodo paiDoPontoDeCorte2 = pontoDeCorte2.getPai();
                        if(pontoDeCorte2.getLadoPai().equals(LadoPai.ESQUERDA)) {
                                paiDoPontoDeCorte2.setEsquerda(pontoDeCorte1);
                        } else {
                                paiDoPontoDeCorte2.setDireita(pontoDeCorte1);
                        }

                        //Mostrar informações sobre os filhos após o crossover
                        Logger.append("Filho 1 (apos crossover) => ");
                        Logger.append(filho1.inFixado());
                        try {
                            int resultado1 = filho1.calcularResultado();
                            Logger.append(String.format(" = %d (válido)", resultado1));
                        } catch(CalculoException ex) {
                            Logger.append(" (inválido)");
                        }
                        Logger.novaLinha();
                        Logger.append("Filho 2 (apos crossover) => ");
                        Logger.append(filho2.inFixado());
                        try {
                            int resultado2 = filho2.calcularResultado();
                            Logger.append(String.format(" = %d (válido)", resultado2));
                        } catch(CalculoException ex) {
                            Logger.append(" (inválido)");
                        }
                        Logger.novaLinha();
                        //fim teste

                        filho1.aplicarMutacao(taxaDeMutacao);
                        filho2.aplicarMutacao(taxaDeMutacao);

                        //Mostrar informações sobre os filhos após o crossover
                        Logger.append("Filho 1 (após mutação) => ");
                        Logger.append(filho1.inFixado());
                        try {
                            int resultado1 = filho1.calcularResultado();
                            Logger.append(String.format(" = %d (válido)", resultado1));
                        } catch(CalculoException ex) {
                            Logger.append(" (inválido)");
                        }
                        Logger.novaLinha();
                        Logger.append("Filho 2 (após mutação) => ");
                        Logger.append(filho2.inFixado());
                        try {
                            int resultado2 = filho2.calcularResultado();
                            Logger.append(String.format(" = %d (válido)", resultado2));
                        } catch(CalculoException ex) {
                            Logger.append(" (inválido)");
                        }
                        Logger.novaLinha();
                        //Fim Logger

                        Logger.novaLinha();
                        try {
                            if(filho1.calcularResultado() != -1) {
                                novasArvores.add(new Individuo(filho1, resultadoEsperado));
                            }
                        } catch (CalculoException ex) {
                            //não faz nada... apenas não insere como individuo válido.
                        }
                        
                        try {
                            if(filho2.calcularResultado() != -1) {
                                novasArvores.add(new Individuo(filho2, resultadoEsperado));
                            }
                        } catch (CalculoException ex) {
                            //não faz nada... apenas não insere como individuo válido.
                        }
                    }
                }
                
		return novasArvores;
	}
	
	private static final int DIREITA = 0;
	private static final int ESQUERDA = 1;
	
	//Uma forma de muta��o
	public Arvore transformacaoArvoreComApenasUmPontoDeCorte(Arvore arvore) {
		//1. Escolher nodo aleat�rio
		Nodo nodoAntigo = arvore.getNodoAleatorioArvore();
		
		//2. Criar novo nodo para estender a �rvore
		Nodo novoNodo = new Nodo(nodoAntigo.getPai(), nodoAntigo.getLadoPai(), NumeroUtils.getOperadorAleatorio(operadores));
		if(nodoAntigo.getLadoPai() == LadoPai.DIREITA) {
			nodoAntigo.getPai().setDireita(novoNodo);
		} else {
			nodoAntigo.getPai().setEsquerda(novoNodo);
		}
		
		int ladoInsercao = NumeroUtils.getLadoAleatorio();
		Nodo insercaoNodoAntigo = SerializationUtils.clone(nodoAntigo);
		insercaoNodoAntigo.setPai(novoNodo);
		
		if(ladoInsercao == DIREITA) {
			insercaoNodoAntigo.setLadoPai(LadoPai.DIREITA);
			novoNodo.setDireita(insercaoNodoAntigo);
			novoNodo.setEsquerda(new Nodo(novoNodo, LadoPai.ESQUERDA, NumeroUtils.getNumeroAleatorio(numeros)));
		} else {
			insercaoNodoAntigo.setLadoPai(LadoPai.ESQUERDA);
			novoNodo.setEsquerda(insercaoNodoAntigo);
			novoNodo.setDireita(new Nodo(novoNodo,LadoPai.DIREITA, NumeroUtils.getNumeroAleatorio(numeros)));
		}
		
		return arvore;
	}
	
}