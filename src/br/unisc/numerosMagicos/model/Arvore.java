package br.unisc.numerosMagicos.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.unisc.numerosMagicos.excecoes.CalculoException;
import br.unisc.numerosMagicos.logger.Logger;
import br.unisc.numerosMagicos.model.operadores.Operador;
import br.unisc.numerosMagicos.model.operadores.OperadorFactory;
import br.unisc.numerosMagicos.utils.NumeroUtils;

public class Arvore implements Serializable {
	
	private Nodo raiz;
	
        private List<Integer> numerosValidos;
        private List<Operador> operadoresValidos;
        
	public Arvore(Nodo raiz, List<Integer> numerosValidos, List<Operador> operadoresValidos) {
		this.raiz = raiz;
                this.numerosValidos = numerosValidos;
                this.operadoresValidos = operadoresValidos;
	}

	public void posFixado() {
		posFixado(raiz);
	}
	
	private void posFixado(Nodo nodo) {
		if ( nodo != null ) {
			posFixado( nodo.getEsquerda() );
	        posFixado( nodo.getDireita() );
	        Logger.append( nodo.toString() );
		}
	}
	
	public void preFixado() {
		preFixado(raiz);
	}
	
	private void preFixado(Nodo nodo) {
		while( nodo != null ) {
			Logger.append( nodo.toString() );
			preFixado(nodo.getEsquerda());
			nodo = nodo.getDireita();
		}
	}
	
	public String inFixado() {
		StringBuilder caminhamento = new StringBuilder();
		inFixado(raiz, caminhamento);
		
		return caminhamento.toString();
	}
	
	private void inFixado(Nodo nodo, StringBuilder caminhamento) {
		if( nodo != null ) {
	         if (!nodo.geteNodoFolha()) {
	        	 caminhamento.append("("); 
	         }
	         
	         inFixado(nodo.getEsquerda(), caminhamento);
	         caminhamento.append( nodo.toString() );
	         inFixado(nodo.getDireita(), caminhamento);
	         
	         if (!nodo.geteNodoFolha()) {
	        	 caminhamento.append(")"); 
	         }
	      }
	}

	public int calcularResultado() throws CalculoException {
		List<Integer> numerosUsados = new ArrayList<>();
		return raiz == null ? 0 : calcularResultado(numerosUsados, raiz);
	}
	
	public int calcularResultado(List<Integer> numerosUsados, Nodo nodo) throws CalculoException {
		if(nodo.geteNodoFolha()) {
			if(numerosUsados.contains(nodo.getValor())) {
				throw new CalculoException("Número já utilizado.");
			}
			
			numerosUsados.add(nodo.getValor());
			return nodo.getValor();
		} else {
			Operador operador = nodo.getOperador();
			
			int esquerda = calcularResultado(numerosUsados, nodo.getEsquerda());
			int direita = calcularResultado(numerosUsados, nodo.getDireita());
			
			return operador.fazerOperacao(esquerda, direita);
		}
	}

	public Nodo getRaiz() {
		return raiz;
	}

	public void aplicarMutacao(double taxaMutacao) {
		aplicarMutacao(raiz, taxaMutacao);
	}
	
	private void aplicarMutacao(Nodo nodo, double taxaMutacao) {
		if( nodo != null ) {
	        aplicarMutacao(nodo.getEsquerda(), taxaMutacao);
	        
	        //Aplicar muta��o
	        double numeroAleatorio = NumeroUtils.gerarNumeroAleatorio(100, 2.0);
		if(numeroAleatorio <= taxaMutacao) {
			if(nodo.geteNodoFolha()) {
				nodo.setValor(NumeroUtils.getNumeroAleatorio(numerosValidos)); //numero aleat�rio
			} else {
				nodo.setOperador(NumeroUtils.getOperadorAleatorio(operadoresValidos)); //operador aleat�rio
			}
		}
	        //Fim muta��o
	        
	        aplicarMutacao(nodo.getDireita(), taxaMutacao);
	   }
	}
	
	public List<Nodo> getPontosDeCorte() {
		List<Nodo> pontosDeCorte = new ArrayList<>();
		getPontosDeCorte(raiz, pontosDeCorte);
	
		return pontosDeCorte;
	}
	
        //Método Pré-fixado
	private void getPontosDeCorte(Nodo nodo, List<Nodo> pontosDeCorte) {
		/*
                if( nodo != null ) {
	        getPontosDeCorte(nodo.getEsquerda(), pontosDeCorte);
	        if(!nodo.geteNodoFolha() && nodo.getPai() != null) { //nem nodo folha, nem a raiz
	        	pontosDeCorte.add(nodo);
	        }
	        getPontosDeCorte(nodo.getDireita(), pontosDeCorte);
           }
                */
                while( nodo != null ) {
			if(!nodo.geteNodoFolha() && nodo.getPai() != null) { //nem nodo folha, nem a raiz
                            pontosDeCorte.add(nodo);
                        }
			getPontosDeCorte(nodo.getEsquerda(), pontosDeCorte);
			nodo = nodo.getDireita();
		}
	}

	private static final int DIREITA = 0;
	private static final int ESQUERDA = 1;
	
	/**
	 * Pegar um nodo folha aleat�rio
	 * Usado para a transforma��o quando a �rvore possui somente um ponto de corte.
	 * 
	 * @return
	 */
	public Nodo getNodoAleatorioArvore() {
		List<Nodo> pontosDeCorte = getPontosDeCorte();
		if(pontosDeCorte.size() > 1) {
			throw new RuntimeException("Este método é para ser usado apenas por árvores com um ponto de corte");
		} else {
			Nodo pontoDeCorte = pontosDeCorte.get(0);
			int ladoFolhaTransformacao = NumeroUtils.getLadoAleatorio();
			if(ladoFolhaTransformacao == DIREITA) {
				return pontoDeCorte.getDireita();
			} else {
				return pontoDeCorte.getEsquerda();
			}
		}
	}

        @Override
        public boolean equals(Object o) {
            if(o instanceof Arvore) {
                return inFixado().equals(((Arvore) o).inFixado());
            }
            
            return false;
        }
	
}