package calculadora;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Marcelo Vaz de Camargo
 */
public class Sobre extends JDialog {

    private Font fonte = new Font("Tahoma", Font.PLAIN, 14);

    private JPanel geral = new JPanel();

    private JPanel panel = new JPanel();
    private GridLayout layout = new GridLayout(4, 1);
    private JLabel nome = new JLabel("Marcelo Vaz de Camargo");
    private JLabel faculdade = new JLabel("Faculdade Estácio de Cotia");
    private JLabel curso = new JLabel("Análise e Desenvolvimento de Sistemas");
    private JLabel disciplina = new JLabel("Programação 2 - 4° semestre");

    private int X;
    private int Y;

    public Sobre(int X, int Y, Frame parent, boolean modal) {
        super(parent, modal);

        this.X = X;
        this.Y = Y;

        // Adiciona os elementos ao Dialog        
        nome.setFont(fonte);
        faculdade.setFont(fonte);
        curso.setFont(fonte);
        disciplina.setFont(fonte);

        panel.setLayout(layout);

        panel.add(nome);
        panel.add(faculdade);
        panel.add(curso);
        panel.add(disciplina);

        panel.setPreferredSize(new Dimension(280, 140));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createTitledBorder(null, "Autor",
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION, new Font("Tahoma", 1, 14)));

        geral.add(panel);

        geral.setFont(fonte);
        add(geral);

        geral.setBackground(Color.WHITE);

        this.setTitle("Sobre a calculadora");
        this.setSize(300, 180);
        this.setResizable(false);
        this.setLocation(X + 20, Y + 40);
    }
}
