package TCP.peer.review.Implementation;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import TCP.peer.review.Data.PeerReview;
import TCP.peer.review.Database.Database;

public class VisualizaRelatórioTest {
	
	ArrayList<PeerReview> alocacoesTest;

	@Before
	public void setUp() throws Exception {
		alocacoesTest = AlocaArtigo.alocaComitê(Database.getInstance().getConferencias(3), 2);
	}

	@Test
	public void testMedia() {
		AtribuiNota.giveNota(alocacoesTest.get(0), 2);
		AtribuiNota.giveNota(alocacoesTest.get(1), 3);
		assertEquals(2.5, VisualizaRelatório.getMedia(alocacoesTest.get(0).getArtigo(), alocacoesTest) , 0.1);
	}

}
