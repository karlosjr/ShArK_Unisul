package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import controler.ProfessorControler;


public class ViewCadastroProfessor extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField varMatricula;
	private JTextField varNome;
	private JTextField varCurso;
	private JLabel lblAlunoCadastro;

	public ViewCadastroProfessor() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 238, 237);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Matricula");
		lblNewLabel.setBounds(19, 60, 61, 16);
		contentPane.add(lblNewLabel);

		varMatricula = new JTextField();
		varMatricula.setBounds(92, 55, 130, 26);
		contentPane.add(varMatricula);
		varMatricula.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(19, 93, 61, 16);
		contentPane.add(lblNewLabel_1);

		varNome = new JTextField();
		varNome.setBounds(92, 88, 130, 26);
		contentPane.add(varNome);
		varNome.setColumns(10);
		

		

		lblAlunoCadastro = new JLabel("Professor - Cadastro");
		lblAlunoCadastro.setBounds(19, 17, 138, 16);
		contentPane.add(lblAlunoCadastro);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(55, 180, 117, 29);
		contentPane.add(btnCadastrar);
		ExecutaBotao executabotao = new ExecutaBotao();
		btnCadastrar.addActionListener(executabotao);

	}

	private class ExecutaBotao implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			try {
				int matricula = Integer.parseInt(varMatricula.getText());
				String nome = varNome.getText();
				ProfessorControler.getInstance().InsereProfessor(matricula, nome);

				fecharTela();
		    } catch (NumberFormatException nfe) {
		    	JOptionPane.showMessageDialog(null, "Insira apenas números na matricula.");
		    	varMatricula.setText("");
		    	
		    }

		}

	}
	private void fecharTela (){
		this.setVisible(false);
	}
}
