package TCP.peer.review.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JOptionPane.showMessageDialog;

import javax.swing.JButton;

import TCP.peer.review.Database.Database;

public class Button extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3304785069452550960L;

	// Construtor de botão para a janela principal, pede um texto para o botão, seu
	// tamanho e sua posição na janela, e tambem a funcao que ira desempenhar como
	// um int
	public Button(String text, int sizeX, int sizeY, int posX, int posY, int funcao) {
		this.setText(text);
		this.setBounds(posX, posY, sizeX, sizeY);

		switch (funcao) {

		case 1:
			ActionListener alocaArtigo = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					AlocarArtigo.execute();
				}
			};
			this.addActionListener(alocaArtigo);
			break;

		case 2:
			ActionListener atribNota = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (Database.getInstance().getAlocacoesListTotalSize() == 0)
						showMessageDialog(null, "Nenhuma conferência foi alocada.");
					else
						AtribuirNota.execute();
				}
			};
			this.addActionListener(atribNota);
			break;

		case 3:
			ActionListener visualizaRelatorio = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					VisualizaRelatorio.execute();

				}
			};
			this.addActionListener(visualizaRelatorio);
			break;

		case 0:
			break;

		}

	}

}
