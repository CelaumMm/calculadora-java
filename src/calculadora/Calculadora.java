package calculadora;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Marcelo Vaz de Camargo
 */
public class Calculadora extends JFrame {

    private JMenuBar menuBar = new JMenuBar();

    private JMenu calculadora = new JMenu("Calculadora");
    private JMenuItem sair = new JMenuItem("Sair");

    private JMenu editar = new JMenu("Editar");
    private JMenuItem copiar = new JMenuItem("Copiar");
    private JMenuItem colar = new JMenuItem("Colar");
    private JMenuItem recortar = new JMenuItem("Recortar");

    private JMenu ajuda = new JMenu("Ajuda");
    private JMenuItem exibir_ajuda = new JMenuItem("Exibir Ajuda");
    private JMenuItem sobre = new JMenuItem("Sobre a Calculadora");

    // Organizando o Layout da Calculadora    
    private GridLayout layout = new GridLayout(6, 4, 4, 4);

    // Define a fonte do visor    
    private Font fonte_visor = new Font("Consolas", Font.PLAIN, 24);
    private JPanel geral = new JPanel();
    private JPanel panel_B = new JPanel();
    private JPanel panel = new JPanel();

    private JLabel visor = new JLabel("0");

    private JButton limpar = new JButton("C");
    private JButton B_backspace = new JButton("<=");
    private JButton B1 = new JButton("1");
    private JButton B2 = new JButton("2");
    private JButton B3 = new JButton("3");
    private JButton B4 = new JButton("4");
    private JButton B5 = new JButton("5");
    private JButton B6 = new JButton("6");
    private JButton B7 = new JButton("7");
    private JButton B8 = new JButton("8");
    private JButton B9 = new JButton("9");
    private JButton B0 = new JButton("0");
    private JButton B_igual = new JButton("=");
    private JButton B_virgula = new JButton(".");
    private JButton B_somar = new JButton("+");
    private JButton B_subtrair = new JButton("-");
    private JButton B_multiplicar = new JButton("X");
    private JButton B_dividir = new JButton("/");
    private JButton B_inverso = new JButton("1/x");
    private JButton B_expoente = new JButton("x²");
    private JButton B_log = new JButton("Log");
    private JButton B_raiz = new JButton("Rz");
    private JButton B_seno = new JButton("Sin");
    private JButton B_cosseno = new JButton("Cos");

    public Calculadora() {
        super("Calculador");

        // Exibi uma mensagem quando o usuário deixa o mouse sobre o botão         
        B_log.setToolTipText("Logaritmo na base 10");
        B_raiz.setToolTipText("Raiz");
        B_seno.setToolTipText("Seno em Graus");
        B_cosseno.setToolTipText("Cosseno em Graus");
        limpar.setToolTipText("Limpa o visor");
        B_backspace.setToolTipText("Apaga o último caractere digitado");
        B_inverso.setToolTipText("Inverso");
        B_expoente.setToolTipText("Quadrado");
        B_dividir.setToolTipText("Dividir");
        B_multiplicar.setToolTipText("Multiplicar");
        B_somar.setToolTipText("Somar");
        B_subtrair.setToolTipText("Subtrair");
        B_igual.setToolTipText("Igual");

        // Adicionando eventos com o teclado        
        B1.setMnemonic(KeyEvent.VK_NUMPAD1);
        B2.setMnemonic(KeyEvent.VK_NUMPAD2);
        B3.setMnemonic(KeyEvent.VK_NUMPAD3);
        B4.setMnemonic(KeyEvent.VK_NUMPAD4);
        B5.setMnemonic(KeyEvent.VK_NUMPAD5);
        B6.setMnemonic(KeyEvent.VK_NUMPAD6);
        B7.setMnemonic(KeyEvent.VK_NUMPAD7);
        B8.setMnemonic(KeyEvent.VK_NUMPAD8);
        B9.setMnemonic(KeyEvent.VK_NUMPAD9);
        B0.setMnemonic(KeyEvent.VK_NUMPAD0);

        B_somar.setMnemonic(KeyEvent.VK_ADD);
        B_subtrair.setMnemonic(KeyEvent.VK_SUBTRACT);
        B_multiplicar.setMnemonic(KeyEvent.VK_MULTIPLY);
        B_dividir.setMnemonic(KeyEvent.VK_DIVIDE);
        B_igual.setMnemonic(KeyEvent.VK_ENTER);
        B_backspace.setMnemonic(KeyEvent.VK_BACK_SPACE);
        limpar.setMnemonic(KeyEvent.VK_DELETE);
        B_log.setMnemonic(KeyEvent.VK_L);

        // Adiciona os elementos a janela        
        calculadora.add(sair);

        editar.add(copiar);
        editar.add(colar);
        editar.add(recortar);

        ajuda.add(exibir_ajuda);
        ajuda.addSeparator();
        ajuda.add(sobre);

        menuBar.add(calculadora);
        menuBar.add(editar);
        menuBar.add(ajuda);

        // Adicionando a barra de menu no JFrame        
        this.setJMenuBar(menuBar);

        panel.add(B_log);
        panel.add(B_raiz);
        panel.add(B_seno);
        panel.add(B_cosseno);

        panel.add(limpar);
        panel.add(B_backspace);
        panel.add(B_inverso);
        panel.add(B_expoente);

        panel.add(B7);
        panel.add(B8);
        panel.add(B9);
        panel.add(B_dividir);

        panel.add(B4);
        panel.add(B5);
        panel.add(B6);
        panel.add(B_multiplicar);

        panel.add(B1);
        panel.add(B2);
        panel.add(B3);
        panel.add(B_subtrair);

        panel.add(B0);
        panel.add(B_virgula);
        panel.add(B_igual);
        panel.add(B_somar);

        panel.setLayout(layout);
        visor.setFont(fonte_visor);
        // Faz com que o texto seja exibido a direita        
        visor.setHorizontalAlignment(SwingConstants.RIGHT);
        // Colocando título em um JPanel        
        visor.setBorder(BorderFactory.createTitledBorder(""));
        panel_B.add(panel);

        // Definindo o tamanho padrão do visor da calculadora       
        visor.setPreferredSize(new Dimension(230, 80));

        geral.add(visor);
        geral.add(panel_B);
        add(geral);

        ButtonHandler Handler = new ButtonHandler();
        
        B1.addActionListener(Handler);
        B2.addActionListener(Handler);
        B3.addActionListener(Handler);
        B4.addActionListener(Handler);
        B5.addActionListener(Handler);
        B6.addActionListener(Handler);
        B7.addActionListener(Handler);
        B8.addActionListener(Handler);
        B9.addActionListener(Handler);
        B0.addActionListener(Handler);

        limpar.addActionListener(Handler);
        B_backspace.addActionListener(Handler);
        B_somar.addActionListener(Handler);
        B_subtrair.addActionListener(Handler);
        B_multiplicar.addActionListener(Handler);
        B_dividir.addActionListener(Handler);
        B_igual.addActionListener(Handler);
        B_inverso.addActionListener(Handler);
        B_expoente.addActionListener(Handler);
        B_virgula.addActionListener(Handler);

        B_log.addActionListener(Handler);
        B_raiz.addActionListener(Handler);
        B_seno.addActionListener(Handler);
        B_cosseno.addActionListener(Handler);

        sobre.addActionListener(Handler);
        exibir_ajuda.addActionListener(Handler);
        sair.addActionListener(Handler);
        copiar.addActionListener(Handler);
        colar.addActionListener(Handler);
        recortar.addActionListener(Handler);
    }

    private class ButtonHandler implements ActionListener {

        String exibir = "0";
        String copy = "";
        double num1, num2, resultado;
        char operacao = 'n';
        int achou, zerar;

        /**
         * Fecha o programa quando chamado
         *
         * @param event
         */
        public void sair(ActionEvent event) {
            if (event.getSource() == sair) {
                System.exit(0);
            }
        }

        /**
         * Obtêm o valor atual da tela que está no formato String
         *
         * @param event
         */
        public void copiar(ActionEvent event) {
            if (event.getSource() == copiar) {
                copy = visor.getText();

                Clipboard board = Toolkit.getDefaultToolkit().getSystemClipboard();
                ClipboardOwner Selecao = new StringSelection(exibir);
                board.setContents((Transferable) Selecao, Selecao);
            }
        }

        /**
         * Colar o valor copiado na tela
         *
         * @param event
         */
        public void colar(ActionEvent event) {
            if (event.getSource() == colar) {
                exibir = copy;
            }
        }

        /**
         * Recorta o valor atual da tela que está no formato String
         *
         * @param event
         */
        public void recortar(ActionEvent event) {
            if (event.getSource() == recortar) {
                copy = visor.getText();

                Clipboard board = Toolkit.getDefaultToolkit().getSystemClipboard();
                ClipboardOwner Selecao = new StringSelection(exibir);
                board.setContents((Transferable) Selecao, Selecao);

                exibir = "0";
            }
        }

        /**
         * Chama uma nova janela que mostra informações sobre o projeto
         *
         * @param event
         */
        public void sobre(ActionEvent event) {
            if (event.getSource() == sobre) {
                new Sobre((int) getLocation().getX(), (int) getLocation().getY(),
                        Calculadora.this, true).setVisible(true);
            }
        }

        /**
         * Chama uma nova janela que mostra ajuda
         *
         * @param event
         */
        public void exibirAjuda(ActionEvent event) {
            if (event.getSource() == exibir_ajuda) {
                JOptionPane.showMessageDialog(Calculadora.this,
                        "Esta calculadora permite a realização de cálculos\n"
                        + "simples, como fazer as 4 operações básicas, obter\n"
                        + "Raiz, Seno, Cosseno, Logaritmo, Inverso, Quadrado\n"
                        + "de um número.", "Ajuda", JOptionPane.PLAIN_MESSAGE);
            }
        }

        /**
         * Operação matemática de logaritimo
         *
         * @param event
         */
        public void botaoLog(ActionEvent event) {
            if (event.getSource() == B_log) {
                exibir = String.valueOf(Math.log10(Double.parseDouble(exibir)));
                zerar = 1;
            }
        }

        /**
         * Operação matemática de raiz quadrada
         *
         * @param event
         */
        public void botaoRaiz(ActionEvent event) {
            if (event.getSource() == B_raiz) {
                exibir = String.valueOf(Math.sqrt(Double.parseDouble(exibir)));
                zerar = 1;
            }
        }

        /**
         * Operação matemática de sena
         *
         * @param event
         */
        public void botaoSeno(ActionEvent event) {
            if (event.getSource() == B_seno) {
                exibir = String.valueOf(Math.sin(Math.toRadians(Double.parseDouble(exibir))));
                zerar = 1;
            }
        }

        /**
         * Operação matemática de cosseno
         *
         * @param event
         */
        public void botaoCosseno(ActionEvent event) {
            if (event.getSource() == B_cosseno) {
                exibir = String.valueOf(Math.cos(Math.toRadians(Double.parseDouble(exibir))));
                zerar = 1;
            }
        }

        /**
         * Adiciona número 0 na tela
         *
         * @param event
         */
        public void botao0(ActionEvent event) {
            if (event.getSource() == B0) {
                if (zerar == 1) {
                    exibir = "";
                }

                if (!exibir.equals("0")) {
                    exibir = exibir + "0";
                } else {
                    zerar = 1;
                }
                zerar = 0;
            }
        }

        /**
         * Adiciona número 1 na tela
         *
         * @param event
         */
        public void botao1(ActionEvent event) {
            if (event.getSource() == B1) {
                // Efetua a ação de enviar o valor para o visor                 
                if (zerar == 1) {
                    exibir = "";
                }
                if (exibir.equals("0")) {
                    exibir = "";
                }
                exibir = exibir + "1";
                zerar = 0;
            }
        }

        /**
         * Adiciona número 2 na tela
         *
         * @param event
         */
        public void botao2(ActionEvent event) {
            if (event.getSource() == B2) {
                if (zerar == 1) {
                    exibir = "";
                }
                if (exibir.equals("0")) {
                    exibir = "";
                }
                exibir = exibir + "2";
                zerar = 0;
            }
        }

        /**
         * Adiciona número 3 na tela
         *
         * @param event
         */
        public void botao3(ActionEvent event) {
            if (event.getSource() == B3) {
                if (zerar == 1) {
                    exibir = "";
                }
                if (exibir.equals("0")) {
                    exibir = "";
                }
                exibir = exibir + "3";
                zerar = 0;
            }
        }

        /**
         * Adiciona número 4 na tela
         *
         * @param event
         */
        public void botao4(ActionEvent event) {
            if (event.getSource() == B4) {
                if (zerar == 1) {
                    exibir = "";
                }
                if (exibir.equals("0")) {
                    exibir = "";
                }
                exibir = exibir + "4";
                zerar = 0;
            }
        }

        /**
         * Adiciona número 5 na tela
         *
         * @param event
         */
        public void botao5(ActionEvent event) {
            if (event.getSource() == B5) {
                if (zerar == 1) {
                    exibir = "";
                }
                if (exibir.equals("0")) {
                    exibir = "";
                }
                exibir = exibir + "5";
                zerar = 0;
            }
        }

        /**
         * Adiciona número 6 na tela
         *
         * @param event
         */
        public void botao6(ActionEvent event) {
            if (event.getSource() == B6) {
                if (zerar == 1) {
                    exibir = "";
                }
                if (exibir.equals("0")) {
                    exibir = "";
                }
                exibir = exibir + "6";
                zerar = 0;
            }
        }

        /**
         * Adiciona número 7 na tela
         *
         * @param event
         */
        public void botao7(ActionEvent event) {
            if (event.getSource() == B7) {
                if (zerar == 1) {
                    exibir = "";
                }
                if (exibir.equals("0")) {
                    exibir = "";
                }
                exibir = exibir + "7";
                zerar = 0;
            }
        }

        /**
         * Adiciona número 8 na tela
         *
         * @param event
         */
        public void botao8(ActionEvent event) {
            if (event.getSource() == B8) {
                if (zerar == 1) {
                    exibir = "";
                }
                if (exibir.equals("0")) {
                    exibir = "";
                }
                exibir = exibir + "8";
                zerar = 0;
            }
        }

        /**
         * Adiciona número 9 na tela
         *
         * @param event
         */
        public void botao9(ActionEvent event) {
            if (event.getSource() == B9) {
                if (zerar == 1) {
                    exibir = "";
                }
                if (exibir.equals("0")) {
                    exibir = "";
                }
                exibir = exibir + "9";
                zerar = 0;
            }
        }

        /**
         * Adiciona virgula na tela
         *
         * @param event
         */
        public void botaoVirgula(ActionEvent event) {
            if (event.getSource() == B_virgula) {
                achou = 0;
                if (zerar == 1) {
                    exibir = "";
                }

                for (int i = 0; i < exibir.length(); ++i) {
                    if (exibir.charAt(i) == '.') {
                        achou = 1;
                    }
                }

                if (exibir.equals("")) {
                    exibir = exibir + "0.";
                } else if (achou == 0) {
                    exibir = exibir + ".";
                }

                zerar = 0;
            }
        }

        /**
         * Limpar a calculadora
         *
         * @param event
         */
        public void botaoLimpar(ActionEvent event) {
            if (event.getSource() == limpar) {
                exibir = "0";
                zerar = 1;
            }
        }

        /**
         * Apagar ultimo caractere da tela
         *
         * @param event
         */
        public void botaoBackspace(ActionEvent event) {
            if (event.getSource() == B_backspace) {
                if (exibir.length() > 1) {
                    exibir = exibir.substring(0, exibir.length() - 1);
                } else {
                    exibir = "0";
                    zerar = 1;
                }
            }
        }

        /**
         * Operação matemática que divido 1 por x
         *
         * @param event
         */
        public void botaoInverso(ActionEvent event) {
            if (event.getSource() == B_inverso) {
                exibir = String.valueOf(1 / Double.parseDouble(exibir));
                zerar = 1;
            }
        }

        /**
         * Operação matemática de expoente ao quadrado
         *
         * @param event
         */
        public void botaoExpoente(ActionEvent event) {
            if (event.getSource() == B_expoente) {
                exibir = String.valueOf(Math.pow(Double.parseDouble(exibir), 2));
                zerar = 1;
            }
        }

        /**
         * Operação matemática de somar
         *
         * @param event
         */
        public void botaoSomar(ActionEvent event) {
            if (event.getSource() == B_somar) {
                num1 = Double.parseDouble(visor.getText());
                operacao = '+';
                zerar = 1;
            }
        }

        /**
         * Operação matemática de subtrair
         *
         * @param event
         */
        public void botaoSubtrair(ActionEvent event) {
            if (event.getSource() == B_subtrair) {
                num1 = Double.parseDouble(visor.getText());
                operacao = '-';
                zerar = 1;
            }
        }

        /**
         * Operação matemática de multiplicar
         *
         * @param event
         */
        public void botaoMultiplicar(ActionEvent event) {
            if (event.getSource() == B_multiplicar) {
                num1 = Double.parseDouble(visor.getText());
                operacao = '*';
                zerar = 1;
            }
        }

        /**
         * Operação matemática de dividir
         *
         * @param event
         */
        public void botaoDividir(ActionEvent event) {
            if (event.getSource() == B_dividir) {
                num1 = Double.parseDouble(visor.getText());
                operacao = '/';
                zerar = 1;
            }
        }

        public void botaoIgual(ActionEvent event) {
            if (event.getSource() == B_igual) {                
                num2 = Double.parseDouble(visor.getText());

                switch (operacao) {
                    case '+':
                        resultado = num1 + num2;
                        break;

                    case '-':
                        resultado = num1 - num2;
                        break;

                    case '*':
                        resultado = num1 * num2;
                        break;

                    case '/':
                        resultado = num1 / num2;
                        break;
                }

                exibir = String.valueOf(resultado);
                zerar = 1;
            }
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            this.sair(event);

            this.copiar(event);
            this.colar(event);
            this.recortar(event);

            this.sobre(event);
            this.exibirAjuda(event);

            this.botaoLog(event);
            this.botaoRaiz(event);
            this.botaoSeno(event);
            this.botaoCosseno(event);

            this.botao0(event);
            this.botao1(event);
            this.botao2(event);
            this.botao3(event);
            this.botao4(event);
            this.botao5(event);
            this.botao6(event);
            this.botao7(event);
            this.botao8(event);
            this.botao9(event);

            this.botaoVirgula(event);
            this.botaoLimpar(event);
            this.botaoBackspace(event);

            this.botaoInverso(event);
            this.botaoExpoente(event);

            this.botaoSomar(event);
            this.botaoSubtrair(event);
            this.botaoMultiplicar(event);
            this.botaoDividir(event);

            this.botaoIgual(event);

            visor.setText("" + exibir);
        }
    }

}
