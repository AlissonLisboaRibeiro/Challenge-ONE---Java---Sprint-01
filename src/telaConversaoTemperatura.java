import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.BoxLayout;
import javax.swing.JDesktopPane;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Label;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class telaConversaoTemperatura extends JFrame {

	private JPanel contentPane;
	private boolean eNumero;
	private Double valorParaConverter = 0.00;
	private Double valorConvertido = 0.00;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telaConversaoTemperatura frame = new telaConversaoTemperatura();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	private boolean checaValorDigitado() {

		if (!eNumero) {
			String valor = JOptionPane.showInputDialog(null, "Informe um valor abaixo:", 0);
			eNumero = true;
			try {
				valorParaConverter = Double.parseDouble(valor);
			} catch (java.lang.NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Caracteres inválidos, corrija e tente novamente!",
						"Erro ao converter", JOptionPane.ERROR_MESSAGE);
				eNumero = false;
				return false;
			} catch (java.lang.NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Caracteres inválidos, corrija e tente novamente!",
						"Erro ao converter", JOptionPane.ERROR_MESSAGE);
				eNumero = false;
				return false;
			} finally {
				// Ação a ser realizada mesmo dando erro na conversão do valor
			}
		}
		return false;
	}

	private double ConverteCelsius(double tempC, char unidadeDestino) {
		double valorConvertido = 0;
		
		switch (unidadeDestino) {
		case 'K': // Celsius para Kelvin
		{
			valorConvertido = tempC + 273.15;
			break;
		}
		case 'F': // Celsius para Fahreinheit
		{
			valorConvertido = ((9.0/5.0) * tempC) + 32.0;
			break;
		}
		}
		return valorConvertido; // A finalizar a função
	}

	private double ConverteKelvin(double tempK, char unidadeDestino) {
		double valorConvertido = 0;
		switch (unidadeDestino) {
		case 'C': // Kelvin para Celsius
		{
			valorConvertido = tempK - 273.15;
			break;
		}
		case 'F': // Kelvin para Fahreinheit
		{
			valorConvertido = ((tempK - 273.15) * (9.0/5.0)) + 32.0;
			break;
		}
		}
		return valorConvertido; // A finalizar a função
	}

	private double ConverteFahrenheit(double tempF, char unidadeDestino) {
		double valorConvertido = 0;
		switch (unidadeDestino) {
		case 'C': // Fahrenheit para Celsius
		{
			valorConvertido = (tempF - 32.0)*(5.0/9.0);
			break;
		}
		case 'K': // Kelvin para Fahreinheit
		{
			valorConvertido = (tempF - 32)*(5.0/9.0) + 273.15;
			break;
		}
		}
		return valorConvertido; // A finalizar a função
	}

	private double Converte(JComboBox cbOrigem, JComboBox cbDestino) {
		Double valorConvertido = 0.00;

		char origem = cbOrigem.getItemAt(cbOrigem.getSelectedIndex()).toString().charAt(1);
		char destino = cbDestino.getItemAt(cbDestino.getSelectedIndex()).toString().charAt(1);
		if (origem == 'C') {
			if (destino == 'C') {
				
				valorConvertido = this.valorParaConverter;
			}
			if (destino == 'K') {
				valorConvertido = ConverteCelsius(this.valorParaConverter, 'K');
			}
			if (destino == 'F') {
				valorConvertido = ConverteCelsius(this.valorParaConverter, 'F');
			}
		}
		if (origem == 'K') {
			if (destino == 'C') {
				valorConvertido = ConverteKelvin(this.valorParaConverter, 'C');
			}
			if (destino == 'K') {
				valorConvertido = this.valorParaConverter;
			}
			if (destino == 'F') {
				valorConvertido = ConverteKelvin(this.valorParaConverter, 'F');
			}
		}
		if (origem == 'F') {
			if (destino == 'C') {
				valorConvertido = ConverteFahrenheit(this.valorParaConverter, 'C');
			}
			if (destino == 'K') {
				valorConvertido = ConverteFahrenheit(this.valorParaConverter, 'K');
			}
			if (destino == 'F') {
				valorConvertido = this.valorParaConverter;
			}
		}

		return valorConvertido;
	}

	public telaConversaoTemperatura() {

		setFont(new Font("Verdana", Font.PLAIN, 12));
		setTitle("Alura Java Challenge - 1 - Conversor de Temperatura");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 289);
		this.setLocationRelativeTo(null); // Centraliza a janela na tela
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));

		JPanel panel = new JPanel();
		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 30, 180, 55, 180, 30 };
		gbl_panel.rowHeights = new int[] { 22, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0 };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		panel.setLayout(gbl_panel);

		Label label = new Label("De: ");
		label.setFont(new Font("Verdana", Font.BOLD, 12));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.NORTHWEST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 1;
		panel.add(label, gbc_label);

		Label label_1 = new Label("Para:");
		label_1.setFont(new Font("Verdana", Font.BOLD, 12));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 3;
		gbc_label_1.gridy = 1;
		panel.add(label_1, gbc_label_1);

		JComboBox cbOrigem = new JComboBox();
		cbOrigem.setFont(new Font("Verdana", Font.PLAIN, 12));
		cbOrigem.setModel(new DefaultComboBoxModel(new String[] { "°C - Celsius", "°K - Kelvin", "°F - Fahrenheit" }));
		GridBagConstraints gbc_cbOrigem = new GridBagConstraints();
		gbc_cbOrigem.anchor = GridBagConstraints.WEST;
		gbc_cbOrigem.insets = new Insets(0, 0, 5, 5);
		gbc_cbOrigem.gridx = 1;
		gbc_cbOrigem.gridy = 2;
		panel.add(cbOrigem, gbc_cbOrigem);

		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea = new GridBagConstraints();
		gbc_rigidArea.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea.gridx = 2;
		gbc_rigidArea.gridy = 2;
		panel.add(rigidArea, gbc_rigidArea);

		JComboBox cbDestino = new JComboBox();
		cbDestino.setFont(new Font("Verdana", Font.PLAIN, 12));
		cbDestino.setModel(new DefaultComboBoxModel(new String[] { "°C - Celsius", "°K - Kelvin", "°F - Fahrenheit" }));
		GridBagConstraints gbc_cbDestino = new GridBagConstraints();
		gbc_cbDestino.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbDestino.insets = new Insets(0, 0, 5, 5);
		gbc_cbDestino.gridx = 3;
		gbc_cbDestino.gridy = 2;
		panel.add(cbDestino, gbc_cbDestino);

		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_1 = new GridBagConstraints();
		gbc_rigidArea_1.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea_1.gridx = 2;
		gbc_rigidArea_1.gridy = 3;
		panel.add(rigidArea_1, gbc_rigidArea_1);

		JButton btnConverter = new JButton(":: Converter ::");
		btnConverter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (eNumero) {

					String unidade = cbDestino.getItemAt(cbDestino.getSelectedIndex()).toString().substring(0, 2);
					//Mensagem com a chamada da função de conversão
					JOptionPane.showMessageDialog(null, "Você terá " + String.format("%.2f", Converte(cbOrigem, cbDestino)) + unidade,
							"Conversão finalizada", JOptionPane.INFORMATION_MESSAGE);

					int opcao = JOptionPane.showConfirmDialog(null, "Deseja continuar?");

					switch (opcao) {
					case 0: // Sim
					{
						telaEscolhaConversor.main(null);
						setVisible(false);
						break;
					}
					case 1: // Não
					{
						JOptionPane.showMessageDialog(null, "Programa finalizado!");
						System.exit(0);
						break;
					}
					case 2: // Cancelar
						JOptionPane.showMessageDialog(null, "Programa concluído!");
						eNumero = false;
						checaValorDigitado();
						break;
					}

				} else {
					eNumero = false;
					checaValorDigitado();

				}
			}
		});
		btnConverter.setFont(new Font("Verdana", Font.PLAIN, 12));
		GridBagConstraints gbc_btnConverter = new GridBagConstraints();
		gbc_btnConverter.gridwidth = 3;
		gbc_btnConverter.insets = new Insets(0, 0, 5, 5);
		gbc_btnConverter.gridx = 1;
		gbc_btnConverter.gridy = 4;
		panel.add(btnConverter, gbc_btnConverter);

		Component rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_3 = new GridBagConstraints();
		gbc_rigidArea_3.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea_3.gridx = 2;
		gbc_rigidArea_3.gridy = 5;
		panel.add(rigidArea_3, gbc_rigidArea_3);

		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_2 = new GridBagConstraints();
		gbc_rigidArea_2.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea_2.gridx = 2;
		gbc_rigidArea_2.gridy = 6;
		panel.add(rigidArea_2, gbc_rigidArea_2);

		JButton btnNewButton = new JButton(":: Sair ::");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaEscolhaConversor.main(null); // Carrega novamente a tela de escolha do conversor
				setVisible(false); // Esconde essa tela
			}
		});

		Component rigidArea_4 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_4 = new GridBagConstraints();
		gbc_rigidArea_4.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea_4.gridx = 2;
		gbc_rigidArea_4.gridy = 7;
		panel.add(rigidArea_4, gbc_rigidArea_4);
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 12));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 8;
		panel.add(btnNewButton, gbc_btnNewButton);

		// Chama a função para inserir valor a ser convertido
		//checaValorDigitado();

	}
}
