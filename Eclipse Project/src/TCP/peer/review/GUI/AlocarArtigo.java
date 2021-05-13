package TCP.peer.review.GUI;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import TCP.peer.review.Database.Database;
import TCP.peer.review.Logic.Conferencia;
import TCP.peer.review.Logic.PeerReview;
import TCP.peer.review.Logic.PeerReviewCommands;

public class AlocarArtigo {

	// Valores default para o seletor
	Conferencia confEscolhida = Database.getInstance().getConferencias(1);
	int numEscolhido = 2;
	Windows window;

	public AlocarArtigo() {
		window = new Windows(500, 100, "Alocação de Artigo");

		JTextArea texto = new JTextArea("Favor escolher a conferência e a quantidade de revisores");
		texto.setEditable(false);
		window.panel.add(texto);

		String[] confs = { Database.getInstance().getConferencias(1).getSigla(),
				Database.getInstance().getConferencias(2).getSigla(),
				Database.getInstance().getConferencias(3).getSigla() };
		JComboBox<?> conferencias = new JComboBox<Object>(confs);
		conferencias.setSelectedIndex(0);
		conferencias.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				confEscolhida = Database.getInstance().getConferencias(conferencias.getSelectedIndex() + 1);
			}

		});

		window.panel.add(conferencias);

		String[] qtdRevisores = { "2", "3", "4", "5" };
		JComboBox<?> qtdRevisors = new JComboBox<Object>(qtdRevisores);
		qtdRevisors.setSelectedIndex(0);
		qtdRevisors.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				numEscolhido = Integer.parseInt((String) qtdRevisors.getSelectedItem());
			}

		});

		window.panel.add(qtdRevisors);

		JButton okbutton = new JButton("Ok");
		okbutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				window.frame.dispose();
				Database.getInstance().setPr(PeerReviewCommands.StartAlocation(confEscolhida, numEscolhido));
				JScrollPane resultado = new JScrollPane(MontaTabelaAlocada(Database.getInstance().getPr()));
				Windows window = new Windows(600, 600, "Resultado");
				window.panel.add(resultado);
				System.out.println("Fim da alocação.");
				showMessageDialog(null, "Operação realizada com sucesso.");

			}
		});
		window.panel.add(okbutton);

	}

	private static JTable MontaTabelaAlocada(ArrayList<PeerReview> ListaDeAlocacao) {
		String[] tituloColunas = { "Artigo", "Revisor" };
		DefaultTableModel model = new DefaultTableModel(tituloColunas, 0);

		for (int i = 0; i < ListaDeAlocacao.size(); i++) {
			String artigo = ListaDeAlocacao.get(i).getArtigo().getTitulo();
			String revisor = ListaDeAlocacao.get(i).getRevisores().getNome();

			Object[] data = { artigo, revisor };

			model.addRow(data);
		}

		return new JTable(model);

	}

	public static void execute() {
		new AlocarArtigo();

	}
}
