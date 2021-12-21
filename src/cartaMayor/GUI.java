package cartaMayor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is used for ...
 *
 * @version v.1.0.3 date:21/11/2021
 * @autor Jhon Alexander Valencia Hilamo jhon.hilamo@correounivalle.edu.co and
 * @autor Janiert Sebastian Salas Castillo janiert.salas@correounivalle.edu.co
 */
public class GUI extends JFrame {

    public static final String MENSAJE_INICIO = "Bienvenidos al juego de la Carta Mayor \n" +
            "Oprime el botón lanzar para iniciar el juego" +
            "\nSi tu carta es mayor que la de la maquina Ganaras!!" +
            "\nSi tu Carta es menor que la de la maquina Perderas!!" +
            "\nSi tu carta es igual que la de la maquina, el ganador se decidirá por el mayor valor del palo" +
            "\nOros es mayor que Copas, Copas es mayor que Espadas y Espadas es mayor que Bastos";
    private Header headerProject;
    private JLabel cartaJ, cartaM;
    private JButton lanzar, ayuda, salir;
    private JPanel panelCartaJ, panelCartaM;
    private ImageIcon imageCarta;
    private JTextArea mensajeSalida, resultadosDados;
    private Escucha escucha;
    private Model model;

    /**
     * Constructor of GUI class
     */
    public GUI() {
        initGUI();

        //Default JFrame configuration
        this.setTitle("Carta Mayor");
        this.setUndecorated(true);
        this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    private void initGUI() {
        //Set up JFrame Container's Layout
        this.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        //Create Listener Object and Control Object
        escucha = new Escucha();
        model = new Model();
        //Set up JComponents
        headerProject = new Header("Juego Carta Mayor", Color.BLACK);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;

        this.add(headerProject, constraints);

        ayuda = new JButton(" ? ");
        ayuda.addActionListener(escucha);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_START;

        this.add(ayuda, constraints);

        salir = new JButton(" X ");
        salir.addActionListener(escucha);
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_END;

        this.add(salir, constraints);

        imageCarta= new ImageIcon(getClass().getResource("/resources/0.png"));
        cartaJ= new JLabel(imageCarta);
        cartaM= new JLabel(imageCarta);

        panelCartaJ = new JPanel();
        panelCartaJ.setPreferredSize(new Dimension(300, 180));
        panelCartaJ.setBorder(BorderFactory.createTitledBorder("Tu Carta "));
        panelCartaJ.add(cartaJ);
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;
        add(panelCartaJ, constraints);

        panelCartaM = new JPanel();
        panelCartaM.setPreferredSize(new Dimension(300, 180));
        panelCartaM.setBorder(BorderFactory.createTitledBorder("Carta maquina "));
        panelCartaM.add(cartaM);
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;
        add(panelCartaM, constraints);

        lanzar = new JButton("Sacar carta");
        lanzar.addActionListener(escucha);
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        add(lanzar, constraints);

        mensajeSalida = new JTextArea(4, 31);
        mensajeSalida.setText("Usa el boton (?) para ver las reglas del juego");
        mensajeSalida.setEditable(false);
        mensajeSalida.setBackground(null);
        mensajeSalida.setBorder(BorderFactory.createTitledBorder("Mensajes"));
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        add(mensajeSalida, constraints);
    }

    /**
     * Main process of the Java program
     *
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            GUI miProjectGUI = new GUI();
        });
    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Escucha implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            /**
             *
             */
            if (e.getSource() == lanzar) {
                model.calcularResultado();
                int[] cartas = model.getCartas();
                imageCarta = new ImageIcon(getClass().getResource("/resources/" + cartas[0] + cartas[1] + ".png"));
                cartaJ.setIcon(imageCarta);
                imageCarta = new ImageIcon(getClass().getResource("/resources/" + cartas[2] + cartas[3] + ".png"));
                cartaM.setIcon(imageCarta);
                mensajeSalida.setText(model.getEstadoToString());
            } else {
                if (e.getSource() == ayuda) {
                    JOptionPane.showMessageDialog(null, MENSAJE_INICIO);
                } else {
                    System.exit(0);
                }
            }

        }

    }
}