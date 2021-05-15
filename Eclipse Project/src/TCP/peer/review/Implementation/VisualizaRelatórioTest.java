package TCP.peer.review.Implementation;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import TCP.peer.review.Data.PeerReview;
import TCP.peer.review.Database.Database;

public class VisualizaRelat�rioTest {
	
	ArrayList<PeerReview> alocacoesTest;

	@Before
	public void setUp() throws Exception {
		alocacoesTest = AlocaArtigo.alocaComit�(Database.getInstance().getConferencias(3), 2);
	}

	@Test
	public void testMedia() {
		AtribuiNota.giveNota(alocacoesTest.get(0), 2);
		AtribuiNota.giveNota(alocacoesTest.get(1), 3);
		assertEquals(2.5, VisualizaRelat�rio.getMedia(alocacoesTest.get(0).getArtigo(), alocacoesTest) , 0.1);
	}

}
