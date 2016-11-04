package Arquivo;

import java.io.*;
import java.util.*;

import dao.ProfessorDao;
import modelo.Professor;

public class ArquivoProfessorDao implements ProfessorDao {
	private static List<Professor> professores = new ArrayList<Professor>();
	
	
	public ArquivoProfessorDao(){
		deserializaProfessores();
	}
	
	@Override
	public void insereProfessor(Professor professor) {
		professores.add(professor);

		serializaProfessores();
		deserializaProfessores();

	}

	@Override
	public Professor consultaProfessor(int matricula) {

		for (Professor professorLocal : professores) {
			if (matricula == professorLocal.getMatricula()) {
				return professorLocal;
			}
		}

		return null;
	}

	@Override
	public void alteraProfessor(Professor professor) {
		for (Professor professorLocal : professores) {
			if (professor.getMatricula() == professorLocal.getMatricula()) {
				professorLocal.setMatricula(professor.getMatricula());
				professorLocal.setNome(professor.getNome());
				professorLocal.setCursos(professor.getCursos());
			}
		}

		serializaProfessores();
		deserializaProfessores();

	}

	@Override
	public void removeProfessor(int matricula) {
		Iterator<Professor> professorRemover = professores.iterator();

		while (professorRemover.hasNext()) {

			if (professorRemover.next().getMatricula() == matricula) {
				professorRemover.remove();
			}
		}
		
		serializaProfessores();
		deserializaProfessores();
	}

	@Override
	public List<Professor> mostraProfessores() {

		return professores;
	}

	public void serializaProfessores() {
		File arquivo = new File("BibliotecaArquivos/Professores/Professores.bin");
		File pasta = new File("BibliotecaArquivos/Professores/");

		OutputStream escritorByte = null;
		ObjectOutputStream escritorObjeto = null;

		try {
			if (arquivo.exists() != true) {
				pasta.mkdir();
				arquivo.createNewFile();
			}

			arquivo.createNewFile();

			escritorByte = new FileOutputStream("BibliotecaArquivos/Professores/Professores.bin");
			escritorObjeto = new ObjectOutputStream(escritorByte);

			escritorObjeto.writeObject(professores);
			escritorObjeto.flush();

		} catch (FileNotFoundException e) {
			System.err.println(e);
		} catch (IOException e) {
			System.err.println(e);
		} finally {
			try {
				if (escritorByte != null) {
					escritorByte.close();
				}
				if (escritorObjeto != null) {
					escritorObjeto.close();
				}

			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}

	public void deserializaProfessores() {

		File arquivo = new File("BibliotecaArquivos/Professores/Professores.bin");

		boolean arquivoExiste = arquivo.exists();

		if (arquivoExiste) {
			InputStream leitorByte = null;
			ObjectInputStream leitorObjeto = null;

			try {
				leitorByte = new FileInputStream("BibliotecaArquivos/Professores/Professores.bin");
				leitorObjeto = new ObjectInputStream(leitorByte);

				professores = (ArrayList<Professor>) leitorObjeto.readObject();

			} catch (FileNotFoundException e) {
				System.err.println(e);
			} catch (IOException e) {
				System.err.println(e);
			} catch (ClassNotFoundException e) {
				System.err.println(e);
			} finally {
				try {
					if (leitorByte != null) {
						leitorByte.close();
					}
					if (leitorObjeto != null) {
						leitorObjeto.close();
					}

				} catch (IOException e) {
					System.err.println(e);
				}
			}
		}

	}

}
