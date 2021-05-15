package TCP.peer.review.Implementation;

import static org.junit.Assert.*;

import javax.swing.JTable;

import org.junit.Before;
import org.junit.Test;

import TCP.peer.review.Database.Database;

public class VisualizaRelatórioTest {
	
	JTable testTable;

	@Before
	public void setUp() throws Exception {
		testTable = VisualizaRelatório.montaTabelaAceitos("Teste Aceitos", Database.getInstance().getConferencias(2));
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
