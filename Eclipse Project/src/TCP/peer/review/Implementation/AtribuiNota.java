package TCP.peer.review.Implementation;

import TCP.peer.review.Data.PeerReview;

/**
 * Atribuição de nota
 * @author Mateus, Raul, Germano
 *
 */
public class AtribuiNota {

	/**
	 * Adiciona ou altera a nota de um artigo, dada por um revisor.
	 * @param artigo
	 * @param Nota
	 */
	public static void giveNota(PeerReview artigo, int Nota) {
		artigo.setNota(Nota);
	}

}
