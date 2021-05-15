package TCP.peer.review.Implementation;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import TCP.peer.review.Data.PeerReview;
import TCP.peer.review.Database.Database;

public class AtribuiNotaTest {

	PeerReview testCase;
	
	@Before
	public void setUp() throws Exception {
		testCase = new PeerReview(Database.getInstance().getArtigo(0), Database.getInstance().getPesquisador(0), null);
	}

	@Test
	public void testSetNota() {
		AtribuiNota.giveNota(testCase, -3);
		assertTrue(testCase.getNota() == -3);
	}

}
