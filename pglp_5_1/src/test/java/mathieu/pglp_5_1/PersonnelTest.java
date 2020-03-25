package mathieu.pglp_5_1;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;

import mathieu.pglp_5_1.personnel.Personnel;

/**
 * tests unitaires sur la classe Personnel.
 * @author user
 *
 */
public class PersonnelTest {

	@Test
	/**
	 * teste le constructeur.
	 */
	public void test() {
		ArrayList<String> numero = new ArrayList<String>();
    	numero.add("06.18.12.15.95");
    	numero.add("01.25.46.85.16");
        Personnel p = new Personnel.Builder("man", "Iron", LocalDate.of(1955, 05, 02), numero).build();
        p.print();
	}

}
