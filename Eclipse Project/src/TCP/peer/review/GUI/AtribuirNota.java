package TCP.peer.review.GUI;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

import TCP.peer.review.Database.Database;
import TCP.peer.review.Logic.PeerReview;
import TCP.peer.review.Logic.PeerReviewCommands;

public class AtribuirNota {

	Windows window;
	PeerReview artigoEscolhido;
	String[] opcoesArtigos;
	String[] opcoesRevisores;
	String[] notas = { "-3", "-2", "-1", "0", "1", "2", "3" };

	public AtribuirNota() {
		window = new Windows(600, 100, "Atribuir Nota");

		JTextArea texto = new JTextArea("Favor escolher o artigo e o revisor : ");
		texto.setEditable(false);
		window.panel.add(texto);

		int i = 0;
		String[] artigos = new String[Database.getInstance().getAlocacoesListTotalSize()];

		for (PeerReview p : Database.getInstance().MergeAlocacoes()) {

			if (i >= 1) {
				if (artigos[i - 1].equals(p.getArtigo().getTitulo())) {
					continue;
				}
			}

			artigos[i] = p.getArtigo().getTitulo();
			i++;

		}

		opcoesArtigos = new String[i];
		for (int k = 0; k < opcoesArtigos.length; k++) {
			opcoesArtigos[k] = artigos[k];

		}

		JComboBox<String> arts = new JComboBox<String>(opcoesArtigos);
		arts.setSelectedIndex(0);
		updateRevisores(arts);

		JComboBox<String> revs = new JComboBox<String>(opcoesRevisores);
		revs.setSelectedIndex(0);

		arts.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				updateRevisores(arts);
				handleSelectEvent(revs);

			}

		});

		JComboBox<String> opcoesNotas = new JComboBox<String>(notas);
		opcoesNotas.setSelectedIndex(0);

		JButton okButton = new JButton("Ok");
		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				for (PeerReview p : Database.getInstance().MergeAlocacoes()) {

					if (p.getArtigo().getTitulo().equals(arts.getSelectedItem())
							&& p.getRevisores().getNome().equals(revs.getSelectedItem())) {
						artigoEscolhido = p;
						break;
					}

				}

				if (artigoEscolhido.getNota() == null)
					showMessageDialog(null, "Nota atribuida com sucesso.");
				else
					showMessageDialog(null, "Nota alterada com sucesso.");

				PeerReviewCommands.AtribuiNota(artigoEscolhido,
						Integer.parseInt((String) opcoesNotas.getSelectedItem()));

			}

		});

		window.panel.add(arts);
		window.panel.add(revs);
		window.panel.add(opcoesNotas);
		window.panel.add(okButton);

	}

	public void handleSelectEvent(JComboBox<String> revisores) {
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(opcoesRevisores);
		revisores.setModel(model);
		window.panel.updateUI();
	}

	public void updateRevisores(JComboBox<String> artigoSelecionado) {
		ArrayList<String> revisores = new ArrayList<>();
		for (PeerReview pr : Database.getInstance().MergeAlocacoes())
			if (pr.getArtigo().getTitulo().equals(artigoSelecionado.getSelectedItem())) {
				revisores.add(pr.getRevisores().getNome());
			}

		opcoesRevisores = new String[revisores.size()];

		for (int j = 0; j < opcoesRevisores.length; j++) {
			opcoesRevisores[j] = revisores.get(j);
		}
	}

	public static void execute() {
		new AtribuirNota();
	}
}
