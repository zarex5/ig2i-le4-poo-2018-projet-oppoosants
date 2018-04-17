package metier;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Définition de la classe Chariot.
 */
public class Trolley {
    
    // Attributs
    private Integer id;
    private static Integer nbColisMax;
    private List<Parcel> parcels;
    
    // Constructeurs

    public Trolley() {
        this.nbColisMax = 0;
        this.parcels = new ArrayList<>();
    }

    public Trolley(int nbColisMax) {
        this();
        this.nbColisMax = nbColisMax;
    }
    
    public Trolley(Integer id, Integer nbColisMax, List<Parcel> parcels) {
        this();
        this.id = id;
        this.nbColisMax = nbColisMax;
        this.parcels = parcels;
    }
    
    public Trolley(Integer id, Integer nbColisMax) {
        this();
        this.id = id;
        this.nbColisMax = nbColisMax;
    }
    
    // Accesseurs

    public int getId() {
        return id;
    }

    public static int getNbColisMax() {
        return nbColisMax;
    }

    public static void setNbColisMax(int nbColisMax) {
        Trolley.nbColisMax = nbColisMax;
    }

    public List<Parcel> getParcels() {
        return parcels;
    }
    
    public boolean addParcel(Parcel p) {   
        if(this.nbColisMax < parcels.size() + 1) return false;
        parcels.add(p);
        return true;
    }
    
    
    // Méthodes

    @Override
    public String toString() {
        return "\nTrolley{" + "id=" + id + ", parcels=" + parcels + '}';
    }
    
}