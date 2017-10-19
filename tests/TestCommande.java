import static org.junit.Assert.*;

import org.junit.Test;

import package_Bogo.Commande;
import package_Bogo.Point;

public class TestCommande {
	Commande c=new Commande(null, new Point(0,0,0),null);
	@Test
	public void testCalculAngleDroite() {
		assertEquals(4, c.calculAngleDroite(364,0));
		assertEquals(90, c.calculAngleDroite(90,0));

	}
	@Test
	public void testCalculAngleGauche() {
		assertEquals(330, c.calculAngleGauche(30,0));
		assertEquals(90, c.calculAngleDroite(90,0));
		
	}
}
