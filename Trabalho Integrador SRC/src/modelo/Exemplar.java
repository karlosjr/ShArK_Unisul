package modelo;

import java.io.Serializable;

public class Exemplar {

	private int codigo;
	private String localizacao;
	private String edicao;
	private Boolean status;
	private Livro livro;

	public int getCodigo() {

		return codigo;
	}

	public void setCodigo(int codigo) {

		this.codigo = codigo;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public String getEdicao() {
		return edicao;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Exemplar(int codigo, String localizacao, String edicao, Livro livro) {
		this.setCodigo(codigo);
		this.setLocalizacao(localizacao);
		this.setEdicao(edicao);
		this.setLivro(livro);
	}

}
