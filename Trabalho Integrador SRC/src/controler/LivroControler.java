package controler;

import java.io.*;
import java.util.*;

import modelo.*;

public class LivroControler {

	private List<Livro> livros = new ArrayList<Livro>();
	
	private static LivroControler livroControler = new LivroControler();
	
	private LivroControler(){
		
	}
	
	public static LivroControler getInstance() {
		return livroControler;
	}
	

	public void insereLivro(String titulo, String autor) {
		int codigoLivro = 1;
		int index = livros.size();
		if (index > 0) {
			index--;

			Livro UltimoAlunoLista = livros.get(index);
			codigoLivro = UltimoAlunoLista.getCodigo() + 1;
		}

		Livro livroInsere = new Livro(codigoLivro, titulo, autor);
		livros.add(livroInsere);
		
	}

	public void removeLivro(int codigo) {
		Iterator<Livro> LivroRemover = livros.iterator();

        while(LivroRemover.hasNext()){

            if(LivroRemover.next().getCodigo() == codigo){
            	LivroRemover.remove();
            }
        }
	}
	
	public List<Livro> MostraLivros() {
		return livros;
	}

	public Livro mostraLivro(int codigo) {
		Livro livro = new Livro(0, null, null);
		for (Livro livroLocal : livros) {
			if (codigo == livroLocal.getCodigo()) {
				livro = livroLocal;
			} 
		}
		return livro;
	}

	public void atualizaLivro(Livro livro) {
		for (Livro livroLocal : livros) {
			if (livro.getCodigo() == livroLocal.getCodigo()) {
				livroLocal.setCodigo(livro.getCodigo());
				livroLocal.setTitulo(livro.getTitulo());
				livroLocal.setExemplares(livro.getExemplares());
				
			} 
		}
	}

	public void insereExemplar(String localizacao, String edicao) {
		
	}

	public void removeExemplar(int codigo) {

	}
	
	public void serializaLivros() {
		File arquivo = new File("BibliotecaArquivos/Livros/Livros.bin");
		File pasta = new File("BibliotecaArquivos/Livros/");

		OutputStream escritorByte = null;
		ObjectOutputStream escritorObjeto = null;

		try {
			if (arquivo.exists() != true) {
				pasta.mkdir();
				arquivo.createNewFile();
			}

			arquivo.createNewFile();

			escritorByte = new FileOutputStream("BibliotecaArquivos/Livros/Livros.bin");
			escritorObjeto = new ObjectOutputStream(escritorByte);

			escritorObjeto.writeObject(livros);
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

		File arquivo = new File("BibliotecaArquivos/Livros/Livros.bin");

		boolean arquivoExiste = arquivo.exists();

		if (arquivoExiste) {
			InputStream leitorByte = null;
			ObjectInputStream leitorObjeto = null;

			try {
				leitorByte = new FileInputStream("BibliotecaArquivos/Livros/Livros.bin");
				leitorObjeto = new ObjectInputStream(leitorByte);

				livros = (ArrayList<Livro>) leitorObjeto.readObject();

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
