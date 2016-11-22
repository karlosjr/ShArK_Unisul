package view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controler.AlunoControler;
import controler.LivroControler;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class ViewCadastraLivro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField varTitulo;
	private JTextField varAutor;
	private JLabel lblAlunoCadastro;

	public ViewCadastraLivro() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 238, 237);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Título");
		lblNewLabel.setBounds(19, 60, 61, 16);
		contentPane.add(lblNewLabel);

		varTitulo = new JTextField();
		varTitulo.setBounds(92, 55, 130, 26);
		contentPane.add(varTitulo);
		varTitulo.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Autor");
		lblNewLabel_1.setBounds(19, 93, 61, 16);
		contentPane.add(lblNewLabel_1);

		varAutor = new JTextField();
		varAutor.setBounds(92, 88, 130, 26);
		contentPane.add(varAutor);
		varAutor.setColumns(10);
		
		
		lblAlunoCadastro = new JLabel("Livro - Cadastro");
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
			String titulo = varTitulo.getText();
			String autor = varAutor.getText();
			
			LivroControler.getInstance().insereLivro(titulo, autor);
			
			
			fecharTela();
		    

		}

	}
	
	
	
	private void fecharTela (){
		this.setVisible(false);
	}

}
