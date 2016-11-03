package Arquivo;

import java.io.*;
import java.util.*;

import dao.LivroDao;
import modelo.*;

public class ArquivoLivroDao implements LivroDao {
	private List<Livro> livros = new ArrayList<Livro>();
	
	@Override
	public void insereLivro(Livro livro) {
		livros.add(livro);
		serializaLivros();
		deserializaLivros();
	}

	@Override
	public Livro consultaLivro(int codigo) {
		Livro livro = new Livro(0, null, null);
		for (Livro livroLocal : livros) {
			if (codigo == livroLocal.getCodigo()) {
				livro = livroLocal;
			} 
		}
		return livro;		
	}

	@Override
	public void alteraLivro(Livro livro) {
		
		for (Livro livroLocal : livros) {
			if (livro.getCodigo() == livroLocal.getCodigo()) {
				livroLocal.setCodigo(livro.getCodigo());
				livroLocal.setTitulo(livro.getTitulo());
				livroLocal.setExemplares(livro.getExemplares());
				
			} 
		}
		serializaLivros();
		deserializaLivros();

	}

	@Override
	public void removeLivro(int codigo) {
		Iterator<Livro> livroRemover = livros.iterator();

        while(livroRemover.hasNext()){

            if(livroRemover.next().getCodigo() == codigo){
            	livroRemover.remove();
            }
        }
        serializaLivros();
		deserializaLivros();

	}

	@Override
	public List<Livro> mostraLivro() {
		
		return livros;
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

	public void deserializaLivros() {

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
