package TCP.peer.review.GUI;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import TCP.peer.review.Database.Database;
import TCP.peer.review.Logic.Conferencia;
import TCP.peer.review.Logic.PeerReview;

public class VisualizaRelatorio {

	Conferencia conf;
	Windows window;

	public VisualizaRelatorio() {

		window = new Windows(300, 100, "Peer Review");
		Button c1 = new Button("ICSE", 300, 50, 45, 50, 0);
		Button c2 = new Button("FSE", 300, 50, 45, 100, 0);
		Button c3 = new Button("SBES", 300, 50, 45, 150, 0);

		c1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				conf = Database.getInstance().getConferencias(1);
				if (testNotas(conf) == true)
					showRelatorio(conf);

			}
		});

		c2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				conf = Database.getInstance().getConferencias(2);
				if (testNotas(conf) == true)
					showRelatorio(conf);

			}
		});

		c3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				conf = Database.getInstance().getConferencias(3);
				if (testNotas(conf) == true)
					showRelatorio(conf);

			}
		});

		window.panel.add(c1);
		window.panel.add(c2);
		window.panel.add(c3);

	}

	private void showRelatorio(Conferencia conf) {

		window = new Windows(600, 600, "Relatório");
		JTabbedPane tabbedPanel = new JTabbedPane();
		JScrollPane tabelaAceitos = new JScrollPane(montaTabela("Aceitos", conf));
		JScrollPane tabelaRejeitados = new JScrollPane(montaTabela("Rejeitados", conf));
		tabbedPanel.addTab("Aceitos", tabelaAceitos);
		tabbedPanel.addTab("Rejeitados", tabelaRejeitados);

		window.panel.add(tabbedPanel);

	}

	private Boolean testNotas(Conferencia conf) {

		if (Database.getInstance().getAlocacoesMap().isEmpty()) {
			showMessageDialog(null, "Esta conferência ainda não foi alocada.");
			return false;
		}

		else {

			if (Database.getInstance().getAlocacoes(conf) == null) {
				showMessageDialog(null, "Esta conferência ainda não foi alocada.");
				return false;
			} else {
				for (PeerReview pr : Database.getInstance().getAlocacoes(conf)) {
					if (pr.getNota() == null) {
						showMessageDialog(null, "Ainda há revisões não recebidas nesta conferência.");
						return false;
					}
				}

				return true;
			}
		}
	}

	private static JTable montaTabela(String nome, Conferencia conf) {

		String[] tituloColunas = { nome, "Nota" };
		DefaultTableModel model = new DefaultTableModel(tituloColunas, 0);

		for (int i = 0; i < Database.getInstance().getAlocacoes(conf).size(); i++) {
			String titulo = Database.getInstance().getAlocacoes(conf).get(i).getArtigo().getTitulo();
			int Nota = Database.getInstance().getAlocacoes(conf).get(i).getNota();

			Object[] data = { titulo, Nota };

			model.addRow(data);
		}

		return new JTable(model);

	}

	public static void execute() {
		new VisualizaRelatorio();
		showMessageDialog(null, "Favor selecione uma conferência.");

	}
}
