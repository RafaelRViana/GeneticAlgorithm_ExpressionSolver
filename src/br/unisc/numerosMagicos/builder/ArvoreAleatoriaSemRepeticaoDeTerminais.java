package br.unisc.numerosMagicos.builder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.unisc.numerosMagicos.model.Arvore;
import br.unisc.numerosMagicos.model.LadoPai;
import br.unisc.numerosMagicos.model.Nodo;
import br.unisc.numerosMagicos.model.operadores.Operador;

public class ArvoreAleatoriaSemRepeticaoDeTerminais {

	private static final int DIREITA = 0;
	private static final int ESQUERDA = 1;
	
	private List<Integer> terminais;
	private List<Operador> naoTerminais;
	
	private List<Nodo> listaAberta = new ArrayList<>();
	private Arvore arvore;
	
	private int quantidadeDeNumeros;
	private int quantidadeDePontosDeCorte;
	private int pontosDeCorteInseridos;
	private int posicaoListaNumeros;
        
        public ArvoreAleatoriaSemRepeticaoDeTerminais(List<Integer> numeros, List<Operador> operadores) {
            this.terminais = numeros;
            this.naoTerminais = operadores;
        }
	
	public Arvore construir() {
		//1. Misturar n�meros de terminais
		Collections.shuffle(terminais);
	
		//2. Calcular vari�veis base
		quantidadeDeNumeros = terminais.size();
		quantidadeDePontosDeCorte = quantidadeDeNumeros -2;
		pontosDeCorteInseridos = 0; /* um ponto de corte inserido � a cria��o de um nodo com operador que n�o seja a ra�z */
		posicaoListaNumeros = 0;
		
		//2. Criar ra�z com operador aleat�rio
		Nodo raiz = new Nodo(null, null, getOperadorRandomico(naoTerminais));
		arvore = new Arvore(raiz, terminais, naoTerminais);
		listaAberta.add(raiz);
		
		//3. 
		//Quando � obrigat�rio inserir n�mero e quando � obrigat�rio inserir operador?
		while(!listaAberta.isEmpty()) {
			Nodo nodo = getNodoAleatorio();
			
			//Escolher lado esquerda ou direita aleat�rio, se ambos estiverem vazios
			if(nodo.getDireita() == null && nodo.getEsquerda() == null) {
				int lado = getLadoAleatorio();
				
				if(lado == ESQUERDA) {
					insercaoDoLadoEsquerdo(nodo);
				} else {
					insercaoDoLadoDireito(nodo);
				}
			} else if(nodo.getEsquerda() == null) {
				insercaoDoLadoEsquerdo(nodo);
				listaAberta.remove(nodo);
			} else {
				insercaoDoLadoDireito(nodo);
				listaAberta.remove(nodo);
			}
		}
		
		return arvore;
	}

	private void insercaoDoLadoDireito(Nodo nodo) {
		if(pontosDeCorteInseridos < quantidadeDePontosDeCorte) {
			boolean inserirOperador;
			
			if(listaAberta.size() == 1 && nodo.getEsquerda() != null) {
				inserirOperador = true;
			} else {
				inserirOperador = getBooleanAleatorio();
			}
			
			if(inserirOperador) {
				Nodo temporario = new Nodo(nodo, LadoPai.DIREITA, getOperadorRandomico(naoTerminais));
				nodo.setDireita(temporario);
				listaAberta.add(temporario);
				pontosDeCorteInseridos++;
			} else {
				Nodo temporario = new Nodo(nodo, LadoPai.DIREITA, terminais.get(posicaoListaNumeros));
				nodo.setDireita(temporario);
				posicaoListaNumeros++;
			}
		} else {
			//J� fiz todos os pontos de corte, agora s� posso incluir operador
			Nodo temporario = new Nodo(nodo, LadoPai.DIREITA, terminais.get(posicaoListaNumeros));
			nodo.setDireita(temporario);
			posicaoListaNumeros++;
		}
	}

	private void insercaoDoLadoEsquerdo(Nodo nodo) {
		if(pontosDeCorteInseridos < quantidadeDePontosDeCorte) {
			boolean inserirOperador;
			
			if(listaAberta.size() == 1 && nodo.getDireita() != null) {
				inserirOperador = true;
			} else {
				inserirOperador = getBooleanAleatorio();
			}
			
			if(inserirOperador) {
				Nodo temporario = new Nodo(nodo, LadoPai.ESQUERDA, getOperadorRandomico(naoTerminais));
				nodo.setEsquerda(temporario);
				listaAberta.add(temporario);
				pontosDeCorteInseridos++;
			} else {
				Nodo temporario = new Nodo(nodo, LadoPai.ESQUERDA, terminais.get(posicaoListaNumeros));
				nodo.setEsquerda(temporario);
				posicaoListaNumeros++;
			}
		} else {
			//J� fiz todos os pontos de corte, agora s� posso incluir operador
			Nodo temporario = new Nodo(nodo, LadoPai.ESQUERDA, terminais.get(posicaoListaNumeros));
			nodo.setEsquerda(temporario);
			posicaoListaNumeros++;
		}
	}
	
	private int getLadoAleatorio() {
		return (int) Math.round(Math.random() * 1);	
	}
	
	private boolean getBooleanAleatorio() {
		return Math.round(Math.random() * 1) == 1 ? true : false;
	}
	
	private Operador getOperadorRandomico(List<Operador> naoTerminais) {
		int indiceRandomico = (int) (Math.random() * naoTerminais.size());
		return naoTerminais.get(indiceRandomico);
	}
	
	private Nodo getNodoAleatorio() {
		int indiceRandomico = (int) (Math.random() * listaAberta.size());
		return listaAberta.get(indiceRandomico);
	}
	
}