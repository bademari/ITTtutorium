/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intt.datenlogik;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author inttentwickler
 */
@Entity
@Table(name = "inventory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inventory.findAll", query = "SELECT i FROM Inventory i"),
    @NamedQuery(name = "Inventory.findByInventoryID", query = "SELECT i FROM Inventory i WHERE i.inventoryID = :inventoryID"),
    @NamedQuery(name = "Inventory.findByStationID", query = "SELECT i FROM Inventory i WHERE i.stationID = :stationID"),        //Named Query erstellt
    @NamedQuery(name = "Inventory.findByProductID", query = "SELECT i FROM Inventory i WHERE i.productID = :productID"),        //Named Query erstellt
    @NamedQuery(name = "Inventory.findByCurrentAmount", query = "SELECT i FROM Inventory i WHERE i.currentAmount = :currentAmount"),
    @NamedQuery(name = "Inventory.findByToStoreAmount", query = "SELECT i FROM Inventory i WHERE i.toStoreAmount = :toStoreAmount")})
public class Inventory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "inventoryID")
    private Integer inventoryID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "currentAmount")
    private int currentAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "toStoreAmount")
    private int toStoreAmount;
    /*@JoinColumn(name = "stationID", referencedColumnName = "stationID")
    @ManyToOne(optional = false)
    private Station stationID;
    @JoinColumn(name = "productID", referencedColumnName = "productID")
    @ManyToOne(optional = false)
    private Products productID;
    */
    
    //new!!!!!
    @Basic(optional = false)
    @NotNull
    @Column(name= "productID")
    private int productID;
    @Basic(optional = false)
    @NotNull
    @Column(name= "stationID")
    private int stationID;
    
    
   

    public Inventory() {
    }

    public Inventory(Integer inventoryID) {
        this.inventoryID = inventoryID;
    }
    
    public Inventory(Integer inventoryID, int currentAmount, int toStoreAmount) {
        this.inventoryID = inventoryID;
        this.currentAmount = currentAmount;
        this.toStoreAmount = toStoreAmount;
    }
    
    

    public Integer getInventoryID() {
        return inventoryID;
    }

    public void setInventoryID(Integer inventoryID) {
        this.inventoryID = inventoryID;
    }

    public int getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(int currentAmount) {
        this.currentAmount = currentAmount;
    }

    public int getToStoreAmount() {
        return toStoreAmount;
    }

    public void setToStoreAmount(int toStoreAmount) {
        this.toStoreAmount = toStoreAmount;
    }

    public int getStationID() {
        return stationID;
    }

    public void setStationID(int stationID) {
        this.stationID = stationID;
    }
    
  

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }
    
    
     /*#################Code hinzugefügt#################*/
    /*
    public String getProductName(){
    
        Products temp = this.productID;
        String name = temp.getName();
        return name;
    }
    
       public String getStationLocation(){
    
        Station temp = this.stationID;
        String location = temp.getLocation();
        return location;
    }
       
        public String getStationType(){
    
        Station temp = this.stationID;
        String type = temp.getType();
        return type;
    }
        
        public Integer getIntStationID(){
            
            Station temp = this.stationID;
            Integer stid = temp.getStationID();
            return stid;
            
        }
        
        public Integer getIntProductID(){
            
            Products temp = this.productID;
            Integer prid = temp.getProductID();
            return prid;
            
        }
    
    */
    
    /*#################Code Ende#################*/
        
        
        

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inventoryID != null ? inventoryID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inventory)) {
            return false;
        }
        Inventory other = (Inventory) object;
        if ((this.inventoryID == null && other.inventoryID != null) || (this.inventoryID != null && !this.inventoryID.equals(other.inventoryID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "intt.datenlogik.Inventory[ inventoryID=" + inventoryID + " ]";
    }
    
}
