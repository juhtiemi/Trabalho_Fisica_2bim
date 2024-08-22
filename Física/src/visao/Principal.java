package visao;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import controle.CalculadoraControle;

public class Principal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JTextField txtCalcCampoEletrico;
	private JTextField raioTextField;
	private JTextField cargaTextField;
	private JTextPane resultPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Principal() {
		
		setSize(new Dimension(900, 675));
		setResizable(false);
		setTitle("Sistema de blocos - Trabalho de física");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtCalcCampoEletrico = new JTextField();
		txtCalcCampoEletrico.setEditable(false);
		txtCalcCampoEletrico.setHorizontalAlignment(SwingConstants.CENTER);
		txtCalcCampoEletrico.setForeground(Color.BLACK);
		txtCalcCampoEletrico.setBackground(Color.WHITE);
		txtCalcCampoEletrico.setFont(new Font("Leelawadee UI", Font.BOLD, 30));
		txtCalcCampoEletrico.setText("Calculadora de Campo Elétrico");
		txtCalcCampoEletrico.setBounds(193, 10, 500, 67);
		contentPane.add(txtCalcCampoEletrico);
		txtCalcCampoEletrico.setColumns(10);
		
		JLabel raioLabel = new JLabel("Raio:");
		raioLabel.setFont(new Font("Leelawadee UI", Font.PLAIN, 20));
		raioLabel.setBounds(44, 223, 68, 51);
		contentPane.add(raioLabel);
		
		raioTextField = new JTextField();
		raioTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		raioTextField.setHorizontalAlignment(SwingConstants.CENTER);
		raioTextField.setText("0.0");
		raioTextField.setBounds(122, 229, 173, 45);
		contentPane.add(raioTextField);
		raioTextField.setColumns(10);
		
		cargaTextField = new JTextField();
		cargaTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cargaTextField.setHorizontalAlignment(SwingConstants.CENTER);
		cargaTextField.setText("0.0");
		cargaTextField.setColumns(10);
		cargaTextField.setBounds(409, 229, 173, 45);
		contentPane.add(cargaTextField);
		
		JLabel cargaLabel = new JLabel("Carga:");
		cargaLabel.setFont(new Font("Leelawadee UI", Font.PLAIN, 20));
		cargaLabel.setBounds(331, 223, 68, 51);
		contentPane.add(cargaLabel);
		
		JButton calcularButton = new JButton("Calcular");
		calcularButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		calcularButton.setBounds(661, 186, 173, 53);
		calcularButton.addActionListener(new CalculadoraControle(this));
		contentPane.add(calcularButton);
		
		JButton limparButton = new JButton("Limpar");
		limparButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		limparButton.setBounds(661, 249, 173, 53);
		limparButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		contentPane.add(limparButton);
		
		resultPane = new JTextPane();
		resultPane.setBorder(new EmptyBorder(8, 8, 8, 8));
		resultPane.setFont(new Font("Tahoma", Font.PLAIN, 20));
		resultPane.setText("Resultado:");
		resultPane.setBackground(Color.LIGHT_GRAY);
		resultPane.setForeground(Color.BLACK);
		resultPane.setBounds(10, 333, 866, 270);
		contentPane.add(resultPane);
		
		JTextArea txtrEstaUma = new JTextArea();
		txtrEstaUma.setFont(new Font("Leelawadee UI", Font.PLAIN, 20));
		txtrEstaUma.setLineWrap(true);
		txtrEstaUma.setText("Esta é uma calculadora específica para a obtenção do valor de um campo elétrico em diferentes regiões de uma esfera metálica de espessura insignificante, para calcular, preencha as informações da esfera:");
		txtrEstaUma.setBounds(34, 107, 822, 106);
		contentPane.add(txtrEstaUma);
	}
	
	private void limpar() {
		raioTextField.setText("0.0");
		cargaTextField.setText("0.0");
		resultPane.setText("Result:");
	}
	
	public void calcular() {
	    try {
	        double raio = Double.parseDouble(raioTextField.getText());
	        double carga = Double.parseDouble(cargaTextField.getText());

	        // Campo elétrico dentro da esfera (idealmente 0)
	        int eInterior = 0;
	        double eSuperficie;
	        double e3metros;

	        // E = Kq/r^2
	        eSuperficie = ((8.99 * Math.pow(10, 9)) * carga) / Math.pow(raio, 2);
	        e3metros = ((8.99 * Math.pow(10, 9)) * carga) / Math.pow(3, 2);

	        String resultado = String.format(
	            "Campo elétrico no interior da esfera: %d N/C\n" +
	            "Campo elétrico junto à superfície da esfera: %.3e N/C\n" +
	            "Campo elétrico a 3 metros do centro: %.3e N/C",
	            eInterior, eSuperficie, e3metros
	        );

	        resultPane.setText(resultado);
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(this, "Por favor, insira valores numéricos válidos.", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
	    }
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
