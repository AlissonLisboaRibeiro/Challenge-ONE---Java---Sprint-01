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

public class telaConversaoMoeda extends JFrame {

	private JPanel contentPane;
	private boolean eNumero;
	private Double valorParaConverter;
	private List<Double> valoresConversao = new ArrayList<Double>();

	// Valores fixados da tabela de conversão do dia 21/09/2022
	// https://www.bcb.gov.br/conversao
	// US$ - Dólar Americano ==> 1,00
	// € - Euro ===============> 0,9878
	// £ - Libra esterlina ====> 1,1328
	// ¥ - Iene ===============> 0,0069367
	// $ - Dólar Australiano ==> 0,666
	// Fr - Franco Suíço ======> 1,0358401
	// $ - Dólar Canadense ====> 0,7462687
	// 元 - Renminbi (Yuan) ===> 0,141842
	// $ - Peso Argentino =====> 0,0069018
	// ₺ - Lira Turca =========> 0,0545509
	// R$ - Real Brasileiro ===> 0,1934535
	// $ - Peso Chileno =======> 0,0010312 (23/09/2022)

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telaConversaoMoeda frame = new telaConversaoMoeda();
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

	public telaConversaoMoeda() {

		// Valores para conversão
		valoresConversao.add(Double.valueOf("1.00"));
		valoresConversao.add(Double.parseDouble("0.9878"));
		valoresConversao.add(Double.parseDouble("1.1328"));
		valoresConversao.add(Double.parseDouble("0.0069367"));
		valoresConversao.add(Double.parseDouble("0.666"));
		valoresConversao.add(Double.parseDouble("1.0358401"));
		valoresConversao.add(Double.parseDouble("0.7462687"));
		valoresConversao.add(Double.parseDouble("0.141842"));
		valoresConversao.add(Double.parseDouble("0.0069013"));
		valoresConversao.add(Double.parseDouble("0.0545509"));
		valoresConversao.add(Double.parseDouble("0.1934535"));
		valoresConversao.add(Double.parseDouble("0.0010312"));

		setFont(new Font("Verdana", Font.PLAIN, 12));
		setTitle("Alura Java Challenge - 1 - Conversor de Moeda");
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
		cbOrigem.setModel(new DefaultComboBoxModel(new String[] {"US$ - Dólar Americano", "€ - Euro", "£ - Libra esterlina", "¥ - Iene", "$ - Dólar Australiano", "Fr - Franco Suíço", "$ - Dólar Canadense", "元 - Renminbi (Yuan)", "$ - Peso Argentino", "₺ - Lira Turca", "R$ - Real Brasileiro", "$ - Peso Chileno"}));
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
		cbDestino.setModel(new DefaultComboBoxModel(new String[] {"US$ - Dólar Americano", "€ - Euro", "£ - Libra esterlina", "¥ - Iene", "$ - Dólar Australiano", "Fr - Franco Suíço", "$ - Dólar Canadense", "元 - Renminbi (Yuan)", "$ - Peso Argentino", "₺ - Lira Turca", "R$ - Real Brasileiro", "$ - Peso Chileno"}));
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

					double razaoConversaoInicial = valoresConversao.get(cbOrigem.getSelectedIndex());
					double razaoConversaoFinal = valoresConversao.get(cbDestino.getSelectedIndex());
					double ConversaoPrimaria = razaoConversaoInicial * valorParaConverter;

					double ConversaoSecundaria = ConversaoPrimaria * (1 / razaoConversaoFinal);

					String moeda = cbDestino.getItemAt(cbDestino.getSelectedIndex()).toString().substring(0, 2);

					JOptionPane.showMessageDialog(null,
							"Você terá " + moeda + String.format("%.2f", ConversaoSecundaria), "Conversão finalizada",
							JOptionPane.INFORMATION_MESSAGE);

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
					}

				} else {

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
		checaValorDigitado();
	}
}
