package TCP.peer.review.UITests;

import static javax.swing.JOptionPane.showMessageDialog;

import TCP.peer.review.Data.Conferencia;
import TCP.peer.review.Data.PeerReview;
import TCP.peer.review.Database.Database;

/**
 * Classe responsável pelos testes de interface.
 * @author Mateus, Raul, Germano
 *
 */
public class UITests {

	/**
	 * Testa se a conferência já foi alocada. Se já foi, testa se há alguma revisão faltando.
	 * @param conf
	 * @return boolean
	 */
	public static Boolean testConferencia(Conferencia conf) {
	
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
	
	/**
	 * Testa se alguma conferência foi alocada na memória.
	 * @return false se nenhuma conferência foi alocada. True se alguma foi.
	 */
	public static Boolean testAlocacoes()
	{
		if (Database.getInstance().getAlocacoesListTotalSize() == 0)
			return false;
		else return true;
	}

}
