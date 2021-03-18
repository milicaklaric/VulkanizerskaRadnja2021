package auto_radnja;

import java.util.LinkedList;
import auto_radnja.gume.AutoGuma;

/**
 * Interfejs koji predstavlja radnju
 * 
 * @author MK
 *
 */
public interface Radnja {
	
	/**
	 * Dodaje novu gumu u radnju
	 * 
	 * @param a Auto guma koja se dodaje
	 * 
	 * @throws java.lang.NullPointerException ako je dodata guma null
	 * @throws java.lang.RuntimeException ako guma veæ postoji u radnji 
	 */
	void dodajGumu(AutoGuma a);

	/**
	 * Vraæa sve gume tražene marke i modela
	 * 
	 * @param markaModel Marka i model gume, na osnovu kojih sistem vrši pretragu
	 * @return Lista svih guma u radnji koje su tražene marke
	 */
	LinkedList<AutoGuma> pronadjiGumu(String markaModel);
	
	/**
	 * Vraæa sve gume u vulkanizerskoj radnji
	 * 
	 * @return Lista svih guma u radnji
	 * 
	 */
	LinkedList<AutoGuma> vratiSveGume();
}