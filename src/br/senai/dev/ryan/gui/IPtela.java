package br.senai.dev.ryan.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.senai.dev.ryan.model.EnderecoIP;

public class IPtela {
	private JLabel lblIP;
	private JLabel lblPonto1;
	private JLabel lblPonto2;
	private JLabel lblPonto3;
	private JLabel lblBarra;
	private JTextField txtOctate1;
	private JTextField txtOctate2;
	private JTextField txtOctate3;
	private JTextField txtOctate4;
	private JTextField txtOctate5;
	private JButton btnMostrarDetalhes;
	private JButton btnSair;
	
	private Font font = new Font("Arial", Font.BOLD, 26);

	public void criarTela() {

		JFrame tela = new JFrame();
		tela.setSize(530, 350);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setTitle("Detalhes do IP");
		tela.setLocationRelativeTo(null);
		tela.setLayout(null);

		JLabel lblIP = new JLabel();
		lblIP.setText("Endereço IP");
		lblIP.setFont(font);
		lblIP.setBounds(185, 10, 200, 50);
		tela.getContentPane().add(lblIP);

		JTextField txtOctate1 = new JTextField();
		txtOctate1.setBounds(20, 70, 80, 40);
		txtOctate1.setHorizontalAlignment(JTextField.CENTER);
		tela.getContentPane().add(txtOctate1);

		JLabel lblPonto1 = new JLabel();
		lblPonto1.setText(".");
		lblPonto1.setBounds(107, 70, 80, 40);
		tela.getContentPane().add(lblPonto1);

		JTextField txtOctate2 = new JTextField();
		txtOctate2.setBounds(120, 70, 80, 40);
		txtOctate2.setHorizontalAlignment(JTextField.CENTER);
		tela.getContentPane().add(txtOctate2);

		JLabel lblPonto2 = new JLabel();
		lblPonto2.setText(".");
		lblPonto2.setBounds(207, 70, 80, 40);
		tela.getContentPane().add(lblPonto2);

		JTextField txtOctate3 = new JTextField();
		txtOctate3.setBounds(220, 70, 80, 40);
		txtOctate3.setHorizontalAlignment(JTextField.CENTER);
		tela.getContentPane().add(txtOctate3);

		JLabel lblPonto3 = new JLabel();
		lblPonto3.setText(".");
		lblPonto3.setBounds(307, 70, 80, 40);
		tela.getContentPane().add(lblPonto3);

		JTextField txtOctate4 = new JTextField();
		txtOctate4.setBounds(320, 70, 80, 40);
		txtOctate4.setHorizontalAlignment(JTextField.CENTER);
		tela.getContentPane().add(txtOctate4);

		JLabel lblBarra = new JLabel();
		lblBarra.setText("/");
		lblBarra.setBounds(407, 70, 80, 40);
		tela.getContentPane().add(lblBarra);

		JTextField txtOctate5 = new JTextField();
		txtOctate5.setBounds(420, 70, 80, 40);
		txtOctate5.setHorizontalAlignment(JTextField.CENTER);
		tela.getContentPane().add(txtOctate5);

		JButton btnMostrarDetalhes = new JButton();
		btnMostrarDetalhes.setText("Mostrar Detalhes do IP");
		btnMostrarDetalhes.setBounds(50, 150, 200, 40);
		tela.getContentPane().add(btnMostrarDetalhes);
		
		JButton btnSair = new JButton();
		btnSair.setText("Sair");
		btnSair.setBounds(270, 150, 200, 40);
		tela.getContentPane().add(btnSair);

		btnMostrarDetalhes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try { // Monta o IP digitado
					String ipCompleto = txtOctate1.getText() + "." + txtOctate2.getText() + "." + txtOctate3.getText()
							+ "." + txtOctate4.getText() + "/" + txtOctate5.getText();
					EnderecoIP endereco = new EnderecoIP(ipCompleto);
					String detalhes = "Classe: " + endereco.getClasse() + "\n" + "Máscara Decimal: "
							+ endereco.getMascaraDecimal() + "\n" + "Máscara Binária: " + endereco.getMascaraBinaria()
							+ "\n" + "Total de IPs: " + endereco.getTotalIPs();
					// Mostra os dados em uma caixa de diálogo
					JOptionPane.showMessageDialog(null, detalhes, "Detalhes do IP", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Erro: entrada inválida.", "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		btnSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(tela, "Confirmar a sáida do sistema?", "Sair do Sistema?",
						JOptionPane.YES_NO_OPTION);

				System.out.println(resposta);
				if (resposta == 0) {
					System.exit(0);
				}
			}
		});
		
		
		tela.setVisible(true);
	}

}
