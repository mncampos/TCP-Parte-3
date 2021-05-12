package TCP.peer.review.Logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

import TCP.peer.review.Database.Database;

public class ConferenciaCommandsImpl implements ConferenciaCommands{

	private final Database database;

	public ConferenciaCommandsImpl(Database database) {
		this.database = database;
	}
	
	@Override
	public void alocaArtigos(Conferencia conferencia) {
		ArrayList<Artigo> artigosConferencia = conferencia.getArtigosSubmetidos();
		Artigo artigoMenorId = conferencia.artigoMenorId(artigosConferencia);
		
		ArrayList<Pesquisador> comiteAvaliador = conferencia.podemAvaliar(artigoMenorId, conferencia.getComit�());
		Collections.sort(comiteAvaliador);
	}

	@Override
	public void atribuirNota() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visualizarRelatorio() {
		// TODO Auto-generated method stub
		
	}

}
