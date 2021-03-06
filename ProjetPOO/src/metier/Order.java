package metier;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Classe définissant un commande.
 */
@Entity
@Table(name = "ORD")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Correspond à l'id de la ligne dans la bdd.
     */
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
    private Integer id;

    /**
     * Correspond à l'id dans le fichier instance.
     */
    @Column
    private Integer idOrder;

    /**
     * Nombre maximal de colis pour préparer la commande.
     */
    @Column
    private Integer m; 

    @Column
    private Integer nbProducts;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private List<ProdQty> prodQtys;

    @JoinColumn(name = "NINSTANCE", referencedColumnName = "ID")
	@ManyToOne
	private Instance ninstance;

    public Order() {
        prodQtys = new ArrayList();
    }

    public Order(Integer id, Integer m, Integer nbProducts, ArrayList<ProdQty> prodQtys,Instance ninstance) {
        this.idOrder = id;
        this.m = m;
        this.nbProducts = nbProducts;
        this.prodQtys = new ArrayList<>(prodQtys);
        this.ninstance = ninstance;
    }

    public int getId() {
        return id;
    }
    
    public Integer getIdOrder() {
        return idOrder;
    }

    public List<ProdQty> getProdQtys() {
        return prodQtys;
    }

    public void setProdQtys(List<ProdQty> prodQtys) {
        this.prodQtys = prodQtys;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.idOrder);
        hash = 37 * hash + Objects.hashCode(this.m);
        hash = 37 * hash + Objects.hashCode(this.nbProducts);
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
        final Order other = (Order) obj;
        if (!Objects.equals(this.idOrder, other.idOrder)) {
            return false;
        }
        if (!Objects.equals(this.m, other.m)) {
            return false;
        }
        if (!Objects.equals(this.nbProducts, other.nbProducts)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Order{" + "idOrder=" + idOrder + ", m=" + m + ", nbProducts=" + nbProducts + ", prodQtys=" + prodQtys + '}';
    }
}