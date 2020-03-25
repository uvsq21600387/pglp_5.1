package mathieu.pglp_5_1.personnel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Iterator;

/**
 * classe pour l'affichage par groupe d'un InterfacePersonnel.
 */
public class AfficheParGroupe implements Iterable<InterfacePersonnels>,
Serializable {
	/**
	 * serial number.
	 */
	private static final long serialVersionUID = 1371441610724778625L;
	/**
	 * liste rempli avec le parcours en largeur.
	 */
	private ArrayDeque<InterfacePersonnels> c
	= new ArrayDeque<InterfacePersonnels>();
	/**
	 * affiche sous forme de parcours en largeur.
	 * @param ip InterfacePersonnel à afficher
	 */
	public void parcoursLargeur(final InterfacePersonnels ip) {
		if (ip.getClass() == CompositePersonnels.class) {
			InterfacePersonnels y, z;
			CompositePersonnels tmp;
			c = new ArrayDeque<InterfacePersonnels>();
			ArrayDeque<InterfacePersonnels> d =
				new ArrayDeque<InterfacePersonnels>();
			d.add(ip);
			while (!d.isEmpty()) {
				y = d.pollFirst();
				c.add(y);
				if (y.getClass() == CompositePersonnels.class) {
					tmp = (CompositePersonnels) y;
					Iterator<InterfacePersonnels> ite =
						tmp.iterator();
					while (ite.hasNext()) {
						z = ite.next();
						if (!d.contains(z) && !c.contains(z)) {
							d.add(z);
						}
					}
				}
			}
		}
	}
	/**
	 * retourne un itérateur sur la liste généré par le parcours.
	 * @return itérateur sur la liste rempli par le parcours
	 */
	public Iterator<InterfacePersonnels> iterator() {
		return c.iterator();
	}
	/**
	 * affiche le parcours en largeur.
	 */
	public void print() {
		System.out.print(toString());
	}
	/**
	 * donne un String contenant le parcours en largeur.
	 * @return le parcours en largeur
	 */
	public String toString() {
	    String s = "";
	    CompositePersonnels tmp;
        //affichage du parcours
        for (InterfacePersonnels c2 : c) {
            if (c2.getClass() == CompositePersonnels.class) {
                tmp = (CompositePersonnels) c2;
                s += tmp.getId() + "\n";
            } else {
                s += ((Personnel) c2).toString();
            }
        }
	    return s;
	}
	/**
     * serialize vers le fichier voulu.
     * @param path nom du fichier vers lequel serializer
     */
    public void serialize(final String path) {
        ObjectOutputStream writer = null;
        try {
            FileOutputStream file = new FileOutputStream(path);
            writer = new ObjectOutputStream(file);
            writer.writeObject(this);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.err.println("La serialization a échoué vers le fichier \"" + path + "\"");
        }
        try {
            if (writer != null) {
                writer.flush();
                writer.close();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
    /**
     * deserialize vers le fichier voulu.
     * @param path nom du fichier pour deserializer
     * @return l'instance de classe créé avec deserialization
     */
    public static AfficheParGroupe deserialize(final String path) {
        ObjectInputStream reader = null;
        AfficheParGroupe apg = null;
        try {
            FileInputStream file = new FileInputStream(path);
            reader = new ObjectInputStream(file);
            apg = (AfficheParGroupe) reader.readObject();
        } catch (IOException e) {
            System.err.println("La deserialization a échoué depuis le fichier \"" + path + "\"");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            if (reader != null) {
                reader.close();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return apg;
    }
}
