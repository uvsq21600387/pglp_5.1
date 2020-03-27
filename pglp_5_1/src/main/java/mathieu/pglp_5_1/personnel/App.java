package mathieu.pglp_5_1.personnel;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * appel à la classe Personnel.
 */
public final class App {
    /**
     * constructeur de la classe App.
     */
    private App() {
    }
    /**
     * début du programme.
     * @param args arguments donnés au démarrage de l'application
     */
    public static void main(final String[] args) {
        CompositePersonnels c1 = new CompositePersonnels();
        CompositePersonnels c2 = new CompositePersonnels();
        CompositePersonnels c3 = new CompositePersonnels();
        CompositePersonnels c4 = new CompositePersonnels();
        CompositePersonnels c5 = new CompositePersonnels();
        CompositePersonnels c6 = new CompositePersonnels();
        CompositePersonnels c7 = new CompositePersonnels();
        ArrayList<String> numero = new ArrayList<String>();
        numero.add("06.18.12.15.95");
        numero.add("01.25.46.85.16");
        Personnel p = new Personnel.Builder(
            "man", "Iron", LocalDate.of(1955, 05, 02), numero).build();
        c7.add(p);
        c4.add(c6);
        c4.add(c7);
        c3.add(c4);
        c3.add(c5);
        c1.add(c2);
        c1.add(c3);
        System.out.println("Parcours en largeur : ");
        AfficheParGroupe apg = new AfficheParGroupe();
        apg.parcoursLargeur(c1);
        apg.print();
        System.out.println("\n\nParcours en profondeur : ");
        c1.print();
    }
}
