package TCP.peer.review.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JOptionPane.showMessageDialog;

import javax.swing.JButton;

import TCP.peer.review.UITests.UITests;

public class MainButton extends JButton {


	private static final long serialVersionUID = -3304785069452550960L;

	/**
	 *  Classe respons�vel pelos 3 bot�es do menu principal. Eles s�o o gatilho para as outras funcionalidades.
	 * @param text : Texto do bot�o
	 * @param sizeX : Largura
	 * @param sizeY : Altura
	 * @param posX : Posi��o X
	 * @param posY : Posi��o Y
	 * @param funcao : Funcionalidade
	 * Funcionalidades:
	 * 1 -> Bot�o de alocar artigo
	 * 2 -> Bot�o de atribuir nota
	 * 3 -> Bot�o de visualizar relat�rio
	 */
	public MainButton(String text, int sizeX, int sizeY, int posX, int posY, int funcao) {
		this.setText(text);
		this.setBounds(posX, posY, sizeX, sizeY);

		switch (funcao) {

		case 1:
			ActionListener alocaArtigo = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					AlocaArtigoGUI.execute();
				}
			};
			this.addActionListener(alocaArtigo);
			break;

		case 2:
			ActionListener atribNota = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (UITests.testAlocacoes() == false)
						showMessageDialog(null, "Nenhuma confer�ncia foi alocada.");
					else
						AtribuiNotaGUI.execute();
				}
			};
			this.addActionListener(atribNota);
			break;

		case 3:
			ActionListener visualizaRelatorio = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					VisualizaRelatorioGUI.execute();
				}
			};
			this.addActionListener(visualizaRelatorio);
			break;

		case 0:
			break;

		}

	}

}
