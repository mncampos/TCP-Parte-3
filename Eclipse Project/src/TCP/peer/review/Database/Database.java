package TCP.peer.review.Database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import TCP.peer.review.Data.Artigo;
import TCP.peer.review.Data.Conferencia;
import TCP.peer.review.Data.PeerReview;
import TCP.peer.review.Data.Pesquisador;
import TCP.peer.review.Implementation.AlocaArtigo;

/**
 * Classe que representa o banco de dados. Foi utilizado o modelo singleton, visto que s? h? uma database no programa inteiro.
 * Para cham?-la, usa-se o m?todo Database.getInstance().
 * @author Mateus, Raul, Germano
 *
 */
public class Database {

	// Clase singleton
	private static Database db;

	private final Map<Integer, Pesquisador> pesquisadores;
	private final Map<Integer, Artigo> artigos;
	private final Map<Integer, Conferencia> conferencias;
	private final Afiliacoes AfiliacoesMap = new Afiliacoes();
	private final Topicos TopicosMap = new Topicos();
	private Map<Conferencia, ArrayList<PeerReview>> Alocacoes = new HashMap<Conferencia, ArrayList<PeerReview>>();

	// Topicos keys
	// 0 = Modularity, 1 = Software Reuse, 2 = Aspect-oriented Programming, 3 =
	// Software Product Lines,
	// 4 = Software Achitecture, 5 = Software Testing, 6 = Software Quality


	public Map<Conferencia, ArrayList<PeerReview>> getAlocacoesMap() {
		return Alocacoes;
	}
	

	public ArrayList<PeerReview> getAlocacoes(Conferencia key) {
		return Alocacoes.get(key);
	}

	public void addAlocacoes(Conferencia conf, ArrayList<PeerReview> list) {
		Alocacoes.put(conf, list);
	}

	public void setAlocacoes(Map<Conferencia, ArrayList<PeerReview>> alocacoes) {
		Alocacoes = alocacoes;
	}

	public ArrayList<PeerReview> MergeAlocacoes()
	{
		ArrayList<PeerReview> mergedList = new ArrayList<>();
		int k = 1;
		int i = 1;

		while (k <= Alocacoes.size()) {
			if (!(Alocacoes.get(conferencias.get(i)) == null)) {
				mergedList.addAll(Alocacoes.get(conferencias.get(i)));
				k++;
				i++;
			} else {
				i++;
				continue;
			}
		}

		return mergedList;
	}

	public int getAlocacoesListTotalSize() {
		int total = 0;

		int k = 1;
		int i = 1;

		while (k <= Alocacoes.size()) {

			if (!(Alocacoes.get(conferencias.get(i)) == null)) {
				total += Alocacoes.get(conferencias.get(i)).size();
				k++;
				i++;
			} else {

				i++;
				continue;
			}
		}

		return total;
	}

	public Pesquisador getPesquisador(int key) {
		return pesquisadores.get(key);
	}

	public Map<Integer, Pesquisador> getPesquisadores() {
		return pesquisadores;
	}

	public Map<Integer, Artigo> getArtigos() {
		return artigos;
	}

	public Map<Integer, Conferencia> getConferencias() {
		return conferencias;
	}

	public Artigo getArtigo(int key) {
		return artigos.get(key);
	}

	public Conferencia getConferencias(int key) {
		return conferencias.get(key);
	}

	// Universidades keys
	// 0 = UFRGS, 1 = USP, 2 = UFRJ
	public Database() {
		this.pesquisadores = initPesquisadores();
		this.conferencias = initConferencias();
		this.artigos = initArtigos();

		// Atualiza as confer?ncias devido ao relacionamento circular entre Artigos e
		// Conferencias
		for (int ind = 1; ind <= conferencias.size(); ind++) {

			for (int indj = 1; indj <= artigos.size(); indj++) {

				if (artigos.get(indj).getConfer?ncia().equals(conferencias.get(ind))) {
					conferencias.get(ind).addArtigosToList(artigos.get(indj));
				}
			}
		}

		// Aloca as confer?ncias iniciais
		ArrayList<PeerReview> alocacoesIniciais = new ArrayList<>();
		alocacoesIniciais.add(new PeerReview(artigos.get(1), pesquisadores.get(8), conferencias.get(3), 2));
		alocacoesIniciais.add(new PeerReview(artigos.get(1), pesquisadores.get(10), conferencias.get(3), null));
		Alocacoes.put(conferencias.get(3), alocacoesIniciais);
		
		
		alocacoesIniciais = new ArrayList<>();
		
		alocacoesIniciais.add(new PeerReview(artigos.get(2), pesquisadores.get(7), conferencias.get(2), 2));
		alocacoesIniciais.add(new PeerReview(artigos.get(2), pesquisadores.get(2), conferencias.get(2), 3));
		alocacoesIniciais.add(new PeerReview(artigos.get(3), pesquisadores.get(4), conferencias.get(2), -1));
		alocacoesIniciais.add(new PeerReview(artigos.get(3), pesquisadores.get(6), conferencias.get(2), 1));
		alocacoesIniciais.add(new PeerReview(artigos.get(4), pesquisadores.get(1), conferencias.get(2), 1));
		alocacoesIniciais.add(new PeerReview(artigos.get(4), pesquisadores.get(3), conferencias.get(2), 0));
		alocacoesIniciais.add(new PeerReview(artigos.get(5), pesquisadores.get(4), conferencias.get(2), -3));
		alocacoesIniciais.add(new PeerReview(artigos.get(5), pesquisadores.get(5), conferencias.get(2), -3));
		alocacoesIniciais.add(new PeerReview(artigos.get(6), pesquisadores.get(3), conferencias.get(2), -1));
		alocacoesIniciais.add(new PeerReview(artigos.get(6), pesquisadores.get(6), conferencias.get(2), 0));
		
		Alocacoes.put(conferencias.get(2), alocacoesIniciais);
		
		alocacoesIniciais = null;

	}

	private Map<Integer, Pesquisador> initPesquisadores() {
		int id = 1;
		Map<Integer, Pesquisador> Pesquisadores = new HashMap<>();

		ArrayList<Integer> TopicosList = new ArrayList<>();

		TopicosList.add(3);
		TopicosList.add(1);
		TopicosList.add(0);
		Pesquisador p1 = new Pesquisador(id++, "Jo?o", AfiliacoesMap.GetUniversidade(0),
				TopicosMap.GetTopicos(TopicosList));
		Pesquisadores.put(1, p1);
		TopicosList.clear();

		TopicosList.add(4);
		TopicosList.add(0);
		TopicosList.add(1);
		Pesquisador p2 = new Pesquisador(id++, "Ana", AfiliacoesMap.GetUniversidade(1),
				TopicosMap.GetTopicos(TopicosList));
		Pesquisadores.put(2, p2);
		TopicosList.clear();

		TopicosList.add(3);
		TopicosList.add(5);
		Pesquisador p3 = new Pesquisador(id++, "Manoel", AfiliacoesMap.GetUniversidade(0),
				TopicosMap.GetTopicos(TopicosList));
		Pesquisadores.put(3, p3);
		TopicosList.clear();

		TopicosList.add(3);
		TopicosList.add(1);
		TopicosList.add(4);
		TopicosList.add(2);
		Pesquisador p4 = new Pesquisador(id++, "Joana", AfiliacoesMap.GetUniversidade(2),
				TopicosMap.GetTopicos(TopicosList));
		Pesquisadores.put(4, p4);
		TopicosList.clear();

		TopicosList.add(0);
		TopicosList.add(4);
		TopicosList.add(5);
		Pesquisador p5 = new Pesquisador(id++, "Miguel", AfiliacoesMap.GetUniversidade(0),
				TopicosMap.GetTopicos(TopicosList));
		Pesquisadores.put(5, p5);
		TopicosList.clear();

		TopicosList.add(1);
		TopicosList.add(2);
		TopicosList.add(5);
		Pesquisador p6 = new Pesquisador(id++, "Beatriz", AfiliacoesMap.GetUniversidade(2),
				TopicosMap.GetTopicos(TopicosList));
		Pesquisadores.put(6, p6);
		TopicosList.clear();

		TopicosList.add(0);
		TopicosList.add(1);
		TopicosList.add(2);
		Pesquisador p7 = new Pesquisador(id++, "Suzana", AfiliacoesMap.GetUniversidade(0),
				TopicosMap.GetTopicos(TopicosList));
		Pesquisadores.put(7, p7);
		TopicosList.clear();

		TopicosList.add(0);
		TopicosList.add(1);
		TopicosList.add(6);
		TopicosList.add(3);
		Pesquisador p8 = new Pesquisador(id++, "Natasha", AfiliacoesMap.GetUniversidade(2),
				TopicosMap.GetTopicos(TopicosList));
		Pesquisadores.put(8, p8);
		TopicosList.clear();

		TopicosList.add(2);
		TopicosList.add(4);
		Pesquisador p9 = new Pesquisador(id++, "Pedro", AfiliacoesMap.GetUniversidade(1),
				TopicosMap.GetTopicos(TopicosList));
		Pesquisadores.put(9, p9);
		TopicosList.clear();

		TopicosList.add(1);
		TopicosList.add(0);
		TopicosList.add(5);
		Pesquisador p10 = new Pesquisador(id++, "Carlos", AfiliacoesMap.GetUniversidade(1),
				TopicosMap.GetTopicos(TopicosList));
		Pesquisadores.put(10, p10);
		TopicosList.clear();

		return Pesquisadores;

	}

	private Map<Integer, Conferencia> initConferencias() {
		Map<Integer, Conferencia> ConferenciaList = new HashMap<>();

		ArrayList<Pesquisador> Comite = new ArrayList<>();
		Comite.add(pesquisadores.get(1));
		Comite.add(pesquisadores.get(2));
		Comite.add(pesquisadores.get(3));
		Comite.add(pesquisadores.get(4));
		Comite.add(pesquisadores.get(5));
		Comite.add(pesquisadores.get(6));
		Comite.add(pesquisadores.get(7));
		Conferencia c1 = new Conferencia("ICSE", null, Comite);
		ConferenciaList.put(1, c1);

		ArrayList<Pesquisador> Comite2 = new ArrayList<>();
		Comite2.add(pesquisadores.get(1));
		Comite2.add(pesquisadores.get(2));
		Comite2.add(pesquisadores.get(3));
		Comite2.add(pesquisadores.get(4));
		Comite2.add(pesquisadores.get(5));
		Comite2.add(pesquisadores.get(6));
		Comite2.add(pesquisadores.get(7));
		Conferencia c2 = new Conferencia("FSE", null, Comite2);
		ConferenciaList.put(2, c2);

		ArrayList<Pesquisador> Comite3 = new ArrayList<>();
		Comite3.add(pesquisadores.get(4));
		Comite3.add(pesquisadores.get(5));
		Comite3.add(pesquisadores.get(6));
		Comite3.add(pesquisadores.get(7));
		Comite3.add(pesquisadores.get(8));
		Comite3.add(pesquisadores.get(9));
		Comite3.add(pesquisadores.get(10));
		Conferencia c3 = new Conferencia("SBES", null, Comite3);
		ConferenciaList.put(3, c3);

		return ConferenciaList;
	}

	private Map<Integer, Artigo> initArtigos() {
		Map<Integer, Artigo> ArtigoList = new HashMap<>();
		int id = 1;
		Artigo a1 = new Artigo(id++, "Coupling and Cohesion", pesquisadores.get(1), conferencias.get(3),
				TopicosMap.GetTopico(0));
		ArtigoList.put(1, a1);
		Artigo a2 = new Artigo(id++, "Design Patterns", pesquisadores.get(6), conferencias.get(2),
				TopicosMap.GetTopico(1));
		ArtigoList.put(2, a2);
		Artigo a3 = new Artigo(id++, "AspectJ", pesquisadores.get(7), conferencias.get(2), TopicosMap.GetTopico(2));
		ArtigoList.put(3, a3);
		Artigo a4 = new Artigo(id++, "Feature Model", pesquisadores.get(8), conferencias.get(2),
				TopicosMap.GetTopico(3));
		ArtigoList.put(4, a4);
		Artigo a5 = new Artigo(id++, "Architecture Recovery", pesquisadores.get(9), conferencias.get(2),
				TopicosMap.GetTopico(4));
		ArtigoList.put(5, a5);
		Artigo a6 = new Artigo(id++, "Functional Testing", pesquisadores.get(10), conferencias.get(2),
				TopicosMap.GetTopico(5));
		ArtigoList.put(6, a6);
		Artigo a7 = new Artigo(id++, "COTs", pesquisadores.get(6), conferencias.get(1), TopicosMap.GetTopico(1));
		ArtigoList.put(7, a7);
		Artigo a8 = new Artigo(id++, "Pointcut", pesquisadores.get(7), conferencias.get(1), TopicosMap.GetTopico(2));
		ArtigoList.put(8, a8);
		Artigo a9 = new Artigo(id++, "Product Derivation", pesquisadores.get(8), conferencias.get(1),
				TopicosMap.GetTopico(3));
		ArtigoList.put(9, a9);
		Artigo a10 = new Artigo(id++, "Architecture Comformance", pesquisadores.get(9), conferencias.get(1),
				TopicosMap.GetTopico(4));
		ArtigoList.put(10, a10);
		Artigo a11 = new Artigo(id++, "Structural Testing", pesquisadores.get(10), conferencias.get(1),
				TopicosMap.GetTopico(5));
		ArtigoList.put(11, a11);

		return ArtigoList;

	}

	// Singleton
	public static synchronized Database getInstance() {
		if (db == null)
			db = new Database();

		return db;

	}

	// Debug
	public void printPesquisadores() {
		for (int ind = 1; ind <= this.pesquisadores.size(); ind++) {
			System.out.println("Nome do Pesquisador " + this.pesquisadores.get(ind).getId() + " = "
					+ this.pesquisadores.get(ind).getNome() + "\n" + "Afilia??o = "
					+ this.pesquisadores.get(ind).getAfiliacao() + "\n" + "T?picos de Pesquisa = "
					+ this.pesquisadores.get(ind).getTopicosDePesquisa() + "\n");

		}

	}

	public void printConferencias() {
		for (int ind = 1; ind <= this.conferencias.size(); ind++) {
			ArrayList<String> MembrosComite = this.conferencias.get(ind).getComiteAsString();
			ArrayList<String> NomeArtigos = this.conferencias.get(ind).getArtigosSubmetidosAsString();

			System.out.println("Confer?ncia = " + this.conferencias.get(ind).getSigla() + "\n" + "Membros = "
					+ MembrosComite + "\n" + "Artigos Submetidos = " + NomeArtigos + "\n");

		}
	}

	public void printArtigos() {
		for (int ind = 1; ind <= this.artigos.size(); ind++) {
			System.out.println("Nome do Artigo = " + this.artigos.get(ind).getTitulo() + "\n" + "Autor = "
					+ this.artigos.get(ind).getAutor().getNome() + "\n" + "Confer?ncia = "
					+ this.artigos.get(ind).getConfer?ncia().getSigla() + "\n" + "T?pico = "
					+ this.artigos.get(ind).getTopicoDePesquisa() + "\n");
		}
	}

}
