package mathieu.pglp_5_1.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

import mathieu.pglp_5_1.personnel.Personnel;

/**
 * DAO pour la classe Personnel.
 */
public class DaoPersonnel implements Dao<Personnel>, Serializable {
    /**
     * serial number pour la serialization.
     */
    private static final long serialVersionUID = 9721705196084890L;
    /**
     * ensemble des Personnels du DAO.
     */
    private ArrayList<Personnel> list;
    /**
     * constructeur de la classe.
     */
    public DaoPersonnel() {
        list = new ArrayList<Personnel>();
    }
    /**
     * ajoute un Personnel dans la liste du DAO.
     */
    public void add(final Personnel object) {
        list.add(object);
    }
    /**
     * obtenir un personnel du DAO.
     * @return null si aucun personnel existe avec l'id spécifié
     * et le personnel sinon
     */
    public Personnel get(final int id) {
        for(Personnel p : list) {
            if(p.getId() == id) {
                return p;
            }
        }
        return null;
    }
    @SuppressWarnings("unchecked")
    /**
     * obtenir une liste de tout les personnels du DAO.
     * @return une liste des personnels du DAO
     */
    public ArrayList<Personnel> getAll() {
        return (ArrayList<Personnel>) list.clone();
    }
    @SuppressWarnings("unchecked")
    /**
     * modifier un personnel (la classe est immuable, son id est donc modifié).
     * la clé doit être identique à l'attribut.
     * la valeur doit être de même type que l'attribut.
     * l'identifiant ne peut être ajouté à la liste des paramètres pour le modifier.
     */
    public void update(final Personnel object, final Map<String, Object> params) {
        if (list.remove(object)) {
            String nom = "";
            if (params.containsKey("nom")) {
                nom = (String) params.get("nom");
            } else {
                nom = object.getNom();
            }
            String prenom = "";
            if (params.containsKey("prenom")) {
                prenom = (String) params.get("prenom");
            } else {
                prenom = object.getPrenom();
            }
            LocalDate dateNaissance;
            if (params.containsKey("dateNaissance")) {
                dateNaissance = (LocalDate) params.get("dateNaissance");
            } else {
                dateNaissance = object.getDateNaissance();
            }
            ArrayList<String> numeroTelephone;
            if (params.containsKey("numeroTelephone")) {
                ArrayList<String> tmp;
                tmp = (ArrayList<String>) params.get("numeroTelephone");
                numeroTelephone = (ArrayList<String>) tmp.clone();
            } else {
                numeroTelephone = object.getNumeroTelephone();
            }
            Personnel p = new Personnel.Builder(
                nom, prenom, dateNaissance, numeroTelephone).build();
            list.add(p);
        }
    }
    /**
     * supprime un personnel du DAO.
     */
    public void remove(final Personnel object) {
        list.remove(object);
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
    public static DaoPersonnel deserialize(final String path) {
        ObjectInputStream reader = null;
        DaoPersonnel dp = null;
        try {
            FileInputStream file = new FileInputStream(path);
            reader = new ObjectInputStream(file);
            dp = (DaoPersonnel) reader.readObject();
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
        return dp;
    }
}
