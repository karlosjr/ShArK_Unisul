package Arquivo;

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

import dao.AluguelDao;
import modelo.Aluguel;
import modelo.Aluno;

public class ArquivoAluguelDao implements AluguelDao {
	private List<Aluguel> locates = new ArrayList<Aluguel>();

	@Override
	public void insereAluguel(Aluguel aluguel) {
		locates.add(aluguel);

	}

	@Override
	public Aluguel consultaAluguel(int idAluguel) {
		for (Aluguel aluguelLocal : locates) {
			if (idAluguel == aluguelLocal.getIdAluguel()) {
				return aluguelLocal;
			}
		}
		return null;
	}

	@Override
	public void alteraAluguel(Aluguel aluguel) {
		for (Aluguel aluguelLocal : locates) {
			if (aluguel.getIdAluguel() == aluguelLocal.getIdAluguel()) {
				aluguelLocal.setIdAluguel(aluguel.getIdAluguel());
				aluguelLocal.setExemplar(aluguel.getExemplar());
				aluguelLocal.setLivro(aluguel.getLivro());
				aluguelLocal.setUsuario(aluguel.getUsuario());
			}
		}
	}

	@Override
	public void removeAluguel(int idAluguel) {
		Iterator<Aluguel> devolveLivro = locates.iterator();

		while (devolveLivro.hasNext()) {

			if (devolveLivro.next().getIdAluguel() == idAluguel) {
				devolveLivro.remove();
			}
		}

	}

	@Override
	public List<Aluguel> mostraAlugueis() {
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
