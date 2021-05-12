package TCP.peer.review.Logic;

import java.util.ArrayList;

import TCP.peer.review.Database.Afiliacoes;

public class Pesquisador {
	private Integer id;
	private String nome;
	private String afiliacao;
	private ArrayList<String> TopicosDePesquisa;
	


	public Pesquisador(Integer id, String nome, String afiliacao, ArrayList<String> topicosDePesquisa) {
		this.id = id;
		this.nome = nome;
		this.afiliacao = afiliacao;
		TopicosDePesquisa = topicosDePesquisa;
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAfiliacao() {
		return afiliacao;
	}

	public void setAfiliacao(String afiliacao) {
		this.afiliacao = afiliacao;
	}

	public ArrayList<String> getTopicosDePesquisa() {
		return TopicosDePesquisa;
	}

	public void setTopicosDePesquisa(ArrayList<String> topicosDePesquisa) {
		TopicosDePesquisa = topicosDePesquisa;
	}
	
	

}
