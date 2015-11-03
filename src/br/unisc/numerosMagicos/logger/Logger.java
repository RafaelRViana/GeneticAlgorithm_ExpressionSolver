package br.unisc.numerosMagicos.logger;

public class Logger {

	private static StringBuilder logger = new StringBuilder();

	public static void append(String s) {
		logger.append(s);
	}
	
	public static void novaLinha() {
		logger.append("\n");
	}
	
	public static String getString() {
		return logger.toString();
	}
	
	public void print() {
		System.out.println(logger.toString());
	}

	public static void empty() {
		logger = new StringBuilder();
	}
	
}