import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import java.awt.FlowLayout;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.Box;
import javax.swing.JTextPane;
import java.awt.Label;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.Button;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class telaEscolhaConversor extends JFrame {

	private JPanel contentPane;
	private JOptionPane caixaEscolhaConversor;
	public static int ConversorEscolhido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telaEscolhaConversor frame = new telaEscolhaConversor();
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
	
	public telaEscolhaConversor() {
		setTitle("Alura Java Challenge - 1");
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(0, 0, 241, 170);
		this.setLocationRelativeTo(null); //Centraliza a janela na tela
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		Label label = new Label("Escolha uma opção:");
		label.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		contentPane.add(label);

		JComboBox cbConversorEscolhido = new JComboBox();
		cbConversorEscolhido.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		contentPane.add(cbConversorEscolhido);
		cbConversorEscolhido.setModel(
				new DefaultComboBoxModel(new String[] { "Conversor de Moedas", "Conversor de Temperaturas" }));

		Component rigidArea = Box.createRigidArea(new Dimension(197, 20));
		contentPane.add(rigidArea);

		Button button = new Button(":: OK ::");
		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Pega o texto que foi escolhido
				ConversorEscolhido = cbConversorEscolhido.getSelectedIndex();
				
				// Carregar outra tela
				if (cbConversorEscolhido.getSelectedIndex() == 0) { // Conversor de Moedas
					telaConversaoMoeda.main(null);
					setVisible(false); // Esconde essa tela
				}
				if (cbConversorEscolhido.getSelectedIndex() == 1) { // Conversor de Temperatura
					telaConversaoTemperatura.main(null);
					setVisible(false); // Esconde essa tela
				} 
			}
		});
		button.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		contentPane.add(button);

	}
}
