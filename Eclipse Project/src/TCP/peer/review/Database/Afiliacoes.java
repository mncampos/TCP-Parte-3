package TCP.peer.review.Database;

import java.util.HashMap;
import java.util.Map;

public class Afiliacoes {

	private final Map<Integer, String> Universidades;
	
	//0 = UFRGS, 1 = USP, 2 = UFRJ
	
	
	public Afiliacoes()
	{
		this.Universidades = new HashMap<>();
		this.Universidades.put(0, "UFRGS");
		this.Universidades.put(1, "USP");
		this.Universidades.put(2, "UFRJ");
	}
	
	
	//Retorna a universidade correspondente à sua chave
	public String GetUniversidade(int key)
	{
		return this.Universidades.get(key);
	}
}
