package TCP.peer.review.Implementation;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import TCP.peer.review.Data.PeerReview;
import TCP.peer.review.Database.Database;
	
/**
 * @author Mateus
 * Testa a corretude do algoritmo de alocação.
 *
 */
public class AlocaArtigoTest {

	ArrayList<PeerReview> comitêTest;
	
	@Before
	public void setUp() {
		comitêTest = new ArrayList<PeerReview>();
	}
	
	@Test
	public void testFSE()
	{
		comitêTest = AlocaArtigo.alocaComitê(Database.getInstance().getConferencias(2), 2);
		assertEquals(comitêTest.get(0).getRevisores().getNome(), "João");
		assertEquals(comitêTest.get(1).getRevisores().getNome(), "Ana");
		assertEquals(comitêTest.get(2).getRevisores().getNome(), "Joana");
		assertEquals(comitêTest.get(3).getRevisores().getNome(), "Beatriz");
	}

}
