package TCP.peer.review.GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

/**
 * @author Mateus, Raul, Germano
 * Classe responsável pelas janelas gráficas do programa.
 */
public class Window {

	// Tamanho padrão do programa
	private static final int windowHeight = 400;
	private static final int windowWidth = 300;

	JFrame frame;
	JPanel panel;
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

	/**
	 * Construtor vazio : Cria o menu principal
	 */
	public Window() {
		this.frame = new JFrame("Peer Review");
		panel = new JPanel();

		frame.setSize(windowHeight, windowWidth);
		frame.add(panel);

		panel.add(new MainButton("Alocar Artigo a Membro do Comitê", 300, 50, 45, 50, 1));
		panel.add(new MainButton("Atribuir Nota a Artigo", 300, 50, 45, 100, 2));
		panel.add(new MainButton("Visualizar Relatório de Artigos", 300, 50, 45, 150, 3));

		panel.setLayout(null);
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
	}


	/**
	 * Construtor parametrizado com um inteiro : Cria uma janela vazia padrão.
	 * Código escalável para adicionar novas janelas caso necessário.
	 * @param op : Default 1 -> Janela vazia
	 */
	public Window(int op) {
		switch (op) {

		case 1:
			frame = new JFrame("Peer Review");
			panel = new JPanel();
			frame.setSize(windowHeight, windowWidth);
			frame.add(panel);
			frame.setLayout(new FlowLayout());
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
			frame.setResizable(false);
			frame.setVisible(true);
			break;
		}

	}

	/**
	 * Construtor parametrizado : Cria uma janela customizada com os parâmetros passados
	 * @param Height : Altura (int)
	 * @param Width : Largura (int)
	 * @param name : Nome (String)
	 */
	public Window(int Height, int Width, String name) {

		frame = new JFrame(name);
		panel = new JPanel();
		frame.setSize(Height, Width);
		frame.add(panel);
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
		frame.setResizable(false);
		frame.setVisible(true);
	}

}
