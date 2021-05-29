/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intt.datenlogik;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author inttentwickler
 */
@Entity
@Table(name = "seller")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seller.findAll", query = "SELECT s FROM Seller s"),
    @NamedQuery(name = "Seller.findBySellerID", query = "SELECT s FROM Seller s WHERE s.sellerID = :sellerID"),
    @NamedQuery(name = "Seller.findByName", query = "SELECT s FROM Seller s WHERE s.name = :name"),
    @NamedQuery(name = "Seller.findByVorname", query = "SELECT s FROM Seller s WHERE s.vorname = :vorname")})
public class Seller implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sellerID")
    private Integer sellerID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "vorname")
    private String vorname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sellerID")
    private Collection<Sales> salesCollection;

    public Seller() {
    }

    public Seller(Integer sellerID) {
        this.sellerID = sellerID;
    }

    public Seller(Integer sellerID, String name, String vorname) {
        this.sellerID = sellerID;
        this.name = name;
        this.vorname = vorname;
    }

    public Integer getSellerID() {
        return sellerID;
    }

    public void setSellerID(Integer sellerID) {
        this.sellerID = sellerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    @XmlTransient
    public Collection<Sales> getSalesCollection() {
        return salesCollection;
    }

    public void setSalesCollection(Collection<Sales> salesCollection) {
        this.salesCollection = salesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sellerID != null ? sellerID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seller)) {
            return false;
        }
        Seller other = (Seller) object;
        if ((this.sellerID == null && other.sellerID != null) || (this.sellerID != null && !this.sellerID.equals(other.sellerID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "intt.datenlogik.Seller[ sellerID=" + sellerID + " ]";
    }
    
}
