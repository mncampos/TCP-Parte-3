package TCP.peer.review.Logic;

import java.util.ArrayList;

public class Artigo {
	private Integer id;
	private String titulo;
	private Pesquisador autor;
	private Conferencia confer�ncia;
	private String TopicoDePesquisa;
	private ArrayList<Pesquisador> revisores = new ArrayList<>();

	public Artigo(Integer id, String titulo, Pesquisador autor, Conferencia confer�ncia, String TopicoDePesquisa) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.confer�ncia = confer�ncia;
		this.TopicoDePesquisa = TopicoDePesquisa;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Pesquisador getAutor() {
		return autor;
	}

	public void setAutor(Pesquisador autor) {
		this.autor = autor;
	}

	public Conferencia getConfer�ncia() {
		return confer�ncia;
	}

	public void setConfer�ncia(Conferencia confer�ncia) {
		this.confer�ncia = confer�ncia;
	}

	public String getTopicoDePesquisa() {
		return TopicoDePesquisa;
	}

	public void setTopicoDePesquisa(String topicoDePesquisa) {
		TopicoDePesquisa = topicoDePesquisa;
	}

	public ArrayList<Pesquisador> getRevisores() {
		return revisores;
	}

	public int qtdeRevisores() {
		return revisores.size();
	}

	public boolean podeAvaliar(Pesquisador pesquisador) {
		if (pesquisador.equals(this.autor)
				|| pesquisador.getAfiliacao().equals(this.autor.getAfiliacao())
				|| contemplaTopico(pesquisador)
				|| pesquisador.getArtigosAlocados().contains(this)) {
			return false;
		}
		return true;
	}

	public boolean contemplaTopico(Pesquisador pesquisador) {
		for (int i = 0; i < pesquisador.getTopicosDePesquisa().size(); i++) {
			if (pesquisador.getTopicosDePesquisa().get(i).equals(this.TopicoDePesquisa)) {
				return true;
			}
		}
		return false;
	}

}
