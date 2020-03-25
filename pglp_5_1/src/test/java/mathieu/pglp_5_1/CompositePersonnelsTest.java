package mathieu.pglp_5_1;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import mathieu.pglp_5_1.personnel.CompositePersonnels;
import mathieu.pglp_5_1.personnel.InterfacePersonnels;

/**
 * tests unitaires sur la classe CompositePersonnels.
 */
public class CompositePersonnelsTest {
	@Test
	/**
	 * teste le constructeur.
	 */
	public void testConstructeur() {
		CompositePersonnels cp = new CompositePersonnels();
		Iterator<InterfacePersonnels> ip = cp.iterator();
		assertFalse(ip.hasNext());
	}
	@Test
	/**
	 * teste l'ajout de personnel.
	 */
	public void testAjout() {
		CompositePersonnels cp = new CompositePersonnels();
		cp.add(new CompositePersonnels());
		Iterator<InterfacePersonnels> ip = cp.iterator();
		assertTrue(ip.hasNext());
	}
	@Test
	/**
	 * teste la suppression de personnel.
	 */
	public void testSuppression() {
		CompositePersonnels cp = new CompositePersonnels();
		CompositePersonnels cp2 = new CompositePersonnels();
		cp.add(cp2);
		cp.remove(cp2);
		Iterator<InterfacePersonnels> ip = cp.iterator();
		assertFalse(ip.hasNext());
	}
}
