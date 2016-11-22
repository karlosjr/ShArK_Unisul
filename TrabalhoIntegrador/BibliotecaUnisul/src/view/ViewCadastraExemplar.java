package view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import controler.LivroControler;


import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class ViewCadastraExemplar extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField varLocalizacao;
	private JTextField varEdicao;
	private JLabel lblAlunoCadastro;
	private JTextField codLivro;

	public ViewCadastraExemplar() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 238, 237);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Título");
		lblNewLabel.setBounds(30, 100, 61, 16);
		contentPane.add(lblNewLabel);

		varLocalizacao = new JTextField();
		varLocalizacao.setBounds(92, 95, 130, 26);
		contentPane.add(varLocalizacao);
		varLocalizacao.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Autor");
		lblNewLabel_1.setBounds(30, 133, 61, 16);
		contentPane.add(lblNewLabel_1);

		varEdicao = new JTextField();
		varEdicao.setBounds(92, 128, 130, 26);
		contentPane.add(varEdicao);
		varEdicao.setColumns(10);
		
		
		lblAlunoCadastro = new JLabel("Exemplar - Cadastro");
		lblAlunoCadastro.setBounds(19, 17, 138, 16);
		contentPane.add(lblAlunoCadastro);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(55, 180, 117, 29);
		contentPane.add(btnCadastrar);
		
		codLivro = new JTextField();
		codLivro.setBounds(88, 55, 134, 28);
		contentPane.add(codLivro);
		codLivro.setColumns(10);
		
		JLabel lblCdigoLivro = new JLabel("Código Livro");
		lblCdigoLivro.setBounds(6, 61, 85, 16);
		contentPane.add(lblCdigoLivro);
		
		ExecutaBotaoCadastro executabotao1 = new ExecutaBotaoCadastro();
		btnCadastrar.addActionListener(executabotao1);

	}

	private class ExecutaBotaoCadastro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				int codigoLivro = Integer.parseInt(codLivro.getText());
				boolean flag = LivroControler.getInstance().verificaCodLivro(codigoLivro);
				
				
				
				
				if(flag){
					String localizacao = varLocalizacao.getText();
					String edicao = varEdicao.getText();
					
					LivroControler.getInstance().insereExemplar(codigoLivro, localizacao, edicao);
					
					fecharTela();
										
				}else{
					JOptionPane.showMessageDialog(rootPane, "Código Inválido.");
				}
				
				
				
				
				
		    } catch (NumberFormatException nfe) {
		    	JOptionPane.showMessageDialog(rootPane, "Insira apenas números do código do livro.");
		    	codLivro.setText("");
		    	
		    }
			
		    

		}

	}
	
	
	
	private void fecharTela (){
		this.setVisible(false);
	}
}
