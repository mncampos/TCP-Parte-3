package TCP.peer.review.Logic;

import java.util.ArrayList;

public class Conferencia {
	
	private String sigla;
	private ArrayList<Artigo> ArtigosSubmetidos;
	private ArrayList<Pesquisador> Comitê;
	
	
	public Conferencia(String sigla, ArrayList<Artigo> ArtigosSubmetidos, ArrayList<Pesquisador> Comitê)
	{
		this.sigla = sigla;
		this.ArtigosSubmetidos = ArtigosSubmetidos;
		this.Comitê = Comitê;
	}
	

	public String getSigla() {
		return sigla;
	}


	public void setSigla(String sigla) {
		this.sigla = sigla;
	}


	public ArrayList<Artigo> getArtigosSubmetidos() {
		return ArtigosSubmetidos;
	}

	public ArrayList<String> getArtigosSubmetidosAsString() {
		ArrayList<String> NomeArtigos = new ArrayList<>();
		
		for(Artigo a : this.ArtigosSubmetidos)
			NomeArtigos.add(a.getTitulo());
		
		return NomeArtigos;
	}

	public ArrayList<Pesquisador> getComitê() {
		return Comitê;
	}


	public void setArtigosSubmetidos(ArrayList<Artigo> artigosSubmetidos) {
		ArtigosSubmetidos = artigosSubmetidos;
	}

	public void addArtigosToList(Artigo artigo)
	{
		if(this.ArtigosSubmetidos == null)
			this.ArtigosSubmetidos = new ArrayList<Artigo>();
		
		
		
		ArtigosSubmetidos.add(artigo);
	}

	
	
	public ArrayList<String> getComiteAsString() {
		
		ArrayList<String> MembrosComite = new ArrayList<>();
		
		for(Pesquisador p : this.Comitê)
			MembrosComite.add(p.getNome());
		
		return MembrosComite;
	}


	public void setComitê(ArrayList<Pesquisador> comitê) {
		Comitê = comitê;
	}
	
	
	
}
