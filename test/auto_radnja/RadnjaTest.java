package auto_radnja;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import auto_radnja.gume.AutoGuma;

public abstract class RadnjaTest {

	protected Radnja radnja;

	@Test
	void testDodajGumu() {
		AutoGuma a = new AutoGuma("Michelin", 15, 200, 80);

		radnja.dodajGumu(a);

		assertEquals(1, radnja.vratiSveGume().size());
		assertEquals(a, radnja.vratiSveGume().get(0));
	}

	@Test
	void testDodajGumuNull() {
		assertThrows(java.lang.NullPointerException.class, () -> radnja.dodajGumu(null));
	}

	@Test
	void testDodajGumuIstu() {
		AutoGuma a = new AutoGuma("Michelin", 15, 200, 80);
		AutoGuma g = new AutoGuma("Michelin", 15, 200, 80);

		radnja.dodajGumu(a);

		assertThrows(java.lang.RuntimeException.class, () -> radnja.dodajGumu(g));
	}

	@Test
	void testPronadjiGumu() {
		AutoGuma g1 = new AutoGuma("Michelin", 15, 200, 80);
		AutoGuma g2 = new AutoGuma("Michelin", 17, 180, 80);
		AutoGuma g3 = new AutoGuma("Tigar", 20, 230, 70);

		radnja.dodajGumu(g1);
		radnja.dodajGumu(g2);
		radnja.dodajGumu(g3);

		assertEquals(2, radnja.pronadjiGumu("Michelin").size());
		assertTrue(radnja.pronadjiGumu("Michelin").contains(g1));
		assertTrue(radnja.pronadjiGumu("Michelin").contains(g2));
		assertFalse(radnja.pronadjiGumu("Michelin").contains(g3));
	}

	@Test
	void testPronadjiGumuBezRez() {
		AutoGuma g1 = new AutoGuma("Michelin", 15, 200, 80);
		AutoGuma g2 = new AutoGuma("Michelin", 17, 180, 80);

		radnja.dodajGumu(g1);
		radnja.dodajGumu(g2);

		assertEquals(0, radnja.pronadjiGumu("Tigar").size());
	}

	@Test
	void testPronadjiGumuNull() {
		AutoGuma g1 = new AutoGuma("Michelin", 15, 200, 80);
		radnja.dodajGumu(g1);

		assertEquals(null, radnja.pronadjiGumu(null));
	}

	@Test
	void testVratiSveGume() {
		AutoGuma g1 = new AutoGuma("Michelin", 15, 200, 80);
		AutoGuma g2 = new AutoGuma("Tigar", 20, 230, 70);

		radnja.dodajGumu(g1);
		radnja.dodajGumu(g2);

		assertEquals(2, radnja.vratiSveGume().size());
		assertTrue(radnja.vratiSveGume().contains(g1));
		assertTrue(radnja.vratiSveGume().contains(g2));

	}

	@Test
	void testVratiSveGumePrazno() {
		
		assertEquals(0, radnja.vratiSveGume().size());
	}
	
}
