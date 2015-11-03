package br.unisc.numerosMagicos.utils;

import br.unisc.numerosMagicos.model.operadores.Operador;
import java.util.List;

public class NumeroUtils {

	public static double arredondar(double valor, double precisao) {
            return (double) Math.round(valor * Math.pow(10.0, precisao)) / Math.pow(10.0, precisao);
	}
	
	public static double gerarNumeroAleatorio(int valorMaximo, double precisao) {
            return (double) Math.round((Math.random() * valorMaximo) * Math.pow(10.0, precisao)) / Math.pow(10.0, precisao);
	}
        
        public static Integer getNumeroAleatorio(List<Integer> numeros) {
            int indiceRandomico = (int) (Math.random() * numeros.size());
            return numeros.get(indiceRandomico);
        }
	
        public static Operador getOperadorAleatorio(List<Operador> operadores) {
            int indiceRandomico = (int) (Math.random() * operadores.size());
            return operadores.get(indiceRandomico);
        }
        
        public static int getLadoAleatorio() {
            return (int) Math.round(Math.random() * 1);	
	}
}