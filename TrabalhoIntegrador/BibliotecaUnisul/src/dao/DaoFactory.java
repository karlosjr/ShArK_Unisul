package dao;

import Arquivo.ArquivoDaoFactory;

public abstract class DaoFactory {

	public static DaoFactory getDaoFactoy() {
		int flagFactory = 1;
		switch (flagFactory) {
		case 1:
			return new ArquivoDaoFactory();

		default:
			break;
		}

		return null;

	}

	public abstract AluguelDao getAluguelDao();

	public abstract AlunoDao getAlunoDao();

	public abstract LivroDao getlivroDao();

	public abstract ProfessorDao getProfessorDao();



}
