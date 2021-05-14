package TCP.peer.review.GUI;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextArea;

import TCP.peer.review.Database.Database;
import TCP.peer.review.Logic.Artigo;
import TCP.peer.review.Logic.PeerReview;

public class AtribuirNota {

	Windows window;
	PeerReview artigoEscolhido;
	String[] opcoesArtigos;
	String[] opcoesRevisores;

	public AtribuirNota() {
		window = new Windows(500, 100, "Atribuir Nota");

		JTextArea texto = new JTextArea("Favor escolher o artigo que receberá a nota.");
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

		JComboBox arts = new JComboBox<Object>(opcoesArtigos);
		arts.setSelectedIndex(0);

		arts.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int k = 0;
				ArrayList<String> revisores = new ArrayList<>();
				for (PeerReview pr : Database.getInstance().MergeAlocacoes())
					if (pr.getArtigo().getTitulo().equals(arts.getSelectedItem())) {
						revisores.add(pr.getRevisores().getNome());
						k++;
					}

				opcoesRevisores = new String[revisores.size()];

				for (int j = 0; j < opcoesRevisores.length; j++)
					opcoesRevisores[j] = revisores.get(j);

			}

		});

		window.panel.add(arts);

	}

	public static void execute() {
		AtribuirNota atrib = new AtribuirNota();
		showMessageDialog(null, "Favor selecione o artigo que receberá a nota.");

	}
}
