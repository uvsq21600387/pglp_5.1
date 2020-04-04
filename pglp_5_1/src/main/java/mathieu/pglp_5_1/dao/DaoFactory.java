package mathieu.pglp_5_1.dao;

import mathieu.pglp_5_1.personnel.AfficheParGroupe;
import mathieu.pglp_5_1.personnel.CompositePersonnels;
import mathieu.pglp_5_1.personnel.Personnel;

/**
 * pattern factory.
 */
public final class DaoFactory {
    /**
     * Les classes utilitaires ne doivent pas
     * avoir de constructeur par défaut ou public.
     */
    private DaoFactory() {
    }
    /**
     * fabrique Dao pour Personnel.
     * @param deserialize charger une sauvegarde
     * @return DaoPersonnel déserializé ou vide si param = null
     */
    public static Dao<Personnel> getDaoPersonnel(final String deserialize) {
        if (deserialize == null) {
            return new DaoPersonnel();
        } else {
            return DaoPersonnel.deserialize(deserialize);
        }
    }
    /**
     * fabrique Dao pour CompositePersonnel.
     * @param deserialize charger une sauvegarde
     * @return DaoCompositePersonnel déserializé ou vide si param = null
     */
    public static Dao<CompositePersonnels>
    getDaoCompositePersonnels(final String deserialize) {
        if (deserialize == null) {
            return new DaoCompositePersonnels();
        } else {
            return DaoCompositePersonnels.deserialize(deserialize);
        }
    }
    /**
     * fabrique Dao pour AfficheParGroupe.
     * @param deserialize charger une sauvegarde
     * @return DaoAfficheParGroupe déserializé ou vide si param = null
     */
    public static Dao<AfficheParGroupe>
    getDaoAfficheParGroupe(final String deserialize) {
        if (deserialize == null) {
            return new DaoAfficheParGroupe();
        } else {
            return DaoAfficheParGroupe.deserialize(deserialize);
        }
    }
}
