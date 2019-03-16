/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicioconta;

import javax.swing.JOptionPane;

/**
 *
 * @author alu201819089
 */
public class ExercicioConta {
    /**
     * @return inteiro que significa a opção para o menu switch
     */    
    public int menu(){
        int op;
        //recebe a opção que o usuário selecionou e manda para o switch
        op = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção desejada"
                + "\n1 - Abrir conta"
                + "\n2 - Fechar conta"
                + "\n3 - Depositar"
                + "\n4 - Sacar"
                + "\n5 - Pagar mensalidade"
                + "\n0 - Sair"));
        
        return op;
    }//fecha menu
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here        
        Conta c = new Conta(0, "Fechada");
        ExercicioConta exer = new ExercicioConta();
        int op;
        
        do {
            op = exer.menu();
                        
            switch(op){
                case 1:
                    c.abrirConta();
                break;             
                case 2:
                    c.fecharConta();
                break;
                case 3:
                    c.depositar();
                break;
                case 4:
                    c.sacar();
                break;
                case 5:
                    c.pagarMensalidade();
                break;
                case 0:
                    System.exit(0);
                break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida, tente novamente", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                    op = exer.menu();
            }//fecha switch            
        } while (op != 0);//fecha while
        
        
        //c.mostrarDados();
        
        
    }//fecha main    
}//fecha class
