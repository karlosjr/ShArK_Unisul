package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controler.AlunoControler;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class TelaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCadastro = new JMenu("Cadastro");
		menuBar.add(mnCadastro);
		
		JMenuItem itemAluno = new JMenuItem("Aluno");
		itemAluno.addActionListener(new ListenerCadastro());
		mnCadastro.add(itemAluno);
		
		JMenu itemProfessor = new JMenu("Professor");
		mnCadastro.add(itemProfessor);
		
		JMenuItem mntmProfessor = new JMenuItem("Professor");
		mntmProfessor.addActionListener(new ListenerCadastro());
		itemProfessor.add(mntmProfessor);
		
		JMenuItem mntmCadastrarCursos = new JMenuItem("Cadastrar Cursos");
		itemProfessor.add(mntmCadastrarCursos);
		
		JMenuItem itemLivro = new JMenuItem("Livro");
		itemLivro.addActionListener(new ListenerCadastro());
		mnCadastro.add(itemLivro);
		
		JMenu mnConsulta = new JMenu("Consulta");
		menuBar.add(mnConsulta);
		
		JMenuItem consultaAluno = new JMenuItem("Aluno");
		consultaAluno.addActionListener(new ListenerConsulta());
		mnConsulta.add(consultaAluno);
		
		JMenuItem consultaProfessor = new JMenuItem("Professor");
		consultaProfessor.addActionListener(new ListenerConsulta());
		mnConsulta.add(consultaProfessor);
		
		JMenuItem consultaLivro = new JMenuItem("Livro");
		consultaLivro.addActionListener(new ListenerConsulta());
		mnConsulta.add(consultaLivro);
		
		JMenuItem consultaAluguel = new JMenuItem("Aluguel");
		consultaAluguel.addActionListener(new ListenerConsulta());
		mnConsulta.add(consultaAluguel);
		
		JMenu mnAluguel = new JMenu("Aluguel");
		menuBar.add(mnAluguel);
		
		JMenuItem itemAlugaLivro = new JMenuItem("Alugar Livro");
		itemAlugaLivro.addActionListener(new ListenerAluguel());
		mnAluguel.add(itemAlugaLivro);
		
		JMenuItem itemDevolveLivro = new JMenuItem("Devolver Livro");
		itemDevolveLivro.addActionListener(new ListenerAluguel());
		mnAluguel.add(itemDevolveLivro);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ListenerSair());
		menuBar.add(mntmSair);
		
		contentPane = new JPanel();
		menuBar.add(contentPane);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
	}
	private class ListenerCadastro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String acao = e.getActionCommand();
			
			switch (acao) {
			case "Aluno":
				ViewCadastraAluno viewCadastroAluno = new ViewCadastraAluno();
				viewCadastroAluno.setVisible(true);
				break;
			case "Professor":
				ViewCadastroProfessor viewCadastroProfessor = new ViewCadastroProfessor();
				viewCadastroProfessor.setVisible(true);
				break;
			case "Livro":
				
				break;


			default:
				break;
			}

		}

	}
	

	private class ListenerConsulta implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String acao = e.getActionCommand();
			
			switch (acao) {
			case "Aluno":
				ViewConsultaAluno viewConsultaAluno = new ViewConsultaAluno();
				viewConsultaAluno.setVisible(true);
				break;
			case "Professor":
				ViewConsultaProfessor viewConsultaProfessor = new ViewConsultaProfessor();
				viewConsultaProfessor.setVisible(true);
				break;
			case "Livro":
				
				break;
			case "Aluguel":
				
				break;


			default:
				break;
			}

		}

	}
	private class ListenerAluguel implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String acao = e.getActionCommand();
			
			switch (acao) {
			case "Alugar Livro":
				
				break;
			case "Devolver Livro":
				
				break;
			
			default:
				break;
			}

		}

	}
	private class ListenerSair implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String acao = e.getActionCommand();
			
			if("Sair".equals(acao)){
				
				System.exit(0);
			}

		}

	}

}
