package TCP.peer.review.Database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import TCP.peer.review.Logic.Artigo;
import TCP.peer.review.Logic.Conferencia;
import TCP.peer.review.Logic.Pesquisador;



public class Database {
	
	private final Map<Integer, Pesquisador> pesquisadores;
	private final Map<Integer, Artigo> artigos;
	private final Map<Integer, Conferencia> conferencias;
	private final Afiliacoes AfiliacoesMap = new Afiliacoes();
	private final Topicos TopicosMap = new Topicos();
	
	//Topicos keys
	//0 = Modularity, 1 = Software Reuse, 2 = Aspect-oriented Programming, 3 = Software Product Lines,
	//4 = Software Achitecture, 5 = Software Testing, 6 = Software Quality
	
	//Universidades keys
	//0 = UFRGS, 1 = USP, 2 = UFRJ
	public Database() {
		this.pesquisadores = initPesquisadores();
		this.conferencias = initConferencias();
		this.artigos = initArtigos();

		//Atualiza as conferências devido ao relacionamento circular entre Artigos e Conferencias
		for(int ind = 1; ind <= conferencias.size() ; ind++ ) {
			
		
			for(int indj = 1; indj <= artigos.size(); indj++) {
			
				if(artigos.get(indj).getConferência().equals(conferencias.get(ind))) {
					conferencias.get(ind).addArtigosToList(artigos.get(indj));
					}
			}
		}
		
		
	}

	
	private Map<Integer,Pesquisador> initPesquisadores()
	{
		int id = 1;
		Map<Integer, Pesquisador> Pesquisadores = new HashMap<>();
		
	    ArrayList<Integer> TopicosList = new ArrayList<>();
						
		TopicosList.add(3);	TopicosList.add(1);	TopicosList.add(0);
		Pesquisador p1 = new Pesquisador(id++, "João",AfiliacoesMap.GetUniversidade(0),TopicosMap.GetTopicos(TopicosList));
		Pesquisadores.put(1, p1);
		TopicosList.clear();
				
		
		TopicosList.add(4);	TopicosList.add(0);	TopicosList.add(1);
		Pesquisador p2 = new Pesquisador(id++,"Ana",AfiliacoesMap.GetUniversidade(1),TopicosMap.GetTopicos(TopicosList));
		Pesquisadores.put(2, p2);
		TopicosList.clear();
		
		TopicosList.add(3);	TopicosList.add(5);
		Pesquisador p3 = new Pesquisador(id++, "Manoel",AfiliacoesMap.GetUniversidade(0),TopicosMap.GetTopicos(TopicosList));
		Pesquisadores.put(3, p3);
		TopicosList.clear();
		
		TopicosList.add(3);	TopicosList.add(1);	TopicosList.add(2);	TopicosList.add(5);
		Pesquisador p4 = new Pesquisador(id++, 	"Joana",AfiliacoesMap.GetUniversidade(2),TopicosMap.GetTopicos(TopicosList));
		Pesquisadores.put(4, p4);
		TopicosList.clear();
		
		TopicosList.add(0);	TopicosList.add(4);	TopicosList.add(5);	
		Pesquisador p5 = new Pesquisador(id++, 	"Miguel",AfiliacoesMap.GetUniversidade(0),TopicosMap.GetTopicos(TopicosList));
		Pesquisadores.put(5, p5);
		TopicosList.clear();
		
		TopicosList.add(1);	TopicosList.add(2);	TopicosList.add(5);	
		Pesquisador p6 = new Pesquisador(id++, 	"Beatriz",	AfiliacoesMap.GetUniversidade(2),TopicosMap.GetTopicos(TopicosList));
		Pesquisadores.put(6, p6);
		TopicosList.clear();
		
		TopicosList.add(0);	TopicosList.add(1);	TopicosList.add(2);
		Pesquisador p7 = new Pesquisador(id++, 	"Suzana",AfiliacoesMap.GetUniversidade(0),	TopicosMap.GetTopicos(TopicosList));
		Pesquisadores.put(7, p7);
		TopicosList.clear();
		
		TopicosList.add(0);	TopicosList.add(1);	TopicosList.add(6);	TopicosList.add(3);		
		Pesquisador p8 = new Pesquisador(id++, 	"Natasha",AfiliacoesMap.GetUniversidade(2),	TopicosMap.GetTopicos(TopicosList));
		Pesquisadores.put(8, p8);
		TopicosList.clear();
		
		TopicosList.add(2);	TopicosList.add(4);		
		Pesquisador p9 = new Pesquisador(id++, 	"Pedro",AfiliacoesMap.GetUniversidade(1),TopicosMap.GetTopicos(TopicosList));
		Pesquisadores.put(9, p9);
		TopicosList.clear();
		
		TopicosList.add(3);	TopicosList.add(5);		
		Pesquisador p10 = new Pesquisador(id++, "Carlos",AfiliacoesMap.GetUniversidade(1),TopicosMap.GetTopicos(TopicosList));
		Pesquisadores.put(10,p10);
		TopicosList.clear();
		
		return Pesquisadores;
		
	}
	
	private Map<Integer,Conferencia> initConferencias()
	{
		Map<Integer,Conferencia> ConferenciaList = new HashMap<>();
		
		ArrayList<Pesquisador> Comite = new ArrayList<>();	
		Comite.add(pesquisadores.get(1)); Comite.add(pesquisadores.get(2)); Comite.add(pesquisadores.get(3)); Comite.add(pesquisadores.get(4));
		Comite.add(pesquisadores.get(5)); Comite.add(pesquisadores.get(6)); Comite.add(pesquisadores.get(7));
		Conferencia c1 = new Conferencia("ICSE", null, Comite);
		ConferenciaList.put(1, c1);
		
		ArrayList<Pesquisador> Comite2 = new ArrayList<>();
		Comite2.add(pesquisadores.get(1)); Comite2.add(pesquisadores.get(2)); Comite2.add(pesquisadores.get(3)); Comite2.add(pesquisadores.get(4));
		Comite2.add(pesquisadores.get(5)); Comite2.add(pesquisadores.get(6)); Comite2.add(pesquisadores.get(7));
		Conferencia c2 = new Conferencia("FSE", null, Comite2);
		ConferenciaList.put(2, c2);
		
		
	
		ArrayList<Pesquisador> Comite3 = new ArrayList<>();
		Comite3.add(pesquisadores.get(4)); Comite3.add(pesquisadores.get(5)); Comite3.add(pesquisadores.get(6)); Comite3.add(pesquisadores.get(7));
		Comite3.add(pesquisadores.get(8)); Comite3.add(pesquisadores.get(9)); Comite3.add(pesquisadores.get(10));
		Conferencia c3 = new Conferencia("SBES", null, Comite3);
		ConferenciaList.put(3, c3);
		

		
		
		return ConferenciaList;
	}
	
	private Map<Integer,Artigo> initArtigos()
	{
		Map<Integer,Artigo> ArtigoList = new HashMap<>();
		int id = 1;
		Artigo a1 = new Artigo(id++, "Coupling and Cohesion", pesquisadores.get(1), conferencias.get(3), TopicosMap.GetTopico(0));
		ArtigoList.put(1, a1);
		Artigo a2 = new Artigo(id++, "Design Patterns", pesquisadores.get(6), conferencias.get(2), TopicosMap.GetTopico(1));
		ArtigoList.put(2, a2);
		Artigo a3 = new Artigo(id++, "AspectJ", pesquisadores.get(7), conferencias.get(2), TopicosMap.GetTopico(2));
		ArtigoList.put(3, a3);
		Artigo a4 = new Artigo(id++, "Feature Model", pesquisadores.get(8), conferencias.get(2), TopicosMap.GetTopico(3));
		ArtigoList.put(4, a4);
		Artigo a5 = new Artigo(id++, "Architecture Recovery", pesquisadores.get(9), conferencias.get(2), TopicosMap.GetTopico(4));
		ArtigoList.put(5, a5);
		Artigo a6 = new Artigo(id++, "Functional Testing", pesquisadores.get(10), conferencias.get(2), TopicosMap.GetTopico(5));
		ArtigoList.put(6, a6);
		Artigo a7 = new Artigo(id++, "COTs", pesquisadores.get(6), conferencias.get(1), TopicosMap.GetTopico(1));
		ArtigoList.put(7, a7);
		Artigo a8 = new Artigo(id++, "Pointcut", pesquisadores.get(7), conferencias.get(1), TopicosMap.GetTopico(2));
		ArtigoList.put(8, a8);
		Artigo a9 = new Artigo(id++, "Product Derivation", pesquisadores.get(8), conferencias.get(1), TopicosMap.GetTopico(3));
		ArtigoList.put(9, a9);
		Artigo a10 = new Artigo(id++, "Architecture Comformance", pesquisadores.get(9), conferencias.get(1), TopicosMap.GetTopico(4));
		ArtigoList.put(10, a10);
		Artigo a11 = new Artigo(id++, "Structural Testing", pesquisadores.get(10), conferencias.get(1), TopicosMap.GetTopico(5));
		ArtigoList.put(11, a11);
		
		
		return ArtigoList;
		
	}
	
	
	//Debug
	public void printPesquisadores()
	{
		for(int ind = 1; ind <= this.pesquisadores.size(); ind++)
		{
			System.out.println(
					"Nome do Pesquisador " + this.pesquisadores.get(ind).getId() + " = " + this.pesquisadores.get(ind).getNome() + "\n" +
					"Afiliação = " + this.pesquisadores.get(ind).getAfiliacao() + "\n" +
					"Tópicos de Pesquisa = " + this.pesquisadores.get(ind).getTopicosDePesquisa() + "\n"
			);
			
		}
		
	}
	
	public void printConferencias()
	{
		for(int ind = 1; ind <= this.conferencias.size(); ind++)
		{
			ArrayList<String> MembrosComite = this.conferencias.get(ind).getComiteAsString();
			ArrayList<String> NomeArtigos = this.conferencias.get(ind).getArtigosSubmetidosAsString();

			
			System.out.println(
					"Conferência = " + this.conferencias.get(ind).getSigla() + "\n" +
				    "Membros = " + MembrosComite + "\n" + 
					"Artigos Submetidos = " + NomeArtigos + "\n" 
					);
					

			
			
		}
	}

	
	public void printArtigos()
	{
		for(int ind = 1; ind <= this.artigos.size(); ind++)
		{
			System.out.println(
					"Nome do Artigo = " + this.artigos.get(ind).getTitulo() + "\n" +
					"Autor = " + this.artigos.get(ind).getAutor().getNome() + "\n" +
					"Conferência = " + this.artigos.get(ind).getConferência().getSigla() + "\n" + 
					"Tópico = " + this.artigos.get(ind).getTopicoDePesquisa() + "\n"
					);
		}
	}
		
}




