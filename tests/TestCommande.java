import static org.junit.Assert.*;

import org.junit.Test;

import package_modele.PointModele;
import package_modele.EnumCouleurModele;

public class TestCommande {
	PointModele c=new PointModele(0, 0, 1);
	
	@Test
	public void testCalculAngleDroite() {
		assertEquals(5, c.calculAngleDroite(364));
		assertEquals(91, c.calculAngleDroite(90));

	}
	@Test
	public void testCalculAngleGauche() {
		assertEquals(331, c.calculAngleGauche(30));
		assertEquals(91, c.calculAngleDroite(90));
		
	}
	@Test
	public void testEstCouleur(){
		assertTrue(EnumCouleurModele.estCouleur("rouge"));
		assertFalse(EnumCouleurModele.estCouleur("rose bonbon"));
	}
}
