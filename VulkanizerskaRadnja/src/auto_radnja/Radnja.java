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
	 * @throws java.lang.RuntimeException ako guma ve� postoji u radnji 
	 */
	void dodajGumu(AutoGuma a);

	/**
	 * Vra�a sve gume tra�ene marke i modela
	 * 
	 * @param markaModel Marka i model gume, na osnovu kojih sistem vr�i pretragu
	 * @return Lista svih guma u radnji koje su tra�ene marke
	 */
	LinkedList<AutoGuma> pronadjiGumu(String markaModel);
	
	/**
	 * Vra�a sve gume u vulkanizerskoj radnji
	 * 
	 * @return Lista svih guma u radnji
	 * 
	 */
	LinkedList<AutoGuma> vratiSveGume();
}