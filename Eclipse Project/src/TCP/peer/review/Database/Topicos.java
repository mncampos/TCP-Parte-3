package TCP.peer.review.Database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Topicos {

	private final Map<Integer, String> Topicos;

	// 0 = Modularity, 1 = Software Reuse, 2 = Aspect-oriented Programming, 3 =
	// Software Product Lines,
	// 4 = Software Achitecture, 5 = Software Testing

	public Topicos() {
		this.Topicos = new HashMap<>();
		this.Topicos.put(0, "Modularity");
		this.Topicos.put(1, "Software Reuse");
		this.Topicos.put(2, "Aspect-oriented Programming");
		this.Topicos.put(3, "Software Product Lines");
		this.Topicos.put(4, "Software Architecture");
		this.Topicos.put(5, "Software Testing");
		this.Topicos.put(6, "Software Quality");
	}

	public String GetTopico(int key) {
		return this.Topicos.get(key);
	}

	public ArrayList<String> GetTopicos(ArrayList<Integer> keys) {
		ArrayList<String> TopicosList = new ArrayList<>();

		for (Integer id : keys) {
			TopicosList.add(this.GetTopico(id));

		}

		return TopicosList;

	}

}
