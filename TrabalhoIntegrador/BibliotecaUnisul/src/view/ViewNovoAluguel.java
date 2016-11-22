package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controler.AlunoControler;
import controler.LivroControler;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class ViewNovoAluguel extends JFrame {

	private JPanel contentPane;
	private JTextField CaixaMatricula;
	private JTextField textField_UserName;
	private JTextField textField_CodLivro;
	private JTextField textField_TitleBook;
	private JTextField textField_UserQuantLoc;
	private JLabel lblExemplar;
	private JTextField textField_edition;
	private JLabel lblUsurio;
	private JLabel lblLivro;
	private JLabel lblTtulo;
	private JTextField textField_Localiza;
	private JLabel lblLocalizao;
	private JTextField textField_Status;
	private JLabel lblDisponvel;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JLabel lblProfessor;
	private JTextField textField_1;
	private JLabel lblDigiteAqui;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewNovoAluguel frame = new ViewNovoAluguel();
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
	public ViewNovoAluguel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 529, 352);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNovoAluguel = new JLabel("NOVO - Aluguel");
		lblNovoAluguel.setBounds(6, 6, 110, 16);
		contentPane.add(lblNovoAluguel);
		
		CaixaMatricula = new JTextField();
		CaixaMatricula.setBounds(20, 123, 134, 28);
		contentPane.add(CaixaMatricula);
		CaixaMatricula.setColumns(10);
		
		JLabel lblMatricula = new JLabel("Matricula");
		lblMatricula.setBounds(20, 106, 60, 16);
		contentPane.add(lblMatricula);
		
		JLabel lblNomeUsuario = new JLabel("Nome Usuario");
		lblNomeUsuario.setBounds(20, 163, 110, 16);
		contentPane.add(lblNomeUsuario);
		
		textField_UserName = new JTextField();
		textField_UserName.setEditable(false);
		textField_UserName.setBounds(17, 177, 194, 28);
		contentPane.add(textField_UserName);
		textField_UserName.setColumns(10);
		
		textField_CodLivro = new JTextField();
		textField_CodLivro.setColumns(10);
		textField_CodLivro.setBounds(288, 123, 134, 28);
		contentPane.add(textField_CodLivro);
		
		JLabel lblCdigoLivro = new JLabel("Código Livro");
		lblCdigoLivro.setBounds(288, 106, 134, 16);
		contentPane.add(lblCdigoLivro);
		
		JLabel lblTitulolivro = new JLabel("TituloLivro");
		lblTitulolivro.setBounds(292, 163, 134, 16);
		contentPane.add(lblTitulolivro);
		
		textField_TitleBook = new JTextField();
		textField_TitleBook.setEditable(false);
		textField_TitleBook.setColumns(10);
		textField_TitleBook.setBounds(286, 177, 192, 28);
		contentPane.add(textField_TitleBook);
		
		JLabel lblExemplareslocados = new JLabel("Locados");
		lblExemplareslocados.setBounds(159, 106, 60, 16);
		contentPane.add(lblExemplareslocados);
		
		textField_UserQuantLoc = new JTextField();
		textField_UserQuantLoc.setColumns(10);
		textField_UserQuantLoc.setBounds(159, 123, 60, 28);
		contentPane.add(textField_UserQuantLoc);
		
		lblExemplar = new JLabel("Exemplar");
		lblExemplar.setBounds(17, 205, 61, 16);
		contentPane.add(lblExemplar);
		
		textField_edition = new JTextField();
		textField_edition.setEditable(false);
		textField_edition.setBounds(18, 247, 168, 28);
		contentPane.add(textField_edition);
		textField_edition.setColumns(10);
		
		lblUsurio = new JLabel("USUÁRIO");
		lblUsurio.setBounds(21, 80, 61, 16);
		contentPane.add(lblUsurio);
		
		lblLivro = new JLabel("LIVRO");
		lblLivro.setBounds(290, 78, 61, 16);
		contentPane.add(lblLivro);
		
		lblTtulo = new JLabel("Edição");
		lblTtulo.setBounds(20, 230, 61, 16);
		contentPane.add(lblTtulo);
		
		textField_Localiza = new JTextField();
		textField_Localiza.setEditable(false);
		textField_Localiza.setColumns(10);
		textField_Localiza.setBounds(198, 247, 168, 28);
		contentPane.add(textField_Localiza);
		
		lblLocalizao = new JLabel("Localização");
		lblLocalizao.setBounds(200, 230, 110, 16);
		contentPane.add(lblLocalizao);
		
		textField_Status = new JTextField();
		textField_Status.setEditable(false);
		textField_Status.setColumns(10);
		textField_Status.setBounds(378, 247, 134, 28);
		contentPane.add(textField_Status);
		
		lblDisponvel = new JLabel("Status");
		lblDisponvel.setBounds(380, 230, 110, 16);
		contentPane.add(lblDisponvel);
		
		JButton btnAlugar = new JButton("Alugar");
		btnAlugar.setBounds(195, 289, 117, 29);
		contentPane.add(btnAlugar);
		ExecutaBotaoAluguel executabotaoAluguel = new ExecutaBotaoAluguel();
		btnAlugar.addActionListener(executabotaoAluguel);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(413, 6, 110, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCdigoAluguel = new JLabel("Código Aluguel");
		lblCdigoAluguel.setBounds(301, 15, 110, 16);
		contentPane.add(lblCdigoAluguel);
		
		lblNewLabel = new JLabel("Aluno - 1\n");
		lblNewLabel.setBounds(20, 29, 72, 16);
		contentPane.add(lblNewLabel);
		
		lblProfessor = new JLabel("Professor - 2");
		lblProfessor.setBounds(20, 47, 84, 16);
		contentPane.add(lblProfessor);
		
		textField_1 = new JTextField();
		textField_1.setBounds(151, 49, 55, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		lblDigiteAqui = new JLabel("Digite aqui");
		lblDigiteAqui.setBounds(142, 27, 72, 16);
		contentPane.add(lblDigiteAqui);
		
		
		
		
	}
	
	private class RadioBtn implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			boolean flag;
			
			
			
		}
		
	}
	
	private class ExecutaBotaoAluguel implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				int codigoLivro = Integer.parseInt(textField_CodLivro.getText());
				boolean flag = LivroControler.getInstance().verificaCodLivro(codigoLivro);
				
				
				JOptionPane.showMessageDialog(rootPane, "Aluguel realizado com sucesso.");
					
				
				
		    } catch (NumberFormatException nfe) {
		    	JOptionPane.showMessageDialog(rootPane, "Insira apenas números do código do livro.");
		    	
		    	
		    }
			
		    

		}

	}
}
