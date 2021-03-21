package auto_radnja;

import java.util.LinkedList;
import auto_radnja.gume.AutoGuma;

/**
 *  Interfejs koji predstavlja radnju za auto gume.
 *  
 * @author Maja Colovic
 * @version 0.1
 *
 */
public interface Radnja {

	/**
	 * Metoda za dodavanje nove gume u radnju.
	 * Guma se dodaje na prvo mesto u listi.
	 * 
	 * @param a Nova guma klase AutoGuma koja se dodaje.
	 * 
	 * @throws java.lang.NullPointerException ako je uneta guma null.
	 * @throws java.lang.RuntimeException ako guma vec postoji u radnji.
	 */
	void dodajGumu(AutoGuma a);
	
	/**
	 * Metoda koja pronalazi gume zadate marke i modela.
	 * 
	 * @param markaModel Marka i model gume kao String vrednost 
	 * @return
	 * <ul>
	 * 		<li>null ako je zadati kriterijum pretrage markaModel jednak null.
	 * 		<li>nova lista koju cine gume zadate marke i modela.
	 * </ul>
	 */
	LinkedList<AutoGuma> pronadjiGumu(String markaModel);

}
