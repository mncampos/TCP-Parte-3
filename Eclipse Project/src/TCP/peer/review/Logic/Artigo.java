package TCP.peer.review.Logic;

import java.util.ArrayList;

public class Artigo {
	private Integer id;
	private String titulo;
	private Pesquisador autor;
	private Conferencia conferência;
	private String TopicoDePesquisa;

	public Artigo(Integer id, String titulo, Pesquisador autor, Conferencia conferência, String TopicoDePesquisa) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.conferência = conferência;
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

	public Conferencia getConferência() {
		return conferência;
	}

	public void setConferência(Conferencia conferência) {
		this.conferência = conferência;
	}

	public String getTopicoDePesquisa() {
		return TopicoDePesquisa;
	}

	public void setTopicoDePesquisa(String topicoDePesquisa) {
		TopicoDePesquisa = topicoDePesquisa;
	}




}
