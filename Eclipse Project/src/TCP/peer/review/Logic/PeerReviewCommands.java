package TCP.peer.review.Logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class PeerReviewCommands {

	//Aloca os revisores para os artigos de acordo com o que foi especificado
	public static ArrayList<PeerReview> StartAlocation(Conferencia conf, int num) {
		
		ArrayList<Artigo> artigosSubmetidos = new ArrayList<Artigo>(conf.getArtigosSubmetidos()); //Artigos submetidos na conferência
		ArrayList<PeerReview> alocacaoTotal = new ArrayList<PeerReview>();						  //Lista usada para armazenar os revisores

		//Garante que não há nenhuma artigo alocado no comitê
		for (Pesquisador p : conf.getComitê())
		{
			p.setNumArtigosAlocados(0);
		}
		
		System.out.println("Iniciando a alocação.\n");
		for (Artigo a : artigosSubmetidos) { //Para cada artigo da lista de artigos submetidos

			ArrayList<Pesquisador> Candidatos = new ArrayList<>(conf.getComitê());  //Teremos uma lista de candidatos
			Iterator<Pesquisador> iterP = Candidatos.iterator();				    //E um iterador para operar nesta lista

			ArrayList<Pesquisador> FlaggedCandidatos = new ArrayList<>();          //Se um candidato for alocado para o artigo, ele é marcado e não pode ser alocado de novo

			for (int i = 0; i < num; i++) {						//Depende do número de revisores por artigo que o usuário especificou

				while (iterP.hasNext()) {
					Pesquisador p = iterP.next();
					if (a.getAutor().equals(p) || a.getAutor().getAfiliacao().equals(p.getAfiliacao())	//Se o usuário for inválido por qualquer um dos motivos
							|| !p.getTopicosDePesquisa().contains(a.getTopicoDePesquisa())				//especificados ele é excluido da lista de candidatos
							|| FlaggedCandidatos.contains(p)) {

						iterP.remove();
					}

				}

				if (Candidatos.isEmpty())	//Se acabou a lista de candidatos segue para o proximo artigo
					continue;

				//Ordenada os usuários restantes na lista de candidatos baseados em seu ID ou numero de artigos alocados
				Collections.sort(Candidatos);

				//Aloca o primeiro candidato da lista e recomeça o loop
				alocacaoTotal.add(new PeerReview(a, Candidatos.get(0), conf));
				Candidatos.get(0).setNumArtigosAlocados(Candidatos.get(0).getNumArtigosAlocados() + 1);
				System.out.println(
						"Artigo de ID " + a.getId() + " alocado ao revisor de ID " + Candidatos.get(0).getId());
				FlaggedCandidatos.add(Candidatos.get(0));
				iterP = Candidatos.iterator(); 
			}
		}
		//Retorna a lista de usuários alocados com seus respectivos artigos
		return alocacaoTotal;
	}

	
	public static void AtribuiNota(PeerReview artigo, int Nota)
	{
		artigo.setNota(Nota);
	}
	
	public static void VisualizaRelatorio()
	{
		//Fazer
	}
	


}
