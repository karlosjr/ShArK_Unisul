package Arquivo;

import dao.AluguelDao;
import dao.AlunoDao;
import dao.DaoFactory;
import dao.LivroDao;
import dao.ProfessorDao;

public class ArquivoDaoFactory extends DaoFactory{
	
	
	@Override
	public LivroDao getlivroDao() {
		return new ArquivoLivroDao();
	}

	@Override
	public AluguelDao getAluguelDao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AlunoDao getAlunoDao() {
		
		return new ArquivoAlunoDao();
	}

	@Override
	public ProfessorDao getProfessorDao() {

		return null;
	}

}
