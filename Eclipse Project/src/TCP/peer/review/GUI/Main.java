package TCP.peer.review.GUI;

import java.util.Scanner;

import TCP.peer.review.Database.Database;


public class Main {

	public static void main(String[] args) {
	
		Database db = new Database();
		
		
		while(true) {
		System.out.println("Favor escolher a opção desejada : \n"
				+ "1 - Printar Pesquisadores \n"
				+ "2 - Printar Conferências \n"
				+ "3 - Printar Artigos \n"
				+ "4 - Sair");
		Scanner s = new Scanner(System.in);
		
		switch(s.nextInt()) {
		case 1:
			db.printPesquisadores();
			break;
		case 2:
			db.printConferencias();
			break;
		case 3:
			db.printArtigos();
			break;
		case 4:
			System.exit(0);
		default:
			break;
		}
		
		}
	

	}

}
