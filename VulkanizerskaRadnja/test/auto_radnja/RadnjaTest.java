package auto_radnja;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import auto_radnja.gume.AutoGuma;

public abstract class RadnjaTest {

	protected Radnja vr;

	@Test
	void testDodajGumu() {
		AutoGuma ag = new AutoGuma("Marka1", 15, 140, 30);

		vr.dodajGumu(ag);

		assertEquals(1, vr.vratiSveGume().size());
		assertTrue(vr.vratiSveGume().contains(ag));
	}
	
	@Test
	void testDodajGumuPrvoMesto() {
		AutoGuma ag1 = new AutoGuma("Marka1", 15, 140, 30);
		AutoGuma ag2 = new AutoGuma("Marka2", 20, 160, 50);

		vr.dodajGumu(ag1);
		vr.dodajGumu(ag2);

		assertEquals(2, vr.vratiSveGume().size());
		assertEquals(ag2, vr.vratiSveGume().get(0));
	}

	@Test
	void testDodajGumuNull() {
		assertThrows(java.lang.NullPointerException.class, () -> vr.dodajGumu(null));
	}

	@Test
	void testDodajGumuDuplikat() {
		AutoGuma ag1 = new AutoGuma("Marka1", 15, 140, 30);
		AutoGuma ag2 = new AutoGuma("Marka1", 15, 140, 30);

		vr.dodajGumu(ag1);

		RuntimeException e = assertThrows(java.lang.RuntimeException.class, () -> vr.dodajGumu(ag2));

		assertEquals("Guma vec postoji", e.getMessage());
	}

	@Test
	void testPronadjiGumu() {
		AutoGuma ag1 = new AutoGuma("Marka1", 15, 140, 30);
		AutoGuma ag2 = new AutoGuma("Marka1", 18, 170, 55);
		AutoGuma ag3 = new AutoGuma("Marka2", 20, 230, 80);
		AutoGuma ag4 = new AutoGuma("Marka3", 22, 355, 95);
		
		vr.dodajGumu(ag1);
		vr.dodajGumu(ag2);
		vr.dodajGumu(ag3);
		vr.dodajGumu(ag4);
		
		List<AutoGuma> rezultat = vr.pronadjiGumu("Marka1");

		assertEquals(2, rezultat.size());
		assertTrue(rezultat.contains(ag1));
		assertTrue(rezultat.contains(ag2));
	}

	@Test
	void testPronadjiGumuNull() {
		AutoGuma ag1 = new AutoGuma("Marka1", 15, 140, 30);
		AutoGuma ag2 = new AutoGuma("Marka1", 18, 170, 55);
		
		vr.dodajGumu(ag1);
		vr.dodajGumu(ag2);
		
		List<AutoGuma> rezultat = vr.pronadjiGumu(null);
		
		assertNull(rezultat);
	}
	
	@Test
	void testPronadjiGumuNepostoji() {
		AutoGuma ag1 = new AutoGuma("Marka1", 15, 140, 30);
		AutoGuma ag2 = new AutoGuma("Marka2", 18, 170, 55);
		
		vr.dodajGumu(ag1);
		vr.dodajGumu(ag2);
		
		List<AutoGuma> rezultat = vr.pronadjiGumu("Marka4");
		
		assertTrue(rezultat.isEmpty());
	}

}
