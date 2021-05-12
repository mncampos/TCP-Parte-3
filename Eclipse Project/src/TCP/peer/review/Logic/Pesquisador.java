package TCP.peer.review.Logic;

import java.util.ArrayList;

public class Pesquisador implements Comparable<Pesquisador> {
	private Integer id;
	private String nome;
	private String afiliacao;
	private ArrayList<String> TopicosDePesquisa;
	private ArrayList<Artigo> artigosAlocados = new ArrayList<>();
	


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
	
	public ArrayList<Artigo> getArtigosAlocados(){
		return artigosAlocados;
	}
	
	public int qtdeArtigosAlocados() {
		return artigosAlocados.size();
	}

	@Override
	public int compareTo(Pesquisador other) {
		
		return Integer.toString(this.qtdeArtigosAlocados()).compareTo(Integer.toString(other.qtdeArtigosAlocados()));

	}
}
