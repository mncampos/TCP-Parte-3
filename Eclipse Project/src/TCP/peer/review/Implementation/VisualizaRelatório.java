package TCP.peer.review.Implementation;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import TCP.peer.review.Data.Artigo;
import TCP.peer.review.Data.Conferencia;
import TCP.peer.review.Data.PeerReview;
import TCP.peer.review.Database.Database;

/**
 * Classe responsável pela funcionalidade de visualizar os artigos aceitos ou rejeitados.
 * @author Mateus, Raul, Germano
 *
 */
public class VisualizaRelatório {

	/**
	 * Retorna uma tabela contendo os artigos com média superior ou igual a 0.
	 * @param nome
	 * @param conf
	 * @return
	 */
	public static JTable montaTabelaAceitos(String nome, Conferencia conf) {
	
		String[] tituloColunas = { nome, "Nota" };
		DefaultTableModel model = new DefaultTableModel(tituloColunas, 0);
	
		for (int j = 0; j < Database.getInstance().getAlocacoes(conf).size(); j++) {
	
			float media = 0;
	
			if (j >= 1)
				if (Database.getInstance().getAlocacoes(conf).get(j - 1).getArtigo().getTitulo()
						.equals(Database.getInstance().getAlocacoes(conf).get(j).getArtigo().getTitulo()))
					continue;

			media = getMedia(Database.getInstance().getAlocacoes(conf).get(j).getArtigo(), Database.getInstance().getAlocacoes(conf));
			
			if (media >= 0) {
				String titulo = Database.getInstance().getAlocacoes(conf).get(j).getArtigo().getTitulo();
				float Nota = media;
	
				Object[] data = { titulo, Nota };
	
				model.addRow(data);
			}
		}
	
		return new JTable(model);
	
	}
	
	/**
	 * Calcula a média de um dado artigo, precisa de uma lista de artigos alocados. Se o artigo não existir, retorna -10.
	 * @param artigo
	 * @param alocacoes
	 * @return
	 */
	public static float getMedia(Artigo artigo, ArrayList<PeerReview> alocacoes)
	{
		float media = 0;
		int counter = 0;
		
		for(PeerReview pr : alocacoes)
		{
			if(pr.getArtigo().equals(artigo)) {
				media += pr.getNota();
				counter++;
		}
				
		}
		
		if(counter == 0)
			return -10;
		
		return media/counter;
		
	}
	
	

	/**
	 * Retorna uma tabela contendo os artigos de nota menor que 0.
	 * @param nome
	 * @param conf
	 * @return
	 */
	public static JTable montaTabelaRejeitados(String nome, Conferencia conf) {
	
		String[] tituloColunas = { nome, "Nota" };
		DefaultTableModel model = new DefaultTableModel(tituloColunas, 0);
	
		for (int j = 0; j < Database.getInstance().getAlocacoes(conf).size(); j++) {
	
			float media = 0;

	
			if (j >= 1)
				if (Database.getInstance().getAlocacoes(conf).get(j - 1).getArtigo().getTitulo()
						.equals(Database.getInstance().getAlocacoes(conf).get(j).getArtigo().getTitulo()))
					continue;
	
			media = getMedia(Database.getInstance().getAlocacoes(conf).get(j).getArtigo(), Database.getInstance().getAlocacoes(conf));
	
			if (media < 0) {
				String titulo = Database.getInstance().getAlocacoes(conf).get(j).getArtigo().getTitulo();
				float Nota = media;
	
				Object[] data = { titulo, Nota };
	
				model.addRow(data);
			}
		}
	
		return new JTable(model);
	
		
	}

}
