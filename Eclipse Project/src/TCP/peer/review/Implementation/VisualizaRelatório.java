package TCP.peer.review.Implementation;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import TCP.peer.review.Data.Conferencia;
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
			int i;
			int counter = 0;
	
			if (j >= 1)
				if (Database.getInstance().getAlocacoes(conf).get(j - 1).getArtigo().getTitulo()
						.equals(Database.getInstance().getAlocacoes(conf).get(j).getArtigo().getTitulo()))
					continue;
	
			Boolean flag = false; // Se foi alocado
	
			for (i = j; i < Database.getInstance().getAlocacoes(conf).size(); i++) {
				if (i - 1 == -1) {
					media += Database.getInstance().getAlocacoes(conf).get(i).getNota();
					counter++;
					continue;
				}
	
				if (flag == false) {
					media += Database.getInstance().getAlocacoes(conf).get(i).getNota();
					flag = true;
					counter++;
					continue;
				}
	
				else if (Database.getInstance().getAlocacoes(conf).get(i - 1).getArtigo().getTitulo()
						.equals(Database.getInstance().getAlocacoes(conf).get(i).getArtigo().getTitulo())) {
					counter++;
					media += Database.getInstance().getAlocacoes(conf).get(i).getNota();
				} else
					break;
			}
	
			media = media / counter;
	
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
			int i;
			int counter = 0;
	
			if (j >= 1)
				if (Database.getInstance().getAlocacoes(conf).get(j - 1).getArtigo().getTitulo()
						.equals(Database.getInstance().getAlocacoes(conf).get(j).getArtigo().getTitulo()))
					continue;
	
			Boolean flag = false; // Se foi alocado
	
			for (i = j; i < Database.getInstance().getAlocacoes(conf).size(); i++) {
				if (i - 1 == -1) {
					media += Database.getInstance().getAlocacoes(conf).get(i).getNota();
					counter++;
					continue;
				}
	
				if (flag == false) {
					media += Database.getInstance().getAlocacoes(conf).get(i).getNota();
					flag = true;
					counter++;
					continue;
				}
	
				else if (Database.getInstance().getAlocacoes(conf).get(i - 1).getArtigo().getTitulo()
						.equals(Database.getInstance().getAlocacoes(conf).get(i).getArtigo().getTitulo())) {
					counter++;
					media += Database.getInstance().getAlocacoes(conf).get(i).getNota();
				} else
					break;
			}
	
			media = media / counter;
	
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
