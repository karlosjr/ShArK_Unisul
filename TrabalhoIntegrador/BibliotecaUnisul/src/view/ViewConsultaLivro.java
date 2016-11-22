package view;


import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controler.AlunoControler;
import controler.LivroControler;
import modelo.Aluno;
import modelo.Exemplar;
import modelo.Livro;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JButton;

public class ViewConsultaLivro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	static String [] [] data = {{"","","",""}};
	private JTextField mostaTitulo;
	private JTextField mostraAutor;
	private JTextField mostraExemplares;
	private JTextField cod1;
	private JTextField loc1;
	private JTextField edi1;
	private JTextField Locado1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewConsultaAluno frame = new ViewConsultaAluno();
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
	public ViewConsultaLivro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConsultaAluno = new JLabel("Consulta Livro");
		lblConsultaAluno.setBounds(173, 16, 103, 16);
		contentPane.add(lblConsultaAluno);
		
		textField = new JTextField();
		textField.setBounds(114, 44, 176, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblMatricula = new JLabel("Código");
		lblMatricula.setBounds(41, 50, 61, 16);
		contentPane.add(lblMatricula);
		
		
        
        
        JButton btnConsultar = new JButton("Consultar");
        btnConsultar.setBounds(296, 45, 117, 29);
        contentPane.add(btnConsultar);
        
        mostaTitulo = new JTextField();
        mostaTitulo.setBounds(18, 105, 206, 28);
        contentPane.add(mostaTitulo);
        mostaTitulo.setColumns(10);
        
        mostraAutor = new JTextField();
        mostraAutor.setBounds(225, 105, 134, 28);
        contentPane.add(mostraAutor);
        mostraAutor.setColumns(10);
        
        mostraExemplares = new JTextField();
        mostraExemplares.setBounds(361, 105, 79, 28);
        contentPane.add(mostraExemplares);
        mostraExemplares.setColumns(10);
        
        JLabel lblNome = new JLabel("Título");
        lblNome.setBounds(20, 89, 61, 16);
        contentPane.add(lblNome);
        
        JLabel lblNewLabel = new JLabel("Autor");
        lblNewLabel.setBounds(225, 89, 61, 16);
        contentPane.add(lblNewLabel);
        
        JLabel lblExemplares = new JLabel("Exemplares");
        lblExemplares.setBounds(367, 88, 72, 16);
        contentPane.add(lblExemplares);
        
        JButton btnSair = new JButton("fechar");
        btnSair.setBounds(169, 220, 117, 29);
        contentPane.add(btnSair);
        
        cod1 = new JTextField();
        cod1.setBounds(18, 178, 72, 28);
        contentPane.add(cod1);
        cod1.setColumns(10);
        
        loc1 = new JTextField();
        loc1.setBounds(89, 178, 169, 28);
        contentPane.add(loc1);
        loc1.setColumns(10);
        
        edi1 = new JTextField();
        edi1.setBounds(260, 178, 140, 28);
        contentPane.add(edi1);
        edi1.setColumns(10);
        
        Locado1 = new JTextField();
        Locado1.setBounds(399, 178, 51, 28);
        contentPane.add(Locado1);
        Locado1.setColumns(10);
        
        JLabel lblDescrioExemplares = new JLabel("Descrição Exemplares");
        lblDescrioExemplares.setBounds(18, 139, 169, 16);
        contentPane.add(lblDescrioExemplares);
        
        JLabel lblCod = new JLabel("Cod");
        lblCod.setBounds(20, 161, 61, 16);
        contentPane.add(lblCod);
        
        JLabel lblNewLabel_1 = new JLabel("Localização");
        lblNewLabel_1.setBounds(89, 161, 98, 16);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblEdio = new JLabel("Edição");
        lblEdio.setBounds(260, 161, 61, 16);
        contentPane.add(lblEdio);
        
        JLabel lblLocado = new JLabel("Locado");
        lblLocado.setBounds(399, 161, 51, 16);
        contentPane.add(lblLocado);
        ListenerSair executabotaoSair = new ListenerSair();
        btnSair.addActionListener(executabotaoSair);
        
        ListenerTable executabotaoConsulta = new ListenerTable();
        btnConsultar.addActionListener(executabotaoConsulta);
        
        
	}
	private class ListenerTable implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			try {
				int codigoLivro = Integer.parseInt(textField.getText());
				boolean flag = LivroControler.getInstance().verificaCodLivro(codigoLivro);
				
				if(flag){
					Livro livro = LivroControler.getInstance().mostraLivro(codigoLivro);
					
					String autor = livro.getAutor();
					String titulo = livro.getTitulo();
					int Exemplares = livro.getExemplares().size();
					
					mostaTitulo.setText(autor);
					mostraAutor.setText(autor);
					mostraExemplares.setText(Exemplares + "");
					
					if(livro.getExemplares() != null){
						for(Exemplar exemplarLocal: livro.getExemplares()){
							int i =1;
							int codigoEx = exemplarLocal.getCodigo() ;
							String localizacaoEx = exemplarLocal.getLocalizacao();
							String edicaoEx = exemplarLocal.getEdicao();
							String statusEx = ""; 
							if(exemplarLocal.getStatus()){
								statusEx = "Sim";
							}else{
								statusEx = "Não";
							}
							
							cod1.setText(codigoEx + "");
							loc1.setText(localizacaoEx);
							edi1.setText(edicaoEx);
							Locado1.setText(statusEx);
							
						}
					}
					
					
				}else{
					JOptionPane.showMessageDialog(rootPane, "Matricula Inválida.");
				}
				
				
				
				
				
		    } catch (NumberFormatException nfe) {
		    	JOptionPane.showMessageDialog(rootPane, "Insira apenas números na matricula.");
		    	textField.setText("");
		    	
		    }

		}

	}
	private class ListenerSair implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			fecharTela();

		}

	}
	
	
	
	private void fecharTela (){
		this.setVisible(false);
	}
}
