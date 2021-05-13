package TCP.peer.review.GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;




public class Windows {
	
	//Tamanho da janela principal
	private static final int windowHeight = 400;
	private static final int windowWidth = 300;
	
	JFrame frame;
	JPanel panel;
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	
	
	public Windows() {	//Construtor default : cria a janela principal
	this.frame = new JFrame("Peer Review");
	panel = new JPanel();
	
	frame.setSize(windowHeight, windowWidth);
	frame.add(panel);
	
	
	panel.add(new Button("Alocar Artigo a Membro do Comitê", 300, 50, 45, 50, 1));
	panel.add(new Button("Atribuir Nota a Artigo", 300, 50, 45 ,100, 2));
	panel.add(new Button("Visualizar Relatório de Artigos", 300, 50, 45, 150, 3));
	
	
	panel.setLayout(null);
	frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setResizable(false);
	frame.setVisible(true);
	}
	
	//Construtor para outras janelas, recebe um inteiro que identifica o tipo de janela. 1 = Janela vazia de tamanho original 2 = Janela de input básica
	public Windows(int op)
	{
		switch(op) {
		
		case 1: 
		frame = new JFrame("Peer Review");
		panel = new JPanel();
		frame.setSize(windowHeight, windowWidth);
		frame.add(panel);
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		frame.setResizable(false);
		frame.setVisible(true);
		break;
		}
		
	}
	
	public Windows(int Height, int Width, String name)
	{

	frame = new JFrame(name);
	panel = new JPanel();
	frame.setSize(Height, Width);
	frame.add(panel);
	frame.setLayout(new FlowLayout());
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
	frame.setResizable(false);
	frame.setVisible(true);
	}
	
	
}
