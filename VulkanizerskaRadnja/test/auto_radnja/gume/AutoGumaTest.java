package auto_radnja.gume;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AutoGumaTest {

	AutoGuma ag;

	@BeforeEach
	void setUp() throws Exception {
		ag = new AutoGuma();
	}

	@AfterEach
	void tearDown() throws Exception {
		ag = null;
	}

	@Test
	void testAutoGuma() {
		ag = new AutoGuma();
		assertNotNull(ag);
	}

	@Test
	void testAutoGumaStringIntIntInt() {
		ag = new AutoGuma("Marka1", 15, 140, 30);
		assertNotNull(ag);
		assertEquals("Marka1", ag.getMarkaModel());
		assertEquals(15, ag.getPrecnik());
		assertEquals(140, ag.getSirina());
		assertEquals(30, ag.getVisina());
	}

	@Test
	void testSetMarkaModel() {
		ag.setMarkaModel("Marka1");
		assertEquals("Marka1", ag.getMarkaModel());
	}

	@Test
	void testSetMarkaModelNull() {
		assertThrows(java.lang.NullPointerException.class, () -> ag.setMarkaModel(null));
	}

	@Test
	void testSetMarkaModelPrekratko() {
		assertThrows(java.lang.RuntimeException.class, () -> ag.setMarkaModel("M"));
	}

	@ParameterizedTest
	@CsvSource({ 
		"13",
		"15",
		"16",
		"22"
		})
	void testSetPrecnik(int precnik) {
		ag.setPrecnik(precnik);
		assertEquals(precnik, ag.getPrecnik());
	}
	
	@ParameterizedTest
	@CsvSource({ 
		"7",
		"12",
		"23",
		"55"
		})
	void testSetPrecnikVanGranica(int precnik) {
		assertThrows(java.lang.RuntimeException.class, 
				() -> ag.setPrecnik(precnik));
	}

	@ParameterizedTest
	@CsvSource({ 
		"135",
		"186",
		"212",
		"271",
		"300",
		"355" 
		})
	void testSetSirina(int sirina) {
		ag.setSirina(sirina);
		assertEquals(sirina, ag.getSirina());
	}
	
	@ParameterizedTest
	@CsvSource({ 
		"10",
		"100",
		"134",
		"356",
		"400"
		})
	void testSetSirinaVanGranica(int sirina) {
		assertThrows(java.lang.RuntimeException.class, 
				() -> ag.setSirina(sirina));
	}

	
	@ParameterizedTest
	@CsvSource({ 
		"25",
		"31",
		"47",
		"50",
		"76",
		"95"
		})
	void testSetVisina(int visina) {
		ag.setVisina(visina);
		assertEquals(visina, ag.getVisina());
	}
	
	@ParameterizedTest
	@CsvSource({ 
		"0",
		"5",
		"24",
		"96",
		"1000"
		})
	void testSetVisinaVanGranica(int visina) {
		assertThrows(java.lang.RuntimeException.class, 
				() -> ag.setVisina(visina));
	}

	@Test
	void testToString() {
		ag.setMarkaModel("Marka1");
		ag.setPrecnik(15);
		ag.setSirina(140);
		ag.setVisina(30);

		String s = ag.toString();
		assertTrue(s.contains("Marka1"));
		assertTrue(s.contains("15"));
		assertTrue(s.contains("140"));
		assertTrue(s.contains("30"));
	}

	@ParameterizedTest
	@CsvSource({ 
		"Marka1, 15, 140, 30, Marka1, 15, 140, 30, true", 
		"Marka1, 15, 140, 30, Marka2, 15, 140, 30, false", 
		"Marka1, 15, 140, 30, Marka1, 20, 140, 30, false", 
		"Marka1, 15, 140, 30, Marka1, 15, 200, 30, false", 
		"Marka1, 15, 140, 30, Marka1, 15, 140, 50, false", 
		"Marka1, 15, 140, 30, Marka2, 20, 200, 50, false", 
		})
	void testEqualsObject(String marka1, int precnik1, int sirina1, int visina1, 
			String marka2, int precnik2, int sirina2, int visina2, boolean equal) {
		ag.setMarkaModel(marka1);
		ag.setPrecnik(precnik1);
		ag.setSirina(sirina1);
		ag.setVisina(visina1);
		
		AutoGuma ag2 = new AutoGuma();
		ag2.setMarkaModel(marka2);
		ag2.setPrecnik(precnik2);
		ag2.setSirina(sirina2);
		ag2.setVisina(visina2);
		
		assertEquals(equal, ag.equals(ag2));
	}

}
