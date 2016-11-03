package controler;

import java.io.*;
import java.util.*;

import modelo.*;

public class ProfessorControler {
	

	private List<Professor> professores = new ArrayList<Professor>();

	private static ProfessorControler professorControler = new ProfessorControler();
	
	private ProfessorControler(){
		
	}
	
	public static ProfessorControler getInstance() {
		return professorControler;
	}
	
	public void InsereProfessor(int matricula, String nome) {
		
		if(!verificaMatricula(matricula)){
			Professor professorInsere = new Professor(matricula, nome);
			professores.add(professorInsere);
		}//retorno de erro se já existe a matrícula
	}

	public void RemoveProfessor(int matricula) {
		Iterator<Professor> professorRemover = professores.iterator();

        while(professorRemover.hasNext()){

            if(professorRemover.next().getMatricula() == matricula){
            	professorRemover.remove();
            }
        }
	}

	public Professor MostraProfessor(int matricula) {
		Professor professor = new Professor(0, null);
		for (Professor professorLocal : professores) {
			if (matricula == professorLocal.getMatricula()) {
				professor = professorLocal;
			}
		}
		return professor;
		
		
		
		
	}

	public List<Professor> Mostraprofessores() {

		return professores;
	}

	public void AtualizaProfessor(Professor professor) {
		for (Professor professorLocal : professores) {
			if (professor.getMatricula() == professorLocal.getMatricula()) {
				professorLocal.setMatricula(professor.getMatricula());
				professorLocal.setNome(professor.getNome());
				professorLocal.setCursos(professor.getCursos());
			} 
		}
	}

	public boolean verificaMatricula(int matricula) {
		boolean flag = false;

		for (Professor professorLocal : professores) {
			if (matricula == professorLocal.getMatricula()) {
				flag = true;
			}
		}

		return flag;
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
