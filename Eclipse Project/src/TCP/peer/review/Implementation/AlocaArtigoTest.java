package TCP.peer.review.Implementation;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import TCP.peer.review.Data.PeerReview;
import TCP.peer.review.Database.Database;
	
/**
 * @author Mateus
 * Testa a corretude do algoritmo de aloca��o.
 *
 */
public class AlocaArtigoTest {

	ArrayList<PeerReview> comit�Test;
	
	@Before
	public void setUp() {
		comit�Test = new ArrayList<PeerReview>();
	}
	
	@Test
	public void testFSE()
	{
		comit�Test = AlocaArtigo.alocaComit�(Database.getInstance().getConferencias(2), 2);
		assertEquals(comit�Test.get(0).getRevisores().getNome(), "Jo�o");
		assertEquals(comit�Test.get(1).getRevisores().getNome(), "Ana");
		assertEquals(comit�Test.get(2).getRevisores().getNome(), "Joana");
		assertEquals(comit�Test.get(3).getRevisores().getNome(), "Beatriz");
	}

}
