package TCP.peer.review.GUI;

import TCP.peer.review.Database.Database;

/**
 * @author Mateus, Raul, Germano
 * Classe main, apenas inicializa o programa.
 */
public class Main {

	public static void main(String[] args) {

		Database.getInstance();
		new Window();
	}

}
