package controler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import modelo.*;

public class AluguelControler {
	private List<Aluguel> locates = new ArrayList<Aluguel>();

	private static AluguelControler aluguelControler = new AluguelControler();

	private AluguelControler() {

	}

	public static AluguelControler getInstance() {
		return aluguelControler;
	}

	public void AlugaLivro(Usuario usuario, Livro livro, Exemplar exemplar) {
		int codigoAluguel = 1;
		int index = locates.size();
		if (index > 0) {
			index--;
			Aluguel UltimoAluguelLista = locates.get(index);
			codigoAluguel = UltimoAluguelLista.getIdAluguel() + 1;
		}

		Aluguel aluguel = new Aluguel();
		aluguel.setIdAluguel(codigoAluguel);
		aluguel.setUsuario(usuario);
		aluguel.setLivro(livro);
		aluguel.setExemplar(exemplar);
	}

	public void DevolveLivro(int idAluguel) {
		Iterator<Aluguel> devolveLivro = locates.iterator();

		while (devolveLivro.hasNext()) {

			if (devolveLivro.next().getIdAluguel() == idAluguel) {
				devolveLivro.remove();
			}
		}
	}
	
	public Aluguel mostraALuguel(int idAluguel){
		Aluguel aluguel = new Aluguel();
		for (Aluguel aluguelLocal : locates) {
			if (idAluguel == aluguelLocal.getIdAluguel()) {
				aluguel = aluguelLocal;
			} 
		}
		return aluguel;
	}

	public List<Aluguel> MostraExemplaresLocados() {
		return locates;
	}

	public void serializaAluguel() {
		File arquivo = new File("BibliotecaArquivos/Aluguel/Aluguel.bin");
		File pasta = new File("BibliotecaArquivos/Aluguel/");

		OutputStream escritorByte = null;
		ObjectOutputStream escritorObjeto = null;

		try {
			if (arquivo.exists() != true) {
				pasta.mkdir();
				arquivo.createNewFile();
			}

			arquivo.createNewFile();

			escritorByte = new FileOutputStream("BibliotecaArquivos/Aluguel/Aluguel.bin");
			escritorObjeto = new ObjectOutputStream(escritorByte);

			escritorObjeto.writeObject(locates);
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

		File arquivo = new File("BibliotecaArquivos/Aluguel/Aluguel.bin");

		boolean arquivoExiste = arquivo.exists();

		if (arquivoExiste) {
			InputStream leitorByte = null;
			ObjectInputStream leitorObjeto = null;

			try {
				leitorByte = new FileInputStream("BibliotecaArquivos/Aluguel/Aluguel.bin");
				leitorObjeto = new ObjectInputStream(leitorByte);

				locates = (ArrayList<Aluguel>) leitorObjeto.readObject();

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
