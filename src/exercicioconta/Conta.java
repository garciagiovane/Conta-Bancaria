/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicioconta;

import javax.swing.JOptionPane;

/**
 * @version 1.0 - 16-03-2019
 * @author Giovane Garcia
 */
public class Conta {
    
    int numConta;
    protected String tipo;
    private String cliente;
    private float saldo;
    private String status;
    
    public Conta(float saldo, String status){
        this.saldo = saldo;
        this.status = status;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    void abrirConta(){
        //verifica se conta é cp ou cc, só aceita um desses dois
        setTipo(JOptionPane.showInputDialog("Qual o tipo de conta? EX: cc (corrente) ou cp (poupança)"));
        
        while (!getTipo().equals("cc") && !getTipo().equals("cp")) {
            setTipo(JOptionPane.showInputDialog("Opção inválida "
                    + "\nQual o tipo de conta? EX: cc (corrente) ou cp (poupança)"));            
        }//fecha while
        
        setCliente(JOptionPane.showInputDialog("Nome do cliente?"));
        numConta = Integer.parseInt(JOptionPane.showInputDialog("Qual número da conta?"));
        
        //muda status da conta para aberta
        setStatus("aberta");
        //se for conta corrente o saldo inicia com 50, se for poupança inicia com 150
        if(this.tipo.equals("cc")){
                setSaldo(50);
            }else {
                setSaldo(150);
            }//fecha if secundário
    }//fecha abrirConta
    
    /**
    * @see Se conta estiver fechada, mostra mensagem direto
    * @see Se conta for aberta com saldo = 0, muda status para fechada
    * @see Se conta aberta e saldo negativo, orienta a fazer depósito
    * @see Se conta aberta e saldo positivo, orienta a fazer saque
    */
    void fecharConta(){
        if(getStatus().equals("aberta")){
            if(getSaldo() != 0){
                if(getSaldo() < 0){
                    JOptionPane.showMessageDialog(null, "Saldo negativo, faça um depósito de R$ " + (getSaldo() * -1), "Resultado", JOptionPane.ERROR_MESSAGE);
                }else {
                    JOptionPane.showMessageDialog(null, "Saldo positivo, faça uma retirada de R$ " + getSaldo());
                }
            } else {
                setStatus("fechada");
                JOptionPane.showMessageDialog(null, "Conta encerrada com sucesso!", "Resultado", JOptionPane.INFORMATION_MESSAGE);
            }//fecha if            
        } else if(!getStatus().equals("aberta") && !getStatus().equals("fechada")) {
            JOptionPane.showMessageDialog(null, "Conta já está fechada!", "Resultado", JOptionPane.INFORMATION_MESSAGE);
        }//fecha if        
    }//fecha fecharConta
    
    void depositar(){
        if(getStatus().equals("aberta")){
            setSaldo(getSaldo() + Float.parseFloat(JOptionPane.showInputDialog("Qual o valor do depósito?")));
        }else if(getStatus().equals("fechada") || !getStatus().equals("aberta")){
            JOptionPane.showMessageDialog(null, "Conta fechada", "resultado", JOptionPane.ERROR_MESSAGE);
        }//fecha if
    }//fecha depositar
    
    void sacar(){
        if(getStatus().equals("aberta")){
            float valorSaque;
            valorSaque = Float.parseFloat(JOptionPane.showInputDialog("Valor do saque?"));
            
            if(valorSaque > getSaldo()){
                JOptionPane.showMessageDialog(null, "Valor maior que o disponível", "Resultado", JOptionPane.ERROR_MESSAGE);
            } else {
                setSaldo(getSaldo() - valorSaque);
            }
        }else if(getStatus().equals("fechada") || !getStatus().equals("aberta")){
            JOptionPane.showMessageDialog(null, "Conta fechada", "resultado", JOptionPane.ERROR_MESSAGE);
        }//fecha if
    }//fecha sacar
    
    void pagarMensalidade(){
        if(getStatus().equals("aberta")){
            if(( getTipo().equals("cc") && getSaldo() >= 12 ) || ( getTipo().equals("cp") && getSaldo() >= 25 )){
                setSaldo(getSaldo() - 12);
                JOptionPane.showMessageDialog(null, "Mensalidade paga com sucesso!", "Resultado", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Saldo Insuficiente!", "Resultado", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Conta fechada", "Resultado", JOptionPane.ERROR_MESSAGE);
        }//fecha if
    }//fecha pagarMensalidade
    
    void mostrarDados(){
        JOptionPane.showMessageDialog(null, "Número conta:  " + numConta + ""
                + "\nNome cliente:  " + getCliente() + ""
                        + "\nTipo conta:    " + getTipo() + ""
                                + "\nSaldo: " + getSaldo() + ""
                                        + "\nStatus:    " + getStatus(), "Resultado", JOptionPane.OK_OPTION);
    }//fecha mostrarDados    
}//fecha class
