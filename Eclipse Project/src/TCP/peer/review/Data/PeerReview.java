package TCP.peer.review.Data;

/**
 * Classe que representa o relacionamento Artigo x Revisor.
 * @author Mateus, Raul, Germano
 *
 */
public class PeerReview {

	private Artigo artigo;
	private Pesquisador revisor;
	private Conferencia conferencia;
	private Integer Nota = null;

	public Artigo getArtigo() {
		return artigo;
	}

	public void setArtigo(Artigo artigo) {
		this.artigo = artigo;
	}

	public Conferencia getConferencia() {
		return conferencia;
	}

	public void setConferencia(Conferencia conferencia) {
		this.conferencia = conferencia;
	}

	public Pesquisador getRevisores() {
		return revisor;
	}

	public void setRevisores(Pesquisador revisores) {
		this.revisor = revisores;
	}

	public Integer getNota() {
		return Nota;
	}

	public void setNota(int nota) {
		Nota = nota;
	}

	public PeerReview(Artigo artigo, Pesquisador revisores) {
		this.artigo = artigo;
		this.revisor = revisores;
	}

	public PeerReview(Artigo artigo, Pesquisador revisores, int nota) {
		this.artigo = artigo;
		this.revisor = revisores;
		Nota = nota;
	}

	public PeerReview(Artigo artigo, Pesquisador revisores, Conferencia conf) {
		this.artigo = artigo;
		this.revisor = revisores;
		this.conferencia = conf;
	}
	
	public PeerReview(Artigo artigo, Pesquisador revisor, Conferencia conf, Integer nota)
	{
		this.artigo = artigo;
		this.revisor = revisor;
		this.conferencia = conf;
		this.Nota = nota;
		
	}

}
