package metier;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Classe définissant un arc.
 */
@Entity
public class Arc implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Correspond à l'id de la ligne dans la bdd.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    /**
     * Correspond à l'id dans le fichier instance.
     */
    @Column
    private Integer idArc;

    @JoinColumn(referencedColumnName = "ID")
    @ManyToOne
    private Location locationStart;

    @JoinColumn(referencedColumnName = "ID")
    @ManyToOne
    private Location locationEnd;

    @Column
    private Integer distance;

    @Column
    private boolean isShortest;

    @JoinColumn(name = "NINSTANCE", referencedColumnName = "ID")
	@ManyToOne
	private Instance ninstance;

    public Arc() {
        id = -1;
    }

    public Arc(Location locationStart, Location locationEnd, Integer distance, boolean isShortest,Instance ninstance) {
        this();
        this.locationStart = locationStart;
        this.locationEnd = locationEnd;
        this.distance = distance;
        this.isShortest = isShortest;
        this.ninstance = ninstance;
    }

    public Arc(Integer id, Location locationStart, Location locationEnd, Integer distance, boolean isShortest,Instance ninstance) {
        this.idArc = id;
        this.locationStart = locationStart;
        this.locationEnd = locationEnd;
        this.distance = distance;
        this.isShortest = isShortest;
        this.ninstance = ninstance;
    }

    public Integer getId() {
        return id;
    }

    public Location getLocationStart() {
        return locationStart;
    }

    public Location getLocationEnd() {
        return locationEnd;
    }

    public double getDistance() {
        return distance;
    }

    public Integer getIdArc() {
        return idArc;
    }

    public boolean isIsShortest() {
        return isShortest;
    }

    public void setLocationStart(Location locationStart) {
        this.locationStart = locationStart;
    }

    public void setLocationEnd(Location locationEnd) {
        this.locationEnd = locationEnd;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public void setIsShortest(boolean isShortest) {
        this.isShortest = isShortest;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.idArc);
        hash = 97 * hash + Objects.hashCode(this.locationStart);
        hash = 97 * hash + Objects.hashCode(this.locationEnd);
        hash = 97 * hash + Objects.hashCode(this.distance);
        hash = 97 * hash + (this.isShortest ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Arc other = (Arc) obj;
        if (this.isShortest != other.isShortest) {
            return false;
        }
        if (!Objects.equals(this.idArc, other.idArc)) {
            return false;
        }
        if (!Objects.equals(this.locationStart, other.locationStart)) {
            return false;
        }
        if (!Objects.equals(this.locationEnd, other.locationEnd)) {
            return false;
        }
        if (!Objects.equals(this.distance, other.distance)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Arc{" + "locationStart=" + locationStart.getName() + ", locationEnd=" + locationEnd.getName() + ", distance=" + distance + ", isShortest=" + isShortest + '}';
    }
}