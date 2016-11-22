package view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controler.AlunoControler;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class ViewCadastraAluno extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField varMatricula;
	private JTextField varNome;
	private JTextField varCurso;
	private JLabel lblAlunoCadastro;

	public ViewCadastraAluno() {
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
		
		JLabel lblCurso = new JLabel("Curso");
		lblCurso.setBounds(19, 131, 61, 16);
		contentPane.add(lblCurso);
		
		varCurso = new JTextField();
		varCurso.setBounds(92, 126, 130, 26);
		contentPane.add(varCurso);
		varCurso.setColumns(10);

		

		lblAlunoCadastro = new JLabel("ALUNO - Cadastro");
		lblAlunoCadastro.setBounds(19, 17, 138, 16);
		contentPane.add(lblAlunoCadastro);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(55, 180, 117, 29);
		contentPane.add(btnCadastrar);
		ExecutaBotaoCadastro executabotao1 = new ExecutaBotaoCadastro();
		btnCadastrar.addActionListener(executabotao1);

	}

	private class ExecutaBotaoCadastro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			try {
				int matricula = Integer.parseInt(varMatricula.getText());
				String nome = varNome.getText();
				String curso = varCurso.getText();
				AlunoControler.getInstance().insereAluno(matricula, nome, curso);
				
				
				fecharTela();
		    } catch (NumberFormatException nfe) {
		    	JOptionPane.showMessageDialog(rootPane, "Insira apenas números na matricula.");
		    	varMatricula.setText("");
		    	
		    }

		}

	}
	
	
	
	private void fecharTela (){
		this.setVisible(false);
	}

}
