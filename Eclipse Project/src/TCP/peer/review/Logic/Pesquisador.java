package TCP.peer.review.Logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Pesquisador implements Comparable<Pesquisador> {
	private Integer id;
	private String nome;
	private String afiliacao;
	private ArrayList<String> TopicosDePesquisa;
	private int numArtigosAlocados;
	
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
	
	

	public void setNumArtigosAlocados(int numArtigosAlocados) {
		this.numArtigosAlocados = numArtigosAlocados;
	}


	public int getNumArtigosAlocados()
	{
		return numArtigosAlocados;
	}


	@Override
	public int compareTo(Pesquisador other) {
		int compareID = ((Pesquisador) other).getId();
		int compareNumArtigos = ((Pesquisador) other).getNumArtigosAlocados();
		
		if(this.numArtigosAlocados == compareNumArtigos) {
			return this.id-compareID + this.numArtigosAlocados-compareNumArtigos;
		}
			
		if(other.numArtigosAlocados > 0 || this.numArtigosAlocados > 0) {
			return this.numArtigosAlocados-compareNumArtigos;
		}
		else {

			return this.id-compareID + this.numArtigosAlocados-compareNumArtigos;
		}
		
			}
}
