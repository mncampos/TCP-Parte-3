package TCP.peer.review.Logic;

import java.util.ArrayList;

import TCP.peer.review.Database.Database;

public class PeerReview {

	private Artigo artigo;
	private Pesquisador revisores;
	private int Nota;
	
	public Artigo getArtigo() {
		return artigo;
	}
	public void setArtigo(Artigo artigo) {
		this.artigo = artigo;
	}
	public Pesquisador getRevisores() {
		return revisores;
	}
	public void setRevisores(Pesquisador revisores) {
		this.revisores = revisores;
	}
	public int getNota() {
		return Nota;
	}
	public void setNota(int nota) {
		Nota = nota;
	}
	public PeerReview(Artigo artigo, Pesquisador revisores) {
		this.artigo = artigo;
		this.revisores = revisores;
	}
	
	

		
}
