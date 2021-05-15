package TCP.peer.review.Logic;

public class PeerReview {

	private Artigo artigo;
	private Pesquisador revisores;
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
		return revisores;
	}
	public void setRevisores(Pesquisador revisores) {
		this.revisores = revisores;
	}
	public Integer getNota() {
		return Nota;
	}
	public void setNota(int nota) {
		Nota = nota;
	}
	public PeerReview(Artigo artigo, Pesquisador revisores) {
		this.artigo = artigo;
		this.revisores = revisores;
	}
	public PeerReview(Artigo artigo, Pesquisador revisores, int nota) {
		this.artigo = artigo;
		this.revisores = revisores;
		Nota = nota;
	}
	
	public PeerReview(Artigo artigo, Pesquisador revisores, Conferencia conf) {
		this.artigo = artigo;
		this.revisores = revisores;
		this.conferencia = conf;
	}
	
	

		
}
