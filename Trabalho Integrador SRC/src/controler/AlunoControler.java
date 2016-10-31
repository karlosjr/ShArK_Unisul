package controler;

import java.io.*;
import java.util.*;

import modelo.*;

public class AlunoControler {

	private static List<Aluno> alunos = new ArrayList<Aluno>();
	
	private static AlunoControler alunoControler = new AlunoControler();
	
	private AlunoControler(){
	}
	
	public static AlunoControler getInstance() {
		return alunoControler;
	}

	public void insereAluno(int matricula, String nome, String curso) {
		if(!verificaMatricula(matricula)){
			Aluno alunoInsere = new Aluno(matricula, nome, curso);
			alunos.add(alunoInsere);
		}
		//retorno de erro se já existe a matrícula
	}
	

	public void removeAluno(int matricula) {
		
		Iterator<Aluno> alunoRemover = alunos.iterator();

        while(alunoRemover.hasNext()){

            if(alunoRemover.next().getMatricula() == matricula){
            	alunoRemover.remove();
            }
        }
		
		
		
		
	}
	
	public Aluno mostraAluno(int matricula) {
		Aluno aluno = new Aluno(0, null, null);
		for (Aluno alunoLocal : alunos) {
			if (matricula == alunoLocal.getMatricula()) {
				aluno = alunoLocal;
			} 
		}
		return aluno;
	}

	public List<Aluno> mostraAlunos() {
		return alunos;
	}

	public void atualizaAluno(Aluno aluno) {
		for (Aluno alunoLocal : alunos) {
			if (aluno.getMatricula() == alunoLocal.getMatricula()) {
				alunoLocal.setMatricula(aluno.getMatricula());
				alunoLocal.setNome(aluno.getNome());
				alunoLocal.setCurso(aluno.getCurso());
			} 
		}
	}
	
	public boolean verificaMatricula(int matricula) {
		
		for (Aluno alunoLocal : alunos) {
			if (matricula == alunoLocal.getMatricula()) {
				return true;
			} 
		}		
		return false;
	}	
	
	/*public void addExemplar(int matricula, Exemplar exemplar){
		
		for (Aluno alunoLocal : alunos) {
			if (matricula == alunoLocal.getMatricula()) {
				List<Exemplar> exemplaresLocados = alunoLocal.getExemplares();
				if(exemplaresLocados.size() <= 5){
					exemplaresLocados.add(exemplar);
				}
			} 
		}
		
		
			
		
	}*/
	
	public void serializaAlunos() {
		File arquivo = new File("BibliotecaArquivos/Alunos/Alunos.bin");
		File pasta = new File("BibliotecaArquivos/Alunos/");

		OutputStream escritorByte = null;
		ObjectOutputStream escritorObjeto = null;

		try {
			if (arquivo.exists() != true) {
				pasta.mkdir();
				arquivo.createNewFile();
			}

			arquivo.createNewFile();

			escritorByte = new FileOutputStream("BibliotecaArquivos/Alunos/Alunos.bin");
			escritorObjeto = new ObjectOutputStream(escritorByte);

			escritorObjeto.writeObject(alunos);
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

	public void deserializaAluno() {

		File arquivo = new File("BibliotecaArquivos/Alunos/Alunos.bin");

		boolean arquivoExiste = arquivo.exists();

		if (arquivoExiste) {
			InputStream leitorByte = null;
			ObjectInputStream leitorObjeto = null;

			try {
				leitorByte = new FileInputStream("BibliotecaArquivos/Alunos/Alunos.bin");
				leitorObjeto = new ObjectInputStream(leitorByte);

				alunos = (ArrayList<Aluno>) leitorObjeto.readObject();

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



