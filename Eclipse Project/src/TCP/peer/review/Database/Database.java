package TCP.peer.review.Database;

import java.util.HashMap;
import java.util.Map;

import TCP.peer.review.Logic.Artigo;
import TCP.peer.review.Logic.Conferencia;
import TCP.peer.review.Logic.Pesquisador;

public class Database {
	
	private final Map<Integer, Pesquisador> pesquisadores;
	private final Map<Integer, Artigo> artigos;
	private final Map<String, Conferencia> conferencias;
	
	public Database() {
		this.pesquisadores = new HashMap<>();
		this.artigos = new HashMap<>();
		this.conferencias = new HashMap<>();
	}

	public Map<Integer, Pesquisador> getPesquisadores() {
		return pesquisadores;
	}

	public Map<Integer, Artigo> getArtigos() {
		return artigos;
	}

	public Map<String, Conferencia> getConferencias() {
		return conferencias;
	}
	
	
	private void initData() {

		try {
			
			//Inicializa pesquisadores
			int idPesquisador = 1;
			Pesquisador p1 = new Pesquisador(idPesquisador);
			save(p1);
			Pesquisador p2 = new Pesquisador(idPesquisador++);
			save(p2);
			Pesquisador p3 = new Pesquisador(idPesquisador++);
			save(p3);
			Pesquisador p4 = new Pesquisador(idPesquisador++);
			save(p4);
			Pesquisador p5 = new Pesquisador(idPesquisador++);
			save(p5);
			Pesquisador p6 = new Pesquisador(idPesquisador++);
			save(p6);
			Pesquisador p7 = new Pesquisador(idPesquisador++);
			save(p7);
			Pesquisador p8 = new Pesquisador(idPesquisador++);
			save(p8);
			Pesquisador p9 = new Pesquisador(idPesquisador++);
			save(p9);
			Pesquisador p10 = new Pesquisador(idPesquisador++);
			save(p10);
			
			//Inicializa conferências
			Conferencia c1 = new Conferencia();
			Conferencia c2 = new Conferencia();
			Conferencia c3 = new Conferencia();
			
			//Inicializa artigos
			int idArtigo = 1;
			Artigo a1 = new Artigo(idArtigo);
			save(a1);
			Artigo a2 = new Artigo(idArtigo++);
			save(a2);
			Artigo a3 = new Artigo(idArtigo++);
			save(a3);
			Artigo a4 = new Artigo(idArtigo++);
			save(a4);
			Artigo a5 = new Artigo(idArtigo++);
			save(a5);
			Artigo a6 = new Artigo(idArtigo++);
			save(a6);
			Artigo a7 = new Artigo(idArtigo++);
			save(a7);
			Artigo a8 = new Artigo(idArtigo++);
			save(a8);
			Artigo a9 = new Artigo(idArtigo++);
			save(a9);
			Artigo a10 = new Artigo(idArtigo++);
			save(a10);
			Artigo a11 = new Artigo(idArtigo++);
			save(a11);	
		} catch(Exception e) {
			e.printStackTrace();
		}
			
		
	}
	
	public void save(Pesquisador pesquisador) {
		this.pesquisadores.put(pesquisador.getId(), pesquisador);
	}

	public void save(Artigo artigo) {
		this.artigos.put(artigo.getId(), artigo);
	}
		
}




