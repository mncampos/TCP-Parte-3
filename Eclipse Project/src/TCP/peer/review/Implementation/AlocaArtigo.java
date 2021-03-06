package TCP.peer.review.Implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import TCP.peer.review.Data.Artigo;
import TCP.peer.review.Data.Conferencia;
import TCP.peer.review.Data.PeerReview;
import TCP.peer.review.Data.Pesquisador;



/**
 * 
 * Classe respons?vel pela funcionalidade de aloca??o de artigos no comit?.
 * @author Mateus, Raul, Germano
 *
 */
public class AlocaArtigo {

	/**
	 * Aloca o comit? de uma certa confer?ncia, retorna uma lista onde cada n? ? uma
	 * rela??o Revisor x Artigo.
	 * 
	 * @param conf
	 * @param num
	 * @return ArrayList
	 */
	public static ArrayList<PeerReview> alocaComit?(Conferencia conf, int num) {

		ArrayList<Artigo> artigosSubmetidos = new ArrayList<Artigo>(conf.getArtigosSubmetidos()); // Artigos submetidos
																									// na confer?ncia
		ArrayList<PeerReview> comit? = new ArrayList<PeerReview>(); // Lista usada para armazenar os revisores

		// Garante que n?o h? nenhuma artigo alocado no comit?
		for (Pesquisador p : conf.getComit?()) {
			p.setNumArtigosAlocados(0);
		}

		System.out.println("Iniciando a aloca??o.\n");
		for (Artigo a : artigosSubmetidos) { // Para cada artigo da lista de artigos submetidos

			ArrayList<Pesquisador> Candidatos = new ArrayList<>(conf.getComit?()); // Teremos uma lista de candidatos
			Iterator<Pesquisador> iterP = Candidatos.iterator(); // E um iterador para operar nesta lista

			ArrayList<Pesquisador> FlaggedCandidatos = new ArrayList<>(); // Se um candidato for alocado para o artigo,
																			// ele ? marcado e n?o pode ser alocado de
																			// novo

			for (int i = 0; i < num; i++) { // Depende do n?mero de revisores por artigo que o usu?rio especificou

				while (iterP.hasNext()) {
					Pesquisador p = iterP.next();
					if (a.getAutor().equals(p) || a.getAutor().getAfiliacao().equals(p.getAfiliacao()) // Se o usu?rio
																										// for inv?lido
																										// por qualquer
																										// um dos
																										// motivos
							|| !p.getTopicosDePesquisa().contains(a.getTopicoDePesquisa()) // especificados ele ?
																							// excluido da lista de
																							// candidatos
							|| FlaggedCandidatos.contains(p)) {

						iterP.remove();
					}

				}

				if (Candidatos.isEmpty()) // Se acabou a lista de candidatos segue para o proximo artigo
					continue;

				// Ordenada os usu?rios restantes na lista de candidatos baseados em seu ID ou
				// numero de artigos alocados
				Collections.sort(Candidatos);

				// Aloca o primeiro candidato da lista e recome?a o loop
				comit?.add(new PeerReview(a, Candidatos.get(0), conf));
				Candidatos.get(0).setNumArtigosAlocados(Candidatos.get(0).getNumArtigosAlocados() + 1);
				System.out.println(
						"Artigo de ID " + a.getId() + " alocado ao revisor de ID " + Candidatos.get(0).getId());
				FlaggedCandidatos.add(Candidatos.get(0));
				iterP = Candidatos.iterator();
			}
		}
		// Retorna a lista de usu?rios alocados com seus respectivos artigos
		System.out.println("Fim da Aloca??o.");
		return comit?;
	}
	


}
