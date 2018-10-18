package calculadora;

import javax.swing.JFrame;

/**
 *
 * @author Marcelo Vaz de Camargo
 */
public class Main {

    public static void main(String[] args) {

        Calculadora calculadora = new Calculadora();
        
        calculadora.setSize(255, 330); // Define o tamanho da tela        
        calculadora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha a janela        
        calculadora.setVisible(true); // Torna a janela visível        
        calculadora.setResizable(false); // Desabilita o maximizar        
        calculadora.setLocationRelativeTo(null); // Abre a janela no meio da tela
    }
}
