package auto_radnja.gume;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AutoGumaTest {

	AutoGuma guma;

	@BeforeEach
	void setUp() throws Exception {
		guma = new AutoGuma();
	}

	@AfterEach
	void tearDown() throws Exception {
		guma = null;
	}

	@Test
	void testAutoGuma() {
		guma = new AutoGuma();
		assertNotNull(guma);
	}

	@Test
	void testAutoGumaStringIntIntInt() {
		guma = new AutoGuma("Michelin 90z", 15, 180, 80);
		
		assertNotNull(guma);
		assertEquals("Michelin 90z", guma.getMarkaModel());
		assertEquals(15, guma.getPrecnik());
		assertEquals(180, guma.getSirina());
		assertEquals(80, guma.getVisina());
	}

	@Test
	void testSetMarkaModel() {
		guma.setMarkaModel("Michelin 90z");
		
		assertEquals("Michelin 90z", guma.getMarkaModel());
		
	}

	@Test
	void testSetMarkaModelNull() {
		
		assertThrows(java.lang.NullPointerException.class, () -> guma.setMarkaModel(null));
	}
	
	@Test
	void testSetMarkaModelKratko() {
		
		assertThrows(java.lang.RuntimeException.class, () -> guma.setMarkaModel("Mi"));
	}
	
	@ParameterizedTest
	@CsvSource({
		"14",
		"17",
		"19"
	})
	void testSetPrecnik(int precnik) {
		guma.setPrecnik(precnik);
		
		assertEquals(precnik, guma.getPrecnik());
	}

	@ParameterizedTest
	@CsvSource({
		"12",
		"100",
		"25",
		"5"
	})
	void testSetPrecnikIzvanOpsega(int precnik) {
		
		assertThrows(java.lang.RuntimeException.class, () -> guma.setPrecnik(precnik));
	}
	
	@ParameterizedTest
	@CsvSource({
		"140",
		"240",
		"290",
		"320"
	})
	void testSetSirina(int sirina) {
		guma.setSirina(sirina);
		
		assertEquals(sirina, guma.getSirina());
	}

	@ParameterizedTest
	@CsvSource({
		"50",
		"120",
		"370",
		"420"
	})
	void testSetSirinaIzvanOpsega(int sirina) {
		
		assertThrows(java.lang.RuntimeException.class, () -> guma.setSirina(sirina));
	}
	
	@ParameterizedTest
	@CsvSource({
		"30",
		"55",
		"63",
		"90"
	})
	void testSetVisina(int visina) {
		guma.setVisina(visina);
		
		assertEquals(visina, guma.getVisina());
	}

	@ParameterizedTest
	@CsvSource({
		"22",
		"100",
		"5",
		"98"
	})
	void testSetVisinaIzvanOpsega(int visina) {
		
		assertThrows(java.lang.RuntimeException.class, () -> guma.setVisina(visina));
	}
	
	
	
	@Test
	void testToString() {
		guma = new AutoGuma("Michelin 90z", 17, 240, 80);

		String s = guma.toString();
		
		assertTrue(s.contains("Michelin 90z"));
		assertTrue(s.contains("17"));
		assertTrue(s.contains("240"));
		assertTrue(s.contains("80"));
	}
	
	@Test
	void testToStringFormatirano() {
		guma = new AutoGuma("Michelin 90z", 17, 240, 80);

		assertEquals("AutoGuma [markaModel=Michelin 90z, precnik=17, sirina=240, visina=80]", guma.toString());
	}
	
	@ParameterizedTest
	@CsvSource({
		"Michelin1, 17, 240, 80, Michelin1, 17, 240, 80, true",
		"Michelin1, 17, 240, 80, Michelin1, 17, 240, 90, false",
		"Michelin1, 17, 240, 80, Michelin1, 17, 250, 80, false",
		"Michelin1, 17, 240, 80, Michelin1, 17, 250, 90, false",
		"Michelin1, 17, 240, 80, Michelin1, 19, 240, 80, false",
		"Michelin1, 17, 240, 80, Michelin1, 19, 240, 90, false",
		"Michelin1, 17, 240, 80, Michelin1, 19, 250, 80, false",
		"Michelin1, 17, 240, 80, Michelin1, 19, 250, 90, false",
		"Michelin1, 17, 240, 80, Michelin2, 17, 240, 80, false",
		"Michelin1, 17, 240, 80, Michelin2, 17, 240, 90, false",
		"Michelin1, 17, 240, 80, Michelin2, 17, 250, 80, false",
		"Michelin1, 17, 240, 80, Michelin2, 17, 250, 90, false",
		"Michelin1, 17, 240, 80, Michelin2, 19, 240, 80, false",
		"Michelin1, 17, 240, 80, Michelin2, 19, 240, 90, false",
		"Michelin1, 17, 240, 80, Michelin2, 19, 250, 80, false",
		"Michelin1, 17, 240, 80, Michelin2, 19, 250, 90, false"
	})
	void testEqualsObject(String mm1, int p1, int s1, int v1, String mm2, int p2, int s2, int v2, boolean eq) {
		
		guma.setMarkaModel(mm1);
		guma.setPrecnik(p1);
		guma.setSirina(s1);
		guma.setVisina(v1);
		AutoGuma guma2 = new AutoGuma(mm2, p2, s2, v2);
		
		assertEquals(eq, guma.equals(guma2));
	}

}
