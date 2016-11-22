package view;


import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controler.AlunoControler;
import controler.ProfessorControler;
import modelo.Aluno;
import modelo.Professor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JButton;

public class ViewConsultaProfessor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	static String [] [] data = {{"","","",""}};
	private JTextField mostaNome;
	private JTextField mostraCurso;
	private JTextField mostraExemplares;
	

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
	public ViewConsultaProfessor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 216);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConsultaAluno = new JLabel("Consulta Aluno");
		lblConsultaAluno.setBounds(173, 16, 103, 16);
		contentPane.add(lblConsultaAluno);
		
		textField = new JTextField();
		textField.setBounds(114, 44, 176, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblMatricula = new JLabel("Matricula");
		lblMatricula.setBounds(41, 50, 61, 16);
		contentPane.add(lblMatricula);
		
		String[] colunas = {"Matricula","Nome","Curso","Livros Locados"};
        
        
        JButton btnConsultar = new JButton("Consultar");
        btnConsultar.setBounds(296, 45, 117, 29);
        contentPane.add(btnConsultar);
        
        mostaNome = new JTextField();
        mostaNome.setBounds(18, 105, 206, 28);
        contentPane.add(mostaNome);
        mostaNome.setColumns(10);
        
        mostraCurso = new JTextField();
        mostraCurso.setBounds(225, 105, 134, 28);
        contentPane.add(mostraCurso);
        mostraCurso.setColumns(10);
        
        mostraExemplares = new JTextField();
        mostraExemplares.setBounds(361, 105, 79, 28);
        contentPane.add(mostraExemplares);
        mostraExemplares.setColumns(10);
        
        JLabel lblNome = new JLabel("Nome");
        lblNome.setBounds(20, 89, 61, 16);
        contentPane.add(lblNome);
        
        JLabel lblNewLabel = new JLabel("Curso");
        lblNewLabel.setBounds(225, 89, 61, 16);
        contentPane.add(lblNewLabel);
        
        JLabel lblExemplares = new JLabel("Exemplares");
        lblExemplares.setBounds(360, 88, 79, 16);
        contentPane.add(lblExemplares);
        
        JButton btnSair = new JButton("fechar");
        btnSair.setBounds(159, 145, 117, 29);
        contentPane.add(btnSair);
        ListenerSair executabotaoSair = new ListenerSair();
        btnSair.addActionListener(executabotaoSair);
        
        ListenerTable executabotaoConsulta = new ListenerTable();
        btnConsultar.addActionListener(executabotaoConsulta);
        
        
	}
	private class ListenerTable implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			try {
				int matricula = Integer.parseInt(textField.getText());
				boolean flag = ProfessorControler.getInstance().verificaMatricula(matricula);
				
				if(flag){
					Professor professor = (ProfessorControler.getInstance().MostraProfessor(matricula));
					int matriculaMostra = professor.getMatricula();
					String nome = professor.getNome();
					List<String> cursos = new ArrayList<String>();
					cursos = professor.getCursos();
					int livrosLocados = professor.getLivrosLocados();
					
					String cursosMostra = "";
					
					mostaNome.setText(nome);
					mostraCurso.setText(cursosMostra);
					mostraExemplares.setText(livrosLocados + "");
					
					
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
