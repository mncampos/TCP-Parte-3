package TCP.peer.review.Logic;

import java.util.Map;

public interface ConferenciaCommands {
	public final float MIN_REVISORES = 2;
	public final float MAX_REVISORES = 5;
	
	public void alocaArtigos(Conferencia conferencia);
	
	
}
