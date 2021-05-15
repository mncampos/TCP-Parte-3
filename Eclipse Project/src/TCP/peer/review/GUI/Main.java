package TCP.peer.review.GUI;

import TCP.peer.review.Database.Database;

public class Main {

	public static void main(String[] args) {

		Database.getInstance();
		new Windows();
	}

}
