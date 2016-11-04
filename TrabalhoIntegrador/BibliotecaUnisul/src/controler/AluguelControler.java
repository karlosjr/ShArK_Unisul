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
		
		locates.add(aluguel);
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

	
}
