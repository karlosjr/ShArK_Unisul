package view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.SingletonBanco;

import javax.swing.ButtonGroup;
import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TelaAberturaPrograma extends JFrame {

	private JPanel contentPane;
	private JTextField varSelect;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public TelaAberturaPrograma() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 184, 176);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnOk = new JButton("ok");
		btnOk.setBounds(37, 115, 117, 29);
		contentPane.add(btnOk);
		ExecutaBotaoOk executaOk = new ExecutaBotaoOk();
		btnOk.addActionListener(executaOk);

		JLabel lblNewLabel = new JLabel("Digite uma opção:");
		lblNewLabel.setBounds(37, 6, 117, 21);
		contentPane.add(lblNewLabel);

		JLabel lblArquivo = new JLabel("1 - Arquivo");
		lblArquivo.setBounds(30, 36, 106, 16);
		contentPane.add(lblArquivo);

		JLabel lblBanco = new JLabel("2 - Banco de dados");
		lblBanco.setBounds(30, 57, 133, 16);
		contentPane.add(lblBanco);

		varSelect = new JTextField();
		varSelect.setBounds(64, 80, 63, 28);
		contentPane.add(varSelect);
		varSelect.setColumns(10);

		ButtonGroup group = new ButtonGroup();

	}

	private class ExecutaBotaoOk implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			try {
				int iniciaPGM = Integer.parseInt(varSelect.getText());
				if (iniciaPGM > 0 && iniciaPGM < 3) {
					SingletonBanco.getInstance().setFlag(iniciaPGM);
					fecharTela();
					TelaPrincipal tela = new TelaPrincipal();
					tela.setVisible(true);
				}else{
					varSelect.setText("a");
					iniciaPGM = Integer.parseInt(varSelect.getText());
				}

			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(rootPane, "Insira apenas as opções 1 ou 2.");
				varSelect.setText("");
			}

		}

	}

	private void fecharTela() {
		this.setVisible(false);
	}
}
