package TCP.peer.review.GUI;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import TCP.peer.review.Data.Conferencia;
import TCP.peer.review.Database.Database;
import TCP.peer.review.Implementation.VisualizaRelatório;
import TCP.peer.review.UITests.UITests;

/**
 * Classe responsável pela parte gráfica da visualização das notas dos artigos.
 * @author Mateus, Raul, Germano
 *
 */
public class VisualizaRelatorioGUI {

	Conferencia conf;
	Window window;

	/**
	 * Construtor default
	 */
	public VisualizaRelatorioGUI() {

		window = new Window(300, 100, "Peer Review");
		MainButton c1 = new MainButton("ICSE", 300, 50, 45, 50, 0);
		MainButton c2 = new MainButton("FSE", 300, 50, 45, 100, 0);
		MainButton c3 = new MainButton("SBES", 300, 50, 45, 150, 0);

		
		
		c1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				conf = Database.getInstance().getConferencias(1);
				if (UITests.testConferencia(conf) == true)
					showRelatorio(conf);

			}
		});

		c2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				conf = Database.getInstance().getConferencias(2);
				if (UITests.testConferencia(conf) == true)
					showRelatorio(conf);

			}
		});

		c3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				conf = Database.getInstance().getConferencias(3);
				if (UITests.testConferencia(conf) == true)
					showRelatorio(conf);

			}
		});

		window.panel.add(c1);
		window.panel.add(c2);
		window.panel.add(c3);

	}

	/**
	 * Cria uma janela contendo 2 tabelas, as quais contém os artigos aceitos e os rejeitados.
	 * @param conf
	 */
	private void showRelatorio(Conferencia conf) {

		window = new Window(600, 600, "Relatório");
		JTabbedPane tabbedPanel = new JTabbedPane();
		JScrollPane tabelaAceitos = new JScrollPane(VisualizaRelatório.montaTabelaAceitos("Aceitos", conf));
		JScrollPane tabelaRejeitados = new JScrollPane(VisualizaRelatório.montaTabelaRejeitados("Rejeitados", conf));
		tabbedPanel.addTab("Aceitos", tabelaAceitos);
		tabbedPanel.addTab("Rejeitados", tabelaRejeitados);

		window.panel.add(tabbedPanel);

	}

	public static void execute() {
		new VisualizaRelatorioGUI();
		showMessageDialog(null, "Favor selecione uma conferência.");

	}
}
