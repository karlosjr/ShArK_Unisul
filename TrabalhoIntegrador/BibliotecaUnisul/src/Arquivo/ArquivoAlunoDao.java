package Arquivo;

import java.io.*;
import java.util.*;

import controler.AlunoControler;
import dao.AlunoDao;
import modelo.Aluno;

public class ArquivoAlunoDao implements AlunoDao {
	private static List<Aluno> alunos = new ArrayList<Aluno>();
	
	public ArquivoAlunoDao() {
		deserializaAluno();
	}
	
	
	
	@Override
	public void insereAluno(Aluno aluno) {
		alunos.add(aluno);
		serializaAlunos();
		deserializaAluno();

	}

	@Override
	public Aluno consultaAluno(int matricula) {
		for (Aluno alunoLocal : alunos) {
			if (matricula == alunoLocal.getMatricula()) {
				return alunoLocal;
			} 
		}
		return null;
		
	}

	@Override
	public void alteraAluno(Aluno aluno) {
		for (Aluno alunoLocal : alunos) {
			if (aluno.getMatricula() == alunoLocal.getMatricula()) {
				alunoLocal.setMatricula(aluno.getMatricula());
				alunoLocal.setNome(aluno.getNome());
				alunoLocal.setCurso(aluno.getCurso());
			} 
		}
		serializaAlunos();
		deserializaAluno();

	}

	@Override
	public void removeAluno(int matricula) {
		Iterator<Aluno> alunoRemover = alunos.iterator();

        while(alunoRemover.hasNext()){

            if(alunoRemover.next().getMatricula() == matricula){
            	alunoRemover.remove();
            }
        }
        serializaAlunos();
		deserializaAluno();

	}

	@Override
	public List<Aluno> mostraAlunos() {

		return alunos;
	}
	
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
