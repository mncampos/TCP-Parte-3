package TCP.peer.review.UITests;

import static javax.swing.JOptionPane.showMessageDialog;

import TCP.peer.review.Data.Conferencia;
import TCP.peer.review.Data.PeerReview;
import TCP.peer.review.Database.Database;

/**
 * Classe respons�vel pelos testes de interface.
 * @author Mateus, Raul, Germano
 *
 */
public class UITests {

	/**
	 * Testa se a confer�ncia j� foi alocada. Se j� foi, testa se h� alguma revis�o faltando.
	 * @param conf
	 * @return boolean
	 */
	public static Boolean testConferencia(Conferencia conf) {
	
		if (Database.getInstance().getAlocacoesMap().isEmpty()) {
			showMessageDialog(null, "Esta confer�ncia ainda n�o foi alocada.");
			return false;
		}
	
		else {
	
			if (Database.getInstance().getAlocacoes(conf) == null) {
				showMessageDialog(null, "Esta confer�ncia ainda n�o foi alocada.");
				return false;
			} else {
				for (PeerReview pr : Database.getInstance().getAlocacoes(conf)) {
					if (pr.getNota() == null) {
						showMessageDialog(null, "Ainda h� revis�es n�o recebidas nesta confer�ncia.");
						return false;
					}
				}
	
				return true;
			}
		}
	}
	
	/**
	 * Testa se alguma confer�ncia foi alocada na mem�ria.
	 * @return false se nenhuma confer�ncia foi alocada. True se alguma foi.
	 */
	public static Boolean testAlocacoes()
	{
		if (Database.getInstance().getAlocacoesListTotalSize() == 0)
			return false;
		else return true;
	}

}
