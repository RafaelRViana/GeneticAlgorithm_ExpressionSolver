/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisc.numerosMagicos.view;

import br.unisc.numerosMagicos.builder.ArvoreAleatoriaSemRepeticaoDeTerminais;
import br.unisc.numerosMagicos.excecoes.CalculoException;
import br.unisc.numerosMagicos.excecoes.DadosInvalidosException;
import br.unisc.numerosMagicos.excecoes.ResultadoEncontradoException;
import br.unisc.numerosMagicos.genetico.Crossover;
import br.unisc.numerosMagicos.genetico.Individuo;
import br.unisc.numerosMagicos.genetico.Roleta;
import br.unisc.numerosMagicos.logger.Logger;
import br.unisc.numerosMagicos.model.Arvore;
import br.unisc.numerosMagicos.model.operadores.Operador;
import br.unisc.numerosMagicos.model.operadores.OperadorFactory;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import javax.swing.*;

/**
 *
 * @author Rafael
 */
public class BackupForcaBruta extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public BackupForcaBruta() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jButton1 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btProximaGeracao = new javax.swing.JButton();
        tfResultado = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtLog = new javax.swing.JTextArea();
        SpinnerModel model1 = new SpinnerNumberModel(1, 1, 9, 1);
        tfNumero1 = new javax.swing.JSpinner(model1);
        SpinnerModel model2 = new SpinnerNumberModel(1, 1, 9, 1);
        tfNumero2 = new javax.swing.JSpinner(model2);
        SpinnerModel model3 = new SpinnerNumberModel(1, 1, 9, 1);
        tfNumero3 = new javax.swing.JSpinner(model3);
        SpinnerModel model4 = new SpinnerNumberModel(1, 1, 9, 1);
        tfNumero4 = new javax.swing.JSpinner(model4);
        SpinnerModel model6 = new SpinnerNumberModel(25, 25, 100, 25);
        tfNumero6 = new javax.swing.JSpinner(model6);
        SpinnerModel model5 = new SpinnerNumberModel(10, 10, 20, 5);
        tfNumero5 = new javax.swing.JSpinner(model5);
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfTaxaMutacao = new javax.swing.JTextField();
        tfPopulacaoInicial = new javax.swing.JTextField();
        tfNumeroDeGeracoes = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btTodasGeracoes = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfMaximoTentativasForcaBruta = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btExecutarForcaBruta = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        btGeracaoAnterior = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Resolvedor de Expressões");
        setResizable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Números utilizados");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Resultado esperado");

        btProximaGeracao.setText("Próxima Geração >");
        btProximaGeracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProximaGeracaoActionPerformed(evt);
            }
        });

        txtLog.setColumns(20);
        txtLog.setRows(5);
        jScrollPane1.setViewportView(txtLog);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Resultados das operações");

        jLabel7.setText("População Inicial");

        jLabel8.setText("Taxa de Mutação");

        tfTaxaMutacao.setText("2.0");

        tfPopulacaoInicial.setText("10");

        tfNumeroDeGeracoes.setText("100");
        tfNumeroDeGeracoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNumeroDeGeracoesActionPerformed(evt);
            }
        });

        jLabel10.setText("iterações");

        btTodasGeracoes.setText("Executar Todas Gerações >>");
        btTodasGeracoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTodasGeracoesActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Algoritmo Genético");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Força Bruta");

        tfMaximoTentativasForcaBruta.setText("100000");

        jLabel11.setText("Número máximo de tentativas");

        btExecutarForcaBruta.setText("Executar Força Bruta >>");
        btExecutarForcaBruta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExecutarForcaBrutaActionPerformed(evt);
            }
        });

        jLabel12.setText("Parada após");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("ou");

        btGeracaoAnterior.setText("< Geração Anterior");
        btGeracaoAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGeracaoAnteriorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfMaximoTentativasForcaBruta, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btExecutarForcaBruta)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator5))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(tfNumeroDeGeracoes, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel10))
                                            .addComponent(tfTaxaMutacao, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tfPopulacaoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel12)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tfNumero1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tfNumero2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tfNumero3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tfNumero4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tfNumero5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tfNumero6, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tfResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btGeracaoAnterior)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btProximaGeracao)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btTodasGeracoes)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNumero1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNumero2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNumero3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNumero4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNumero5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNumero6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(tfMaximoTentativasForcaBruta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btExecutarForcaBruta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfPopulacaoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tfTaxaMutacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(tfNumeroDeGeracoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btProximaGeracao)
                    .addComponent(btGeracaoAnterior)
                    .addComponent(btTodasGeracoes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private List<Integer> numeros;
    private List<Operador> operadores;
    private Integer tamanhoPopulacao;
    private Double taxaMutacao;
    private Integer numeroDeGeracoes;
    private Integer resultadoEsperado;
            
    //Executar próximo geração
    private Crossover crossover = null;
    private Integer geracao = 1;
    private List<Individuo> populacao = null;
    
    private void btProximaGeracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProximaGeracaoActionPerformed
        try {
            validarDados();
        } catch (DadosInvalidosException ex) {
            return;
        }
        
        try {
                validarDados();
                executarProximaGeracao(resultadoEsperado, numeros, operadores, tamanhoPopulacao, taxaMutacao, numeroDeGeracoes);
            } catch (DadosInvalidosException ex) {
                return;
            }
    }//GEN-LAST:event_btProximaGeracaoActionPerformed

    private void validarDados() throws DadosInvalidosException {
        txtLog.setText("");
        
        Integer numero1 = (Integer) tfNumero1.getValue();
        Integer numero2 = (Integer) tfNumero2.getValue();
        Integer numero3 = (Integer) tfNumero3.getValue();
        Integer numero4 = (Integer) tfNumero4.getValue();
        Integer numero5 = (Integer) tfNumero5.getValue();
        Integer numero6 = (Integer) tfNumero6.getValue();
        
        numeros = new ArrayList<>();
        numeros.add(numero1);
        numeros.add(numero2);
        numeros.add(numero3);
        numeros.add(numero4);
        numeros.add(numero5);
        numeros.add(numero6);
        
        operadores = new ArrayList<>();
        operadores.add(OperadorFactory.ADICAO);
        operadores.add(OperadorFactory.SUBTRACAO);
        operadores.add(OperadorFactory.DIVISAO);
        operadores.add(OperadorFactory.MULTIPLICACAO);
        
        tamanhoPopulacao = Integer.parseInt(tfPopulacaoInicial.getText());
        taxaMutacao = Double.parseDouble(tfTaxaMutacao.getText());
        numeroDeGeracoes = Integer.parseInt(tfNumeroDeGeracoes.getText());
        
        if(numero1 == numero2 || numero1 == numero3 || numero1 == numero4) {
            JOptionPane.showMessageDialog(this, "Não pode inserir números de entrada repetidos.");
            throw new DadosInvalidosException();
        } else if(numero2 == numero3 || numero2 == numero4) {
            JOptionPane.showMessageDialog(this, "Não pode inserir números de entrada repetidos.");
            throw new DadosInvalidosException();
        } else if(numero3 == numero4) {
            JOptionPane.showMessageDialog(this, "Não pode inserir números de entrada repetidos.");
            throw new DadosInvalidosException();
        }
        
        try {
            resultadoEsperado = Integer.parseInt(tfResultado.getText());
            if(resultadoEsperado < 100 || resultadoEsperado > 999) {
               JOptionPane.showMessageDialog(this, "Digite um resultado esperado maior ou igual que 100 e menor ou igual que 999."); 
               throw new DadosInvalidosException();
            }
        } catch(NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Digite um número válido como resultado esperado.");
            throw new DadosInvalidosException();
        }
    }
    
    private void tfNumeroDeGeracoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNumeroDeGeracoesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNumeroDeGeracoesActionPerformed

    private void btTodasGeracoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTodasGeracoesActionPerformed
        try {
            validarDados();
        } catch(DadosInvalidosException ex) {
            return;
        }
        executarAlgoritmoGenetico(resultadoEsperado, numeros, operadores, tamanhoPopulacao, taxaMutacao, numeroDeGeracoes);
    }//GEN-LAST:event_btTodasGeracoesActionPerformed

    private void btExecutarForcaBrutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExecutarForcaBrutaActionPerformed
        try {
            validarDados();
            executarAlgoritmoForcaBruta(resultadoEsperado, numeros, operadores);
        } catch (DadosInvalidosException ex) {
            return;
        }
    }//GEN-LAST:event_btExecutarForcaBrutaActionPerformed

    private void btGeracaoAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGeracaoAnteriorActionPerformed
        System.out.println("Voltando... Geração => " + geracao);
        if(geracao > 1) {
            geracao--;
        } else {
            JOptionPane.showMessageDialog(this, "Não existe geração anterior.");
            return;
        }
        
        //txtLog.setText(passos[geracao-1]);
        //txtLog.setCaretPosition(0);
    }//GEN-LAST:event_btGeracaoAnteriorActionPerformed

    private void executarProximaGeracao(Integer resultadoEsperado, List<Integer> numeros, List<Operador> operadores, 
            Integer tamanhoPopulacao, Double taxaMutacao, Integer numeroDeGeracoes) {
        
        if(geracao > numeroDeGeracoes) {
            JOptionPane.showMessageDialog(this, "Já executou todas as gerações.");
            return;
        }
        
        //Inicialização da população
        if(geracao == 1) {
            if(tamanhoPopulacao % 2 == 1) {
                JOptionPane.showMessageDialog(this, "O tamanho da população deve ser um número par");
                return;
            }
            
            //Criação de objeto que vai lidar com os cruzamentos dos individuos
            crossover = new Crossover(resultadoEsperado, taxaMutacao, numeros, operadores);   
            
            //Primeiro passo: Geração da população inicial
            populacao = Arrays.asList(gerarPopulacaoInicial(numeros, operadores, tamanhoPopulacao, resultadoEsperado));
            Collections.sort(populacao);
        }
        
        Logger.append(String.format("Geração %d\n", geracao));
        Logger.append(String.format("Resultado esperado: %d\n", resultadoEsperado));
        Logger.novaLinha();
            
        //Inicio de avaliação da população
        //Segundo passo: Monta a roleta 
        Roleta roleta = new Roleta(populacao);
        roleta.print();
        List<Individuo> novaPopulacao = new ArrayList<>();
				
        //Segundo passo: Fazer o crossover (cortes) nas arvores binarias para produzir novas
        int metadePopulacao = tamanhoPopulacao/2; 
        for(int i = 0; i < metadePopulacao; i++) {
            //Pega dois individuos da roleta
            Individuo pai = roleta.getIndividuo();
            Individuo mae = roleta.getIndividuo();
				
            //Gerar o crossover e aplicar a mutação
            Logger.append("Crossover nº " + (i+1));
            Logger.novaLinha();
            Logger.novaLinha();
            novaPopulacao.addAll(crossover.crossover(pai, mae));
				
            //Limpar variáveis para a coleçao de lixo
            pai = null;
            mae = null;
        }
			
        //A nova população é formada por todos os filhos válidos gerados por esta geração
        //mais os filhos da população antiga
        novaPopulacao.addAll(populacao); //Considero tanto os novos individuos gerados, quanto os já existem
        //Ordenar todos os índividuos por ordem do melhor fitness
        Collections.sort(novaPopulacao);
            
        populacao = null; //Limpar variavel para melhor memória
                        
        //Escolho os dez melhores individuos (não repetidos) para continuar a população
        int contador = 0;
        Iterator<Individuo> iteradorNovaPopulacao = novaPopulacao.iterator();
        populacao = new ArrayList<>();
                        
        while(contador < tamanhoPopulacao && iteradorNovaPopulacao.hasNext()) {
            Individuo individuo = iteradorNovaPopulacao.next();
            if(!populacao.contains(individuo)) {
                populacao.add(individuo);
                contador++;
            }
        }
                        
        //Limpar variáveis para a coleção de lixo
        roleta = null;
	
        //Bufferizar o texto da geração para permitir voltar
        //passos[geracao-1] = Logger.getString();
        
        //Somando a geração
        geracao++;
                
        txtLog.setText(txtLog.getText() + "\n" + Logger.getString());
        txtLog.setCaretPosition(0);
        Logger.empty();
       
    }
    
    //Executar todo o algoritmo
    private void executarAlgoritmoGenetico(Integer resultadoEsperado, List<Integer> numeros, List<Operador> operadores, 
            Integer tamanhoPopulacao, Double taxaMutacao, Integer numeroDeGeracoes) {
        
        if(tamanhoPopulacao % 2 == 1) {
            JOptionPane.showMessageDialog(this, "O tamanho da população deve ser um número par");
            return;
        }
        
        //Criação de objeto que vai lidar com os cruzamentos dos individuos
        crossover = new Crossover(resultadoEsperado, taxaMutacao, numeros, operadores);
        
	//Primeiro passo: Geração da população inicial
	populacao = Arrays.asList(gerarPopulacaoInicial(numeros, operadores, tamanhoPopulacao, resultadoEsperado));
	Collections.sort(populacao);
        
        //Vou avaliar várias gerações
	while(geracao <= numeroDeGeracoes) {
            executarProximaGeracao(resultadoEsperado, numeros, operadores, tamanhoPopulacao, taxaMutacao, numeroDeGeracoes);
        }
    }
    
    private void executarAlgoritmoForcaBruta(Integer resultadoEsperado, List<Integer> numeros, List<Operador> operadores) {
        ArvoreAleatoriaSemRepeticaoDeTerminais builder = new ArvoreAleatoriaSemRepeticaoDeTerminais(numeros, operadores);
	
        int melhorResultado = Integer.MIN_VALUE;
        double melhorFitness = Double.MIN_VALUE;
        Arvore melhorExpressao = null;
        
        Arvore arvore = null;
        int resultado = 0;
	int numeroAlvo = resultadoEsperado;
        int tentativa = 1;
        int numeroMaximoTentativas;
        
        try {
            numeroMaximoTentativas = Integer.parseInt(tfMaximoTentativasForcaBruta.getText());
        } catch(NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Informe um número de tentativas válido.");
            return;
        }
        
	while(tentativa < numeroMaximoTentativas && resultado != numeroAlvo) {
            arvore = builder.construir();
            Logger.append(tentativa + " : " + arvore.inFixado());
            Logger.novaLinha();
            try {
                resultado = arvore.calcularResultado();
                
                Individuo individuo = new Individuo(arvore, numeroAlvo);
                if(individuo.getFitness() > melhorFitness) {
                    melhorResultado = resultado;
                    melhorFitness = individuo.getFitness();
                    melhorExpressao = arvore;
                }
            } catch(CalculoException ex) {
                //nao preciso fazer nada... apenas sei que o número é negativo ou não-inteiro.
            }
            
            tentativa++;
        }
        
        try {
            Logger.append("Resultado Final => " + melhorExpressao.calcularResultado());
        } catch (CalculoException ex) {
            java.util.logging.Logger.getLogger(BackupForcaBruta.class.getName()).log(Level.SEVERE, null, ex);
        }
        Logger.novaLinha();
        Logger.append("Expressão => " + melhorExpressao.inFixado());
        Logger.novaLinha();
        
        txtLog.setText(Logger.getString());
    }
    
    private static Individuo[] gerarPopulacaoInicial(List<Integer> numeros, List<Operador> operadores,
            Integer tamanhoPopulacao, Integer resultadoEsperado) {
        Integer INVALIDO = -1;
        ArvoreAleatoriaSemRepeticaoDeTerminais geradorIndividuo = new ArvoreAleatoriaSemRepeticaoDeTerminais(numeros, operadores);
	Individuo[] populacao = new Individuo[tamanhoPopulacao];
	int populacaoCriada = 0;
        while(populacaoCriada < tamanhoPopulacao) {
            Individuo individuo = new Individuo(geradorIndividuo.construir(), resultadoEsperado);
        
            if(individuo.getResultado() != INVALIDO) {
                populacao[populacaoCriada] = individuo;
                populacaoCriada++;
            }
        }
        
	return populacao;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BackupForcaBruta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BackupForcaBruta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BackupForcaBruta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BackupForcaBruta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new BackupForcaBruta().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btExecutarForcaBruta;
    private javax.swing.JButton btGeracaoAnterior;
    private javax.swing.JButton btProximaGeracao;
    private javax.swing.JButton btTodasGeracoes;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTextField tfMaximoTentativasForcaBruta;
    private javax.swing.JSpinner tfNumero1;
    private javax.swing.JSpinner tfNumero2;
    private javax.swing.JSpinner tfNumero3;
    private javax.swing.JSpinner tfNumero4;
    private javax.swing.JSpinner tfNumero5;
    private javax.swing.JSpinner tfNumero6;
    private javax.swing.JTextField tfNumeroDeGeracoes;
    private javax.swing.JTextField tfPopulacaoInicial;
    private javax.swing.JTextField tfResultado;
    private javax.swing.JTextField tfTaxaMutacao;
    private javax.swing.JTextArea txtLog;
    // End of variables declaration//GEN-END:variables
}
